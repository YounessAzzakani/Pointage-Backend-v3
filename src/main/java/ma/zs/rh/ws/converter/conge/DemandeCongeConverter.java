package  ma.zs.rh.ws.converter.conge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.ws.converter.commun.AgentConverter;
import ma.zs.rh.ws.converter.conge.MotifRejetDemandeCongeConverter;
import ma.zs.rh.ws.converter.conge.EtatDemandeCongeConverter;
import ma.zs.rh.ws.converter.commun.EntiteAdministrativeConverter;
import ma.zs.rh.ws.converter.conge.RaisonCongeConverter;



import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.conge.DemandeConge;
import ma.zs.rh.ws.dto.conge.DemandeCongeDto;

@Component
public class DemandeCongeConverter {

    @Autowired
    private AgentConverter agentConverter ;
    @Autowired
    private MotifRejetDemandeCongeConverter motifRejetDemandeCongeConverter ;
    @Autowired
    private EtatDemandeCongeConverter etatDemandeCongeConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private RaisonCongeConverter raisonCongeConverter ;
    private boolean motifRejetDemandeConge;
    private boolean manager;
    private boolean agent;
    private boolean raisonConge;
    private boolean etatDemandeConge;
    private boolean entiteAdministrative;

    public  DemandeCongeConverter() {
        initObject(true);
    }


