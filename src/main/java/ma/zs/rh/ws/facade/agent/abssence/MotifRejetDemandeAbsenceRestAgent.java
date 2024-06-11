package  ma.zs.rh.ws.facade.agent.abssence;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.abssence.MotifRejetDemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.MotifRejetDemandeAbsenceCriteria;
import ma.zs.rh.service.facade.agent.abssence.MotifRejetDemandeAbsenceAgentService;
import ma.zs.rh.ws.converter.abssence.MotifRejetDemandeAbsenceConverter;
import ma.zs.rh.ws.dto.abssence.MotifRejetDemandeAbsenceDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/agent/motifRejetDemandeAbsence/")
public class MotifRejetDemandeAbsenceRestAgent {




    @Operation(summary = "Finds a list of all motifRejetDemandeAbsences")
    @GetMapping("")
    public ResponseEntity<List<MotifRejetDemandeAbsenceDto>> findAll() throws Exception {
        ResponseEntity<List<MotifRejetDemandeAbsenceDto>> res = null;
        List<MotifRejetDemandeAbsence> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<MotifRejetDemandeAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all motifRejetDemandeAbsences")
    @GetMapping("optimized")
    public ResponseEntity<List<MotifRejetDemandeAbsenceDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<MotifRejetDemandeAbsenceDto>> res = null;
        List<MotifRejetDemandeAbsence> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<MotifRejetDemandeAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a motifRejetDemandeAbsence by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MotifRejetDemandeAbsenceDto> findById(@PathVariable Long id) {
        MotifRejetDemandeAbsence t = service.findById(id);
        if (t != null) {
            MotifRejetDemandeAbsenceDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a motifRejetDemandeAbsence by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<MotifRejetDemandeAbsenceDto> findByLibelle(@PathVariable String libelle) {
	    MotifRejetDemandeAbsence t = service.findByReferenceEntity(new MotifRejetDemandeAbsence(libelle));
        if (t != null) {
            MotifRejetDemandeAbsenceDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  motifRejetDemandeAbsence")
    @PostMapping("")
    public ResponseEntity<MotifRejetDemandeAbsenceDto> save(@RequestBody MotifRejetDemandeAbsenceDto dto) throws Exception {
        if(dto!=null){
            MotifRejetDemandeAbsence myT = converter.toItem(dto);
            MotifRejetDemandeAbsence t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                MotifRejetDemandeAbsenceDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  motifRejetDemandeAbsence")
    @PutMapping("")
    public ResponseEntity<MotifRejetDemandeAbsenceDto> update(@RequestBody MotifRejetDemandeAbsenceDto dto) throws Exception {
        ResponseEntity<MotifRejetDemandeAbsenceDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            MotifRejetDemandeAbsence t = service.findById(dto.getId());
            converter.copy(dto,t);
            MotifRejetDemandeAbsence updated = service.update(t);
            MotifRejetDemandeAbsenceDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of motifRejetDemandeAbsence")
    @PostMapping("multiple")
    public ResponseEntity<List<MotifRejetDemandeAbsenceDto>> delete(@RequestBody List<MotifRejetDemandeAbsenceDto> dtos) throws Exception {
        ResponseEntity<List<MotifRejetDemandeAbsenceDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<MotifRejetDemandeAbsence> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified motifRejetDemandeAbsence")
    @DeleteMapping("")
    public ResponseEntity<MotifRejetDemandeAbsenceDto> delete(@RequestBody MotifRejetDemandeAbsenceDto dto) throws Exception {
		ResponseEntity<MotifRejetDemandeAbsenceDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            MotifRejetDemandeAbsence t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified motifRejetDemandeAbsence")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        ResponseEntity<Long> res;
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        if (id != null) {
            boolean resultDelete = service.deleteById(id);
            if (resultDelete) {
                status = HttpStatus.OK;
            }
        }
        res = new ResponseEntity<>(id, status);
        return res;
    }
    @Operation(summary = "Delete multiple motifRejetDemandeAbsences by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        ResponseEntity<List<Long>> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (ids != null) {
            service.deleteByIdIn(ids);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(ids, status);
        return res;
     }



    @Operation(summary = "Finds a motifRejetDemandeAbsence and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<MotifRejetDemandeAbsenceDto> findWithAssociatedLists(@PathVariable Long id) {
        MotifRejetDemandeAbsence loaded =  service.findWithAssociatedLists(id);
        MotifRejetDemandeAbsenceDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds motifRejetDemandeAbsences by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MotifRejetDemandeAbsenceDto>> findByCriteria(@RequestBody MotifRejetDemandeAbsenceCriteria criteria) throws Exception {
        ResponseEntity<List<MotifRejetDemandeAbsenceDto>> res = null;
        List<MotifRejetDemandeAbsence> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<MotifRejetDemandeAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated motifRejetDemandeAbsences by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MotifRejetDemandeAbsenceCriteria criteria) throws Exception {
        List<MotifRejetDemandeAbsence> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<MotifRejetDemandeAbsenceDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets motifRejetDemandeAbsence data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MotifRejetDemandeAbsenceCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<MotifRejetDemandeAbsenceDto> findDtos(List<MotifRejetDemandeAbsence> list){
        List<MotifRejetDemandeAbsenceDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<MotifRejetDemandeAbsenceDto> getDtoResponseEntity(MotifRejetDemandeAbsenceDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private MotifRejetDemandeAbsenceAgentService service;
    @Autowired private MotifRejetDemandeAbsenceConverter converter;





}
