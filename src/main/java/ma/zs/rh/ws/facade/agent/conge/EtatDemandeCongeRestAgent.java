package  ma.zs.rh.ws.facade.agent.conge;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.rh.bean.core.conge.EtatDemandeConge;
import ma.zs.rh.dao.criteria.core.conge.EtatDemandeCongeCriteria;
import ma.zs.rh.service.facade.agent.conge.EtatDemandeCongeAgentService;
import ma.zs.rh.ws.converter.conge.EtatDemandeCongeConverter;
import ma.zs.rh.ws.dto.conge.EtatDemandeCongeDto;
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
@RequestMapping("/api/agent/etatDemandeConge/")
public class EtatDemandeCongeRestAgent {




    @Operation(summary = "Finds a list of all etatDemandeConges")
    @GetMapping("")
    public ResponseEntity<List<EtatDemandeCongeDto>> findAll() throws Exception {
        ResponseEntity<List<EtatDemandeCongeDto>> res = null;
        List<EtatDemandeConge> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all etatDemandeConges")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatDemandeCongeDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<EtatDemandeCongeDto>> res = null;
        List<EtatDemandeConge> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a etatDemandeConge by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatDemandeCongeDto> findById(@PathVariable Long id) {
        EtatDemandeConge t = service.findById(id);
        if (t != null) {
            EtatDemandeCongeDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a etatDemandeConge by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatDemandeCongeDto> findByLibelle(@PathVariable String libelle) {
	    EtatDemandeConge t = service.findByReferenceEntity(new EtatDemandeConge(libelle));
        if (t != null) {
            EtatDemandeCongeDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  etatDemandeConge")
    @PostMapping("")
    public ResponseEntity<EtatDemandeCongeDto> save(@RequestBody EtatDemandeCongeDto dto) throws Exception {
        if(dto!=null){
            EtatDemandeConge myT = converter.toItem(dto);
            EtatDemandeConge t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                EtatDemandeCongeDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  etatDemandeConge")
    @PutMapping("")
    public ResponseEntity<EtatDemandeCongeDto> update(@RequestBody EtatDemandeCongeDto dto) throws Exception {
        ResponseEntity<EtatDemandeCongeDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            EtatDemandeConge t = service.findById(dto.getId());
            converter.copy(dto,t);
            EtatDemandeConge updated = service.update(t);
            EtatDemandeCongeDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of etatDemandeConge")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatDemandeCongeDto>> delete(@RequestBody List<EtatDemandeCongeDto> dtos) throws Exception {
        ResponseEntity<List<EtatDemandeCongeDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<EtatDemandeConge> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified etatDemandeConge")
    @DeleteMapping("")
    public ResponseEntity<EtatDemandeCongeDto> delete(@RequestBody EtatDemandeCongeDto dto) throws Exception {
		ResponseEntity<EtatDemandeCongeDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            EtatDemandeConge t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified etatDemandeConge")
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
    @Operation(summary = "Delete multiple etatDemandeConges by ids")
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



    @Operation(summary = "Finds a etatDemandeConge and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<EtatDemandeCongeDto> findWithAssociatedLists(@PathVariable Long id) {
        EtatDemandeConge loaded =  service.findWithAssociatedLists(id);
        EtatDemandeCongeDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds etatDemandeConges by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatDemandeCongeDto>> findByCriteria(@RequestBody EtatDemandeCongeCriteria criteria) throws Exception {
        ResponseEntity<List<EtatDemandeCongeDto>> res = null;
        List<EtatDemandeConge> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatDemandeCongeDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated etatDemandeConges by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatDemandeCongeCriteria criteria) throws Exception {
        List<EtatDemandeConge> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<EtatDemandeCongeDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets etatDemandeConge data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatDemandeCongeCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<EtatDemandeCongeDto> findDtos(List<EtatDemandeConge> list){
        List<EtatDemandeCongeDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<EtatDemandeCongeDto> getDtoResponseEntity(EtatDemandeCongeDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private EtatDemandeCongeAgentService service;
    @Autowired private EtatDemandeCongeConverter converter;





}
