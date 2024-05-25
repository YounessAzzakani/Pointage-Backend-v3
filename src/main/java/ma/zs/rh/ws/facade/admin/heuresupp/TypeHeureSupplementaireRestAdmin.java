package  ma.zs.rh.ws.facade.admin.heuresupp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.TypeHeureSupplementaireCriteria;
import ma.zs.rh.service.facade.admin.heuresupp.TypeHeureSupplementaireAdminService;
import ma.zs.rh.ws.converter.heuresupp.TypeHeureSupplementaireConverter;
import ma.zs.rh.ws.dto.heuresupp.TypeHeureSupplementaireDto;
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
@RequestMapping("/api/admin/typeHeureSupplementaire/")
public class TypeHeureSupplementaireRestAdmin {




    @Operation(summary = "Finds a list of all typeHeureSupplementaires")
    @GetMapping("")
    public ResponseEntity<List<TypeHeureSupplementaireDto>> findAll() throws Exception {
        ResponseEntity<List<TypeHeureSupplementaireDto>> res = null;
        List<TypeHeureSupplementaire> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeHeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all typeHeureSupplementaires")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeHeureSupplementaireDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<TypeHeureSupplementaireDto>> res = null;
        List<TypeHeureSupplementaire> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeHeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a typeHeureSupplementaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeHeureSupplementaireDto> findById(@PathVariable Long id) {
        TypeHeureSupplementaire t = service.findById(id);
        if (t != null) {
            TypeHeureSupplementaireDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a typeHeureSupplementaire by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeHeureSupplementaireDto> findByLibelle(@PathVariable String libelle) {
	    TypeHeureSupplementaire t = service.findByReferenceEntity(new TypeHeureSupplementaire(libelle));
        if (t != null) {
            TypeHeureSupplementaireDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  typeHeureSupplementaire")
    @PostMapping("")
    public ResponseEntity<TypeHeureSupplementaireDto> save(@RequestBody TypeHeureSupplementaireDto dto) throws Exception {
        if(dto!=null){
            TypeHeureSupplementaire myT = converter.toItem(dto);
            TypeHeureSupplementaire t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                TypeHeureSupplementaireDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  typeHeureSupplementaire")
    @PutMapping("")
    public ResponseEntity<TypeHeureSupplementaireDto> update(@RequestBody TypeHeureSupplementaireDto dto) throws Exception {
        ResponseEntity<TypeHeureSupplementaireDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            TypeHeureSupplementaire t = service.findById(dto.getId());
            converter.copy(dto,t);
            TypeHeureSupplementaire updated = service.update(t);
            TypeHeureSupplementaireDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of typeHeureSupplementaire")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeHeureSupplementaireDto>> delete(@RequestBody List<TypeHeureSupplementaireDto> dtos) throws Exception {
        ResponseEntity<List<TypeHeureSupplementaireDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<TypeHeureSupplementaire> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified typeHeureSupplementaire")
    @DeleteMapping("")
    public ResponseEntity<TypeHeureSupplementaireDto> delete(@RequestBody TypeHeureSupplementaireDto dto) throws Exception {
		ResponseEntity<TypeHeureSupplementaireDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            TypeHeureSupplementaire t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified typeHeureSupplementaire")
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
    @Operation(summary = "Delete multiple typeHeureSupplementaires by ids")
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



    @Operation(summary = "Finds a typeHeureSupplementaire and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TypeHeureSupplementaireDto> findWithAssociatedLists(@PathVariable Long id) {
        TypeHeureSupplementaire loaded =  service.findWithAssociatedLists(id);
        TypeHeureSupplementaireDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds typeHeureSupplementaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeHeureSupplementaireDto>> findByCriteria(@RequestBody TypeHeureSupplementaireCriteria criteria) throws Exception {
        ResponseEntity<List<TypeHeureSupplementaireDto>> res = null;
        List<TypeHeureSupplementaire> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeHeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated typeHeureSupplementaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeHeureSupplementaireCriteria criteria) throws Exception {
        List<TypeHeureSupplementaire> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<TypeHeureSupplementaireDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets typeHeureSupplementaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeHeureSupplementaireCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<TypeHeureSupplementaireDto> findDtos(List<TypeHeureSupplementaire> list){
        List<TypeHeureSupplementaireDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<TypeHeureSupplementaireDto> getDtoResponseEntity(TypeHeureSupplementaireDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private TypeHeureSupplementaireAdminService service;
    @Autowired private TypeHeureSupplementaireConverter converter;





}
