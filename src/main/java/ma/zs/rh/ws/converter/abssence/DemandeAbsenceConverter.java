package  ma.zs.rh.ws.converter.abssence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.ws.converter.commun.AgentConverter;
import ma.zs.rh.ws.converter.abssence.RaisonAbsenceConverter;
import ma.zs.rh.ws.converter.abssence.EtatDemandeAbsenceConverter;
import ma.zs.rh.ws.converter.commun.EntiteAdministrativeConverter;
import ma.zs.rh.ws.converter.abssence.MotifRejetDemandeAbsenceConverter;



import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.abssence.DemandeAbsence;
import ma.zs.rh.ws.dto.abssence.DemandeAbsenceDto;

@Component
public class DemandeAbsenceConverter {

    @Autowired
    private AgentConverter agentConverter ;
    @Autowired
    private RaisonAbsenceConverter raisonAbsenceConverter ;
    @Autowired
    private EtatDemandeAbsenceConverter etatDemandeAbsenceConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private MotifRejetDemandeAbsenceConverter motifRejetDemandeAbsenceConverter ;
    private boolean motifRejetDemandeAbsence;
    private boolean entiteAdministrative;
    private boolean manager;
    private boolean agent;
    private boolean raisonAbsence;
    private boolean etatDemandeAbsence;

    public  DemandeAbsenceConverter() {
        initObject(true);
    }


    public DemandeAbsence toItem(DemandeAbsenceDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandeAbsence item = new DemandeAbsence();
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
            if(this.motifRejetDemandeAbsence && dto.getMotifRejetDemandeAbsence()!=null)
                item.setMotifRejetDemandeAbsence(motifRejetDemandeAbsenceConverter.toItem(dto.getMotifRejetDemandeAbsence())) ;

            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;

            if(this.manager && dto.getManager()!=null)
                item.setManager(agentConverter.toItem(dto.getManager())) ;

            if(this.agent && dto.getAgent()!=null)
                item.setAgent(agentConverter.toItem(dto.getAgent())) ;

            if(this.raisonAbsence && dto.getRaisonAbsence()!=null)
                item.setRaisonAbsence(raisonAbsenceConverter.toItem(dto.getRaisonAbsence())) ;

            if(this.etatDemandeAbsence && dto.getEtatDemandeAbsence()!=null)
                item.setEtatDemandeAbsence(etatDemandeAbsenceConverter.toItem(dto.getEtatDemandeAbsence())) ;




        return item;
        }
    }


    public DemandeAbsenceDto toDto(DemandeAbsence item) {
        if (item == null) {
            return null;
        } else {
            DemandeAbsenceDto dto = new DemandeAbsenceDto();
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
            if(this.motifRejetDemandeAbsence && item.getMotifRejetDemandeAbsence()!=null) {
                dto.setMotifRejetDemandeAbsence(motifRejetDemandeAbsenceConverter.toDto(item.getMotifRejetDemandeAbsence())) ;

            }
            if(this.entiteAdministrative && item.getEntiteAdministrative()!=null) {
                dto.setEntiteAdministrative(entiteAdministrativeConverter.toDto(item.getEntiteAdministrative())) ;

            }
            if(this.manager && item.getManager()!=null) {
                dto.setManager(agentConverter.toDto(item.getManager())) ;

            }
            if(this.agent && item.getAgent()!=null) {
                dto.setAgent(agentConverter.toDto(item.getAgent())) ;

            }
            if(this.raisonAbsence && item.getRaisonAbsence()!=null) {
                dto.setRaisonAbsence(raisonAbsenceConverter.toDto(item.getRaisonAbsence())) ;

            }
            if(this.etatDemandeAbsence && item.getEtatDemandeAbsence()!=null) {
                dto.setEtatDemandeAbsence(etatDemandeAbsenceConverter.toDto(item.getEtatDemandeAbsence())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.motifRejetDemandeAbsence = value;
        this.entiteAdministrative = value;
        this.manager = value;
        this.agent = value;
        this.raisonAbsence = value;
        this.etatDemandeAbsence = value;
    }
	
    public List<DemandeAbsence> toItem(List<DemandeAbsenceDto> dtos) {
        List<DemandeAbsence> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (DemandeAbsenceDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<DemandeAbsenceDto> toDto(List<DemandeAbsence> items) {
        List<DemandeAbsenceDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (DemandeAbsence item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(DemandeAbsenceDto dto, DemandeAbsence t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getMotifRejetDemandeAbsence() != null)
        motifRejetDemandeAbsenceConverter.copy(dto.getMotifRejetDemandeAbsence(), t.getMotifRejetDemandeAbsence());
        if (dto.getEntiteAdministrative() != null)
        entiteAdministrativeConverter.copy(dto.getEntiteAdministrative(), t.getEntiteAdministrative());
        if (dto.getManager() != null)
        agentConverter.copy(dto.getManager(), t.getManager());
        if (dto.getAgent() != null)
        agentConverter.copy(dto.getAgent(), t.getAgent());
        if (dto.getRaisonAbsence() != null)
        raisonAbsenceConverter.copy(dto.getRaisonAbsence(), t.getRaisonAbsence());
        if (dto.getEtatDemandeAbsence() != null)
        etatDemandeAbsenceConverter.copy(dto.getEtatDemandeAbsence(), t.getEtatDemandeAbsence());
    }

    public List<DemandeAbsence> copy(List<DemandeAbsenceDto> dtos) {
        List<DemandeAbsence> result = new ArrayList<>();
        if (dtos != null) {
            for (DemandeAbsenceDto dto : dtos) {
                DemandeAbsence instance = new DemandeAbsence();
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
    public RaisonAbsenceConverter getRaisonAbsenceConverter(){
        return this.raisonAbsenceConverter;
    }
    public void setRaisonAbsenceConverter(RaisonAbsenceConverter raisonAbsenceConverter ){
        this.raisonAbsenceConverter = raisonAbsenceConverter;
    }
    public EtatDemandeAbsenceConverter getEtatDemandeAbsenceConverter(){
        return this.etatDemandeAbsenceConverter;
    }
    public void setEtatDemandeAbsenceConverter(EtatDemandeAbsenceConverter etatDemandeAbsenceConverter ){
        this.etatDemandeAbsenceConverter = etatDemandeAbsenceConverter;
    }
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public MotifRejetDemandeAbsenceConverter getMotifRejetDemandeAbsenceConverter(){
        return this.motifRejetDemandeAbsenceConverter;
    }
    public void setMotifRejetDemandeAbsenceConverter(MotifRejetDemandeAbsenceConverter motifRejetDemandeAbsenceConverter ){
        this.motifRejetDemandeAbsenceConverter = motifRejetDemandeAbsenceConverter;
    }
    public boolean  isMotifRejetDemandeAbsence(){
        return this.motifRejetDemandeAbsence;
    }
    public void  setMotifRejetDemandeAbsence(boolean motifRejetDemandeAbsence){
        this.motifRejetDemandeAbsence = motifRejetDemandeAbsence;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
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
    public boolean  isRaisonAbsence(){
        return this.raisonAbsence;
    }
    public void  setRaisonAbsence(boolean raisonAbsence){
        this.raisonAbsence = raisonAbsence;
    }
    public boolean  isEtatDemandeAbsence(){
        return this.etatDemandeAbsence;
    }
    public void  setEtatDemandeAbsence(boolean etatDemandeAbsence){
        this.etatDemandeAbsence = etatDemandeAbsence;
    }
}
