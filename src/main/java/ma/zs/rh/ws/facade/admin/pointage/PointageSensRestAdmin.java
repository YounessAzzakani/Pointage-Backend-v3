package  ma.zs.rh.ws.facade.admin.pointage;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.pointage.PointageSens;
import ma.zs.rh.dao.criteria.core.pointage.PointageSensCriteria;
import ma.zs.rh.service.facade.admin.pointage.PointageSensAdminService;
import ma.zs.rh.ws.converter.pointage.PointageSensConverter;
import ma.zs.rh.ws.dto.pointage.PointageSensDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/pointageSens/")
public class PointageSensRestAdmin {




    @Operation(summary = "Finds a list of all pointageSenss")
    @GetMapping("")
    public ResponseEntity<List<PointageSensDto>> findAll() throws Exception {
        ResponseEntity<List<PointageSensDto>> res = null;
        List<PointageSens> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<PointageSensDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all pointageSenss")
    @GetMapping("optimized")
    public ResponseEntity<List<PointageSensDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<PointageSensDto>> res = null;
        List<PointageSens> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<PointageSensDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a pointageSens by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PointageSensDto> findById(@PathVariable Long id) {
        PointageSens t = service.findById(id);
        if (t != null) {
            PointageSensDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a pointageSens by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<PointageSensDto> findByLibelle(@PathVariable String libelle) {
	    PointageSens t = service.findByReferenceEntity(new PointageSens(libelle));
        if (t != null) {
            PointageSensDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  pointageSens")
    @PostMapping("")
    public ResponseEntity<PointageSensDto> save(@RequestBody PointageSensDto dto) throws Exception {
        if(dto!=null){
            PointageSens myT = converter.toItem(dto);
            PointageSens t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                PointageSensDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  pointageSens")
    @PutMapping("")
    public ResponseEntity<PointageSensDto> update(@RequestBody PointageSensDto dto) throws Exception {
        ResponseEntity<PointageSensDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            PointageSens t = service.findById(dto.getId());
            converter.copy(dto,t);
            PointageSens updated = service.update(t);
            PointageSensDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of pointageSens")
    @PostMapping("multiple")
    public ResponseEntity<List<PointageSensDto>> delete(@RequestBody List<PointageSensDto> dtos) throws Exception {
        ResponseEntity<List<PointageSensDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<PointageSens> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified pointageSens")
    @DeleteMapping("")
    public ResponseEntity<PointageSensDto> delete(@RequestBody PointageSensDto dto) throws Exception {
		ResponseEntity<PointageSensDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            PointageSens t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified pointageSens")
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
    @Operation(summary = "Delete multiple pointageSenss by ids")
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



    @Operation(summary = "Finds a pointageSens and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<PointageSensDto> findWithAssociatedLists(@PathVariable Long id) {
        PointageSens loaded =  service.findWithAssociatedLists(id);
        PointageSensDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds pointageSenss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PointageSensDto>> findByCriteria(@RequestBody PointageSensCriteria criteria) throws Exception {
        ResponseEntity<List<PointageSensDto>> res = null;
        List<PointageSens> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<PointageSensDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated pointageSenss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PointageSensCriteria criteria) throws Exception {
        List<PointageSens> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<PointageSensDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets pointageSens data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PointageSensCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<PointageSensDto> findDtos(List<PointageSens> list){
        List<PointageSensDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<PointageSensDto> getDtoResponseEntity(PointageSensDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private PointageSensAdminService service;
    @Autowired private PointageSensConverter converter;





}
