package  ma.zs.rh.ws.facade.admin.conge;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.conge.MotifRejetDemandeConge;
import ma.zs.rh.dao.criteria.core.conge.MotifRejetDemandeCongeCriteria;
import ma.zs.rh.service.facade.admin.conge.MotifRejetDemandeCongeAdminService;
import ma.zs.rh.ws.converter.conge.MotifRejetDemandeCongeConverter;
import ma.zs.rh.ws.dto.conge.MotifRejetDemandeCongeDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/motifRejetDemandeConge/")
public class MotifRejetDemandeCongeRestAdmin {




    @Operation(summary = "Finds a list of all motifRejetDemandeConges")
    @GetMapping("")
    public ResponseEntity<List<MotifRejetDemandeCongeDto>> findAll() throws Exception {
        ResponseEntity<List<MotifRejetDemandeCongeDto>> res = null;
        List<MotifRejetDemandeConge> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<MotifRejetDemandeCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all motifRejetDemandeConges")
    @GetMapping("optimized")
    public ResponseEntity<List<MotifRejetDemandeCongeDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<MotifRejetDemandeCongeDto>> res = null;
        List<MotifRejetDemandeConge> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<MotifRejetDemandeCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a motifRejetDemandeConge by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MotifRejetDemandeCongeDto> findById(@PathVariable Long id) {
        MotifRejetDemandeConge t = service.findById(id);
        if (t != null) {
            MotifRejetDemandeCongeDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a motifRejetDemandeConge by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<MotifRejetDemandeCongeDto> findByLibelle(@PathVariable String libelle) {
	    MotifRejetDemandeConge t = service.findByReferenceEntity(new MotifRejetDemandeConge(libelle));
        if (t != null) {
            MotifRejetDemandeCongeDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  motifRejetDemandeConge")
    @PostMapping("")
    public ResponseEntity<MotifRejetDemandeCongeDto> save(@RequestBody MotifRejetDemandeCongeDto dto) throws Exception {
        if(dto!=null){
            MotifRejetDemandeConge myT = converter.toItem(dto);
            MotifRejetDemandeConge t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                MotifRejetDemandeCongeDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  motifRejetDemandeConge")
    @PutMapping("")
    public ResponseEntity<MotifRejetDemandeCongeDto> update(@RequestBody MotifRejetDemandeCongeDto dto) throws Exception {
        ResponseEntity<MotifRejetDemandeCongeDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            MotifRejetDemandeConge t = service.findById(dto.getId());
            converter.copy(dto,t);
            MotifRejetDemandeConge updated = service.update(t);
            MotifRejetDemandeCongeDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of motifRejetDemandeConge")
    @PostMapping("multiple")
    public ResponseEntity<List<MotifRejetDemandeCongeDto>> delete(@RequestBody List<MotifRejetDemandeCongeDto> dtos) throws Exception {
        ResponseEntity<List<MotifRejetDemandeCongeDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<MotifRejetDemandeConge> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified motifRejetDemandeConge")
    @DeleteMapping("")
    public ResponseEntity<MotifRejetDemandeCongeDto> delete(@RequestBody MotifRejetDemandeCongeDto dto) throws Exception {
		ResponseEntity<MotifRejetDemandeCongeDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            MotifRejetDemandeConge t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified motifRejetDemandeConge")
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
    @Operation(summary = "Delete multiple motifRejetDemandeConges by ids")
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



    @Operation(summary = "Finds a motifRejetDemandeConge and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<MotifRejetDemandeCongeDto> findWithAssociatedLists(@PathVariable Long id) {
        MotifRejetDemandeConge loaded =  service.findWithAssociatedLists(id);
        MotifRejetDemandeCongeDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds motifRejetDemandeConges by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MotifRejetDemandeCongeDto>> findByCriteria(@RequestBody MotifRejetDemandeCongeCriteria criteria) throws Exception {
        ResponseEntity<List<MotifRejetDemandeCongeDto>> res = null;
        List<MotifRejetDemandeConge> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<MotifRejetDemandeCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated motifRejetDemandeConges by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MotifRejetDemandeCongeCriteria criteria) throws Exception {
        List<MotifRejetDemandeConge> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<MotifRejetDemandeCongeDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets motifRejetDemandeConge data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MotifRejetDemandeCongeCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<MotifRejetDemandeCongeDto> findDtos(List<MotifRejetDemandeConge> list){
        List<MotifRejetDemandeCongeDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<MotifRejetDemandeCongeDto> getDtoResponseEntity(MotifRejetDemandeCongeDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private MotifRejetDemandeCongeAdminService service;
    @Autowired private MotifRejetDemandeCongeConverter converter;





}
