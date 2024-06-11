package  ma.zs.rh.ws.facade.admin.docadmin;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.EtatDemandeDocumentAdministratifCriteria;
import ma.zs.rh.service.facade.admin.docadmin.EtatDemandeDocumentAdministratifAdminService;
import ma.zs.rh.ws.converter.docadmin.EtatDemandeDocumentAdministratifConverter;
import ma.zs.rh.ws.dto.docadmin.EtatDemandeDocumentAdministratifDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/etatDemandeDocumentAdministratif/")
public class EtatDemandeDocumentAdministratifRestAdmin {




    @Operation(summary = "Finds a list of all etatDemandeDocumentAdministratifs")
    @GetMapping("")
    public ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> findAll() throws Exception {
        ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> res = null;
        List<EtatDemandeDocumentAdministratif> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all etatDemandeDocumentAdministratifs")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> res = null;
        List<EtatDemandeDocumentAdministratif> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a etatDemandeDocumentAdministratif by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatDemandeDocumentAdministratifDto> findById(@PathVariable Long id) {
        EtatDemandeDocumentAdministratif t = service.findById(id);
        if (t != null) {
            EtatDemandeDocumentAdministratifDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a etatDemandeDocumentAdministratif by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatDemandeDocumentAdministratifDto> findByLibelle(@PathVariable String libelle) {
	    EtatDemandeDocumentAdministratif t = service.findByReferenceEntity(new EtatDemandeDocumentAdministratif(libelle));
        if (t != null) {
            EtatDemandeDocumentAdministratifDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  etatDemandeDocumentAdministratif")
    @PostMapping("")
    public ResponseEntity<EtatDemandeDocumentAdministratifDto> save(@RequestBody EtatDemandeDocumentAdministratifDto dto) throws Exception {
        if(dto!=null){
            EtatDemandeDocumentAdministratif myT = converter.toItem(dto);
            EtatDemandeDocumentAdministratif t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                EtatDemandeDocumentAdministratifDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  etatDemandeDocumentAdministratif")
    @PutMapping("")
    public ResponseEntity<EtatDemandeDocumentAdministratifDto> update(@RequestBody EtatDemandeDocumentAdministratifDto dto) throws Exception {
        ResponseEntity<EtatDemandeDocumentAdministratifDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            EtatDemandeDocumentAdministratif t = service.findById(dto.getId());
            converter.copy(dto,t);
            EtatDemandeDocumentAdministratif updated = service.update(t);
            EtatDemandeDocumentAdministratifDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of etatDemandeDocumentAdministratif")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> delete(@RequestBody List<EtatDemandeDocumentAdministratifDto> dtos) throws Exception {
        ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<EtatDemandeDocumentAdministratif> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified etatDemandeDocumentAdministratif")
    @DeleteMapping("")
    public ResponseEntity<EtatDemandeDocumentAdministratifDto> delete(@RequestBody EtatDemandeDocumentAdministratifDto dto) throws Exception {
		ResponseEntity<EtatDemandeDocumentAdministratifDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            EtatDemandeDocumentAdministratif t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified etatDemandeDocumentAdministratif")
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
    @Operation(summary = "Delete multiple etatDemandeDocumentAdministratifs by ids")
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



    @Operation(summary = "Finds a etatDemandeDocumentAdministratif and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<EtatDemandeDocumentAdministratifDto> findWithAssociatedLists(@PathVariable Long id) {
        EtatDemandeDocumentAdministratif loaded =  service.findWithAssociatedLists(id);
        EtatDemandeDocumentAdministratifDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds etatDemandeDocumentAdministratifs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> findByCriteria(@RequestBody EtatDemandeDocumentAdministratifCriteria criteria) throws Exception {
        ResponseEntity<List<EtatDemandeDocumentAdministratifDto>> res = null;
        List<EtatDemandeDocumentAdministratif> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeDocumentAdministratifDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated etatDemandeDocumentAdministratifs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatDemandeDocumentAdministratifCriteria criteria) throws Exception {
        List<EtatDemandeDocumentAdministratif> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<EtatDemandeDocumentAdministratifDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets etatDemandeDocumentAdministratif data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatDemandeDocumentAdministratifCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<EtatDemandeDocumentAdministratifDto> findDtos(List<EtatDemandeDocumentAdministratif> list){
        List<EtatDemandeDocumentAdministratifDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<EtatDemandeDocumentAdministratifDto> getDtoResponseEntity(EtatDemandeDocumentAdministratifDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private EtatDemandeDocumentAdministratifAdminService service;
    @Autowired private EtatDemandeDocumentAdministratifConverter converter;





}
