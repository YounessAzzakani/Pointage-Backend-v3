package  ma.zs.rh.ws.facade.agent.heuresupp;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;

import ma.zs.rh.bean.core.heuresupp.EtatTypeHeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.EtatTypeHeureSupplementaireCriteria;
import ma.zs.rh.service.facade.agent.heuresupp.EtatTypeHeureSupplementaireAgentService;
import ma.zs.rh.ws.converter.heuresupp.EtatTypeHeureSupplementaireConverter;
import ma.zs.rh.ws.dto.heuresupp.EtatTypeHeureSupplementaireDto;
import ma.zs.rh.zbiblio.util.PaginatedList;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/agent/etatTypeHeureSupplementaire/")
public class EtatTypeHeureSupplementaireRestAgent {




    @Operation(summary = "Finds a list of all etatTypeHeureSupplementaires")
    @GetMapping("")
    public ResponseEntity<List<EtatTypeHeureSupplementaireDto>> findAll() throws Exception {
        ResponseEntity<List<EtatTypeHeureSupplementaireDto>> res = null;
        List<EtatTypeHeureSupplementaire> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatTypeHeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all etatTypeHeureSupplementaires")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatTypeHeureSupplementaireDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<EtatTypeHeureSupplementaireDto>> res = null;
        List<EtatTypeHeureSupplementaire> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatTypeHeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a etatTypeHeureSupplementaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatTypeHeureSupplementaireDto> findById(@PathVariable Long id) {
        EtatTypeHeureSupplementaire t = service.findById(id);
        if (t != null) {
            EtatTypeHeureSupplementaireDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a etatTypeHeureSupplementaire by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatTypeHeureSupplementaireDto> findByLibelle(@PathVariable String libelle) {
	    EtatTypeHeureSupplementaire t = service.findByReferenceEntity(new EtatTypeHeureSupplementaire(libelle));
        if (t != null) {
            EtatTypeHeureSupplementaireDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  etatTypeHeureSupplementaire")
    @PostMapping("")
    public ResponseEntity<EtatTypeHeureSupplementaireDto> save(@RequestBody EtatTypeHeureSupplementaireDto dto) throws Exception {
        if(dto!=null){
            EtatTypeHeureSupplementaire myT = converter.toItem(dto);
            EtatTypeHeureSupplementaire t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                EtatTypeHeureSupplementaireDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  etatTypeHeureSupplementaire")
    @PutMapping("")
    public ResponseEntity<EtatTypeHeureSupplementaireDto> update(@RequestBody EtatTypeHeureSupplementaireDto dto) throws Exception {
        ResponseEntity<EtatTypeHeureSupplementaireDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            EtatTypeHeureSupplementaire t = service.findById(dto.getId());
            converter.copy(dto,t);
            EtatTypeHeureSupplementaire updated = service.update(t);
            EtatTypeHeureSupplementaireDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of etatTypeHeureSupplementaire")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatTypeHeureSupplementaireDto>> delete(@RequestBody List<EtatTypeHeureSupplementaireDto> dtos) throws Exception {
        ResponseEntity<List<EtatTypeHeureSupplementaireDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<EtatTypeHeureSupplementaire> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified etatTypeHeureSupplementaire")
    @DeleteMapping("")
    public ResponseEntity<EtatTypeHeureSupplementaireDto> delete(@RequestBody EtatTypeHeureSupplementaireDto dto) throws Exception {
		ResponseEntity<EtatTypeHeureSupplementaireDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            EtatTypeHeureSupplementaire t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified etatTypeHeureSupplementaire")
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
    @Operation(summary = "Delete multiple etatTypeHeureSupplementaires by ids")
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



    @Operation(summary = "Finds a etatTypeHeureSupplementaire and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<EtatTypeHeureSupplementaireDto> findWithAssociatedLists(@PathVariable Long id) {
        EtatTypeHeureSupplementaire loaded =  service.findWithAssociatedLists(id);
        EtatTypeHeureSupplementaireDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds etatTypeHeureSupplementaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatTypeHeureSupplementaireDto>> findByCriteria(@RequestBody EtatTypeHeureSupplementaireCriteria criteria) throws Exception {
        ResponseEntity<List<EtatTypeHeureSupplementaireDto>> res = null;
        List<EtatTypeHeureSupplementaire> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<EtatTypeHeureSupplementaireDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated etatTypeHeureSupplementaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatTypeHeureSupplementaireCriteria criteria) throws Exception {
        List<EtatTypeHeureSupplementaire> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<EtatTypeHeureSupplementaireDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets etatTypeHeureSupplementaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatTypeHeureSupplementaireCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<EtatTypeHeureSupplementaireDto> findDtos(List<EtatTypeHeureSupplementaire> list){
        List<EtatTypeHeureSupplementaireDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<EtatTypeHeureSupplementaireDto> getDtoResponseEntity(EtatTypeHeureSupplementaireDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private EtatTypeHeureSupplementaireAgentService service;
    @Autowired private EtatTypeHeureSupplementaireConverter converter;





}
