package  ma.zs.rh.ws.facade.admin.docadmin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.rh.bean.core.docadmin.DemandeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.DemandeDocumentAdministratifCriteria;
import ma.zs.rh.service.facade.admin.docadmin.DemandeDocumentAdministratifAdminService;
import ma.zs.rh.ws.converter.docadmin.DemandeDocumentAdministratifConverter;
import ma.zs.rh.ws.dto.docadmin.DemandeDocumentAdministratifDto;
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
@RequestMapping("/api/admin/demandeDocumentAdministratif/")
public class DemandeDocumentAdministratifRestAdmin {




    @Operation(summary = "Finds a list of all demandeDocumentAdministratifs")
    @GetMapping("")
    public ResponseEntity<List<DemandeDocumentAdministratifDto>> findAll() throws Exception {
        ResponseEntity<List<DemandeDocumentAdministratifDto>> res = null;
        List<DemandeDocumentAdministratif> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<DemandeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all demandeDocumentAdministratifs")
    @GetMapping("optimized")
    public ResponseEntity<List<DemandeDocumentAdministratifDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<DemandeDocumentAdministratifDto>> res = null;
        List<DemandeDocumentAdministratif> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<DemandeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a demandeDocumentAdministratif by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandeDocumentAdministratifDto> findById(@PathVariable Long id) {
        DemandeDocumentAdministratif t = service.findById(id);
        if (t != null) {
            converter.init(true);
            DemandeDocumentAdministratifDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a demandeDocumentAdministratif by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<DemandeDocumentAdministratifDto> findByLibelle(@PathVariable String libelle) {
	    DemandeDocumentAdministratif t = service.findByReferenceEntity(new DemandeDocumentAdministratif(libelle));
        if (t != null) {
            converter.init(true);
            DemandeDocumentAdministratifDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  demandeDocumentAdministratif")
    @PostMapping("")
    public ResponseEntity<DemandeDocumentAdministratifDto> save(@RequestBody DemandeDocumentAdministratifDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            DemandeDocumentAdministratif myT = converter.toItem(dto);
            DemandeDocumentAdministratif t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                DemandeDocumentAdministratifDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  demandeDocumentAdministratif")
    @PutMapping("")
    public ResponseEntity<DemandeDocumentAdministratifDto> update(@RequestBody DemandeDocumentAdministratifDto dto) throws Exception {
        ResponseEntity<DemandeDocumentAdministratifDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            DemandeDocumentAdministratif t = service.findById(dto.getId());
            converter.copy(dto,t);
            DemandeDocumentAdministratif updated = service.update(t);
            DemandeDocumentAdministratifDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of demandeDocumentAdministratif")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandeDocumentAdministratifDto>> delete(@RequestBody List<DemandeDocumentAdministratifDto> dtos) throws Exception {
        ResponseEntity<List<DemandeDocumentAdministratifDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<DemandeDocumentAdministratif> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified demandeDocumentAdministratif")
    @DeleteMapping("")
    public ResponseEntity<DemandeDocumentAdministratifDto> delete(@RequestBody DemandeDocumentAdministratifDto dto) throws Exception {
		ResponseEntity<DemandeDocumentAdministratifDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            DemandeDocumentAdministratif t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified demandeDocumentAdministratif")
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
    @Operation(summary = "Delete multiple demandeDocumentAdministratifs by ids")
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


    @Operation(summary = "find by entiteAdministrative id")
    @GetMapping("entiteAdministrative/id/{id}")
    public List<DemandeDocumentAdministratifDto> findByEntiteAdministrativeId(@PathVariable Long id){
        return findDtos(service.findByEntiteAdministrativeId(id));
    }
    @Operation(summary = "delete by entiteAdministrative id")
    @DeleteMapping("entiteAdministrative/id/{id}")
    public int deleteByEntiteAdministrativeId(@PathVariable Long id){
        return service.deleteByEntiteAdministrativeId(id);
    }

    @Operation(summary = "Finds a demandeDocumentAdministratif and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<DemandeDocumentAdministratifDto> findWithAssociatedLists(@PathVariable Long id) {
        DemandeDocumentAdministratif loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        DemandeDocumentAdministratifDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds demandeDocumentAdministratifs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandeDocumentAdministratifDto>> findByCriteria(@RequestBody DemandeDocumentAdministratifCriteria criteria) throws Exception {
        ResponseEntity<List<DemandeDocumentAdministratifDto>> res = null;
        List<DemandeDocumentAdministratif> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<DemandeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated demandeDocumentAdministratifs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandeDocumentAdministratifCriteria criteria) throws Exception {
        List<DemandeDocumentAdministratif> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<DemandeDocumentAdministratifDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets demandeDocumentAdministratif data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandeDocumentAdministratifCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<DemandeDocumentAdministratifDto> findDtos(List<DemandeDocumentAdministratif> list){
        converter.initObject(true);
        List<DemandeDocumentAdministratifDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<DemandeDocumentAdministratifDto> getDtoResponseEntity(DemandeDocumentAdministratifDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private DemandeDocumentAdministratifAdminService service;
    @Autowired private DemandeDocumentAdministratifConverter converter;





}
