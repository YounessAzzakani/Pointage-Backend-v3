package  ma.zs.rh.ws.facade.admin.abssence;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.rh.bean.core.abssence.RaisonAbsence;
import ma.zs.rh.dao.criteria.core.abssence.RaisonAbsenceCriteria;
import ma.zs.rh.service.facade.admin.abssence.RaisonAbsenceAdminService;
import ma.zs.rh.ws.converter.abssence.RaisonAbsenceConverter;
import ma.zs.rh.ws.dto.abssence.RaisonAbsenceDto;
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
@RequestMapping("/api/admin/raisonAbsence/")
public class RaisonAbsenceRestAdmin {




    @Operation(summary = "Finds a list of all raisonAbsences")
    @GetMapping("")
    public ResponseEntity<List<RaisonAbsenceDto>> findAll() throws Exception {
        ResponseEntity<List<RaisonAbsenceDto>> res = null;
        List<RaisonAbsence> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RaisonAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all raisonAbsences")
    @GetMapping("optimized")
    public ResponseEntity<List<RaisonAbsenceDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<RaisonAbsenceDto>> res = null;
        List<RaisonAbsence> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RaisonAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a raisonAbsence by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RaisonAbsenceDto> findById(@PathVariable Long id) {
        RaisonAbsence t = service.findById(id);
        if (t != null) {
            RaisonAbsenceDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a raisonAbsence by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<RaisonAbsenceDto> findByLibelle(@PathVariable String libelle) {
	    RaisonAbsence t = service.findByReferenceEntity(new RaisonAbsence(libelle));
        if (t != null) {
            RaisonAbsenceDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  raisonAbsence")
    @PostMapping("")
    public ResponseEntity<RaisonAbsenceDto> save(@RequestBody RaisonAbsenceDto dto) throws Exception {
        if(dto!=null){
            RaisonAbsence myT = converter.toItem(dto);
            RaisonAbsence t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                RaisonAbsenceDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  raisonAbsence")
    @PutMapping("")
    public ResponseEntity<RaisonAbsenceDto> update(@RequestBody RaisonAbsenceDto dto) throws Exception {
        ResponseEntity<RaisonAbsenceDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            RaisonAbsence t = service.findById(dto.getId());
            converter.copy(dto,t);
            RaisonAbsence updated = service.update(t);
            RaisonAbsenceDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of raisonAbsence")
    @PostMapping("multiple")
    public ResponseEntity<List<RaisonAbsenceDto>> delete(@RequestBody List<RaisonAbsenceDto> dtos) throws Exception {
        ResponseEntity<List<RaisonAbsenceDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<RaisonAbsence> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified raisonAbsence")
    @DeleteMapping("")
    public ResponseEntity<RaisonAbsenceDto> delete(@RequestBody RaisonAbsenceDto dto) throws Exception {
		ResponseEntity<RaisonAbsenceDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            RaisonAbsence t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified raisonAbsence")
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
    @Operation(summary = "Delete multiple raisonAbsences by ids")
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



    @Operation(summary = "Finds a raisonAbsence and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<RaisonAbsenceDto> findWithAssociatedLists(@PathVariable Long id) {
        RaisonAbsence loaded =  service.findWithAssociatedLists(id);
        RaisonAbsenceDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds raisonAbsences by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RaisonAbsenceDto>> findByCriteria(@RequestBody RaisonAbsenceCriteria criteria) throws Exception {
        ResponseEntity<List<RaisonAbsenceDto>> res = null;
        List<RaisonAbsence> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RaisonAbsenceDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated raisonAbsences by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RaisonAbsenceCriteria criteria) throws Exception {
        List<RaisonAbsence> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<RaisonAbsenceDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets raisonAbsence data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RaisonAbsenceCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<RaisonAbsenceDto> findDtos(List<RaisonAbsence> list){
        List<RaisonAbsenceDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<RaisonAbsenceDto> getDtoResponseEntity(RaisonAbsenceDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private RaisonAbsenceAdminService service;
    @Autowired private RaisonAbsenceConverter converter;





}
