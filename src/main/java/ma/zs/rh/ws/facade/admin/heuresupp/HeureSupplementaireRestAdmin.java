package  ma.zs.rh.ws.facade.admin.heuresupp;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.heuresupp.HeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.HeureSupplementaireCriteria;
import ma.zs.rh.service.facade.admin.heuresupp.HeureSupplementaireAdminService;
import ma.zs.rh.ws.converter.heuresupp.HeureSupplementaireConverter;
import ma.zs.rh.ws.dto.heuresupp.HeureSupplementaireDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/heureSupplementaire/")
public class HeureSupplementaireRestAdmin {




    @Operation(summary = "Finds a list of all heureSupplementaires")
    @GetMapping("")
    public ResponseEntity<List<HeureSupplementaireDto>> findAll() throws Exception {
        ResponseEntity<List<HeureSupplementaireDto>> res = null;
        List<HeureSupplementaire> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<HeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all heureSupplementaires")
    @GetMapping("optimized")
    public ResponseEntity<List<HeureSupplementaireDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<HeureSupplementaireDto>> res = null;
        List<HeureSupplementaire> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<HeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a heureSupplementaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<HeureSupplementaireDto> findById(@PathVariable Long id) {
        HeureSupplementaire t = service.findById(id);
        if (t != null) {
            converter.init(true);
            HeureSupplementaireDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a heureSupplementaire by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<HeureSupplementaireDto> findByRef(@PathVariable String ref) {
	    HeureSupplementaire t = service.findByReferenceEntity(new HeureSupplementaire(ref));
        if (t != null) {
            converter.init(true);
            HeureSupplementaireDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  heureSupplementaire")
    @PostMapping("")
    public ResponseEntity<HeureSupplementaireDto> save(@RequestBody HeureSupplementaireDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            HeureSupplementaire myT = converter.toItem(dto);
            HeureSupplementaire t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                HeureSupplementaireDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  heureSupplementaire")
    @PutMapping("")
    public ResponseEntity<HeureSupplementaireDto> update(@RequestBody HeureSupplementaireDto dto) throws Exception {
        ResponseEntity<HeureSupplementaireDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            HeureSupplementaire t = service.findById(dto.getId());
            converter.copy(dto,t);
            HeureSupplementaire updated = service.update(t);
            HeureSupplementaireDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of heureSupplementaire")
    @PostMapping("multiple")
    public ResponseEntity<List<HeureSupplementaireDto>> delete(@RequestBody List<HeureSupplementaireDto> dtos) throws Exception {
        ResponseEntity<List<HeureSupplementaireDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<HeureSupplementaire> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified heureSupplementaire")
    @DeleteMapping("")
    public ResponseEntity<HeureSupplementaireDto> delete(@RequestBody HeureSupplementaireDto dto) throws Exception {
		ResponseEntity<HeureSupplementaireDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            HeureSupplementaire t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified heureSupplementaire")
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
    @Operation(summary = "Delete multiple heureSupplementaires by ids")
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
    public List<HeureSupplementaireDto> findByEntiteAdministrativeId(@PathVariable Long id){
        return findDtos(service.findByEntiteAdministrativeId(id));
    }
    @Operation(summary = "delete by entiteAdministrative id")
    @DeleteMapping("entiteAdministrative/id/{id}")
    public int deleteByEntiteAdministrativeId(@PathVariable Long id){
        return service.deleteByEntiteAdministrativeId(id);
    }

    @Operation(summary = "Finds a heureSupplementaire and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<HeureSupplementaireDto> findWithAssociatedLists(@PathVariable Long id) {
        HeureSupplementaire loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        HeureSupplementaireDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds heureSupplementaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<HeureSupplementaireDto>> findByCriteria(@RequestBody HeureSupplementaireCriteria criteria) throws Exception {
        ResponseEntity<List<HeureSupplementaireDto>> res = null;
        List<HeureSupplementaire> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<HeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated heureSupplementaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody HeureSupplementaireCriteria criteria) throws Exception {
        List<HeureSupplementaire> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<HeureSupplementaireDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets heureSupplementaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody HeureSupplementaireCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<HeureSupplementaireDto> findDtos(List<HeureSupplementaire> list){
        converter.initObject(true);
        List<HeureSupplementaireDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<HeureSupplementaireDto> getDtoResponseEntity(HeureSupplementaireDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private HeureSupplementaireAdminService service;
    @Autowired private HeureSupplementaireConverter converter;





}