    public DemandeConge toItem(DemandeCongeDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandeConge item = new DemandeConge();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getContenu()))
                item.setContenu(dto.getContenu());
            if(StringUtil.isNotEmpty(dto.getDateDepart()))
                item.setDateDepart(DateUtil.stringEnToDate(dto.getDateDepart()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(StringUtil.isNotEmpty(dto.getNombreJour()))
                item.setNombreJour(dto.getNombreJour());
            if(this.motifRejetDemandeConge && dto.getMotifRejetDemandeConge()!=null)
                item.setMotifRejetDemandeConge(motifRejetDemandeCongeConverter.toItem(dto.getMotifRejetDemandeConge())) ;

            if(this.manager && dto.getManager()!=null)
                item.setManager(agentConverter.toItem(dto.getManager())) ;

            if(this.agent && dto.getAgent()!=null)
                item.setAgent(agentConverter.toItem(dto.getAgent())) ;

            if(this.raisonConge && dto.getRaisonConge()!=null)
                item.setRaisonConge(raisonCongeConverter.toItem(dto.getRaisonConge())) ;

            if(this.etatDemandeConge && dto.getEtatDemandeConge()!=null)
                item.setEtatDemandeConge(etatDemandeCongeConverter.toItem(dto.getEtatDemandeConge())) ;

            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;




        return item;
        }
    }


    public DemandeCongeDto toDto(DemandeConge item) {
        if (item == null) {
            return null;
        } else {
            DemandeCongeDto dto = new DemandeCongeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getContenu()))
                dto.setContenu(item.getContenu());
            if(item.getDateDepart()!=null)
                dto.setDateDepart(DateUtil.dateTimeToString(item.getDateDepart()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(StringUtil.isNotEmpty(item.getNombreJour()))
                dto.setNombreJour(item.getNombreJour());
            if(this.motifRejetDemandeConge && item.getMotifRejetDemandeConge()!=null) {
                dto.setMotifRejetDemandeConge(motifRejetDemandeCongeConverter.toDto(item.getMotifRejetDemandeConge())) ;

            }
            if(this.manager && item.getManager()!=null) {
                dto.setManager(agentConverter.toDto(item.getManager())) ;

            }
            if(this.agent && item.getAgent()!=null) {
                dto.setAgent(agentConverter.toDto(item.getAgent())) ;

            }
            if(this.raisonConge && item.getRaisonConge()!=null) {
                dto.setRaisonConge(raisonCongeConverter.toDto(item.getRaisonConge())) ;

            }
            if(this.etatDemandeConge && item.getEtatDemandeConge()!=null) {
                dto.setEtatDemandeConge(etatDemandeCongeConverter.toDto(item.getEtatDemandeConge())) ;

            }
            if(this.entiteAdministrative && item.getEntiteAdministrative()!=null) {
                dto.setEntiteAdministrative(entiteAdministrativeConverter.toDto(item.getEntiteAdministrative())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.motifRejetDemandeConge = value;
        this.manager = value;
        this.agent = value;
        this.raisonConge = value;
        this.etatDemandeConge = value;
        this.entiteAdministrative = value;
    }
	
    public List<DemandeConge> toItem(List<DemandeCongeDto> dtos) {
        List<DemandeConge> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (DemandeCongeDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<DemandeCongeDto> toDto(List<DemandeConge> items) {
        List<DemandeCongeDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (DemandeConge item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(DemandeCongeDto dto, DemandeConge t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getMotifRejetDemandeConge() != null)
        motifRejetDemandeCongeConverter.copy(dto.getMotifRejetDemandeConge(), t.getMotifRejetDemandeConge());
        if (dto.getManager() != null)
        agentConverter.copy(dto.getManager(), t.getManager());
        if (dto.getAgent() != null)
        agentConverter.copy(dto.getAgent(), t.getAgent());
        if (dto.getRaisonConge() != null)
        raisonCongeConverter.copy(dto.getRaisonConge(), t.getRaisonConge());
        if (dto.getEtatDemandeConge() != null)
        etatDemandeCongeConverter.copy(dto.getEtatDemandeConge(), t.getEtatDemandeConge());
        if (dto.getEntiteAdministrative() != null)
        entiteAdministrativeConverter.copy(dto.getEntiteAdministrative(), t.getEntiteAdministrative());
    }

    public List<DemandeConge> copy(List<DemandeCongeDto> dtos) {
        List<DemandeConge> result = new ArrayList<>();
        if (dtos != null) {
            for (DemandeCongeDto dto : dtos) {
                DemandeConge instance = new DemandeConge();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public AgentConverter getAgentConverter(){
        return this.agentConverter;
    }
    public void setAgentConverter(AgentConverter agentConverter ){
        this.agentConverter = agentConverter;
    }
    public MotifRejetDemandeCongeConverter getMotifRejetDemandeCongeConverter(){
        return this.motifRejetDemandeCongeConverter;
    }
    public void setMotifRejetDemandeCongeConverter(MotifRejetDemandeCongeConverter motifRejetDemandeCongeConverter ){
        this.motifRejetDemandeCongeConverter = motifRejetDemandeCongeConverter;
    }
    public EtatDemandeCongeConverter getEtatDemandeCongeConverter(){
        return this.etatDemandeCongeConverter;
    }
    public void setEtatDemandeCongeConverter(EtatDemandeCongeConverter etatDemandeCongeConverter ){
        this.etatDemandeCongeConverter = etatDemandeCongeConverter;
    }
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public RaisonCongeConverter getRaisonCongeConverter(){
        return this.raisonCongeConverter;
    }
    public void setRaisonCongeConverter(RaisonCongeConverter raisonCongeConverter ){
        this.raisonCongeConverter = raisonCongeConverter;
    }
    public boolean  isMotifRejetDemandeConge(){
        return this.motifRejetDemandeConge;
    }
    public void  setMotifRejetDemandeConge(boolean motifRejetDemandeConge){
        this.motifRejetDemandeConge = motifRejetDemandeConge;
    }
    public boolean  isManager(){
        return this.manager;
    }
    public void  setManager(boolean manager){
        this.manager = manager;
    }
    public boolean  isAgent(){
        return this.agent;
    }
    public void  setAgent(boolean agent){
        this.agent = agent;
    }
    public boolean  isRaisonConge(){
        return this.raisonConge;
    }
    public void  setRaisonConge(boolean raisonConge){
        this.raisonConge = raisonConge;
    }
    public boolean  isEtatDemandeConge(){
        return this.etatDemandeConge;
    }
    public void  setEtatDemandeConge(boolean etatDemandeConge){
        this.etatDemandeConge = etatDemandeConge;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
}
