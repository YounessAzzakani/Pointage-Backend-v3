package  ma.zs.rh.ws.facade.admin.docadmin;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.docadmin.TypeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.TypeDocumentAdministratifCriteria;
import ma.zs.rh.service.facade.admin.docadmin.TypeDocumentAdministratifAdminService;
import ma.zs.rh.ws.converter.docadmin.TypeDocumentAdministratifConverter;
import ma.zs.rh.ws.dto.docadmin.TypeDocumentAdministratifDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/typeDocumentAdministratif/")
public class TypeDocumentAdministratifRestAdmin {




    @Operation(summary = "Finds a list of all typeDocumentAdministratifs")
    @GetMapping("")
    public ResponseEntity<List<TypeDocumentAdministratifDto>> findAll() throws Exception {
        ResponseEntity<List<TypeDocumentAdministratifDto>> res = null;
        List<TypeDocumentAdministratif> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all typeDocumentAdministratifs")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeDocumentAdministratifDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<TypeDocumentAdministratifDto>> res = null;
        List<TypeDocumentAdministratif> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a typeDocumentAdministratif by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeDocumentAdministratifDto> findById(@PathVariable Long id) {
        TypeDocumentAdministratif t = service.findById(id);
        if (t != null) {
            TypeDocumentAdministratifDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a typeDocumentAdministratif by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeDocumentAdministratifDto> findByLibelle(@PathVariable String libelle) {
	    TypeDocumentAdministratif t = service.findByReferenceEntity(new TypeDocumentAdministratif(libelle));
        if (t != null) {
            TypeDocumentAdministratifDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  typeDocumentAdministratif")
    @PostMapping("")
    public ResponseEntity<TypeDocumentAdministratifDto> save(@RequestBody TypeDocumentAdministratifDto dto) throws Exception {
        if(dto!=null){
            TypeDocumentAdministratif myT = converter.toItem(dto);
            TypeDocumentAdministratif t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                TypeDocumentAdministratifDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  typeDocumentAdministratif")
    @PutMapping("")
    public ResponseEntity<TypeDocumentAdministratifDto> update(@RequestBody TypeDocumentAdministratifDto dto) throws Exception {
        ResponseEntity<TypeDocumentAdministratifDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            TypeDocumentAdministratif t = service.findById(dto.getId());
            converter.copy(dto,t);
            TypeDocumentAdministratif updated = service.update(t);
            TypeDocumentAdministratifDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of typeDocumentAdministratif")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeDocumentAdministratifDto>> delete(@RequestBody List<TypeDocumentAdministratifDto> dtos) throws Exception {
        ResponseEntity<List<TypeDocumentAdministratifDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<TypeDocumentAdministratif> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified typeDocumentAdministratif")
    @DeleteMapping("")
    public ResponseEntity<TypeDocumentAdministratifDto> delete(@RequestBody TypeDocumentAdministratifDto dto) throws Exception {
		ResponseEntity<TypeDocumentAdministratifDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            TypeDocumentAdministratif t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified typeDocumentAdministratif")
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
    @Operation(summary = "Delete multiple typeDocumentAdministratifs by ids")
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



    @Operation(summary = "Finds a typeDocumentAdministratif and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TypeDocumentAdministratifDto> findWithAssociatedLists(@PathVariable Long id) {
        TypeDocumentAdministratif loaded =  service.findWithAssociatedLists(id);
        TypeDocumentAdministratifDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds typeDocumentAdministratifs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeDocumentAdministratifDto>> findByCriteria(@RequestBody TypeDocumentAdministratifCriteria criteria) throws Exception {
        ResponseEntity<List<TypeDocumentAdministratifDto>> res = null;
        List<TypeDocumentAdministratif> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated typeDocumentAdministratifs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeDocumentAdministratifCriteria criteria) throws Exception {
        List<TypeDocumentAdministratif> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<TypeDocumentAdministratifDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets typeDocumentAdministratif data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeDocumentAdministratifCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<TypeDocumentAdministratifDto> findDtos(List<TypeDocumentAdministratif> list){
        List<TypeDocumentAdministratifDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<TypeDocumentAdministratifDto> getDtoResponseEntity(TypeDocumentAdministratifDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private TypeDocumentAdministratifAdminService service;
    @Autowired private TypeDocumentAdministratifConverter converter;





}
