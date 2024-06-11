package  ma.zs.rh.ws.facade.admin.retard;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.retard.EtatRetard;
import ma.zs.rh.dao.criteria.core.retard.EtatRetardCriteria;
import ma.zs.rh.service.facade.admin.retard.EtatRetardAdminService;
import ma.zs.rh.ws.converter.retard.EtatRetardConverter;
import ma.zs.rh.ws.dto.retard.EtatRetardDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/etatRetard/")
public class EtatRetardRestAdmin {




    @Operation(summary = "Finds a list of all etatRetards")
    @GetMapping("")
    public ResponseEntity<List<EtatRetardDto>> findAll() throws Exception {
        ResponseEntity<List<EtatRetardDto>> res = null;
        List<EtatRetard> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatRetardDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all etatRetards")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatRetardDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<EtatRetardDto>> res = null;
        List<EtatRetard> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatRetardDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a etatRetard by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatRetardDto> findById(@PathVariable Long id) {
        EtatRetard t = service.findById(id);
        if (t != null) {
            EtatRetardDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a etatRetard by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatRetardDto> findByLibelle(@PathVariable String libelle) {
	    EtatRetard t = service.findByReferenceEntity(new EtatRetard(libelle));
        if (t != null) {
            EtatRetardDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  etatRetard")
    @PostMapping("")
    public ResponseEntity<EtatRetardDto> save(@RequestBody EtatRetardDto dto) throws Exception {
        if(dto!=null){
            EtatRetard myT = converter.toItem(dto);
            EtatRetard t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                EtatRetardDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  etatRetard")
    @PutMapping("")
    public ResponseEntity<EtatRetardDto> update(@RequestBody EtatRetardDto dto) throws Exception {
        ResponseEntity<EtatRetardDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            EtatRetard t = service.findById(dto.getId());
            converter.copy(dto,t);
            EtatRetard updated = service.update(t);
            EtatRetardDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of etatRetard")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatRetardDto>> delete(@RequestBody List<EtatRetardDto> dtos) throws Exception {
        ResponseEntity<List<EtatRetardDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<EtatRetard> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified etatRetard")
    @DeleteMapping("")
    public ResponseEntity<EtatRetardDto> delete(@RequestBody EtatRetardDto dto) throws Exception {
		ResponseEntity<EtatRetardDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            EtatRetard t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified etatRetard")
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
    @Operation(summary = "Delete multiple etatRetards by ids")
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



    @Operation(summary = "Finds a etatRetard and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<EtatRetardDto> findWithAssociatedLists(@PathVariable Long id) {
        EtatRetard loaded =  service.findWithAssociatedLists(id);
        EtatRetardDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds etatRetards by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatRetardDto>> findByCriteria(@RequestBody EtatRetardCriteria criteria) throws Exception {
        ResponseEntity<List<EtatRetardDto>> res = null;
        List<EtatRetard> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatRetardDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated etatRetards by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatRetardCriteria criteria) throws Exception {
        List<EtatRetard> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<EtatRetardDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets etatRetard data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatRetardCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<EtatRetardDto> findDtos(List<EtatRetard> list){
        List<EtatRetardDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<EtatRetardDto> getDtoResponseEntity(EtatRetardDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private EtatRetardAdminService service;
    @Autowired private EtatRetardConverter converter;





}
