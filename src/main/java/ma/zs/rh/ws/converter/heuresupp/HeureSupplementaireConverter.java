package  ma.zs.rh.ws.converter.heuresupp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.ws.converter.commun.AgentConverter;
import ma.zs.rh.ws.converter.commun.EntiteAdministrativeConverter;
import ma.zs.rh.ws.converter.heuresupp.EtatTypeHeureSupplementaireConverter;
import ma.zs.rh.ws.converter.heuresupp.TypeHeureSupplementaireConverter;



import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.heuresupp.HeureSupplementaire;
import ma.zs.rh.ws.dto.heuresupp.HeureSupplementaireDto;

@Component
public class HeureSupplementaireConverter {

    @Autowired
    private AgentConverter agentConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private EtatTypeHeureSupplementaireConverter etatTypeHeureSupplementaireConverter ;
    @Autowired
    private TypeHeureSupplementaireConverter typeHeureSupplementaireConverter ;
    private boolean typeHeureSupplementaire;
    private boolean agent;
    private boolean etatTypeHeureSupplementaire;
    private boolean entiteAdministrative;

    public  HeureSupplementaireConverter() {
        initObject(true);
    }


    public HeureSupplementaire toItem(HeureSupplementaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        HeureSupplementaire item = new HeureSupplementaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getNbrHeure()))
                item.setNbrHeure(dto.getNbrHeure());
            if(StringUtil.isNotEmpty(dto.getThm()))
                item.setThm(dto.getThm());
            if(this.typeHeureSupplementaire && dto.getTypeHeureSupplementaire()!=null)
                item.setTypeHeureSupplementaire(typeHeureSupplementaireConverter.toItem(dto.getTypeHeureSupplementaire())) ;

            if(this.agent && dto.getAgent()!=null)
                item.setAgent(agentConverter.toItem(dto.getAgent())) ;

            if(this.etatTypeHeureSupplementaire && dto.getEtatTypeHeureSupplementaire()!=null)
                item.setEtatTypeHeureSupplementaire(etatTypeHeureSupplementaireConverter.toItem(dto.getEtatTypeHeureSupplementaire())) ;

            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;




        return item;
        }
    }


    public HeureSupplementaireDto toDto(HeureSupplementaire item) {
        if (item == null) {
            return null;
        } else {
            HeureSupplementaireDto dto = new HeureSupplementaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getNbrHeure()))
                dto.setNbrHeure(item.getNbrHeure());
            if(StringUtil.isNotEmpty(item.getThm()))
                dto.setThm(item.getThm());
            if(this.typeHeureSupplementaire && item.getTypeHeureSupplementaire()!=null) {
                dto.setTypeHeureSupplementaire(typeHeureSupplementaireConverter.toDto(item.getTypeHeureSupplementaire())) ;

            }
            if(this.agent && item.getAgent()!=null) {
                dto.setAgent(agentConverter.toDto(item.getAgent())) ;

            }
            if(this.etatTypeHeureSupplementaire && item.getEtatTypeHeureSupplementaire()!=null) {
                dto.setEtatTypeHeureSupplementaire(etatTypeHeureSupplementaireConverter.toDto(item.getEtatTypeHeureSupplementaire())) ;

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
        this.typeHeureSupplementaire = value;
        this.agent = value;
        this.etatTypeHeureSupplementaire = value;
        this.entiteAdministrative = value;
    }
	
    public List<HeureSupplementaire> toItem(List<HeureSupplementaireDto> dtos) {
        List<HeureSupplementaire> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (HeureSupplementaireDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<HeureSupplementaireDto> toDto(List<HeureSupplementaire> items) {
        List<HeureSupplementaireDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (HeureSupplementaire item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(HeureSupplementaireDto dto, HeureSupplementaire t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getTypeHeureSupplementaire() != null)
        typeHeureSupplementaireConverter.copy(dto.getTypeHeureSupplementaire(), t.getTypeHeureSupplementaire());
        if (dto.getAgent() != null)
        agentConverter.copy(dto.getAgent(), t.getAgent());
        if (dto.getEtatTypeHeureSupplementaire() != null)
        etatTypeHeureSupplementaireConverter.copy(dto.getEtatTypeHeureSupplementaire(), t.getEtatTypeHeureSupplementaire());
        if (dto.getEntiteAdministrative() != null)
        entiteAdministrativeConverter.copy(dto.getEntiteAdministrative(), t.getEntiteAdministrative());
    }

    public List<HeureSupplementaire> copy(List<HeureSupplementaireDto> dtos) {
        List<HeureSupplementaire> result = new ArrayList<>();
        if (dtos != null) {
            for (HeureSupplementaireDto dto : dtos) {
                HeureSupplementaire instance = new HeureSupplementaire();
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
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public EtatTypeHeureSupplementaireConverter getEtatTypeHeureSupplementaireConverter(){
        return this.etatTypeHeureSupplementaireConverter;
    }
    public void setEtatTypeHeureSupplementaireConverter(EtatTypeHeureSupplementaireConverter etatTypeHeureSupplementaireConverter ){
        this.etatTypeHeureSupplementaireConverter = etatTypeHeureSupplementaireConverter;
    }
    public TypeHeureSupplementaireConverter getTypeHeureSupplementaireConverter(){
        return this.typeHeureSupplementaireConverter;
    }
    public void setTypeHeureSupplementaireConverter(TypeHeureSupplementaireConverter typeHeureSupplementaireConverter ){
        this.typeHeureSupplementaireConverter = typeHeureSupplementaireConverter;
    }
    public boolean  isTypeHeureSupplementaire(){
        return this.typeHeureSupplementaire;
    }
    public void  setTypeHeureSupplementaire(boolean typeHeureSupplementaire){
        this.typeHeureSupplementaire = typeHeureSupplementaire;
    }
    public boolean  isAgent(){
        return this.agent;
    }
    public void  setAgent(boolean agent){
        this.agent = agent;
    }
    public boolean  isEtatTypeHeureSupplementaire(){
        return this.etatTypeHeureSupplementaire;
    }
    public void  setEtatTypeHeureSupplementaire(boolean etatTypeHeureSupplementaire){
        this.etatTypeHeureSupplementaire = etatTypeHeureSupplementaire;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
}
