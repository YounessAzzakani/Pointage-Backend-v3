package  ma.zs.rh.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.commun.PaiementAgent;
import ma.zs.rh.dao.criteria.core.commun.PaiementAgentCriteria;
import ma.zs.rh.service.facade.admin.commun.PaiementAgentAdminService;
import ma.zs.rh.ws.converter.commun.PaiementAgentConverter;
import ma.zs.rh.ws.dto.commun.PaiementAgentDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/paiementAgent/")
public class PaiementAgentRestAdmin {




    @Operation(summary = "Finds a list of all paiementAgents")
    @GetMapping("")
    public ResponseEntity<List<PaiementAgentDto>> findAll() throws Exception {
        ResponseEntity<List<PaiementAgentDto>> res = null;
        List<PaiementAgent> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<PaiementAgentDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all paiementAgents")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementAgentDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<PaiementAgentDto>> res = null;
        List<PaiementAgent> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<PaiementAgentDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a paiementAgent by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementAgentDto> findById(@PathVariable Long id) {
        PaiementAgent t = service.findById(id);
        if (t != null) {
            converter.init(true);
            PaiementAgentDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a paiementAgent by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<PaiementAgentDto> findByRef(@PathVariable String ref) {
	    PaiementAgent t = service.findByReferenceEntity(new PaiementAgent(ref));
        if (t != null) {
            converter.init(true);
            PaiementAgentDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  paiementAgent")
    @PostMapping("")
    public ResponseEntity<PaiementAgentDto> save(@RequestBody PaiementAgentDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            PaiementAgent myT = converter.toItem(dto);
            PaiementAgent t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                PaiementAgentDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  paiementAgent")
    @PutMapping("")
    public ResponseEntity<PaiementAgentDto> update(@RequestBody PaiementAgentDto dto) throws Exception {
        ResponseEntity<PaiementAgentDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            PaiementAgent t = service.findById(dto.getId());
            converter.copy(dto,t);
            PaiementAgent updated = service.update(t);
            PaiementAgentDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of paiementAgent")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementAgentDto>> delete(@RequestBody List<PaiementAgentDto> dtos) throws Exception {
        ResponseEntity<List<PaiementAgentDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<PaiementAgent> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified paiementAgent")
    @DeleteMapping("")
    public ResponseEntity<PaiementAgentDto> delete(@RequestBody PaiementAgentDto dto) throws Exception {
		ResponseEntity<PaiementAgentDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            PaiementAgent t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified paiementAgent")
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
    @Operation(summary = "Delete multiple paiementAgents by ids")
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



    @Operation(summary = "Finds a paiementAgent and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<PaiementAgentDto> findWithAssociatedLists(@PathVariable Long id) {
        PaiementAgent loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        PaiementAgentDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds paiementAgents by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementAgentDto>> findByCriteria(@RequestBody PaiementAgentCriteria criteria) throws Exception {
        ResponseEntity<List<PaiementAgentDto>> res = null;
        List<PaiementAgent> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<PaiementAgentDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated paiementAgents by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementAgentCriteria criteria) throws Exception {
        List<PaiementAgent> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<PaiementAgentDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets paiementAgent data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementAgentCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<PaiementAgentDto> findDtos(List<PaiementAgent> list){
        converter.initObject(true);
        List<PaiementAgentDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<PaiementAgentDto> getDtoResponseEntity(PaiementAgentDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private PaiementAgentAdminService service;
    @Autowired private PaiementAgentConverter converter;





}
