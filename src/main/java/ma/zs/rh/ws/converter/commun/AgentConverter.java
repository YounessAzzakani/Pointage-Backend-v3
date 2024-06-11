package  ma.zs.rh.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zbiblio.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;


import ma.zs.rh.zbiblio.util.StringUtil;
import ma.zs.rh.bean.core.commun.Agent;
import ma.zs.rh.ws.dto.commun.AgentDto;

@Component
public class AgentConverter {

    @Autowired
    private PlageHoraireConverter plageHoraireConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private PosteConverter posteConverter ;
    private boolean entiteAdministrative;
    private boolean poste;
    private boolean plageHoraire;

    public  AgentConverter() {
        initObject(true);
    }


    public Agent toItem(AgentDto dto) {
        if (dto == null) {
            return null;
        } else {
        Agent item = new Agent();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            
            
            if(StringUtil.isNotEmpty(dto.getLastName()))
                item.setLastName(dto.getLastName());

            
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());
            if(StringUtil.isNotEmpty(dto.getThm()))
                item.setThm(dto.getThm());
            if(StringUtil.isNotEmpty(dto.getSalaire()))
                item.setSalaire(dto.getSalaire());
            item.setCredentialsNonExpired(dto.getCredentialsNonExpired());
            item.setEnabled(dto.getEnabled());
            item.setAccountNonExpired(dto.getAccountNonExpired());
            item.setAccountNonLocked(dto.getAccountNonLocked());
            item.setPasswordChanged(dto.getPasswordChanged());
            if(StringUtil.isNotEmpty(dto.getUsername()))
                item.setUsername(dto.getUsername());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());
            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;

            if(this.poste && dto.getPoste()!=null)
                item.setPoste(posteConverter.toItem(dto.getPoste())) ;

            if(this.plageHoraire && dto.getPlageHoraire()!=null)
                item.setPlageHoraire(plageHoraireConverter.toItem(dto.getPlageHoraire())) ;



            //item.setRoles(dto.getRoles());

        return item;
        }
    }


    public AgentDto toDto(Agent item) {
        if (item == null) {
            return null;
        } else {
            AgentDto dto = new AgentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            
            
            if(StringUtil.isNotEmpty(item.getLastName()))
                dto.setLastName(item.getLastName());

//            if(StringUtil.isNotEmpty(item.getFirstName()))
//                dto.setFirstName(item.getFirstName());

            
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());
            if(StringUtil.isNotEmpty(item.getThm()))
                dto.setThm(item.getThm());
            if(StringUtil.isNotEmpty(item.getSalaire()))
                dto.setSalaire(item.getSalaire());
            if(StringUtil.isNotEmpty(item.getCredentialsNonExpired()))
                dto.setCredentialsNonExpired(item.getCredentialsNonExpired());
            if(StringUtil.isNotEmpty(item.getEnabled()))
                dto.setEnabled(item.getEnabled());
            if(StringUtil.isNotEmpty(item.getAccountNonExpired()))
                dto.setAccountNonExpired(item.getAccountNonExpired());
            if(StringUtil.isNotEmpty(item.getAccountNonLocked()))
                dto.setAccountNonLocked(item.getAccountNonLocked());
            if(StringUtil.isNotEmpty(item.getPasswordChanged()))
                dto.setPasswordChanged(item.getPasswordChanged());
            if(StringUtil.isNotEmpty(item.getUsername()))
                dto.setUsername(item.getUsername());
            if(this.entiteAdministrative && item.getEntiteAdministrative()!=null) {
                entiteAdministrativeConverter.setChefService(false);
                dto.setEntiteAdministrative(entiteAdministrativeConverter.toDto(item.getEntiteAdministrative())) ;
                entiteAdministrativeConverter.setChefService(true);

            }
            if(this.poste && item.getPoste()!=null) {
                dto.setPoste(posteConverter.toDto(item.getPoste())) ;

            }
            if(this.plageHoraire && item.getPlageHoraire()!=null) {
                dto.setPlageHoraire(plageHoraireConverter.toDto(item.getPlageHoraire())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.entiteAdministrative = value;
        this.poste = value;
        this.plageHoraire = value;
    }
	
    public List<Agent> toItem(List<AgentDto> dtos) {
        List<Agent> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (AgentDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<AgentDto> toDto(List<Agent> items) {
        List<AgentDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Agent item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(AgentDto dto, Agent t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getEntiteAdministrative() != null)
        entiteAdministrativeConverter.copy(dto.getEntiteAdministrative(), t.getEntiteAdministrative());
        if (dto.getPoste() != null)
        posteConverter.copy(dto.getPoste(), t.getPoste());
        if (dto.getPlageHoraire() != null)
        plageHoraireConverter.copy(dto.getPlageHoraire(), t.getPlageHoraire());
    }

    public List<Agent> copy(List<AgentDto> dtos) {
        List<Agent> result = new ArrayList<>();
        if (dtos != null) {
            for (AgentDto dto : dtos) {
                Agent instance = new Agent();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public PlageHoraireConverter getPlageHoraireConverter(){
        return this.plageHoraireConverter;
    }
    public void setPlageHoraireConverter(PlageHoraireConverter plageHoraireConverter ){
        this.plageHoraireConverter = plageHoraireConverter;
    }
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public PosteConverter getPosteConverter(){
        return this.posteConverter;
    }
    public void setPosteConverter(PosteConverter posteConverter ){
        this.posteConverter = posteConverter;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    public boolean  isPoste(){
        return this.poste;
    }
    public void  setPoste(boolean poste){
        this.poste = poste;
    }
    public boolean  isPlageHoraire(){
        return this.plageHoraire;
    }
    public void  setPlageHoraire(boolean plageHoraire){
        this.plageHoraire = plageHoraire;
    }
}
