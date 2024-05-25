package  ma.zs.rh.ws.facade.agent.retard;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.rh.bean.core.retard.JustificationRetard;
import ma.zs.rh.dao.criteria.core.retard.JustificationRetardCriteria;
import ma.zs.rh.service.facade.agent.retard.JustificationRetardAgentService;
import ma.zs.rh.ws.converter.retard.JustificationRetardConverter;
import ma.zs.rh.ws.dto.retard.JustificationRetardDto;
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
@RequestMapping("/api/agent/justificationRetard/")
public class JustificationRetardRestAgent {




    @Operation(summary = "Finds a list of all justificationRetards")
    @GetMapping("")
    public ResponseEntity<List<JustificationRetardDto>> findAll() throws Exception {
        ResponseEntity<List<JustificationRetardDto>> res = null;
        List<JustificationRetard> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<JustificationRetardDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all justificationRetards")
    @GetMapping("optimized")
    public ResponseEntity<List<JustificationRetardDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<JustificationRetardDto>> res = null;
        List<JustificationRetard> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<JustificationRetardDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a justificationRetard by id")
    @GetMapping("id/{id}")
    public ResponseEntity<JustificationRetardDto> findById(@PathVariable Long id) {
        JustificationRetard t = service.findById(id);
        if (t != null) {
            JustificationRetardDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a justificationRetard by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<JustificationRetardDto> findByLibelle(@PathVariable String libelle) {
	    JustificationRetard t = service.findByReferenceEntity(new JustificationRetard(libelle));
        if (t != null) {
            JustificationRetardDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  justificationRetard")
    @PostMapping("")
    public ResponseEntity<JustificationRetardDto> save(@RequestBody JustificationRetardDto dto) throws Exception {
        if(dto!=null){
            JustificationRetard myT = converter.toItem(dto);
            JustificationRetard t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                JustificationRetardDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  justificationRetard")
    @PutMapping("")
    public ResponseEntity<JustificationRetardDto> update(@RequestBody JustificationRetardDto dto) throws Exception {
        ResponseEntity<JustificationRetardDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            JustificationRetard t = service.findById(dto.getId());
            converter.copy(dto,t);
            JustificationRetard updated = service.update(t);
            JustificationRetardDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of justificationRetard")
    @PostMapping("multiple")
    public ResponseEntity<List<JustificationRetardDto>> delete(@RequestBody List<JustificationRetardDto> dtos) throws Exception {
        ResponseEntity<List<JustificationRetardDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<JustificationRetard> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified justificationRetard")
    @DeleteMapping("")
    public ResponseEntity<JustificationRetardDto> delete(@RequestBody JustificationRetardDto dto) throws Exception {
		ResponseEntity<JustificationRetardDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            JustificationRetard t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified justificationRetard")
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
    @Operation(summary = "Delete multiple justificationRetards by ids")
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



    @Operation(summary = "Finds a justificationRetard and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<JustificationRetardDto> findWithAssociatedLists(@PathVariable Long id) {
        JustificationRetard loaded =  service.findWithAssociatedLists(id);
        JustificationRetardDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds justificationRetards by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<JustificationRetardDto>> findByCriteria(@RequestBody JustificationRetardCriteria criteria) throws Exception {
        ResponseEntity<List<JustificationRetardDto>> res = null;
        List<JustificationRetard> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<JustificationRetardDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated justificationRetards by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody JustificationRetardCriteria criteria) throws Exception {
        List<JustificationRetard> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<JustificationRetardDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets justificationRetard data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody JustificationRetardCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<JustificationRetardDto> findDtos(List<JustificationRetard> list){
        List<JustificationRetardDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<JustificationRetardDto> getDtoResponseEntity(JustificationRetardDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private JustificationRetardAgentService service;
    @Autowired private JustificationRetardConverter converter;





}
