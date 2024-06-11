package  ma.zs.rh.ws.facade.admin.conge;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.conge.RaisonConge;
import ma.zs.rh.dao.criteria.core.conge.RaisonCongeCriteria;
import ma.zs.rh.service.facade.admin.conge.RaisonCongeAdminService;
import ma.zs.rh.ws.converter.conge.RaisonCongeConverter;
import ma.zs.rh.ws.dto.conge.RaisonCongeDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/raisonConge/")
public class RaisonCongeRestAdmin {




    @Operation(summary = "Finds a list of all raisonConges")
    @GetMapping("")
    public ResponseEntity<List<RaisonCongeDto>> findAll() throws Exception {
        ResponseEntity<List<RaisonCongeDto>> res = null;
        List<RaisonConge> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RaisonCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all raisonConges")
    @GetMapping("optimized")
    public ResponseEntity<List<RaisonCongeDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<RaisonCongeDto>> res = null;
        List<RaisonConge> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RaisonCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a raisonConge by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RaisonCongeDto> findById(@PathVariable Long id) {
        RaisonConge t = service.findById(id);
        if (t != null) {
            RaisonCongeDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a raisonConge by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<RaisonCongeDto> findByLibelle(@PathVariable String libelle) {
	    RaisonConge t = service.findByReferenceEntity(new RaisonConge(libelle));
        if (t != null) {
            RaisonCongeDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  raisonConge")
    @PostMapping("")
    public ResponseEntity<RaisonCongeDto> save(@RequestBody RaisonCongeDto dto) throws Exception {
        if(dto!=null){
            RaisonConge myT = converter.toItem(dto);
            RaisonConge t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                RaisonCongeDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  raisonConge")
    @PutMapping("")
    public ResponseEntity<RaisonCongeDto> update(@RequestBody RaisonCongeDto dto) throws Exception {
        ResponseEntity<RaisonCongeDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            RaisonConge t = service.findById(dto.getId());
            converter.copy(dto,t);
            RaisonConge updated = service.update(t);
            RaisonCongeDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of raisonConge")
    @PostMapping("multiple")
    public ResponseEntity<List<RaisonCongeDto>> delete(@RequestBody List<RaisonCongeDto> dtos) throws Exception {
        ResponseEntity<List<RaisonCongeDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<RaisonConge> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified raisonConge")
    @DeleteMapping("")
    public ResponseEntity<RaisonCongeDto> delete(@RequestBody RaisonCongeDto dto) throws Exception {
		ResponseEntity<RaisonCongeDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            RaisonConge t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified raisonConge")
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
    @Operation(summary = "Delete multiple raisonConges by ids")
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



    @Operation(summary = "Finds a raisonConge and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<RaisonCongeDto> findWithAssociatedLists(@PathVariable Long id) {
        RaisonConge loaded =  service.findWithAssociatedLists(id);
        RaisonCongeDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds raisonConges by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RaisonCongeDto>> findByCriteria(@RequestBody RaisonCongeCriteria criteria) throws Exception {
        ResponseEntity<List<RaisonCongeDto>> res = null;
        List<RaisonConge> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RaisonCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated raisonConges by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RaisonCongeCriteria criteria) throws Exception {
        List<RaisonConge> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<RaisonCongeDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets raisonConge data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RaisonCongeCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<RaisonCongeDto> findDtos(List<RaisonConge> list){
        List<RaisonCongeDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<RaisonCongeDto> getDtoResponseEntity(RaisonCongeDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private RaisonCongeAdminService service;
    @Autowired private RaisonCongeConverter converter;





}
