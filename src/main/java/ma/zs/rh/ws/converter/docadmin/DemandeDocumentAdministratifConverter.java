package  ma.zs.rh.ws.converter.docadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.ws.converter.commun.AgentConverter;
import ma.zs.rh.ws.converter.docadmin.EtatDemandeDocumentAdministratifConverter;
import ma.zs.rh.ws.converter.commun.EntiteAdministrativeConverter;
import ma.zs.rh.ws.converter.docadmin.TypeDocumentAdministratifConverter;



import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.docadmin.DemandeDocumentAdministratif;
import ma.zs.rh.ws.dto.docadmin.DemandeDocumentAdministratifDto;

@Component
public class DemandeDocumentAdministratifConverter {

    @Autowired
    private AgentConverter agentConverter ;
    @Autowired
    private EtatDemandeDocumentAdministratifConverter etatDemandeDocumentAdministratifConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private TypeDocumentAdministratifConverter typeDocumentAdministratifConverter ;
    private boolean typeDocumentAdministratif;
    private boolean agent;
    private boolean etatDemandeDocumentAdministratif;
    private boolean entiteAdministrative;

    public  DemandeDocumentAdministratifConverter() {
        initObject(true);
    }


    public DemandeDocumentAdministratif toItem(DemandeDocumentAdministratifDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandeDocumentAdministratif item = new DemandeDocumentAdministratif();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.typeDocumentAdministratif && dto.getTypeDocumentAdministratif()!=null)
                item.setTypeDocumentAdministratif(typeDocumentAdministratifConverter.toItem(dto.getTypeDocumentAdministratif())) ;

            if(this.agent && dto.getAgent()!=null)
                item.setAgent(agentConverter.toItem(dto.getAgent())) ;

            if(this.etatDemandeDocumentAdministratif && dto.getEtatDemandeDocumentAdministratif()!=null)
                item.setEtatDemandeDocumentAdministratif(etatDemandeDocumentAdministratifConverter.toItem(dto.getEtatDemandeDocumentAdministratif())) ;

            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;




        return item;
        }
    }


    public DemandeDocumentAdministratifDto toDto(DemandeDocumentAdministratif item) {
        if (item == null) {
            return null;
        } else {
            DemandeDocumentAdministratifDto dto = new DemandeDocumentAdministratifDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.typeDocumentAdministratif && item.getTypeDocumentAdministratif()!=null) {
                dto.setTypeDocumentAdministratif(typeDocumentAdministratifConverter.toDto(item.getTypeDocumentAdministratif())) ;

            }
            if(this.agent && item.getAgent()!=null) {
                dto.setAgent(agentConverter.toDto(item.getAgent())) ;

            }
            if(this.etatDemandeDocumentAdministratif && item.getEtatDemandeDocumentAdministratif()!=null) {
                dto.setEtatDemandeDocumentAdministratif(etatDemandeDocumentAdministratifConverter.toDto(item.getEtatDemandeDocumentAdministratif())) ;

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
        this.typeDocumentAdministratif = value;
        this.agent = value;
        this.etatDemandeDocumentAdministratif = value;
        this.entiteAdministrative = value;
    }
	
    public List<DemandeDocumentAdministratif> toItem(List<DemandeDocumentAdministratifDto> dtos) {
        List<DemandeDocumentAdministratif> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (DemandeDocumentAdministratifDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<DemandeDocumentAdministratifDto> toDto(List<DemandeDocumentAdministratif> items) {
        List<DemandeDocumentAdministratifDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (DemandeDocumentAdministratif item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(DemandeDocumentAdministratifDto dto, DemandeDocumentAdministratif t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getTypeDocumentAdministratif() != null)
        typeDocumentAdministratifConverter.copy(dto.getTypeDocumentAdministratif(), t.getTypeDocumentAdministratif());
        if (dto.getAgent() != null)
        agentConverter.copy(dto.getAgent(), t.getAgent());
        if (dto.getEtatDemandeDocumentAdministratif() != null)
        etatDemandeDocumentAdministratifConverter.copy(dto.getEtatDemandeDocumentAdministratif(), t.getEtatDemandeDocumentAdministratif());
        if (dto.getEntiteAdministrative() != null)
        entiteAdministrativeConverter.copy(dto.getEntiteAdministrative(), t.getEntiteAdministrative());
    }

    public List<DemandeDocumentAdministratif> copy(List<DemandeDocumentAdministratifDto> dtos) {
        List<DemandeDocumentAdministratif> result = new ArrayList<>();
        if (dtos != null) {
            for (DemandeDocumentAdministratifDto dto : dtos) {
                DemandeDocumentAdministratif instance = new DemandeDocumentAdministratif();
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
    public EtatDemandeDocumentAdministratifConverter getEtatDemandeDocumentAdministratifConverter(){
        return this.etatDemandeDocumentAdministratifConverter;
    }
    public void setEtatDemandeDocumentAdministratifConverter(EtatDemandeDocumentAdministratifConverter etatDemandeDocumentAdministratifConverter ){
        this.etatDemandeDocumentAdministratifConverter = etatDemandeDocumentAdministratifConverter;
    }
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public TypeDocumentAdministratifConverter getTypeDocumentAdministratifConverter(){
        return this.typeDocumentAdministratifConverter;
    }
    public void setTypeDocumentAdministratifConverter(TypeDocumentAdministratifConverter typeDocumentAdministratifConverter ){
        this.typeDocumentAdministratifConverter = typeDocumentAdministratifConverter;
    }
    public boolean  isTypeDocumentAdministratif(){
        return this.typeDocumentAdministratif;
    }
    public void  setTypeDocumentAdministratif(boolean typeDocumentAdministratif){
        this.typeDocumentAdministratif = typeDocumentAdministratif;
    }
    public boolean  isAgent(){
        return this.agent;
    }
    public void  setAgent(boolean agent){
        this.agent = agent;
    }
    public boolean  isEtatDemandeDocumentAdministratif(){
        return this.etatDemandeDocumentAdministratif;
    }
    public void  setEtatDemandeDocumentAdministratif(boolean etatDemandeDocumentAdministratif){
        this.etatDemandeDocumentAdministratif = etatDemandeDocumentAdministratif;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
}
