package  ma.zs.rh.ws.facade.admin.abssence;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.abssence.EtatDemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.EtatDemandeAbsenceCriteria;
import ma.zs.rh.service.facade.admin.abssence.EtatDemandeAbsenceAdminService;
import ma.zs.rh.ws.converter.abssence.EtatDemandeAbsenceConverter;
import ma.zs.rh.ws.dto.abssence.EtatDemandeAbsenceDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/etatDemandeAbsence/")
public class EtatDemandeAbsenceRestAdmin {




    @Operation(summary = "Finds a list of all etatDemandeAbsences")
    @GetMapping("")
    public ResponseEntity<List<EtatDemandeAbsenceDto>> findAll() throws Exception {
        ResponseEntity<List<EtatDemandeAbsenceDto>> res = null;
        List<EtatDemandeAbsence> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all etatDemandeAbsences")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatDemandeAbsenceDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<EtatDemandeAbsenceDto>> res = null;
        List<EtatDemandeAbsence> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a etatDemandeAbsence by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatDemandeAbsenceDto> findById(@PathVariable Long id) {
        EtatDemandeAbsence t = service.findById(id);
        if (t != null) {
            EtatDemandeAbsenceDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a etatDemandeAbsence by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatDemandeAbsenceDto> findByLibelle(@PathVariable String libelle) {
	    EtatDemandeAbsence t = service.findByReferenceEntity(new EtatDemandeAbsence(libelle));
        if (t != null) {
            EtatDemandeAbsenceDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  etatDemandeAbsence")
    @PostMapping("")
    public ResponseEntity<EtatDemandeAbsenceDto> save(@RequestBody EtatDemandeAbsenceDto dto) throws Exception {
        if(dto!=null){
            EtatDemandeAbsence myT = converter.toItem(dto);
            EtatDemandeAbsence t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                EtatDemandeAbsenceDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  etatDemandeAbsence")
    @PutMapping("")
    public ResponseEntity<EtatDemandeAbsenceDto> update(@RequestBody EtatDemandeAbsenceDto dto) throws Exception {
        ResponseEntity<EtatDemandeAbsenceDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            EtatDemandeAbsence t = service.findById(dto.getId());
            converter.copy(dto,t);
            EtatDemandeAbsence updated = service.update(t);
            EtatDemandeAbsenceDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of etatDemandeAbsence")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatDemandeAbsenceDto>> delete(@RequestBody List<EtatDemandeAbsenceDto> dtos) throws Exception {
        ResponseEntity<List<EtatDemandeAbsenceDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<EtatDemandeAbsence> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified etatDemandeAbsence")
    @DeleteMapping("")
    public ResponseEntity<EtatDemandeAbsenceDto> delete(@RequestBody EtatDemandeAbsenceDto dto) throws Exception {
		ResponseEntity<EtatDemandeAbsenceDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            EtatDemandeAbsence t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified etatDemandeAbsence")
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
    @Operation(summary = "Delete multiple etatDemandeAbsences by ids")
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



    @Operation(summary = "Finds a etatDemandeAbsence and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<EtatDemandeAbsenceDto> findWithAssociatedLists(@PathVariable Long id) {
        EtatDemandeAbsence loaded =  service.findWithAssociatedLists(id);
        EtatDemandeAbsenceDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds etatDemandeAbsences by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatDemandeAbsenceDto>> findByCriteria(@RequestBody EtatDemandeAbsenceCriteria criteria) throws Exception {
        ResponseEntity<List<EtatDemandeAbsenceDto>> res = null;
        List<EtatDemandeAbsence> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated etatDemandeAbsences by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatDemandeAbsenceCriteria criteria) throws Exception {
        List<EtatDemandeAbsence> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<EtatDemandeAbsenceDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets etatDemandeAbsence data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatDemandeAbsenceCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<EtatDemandeAbsenceDto> findDtos(List<EtatDemandeAbsence> list){
        List<EtatDemandeAbsenceDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<EtatDemandeAbsenceDto> getDtoResponseEntity(EtatDemandeAbsenceDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private EtatDemandeAbsenceAdminService service;
    @Autowired private EtatDemandeAbsenceConverter converter;





}
