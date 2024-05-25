package  ma.zs.rh.ws.facade.admin.pointage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.rh.bean.core.pointage.Pointeuse;
import ma.zs.rh.dao.criteria.core.pointage.PointeuseCriteria;
import ma.zs.rh.service.facade.admin.pointage.PointeuseAdminService;
import ma.zs.rh.ws.converter.pointage.PointeuseConverter;
import ma.zs.rh.ws.dto.pointage.PointeuseDto;
import ma.zs.rh.zynerator.controller.AbstractController;
import ma.zs.rh.zynerator.dto.AuditEntityDto;
import ma.zs.rh.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.rh.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.rh.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/pointeuse/")
public class PointeuseRestAdmin {




    @Operation(summary = "Finds a list of all pointeuses")
    @GetMapping("")
    public ResponseEntity<List<PointeuseDto>> findAll() throws Exception {
        ResponseEntity<List<PointeuseDto>> res = null;
        List<Pointeuse> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<PointeuseDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all pointeuses")
    @GetMapping("optimized")
    public ResponseEntity<List<PointeuseDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<PointeuseDto>> res = null;
        List<Pointeuse> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<PointeuseDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a pointeuse by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PointeuseDto> findById(@PathVariable Long id) {
        Pointeuse t = service.findById(id);
        if (t != null) {
            PointeuseDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a pointeuse by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<PointeuseDto> findByLibelle(@PathVariable String libelle) {
	    Pointeuse t = service.findByReferenceEntity(new Pointeuse(libelle));
        if (t != null) {
            PointeuseDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  pointeuse")
    @PostMapping("")
    public ResponseEntity<PointeuseDto> save(@RequestBody PointeuseDto dto) throws Exception {
        if(dto!=null){
            Pointeuse myT = converter.toItem(dto);
            Pointeuse t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                PointeuseDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  pointeuse")
    @PutMapping("")
    public ResponseEntity<PointeuseDto> update(@RequestBody PointeuseDto dto) throws Exception {
        ResponseEntity<PointeuseDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Pointeuse t = service.findById(dto.getId());
            converter.copy(dto,t);
            Pointeuse updated = service.update(t);
            PointeuseDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of pointeuse")
    @PostMapping("multiple")
    public ResponseEntity<List<PointeuseDto>> delete(@RequestBody List<PointeuseDto> dtos) throws Exception {
        ResponseEntity<List<PointeuseDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<Pointeuse> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified pointeuse")
    @DeleteMapping("")
    public ResponseEntity<PointeuseDto> delete(@RequestBody PointeuseDto dto) throws Exception {
		ResponseEntity<PointeuseDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            Pointeuse t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified pointeuse")
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
    @Operation(summary = "Delete multiple pointeuses by ids")
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



    @Operation(summary = "Finds a pointeuse and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<PointeuseDto> findWithAssociatedLists(@PathVariable Long id) {
        Pointeuse loaded =  service.findWithAssociatedLists(id);
        PointeuseDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds pointeuses by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PointeuseDto>> findByCriteria(@RequestBody PointeuseCriteria criteria) throws Exception {
        ResponseEntity<List<PointeuseDto>> res = null;
        List<Pointeuse> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<PointeuseDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated pointeuses by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PointeuseCriteria criteria) throws Exception {
        List<Pointeuse> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<PointeuseDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets pointeuse data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PointeuseCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<PointeuseDto> findDtos(List<Pointeuse> list){
        List<PointeuseDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<PointeuseDto> getDtoResponseEntity(PointeuseDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private PointeuseAdminService service;
    @Autowired private PointeuseConverter converter;





}
