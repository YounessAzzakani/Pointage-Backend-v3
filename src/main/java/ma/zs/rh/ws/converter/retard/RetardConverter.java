package  ma.zs.rh.ws.converter.retard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.ws.converter.commun.AgentConverter;
import ma.zs.rh.ws.converter.retard.EtatRetardConverter;
import ma.zs.rh.ws.converter.retard.JustificationRetardConverter;



import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.retard.Retard;
import ma.zs.rh.ws.dto.retard.RetardDto;

@Component
public class RetardConverter {

    @Autowired
    private AgentConverter agentConverter ;
    @Autowired
    private EtatRetardConverter etatRetardConverter ;
    @Autowired
    private JustificationRetardConverter justificationRetardConverter ;
    private boolean agent;
    private boolean etatRetard;
    private boolean justificationRetard;

    public  RetardConverter() {
        initObject(true);
    }


    public Retard toItem(RetardDto dto) {
        if (dto == null) {
            return null;
        } else {
        Retard item = new Retard();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDateRetard()))
                item.setDateRetard(DateUtil.stringEnToDate(dto.getDateRetard()));
            if(StringUtil.isNotEmpty(dto.getNombreHeure()))
                item.setNombreHeure(dto.getNombreHeure());
            if(this.agent && dto.getAgent()!=null)
                item.setAgent(agentConverter.toItem(dto.getAgent())) ;

            if(this.etatRetard && dto.getEtatRetard()!=null)
                item.setEtatRetard(etatRetardConverter.toItem(dto.getEtatRetard())) ;

            if(this.justificationRetard && dto.getJustificationRetard()!=null)
                item.setJustificationRetard(justificationRetardConverter.toItem(dto.getJustificationRetard())) ;




        return item;
        }
    }


    public RetardDto toDto(Retard item) {
        if (item == null) {
            return null;
        } else {
            RetardDto dto = new RetardDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(item.getDateRetard()!=null)
                dto.setDateRetard(DateUtil.dateTimeToString(item.getDateRetard()));
            if(StringUtil.isNotEmpty(item.getNombreHeure()))
                dto.setNombreHeure(item.getNombreHeure());
            if(this.agent && item.getAgent()!=null) {
                dto.setAgent(agentConverter.toDto(item.getAgent())) ;

            }
            if(this.etatRetard && item.getEtatRetard()!=null) {
                dto.setEtatRetard(etatRetardConverter.toDto(item.getEtatRetard())) ;

            }
            if(this.justificationRetard && item.getJustificationRetard()!=null) {
                dto.setJustificationRetard(justificationRetardConverter.toDto(item.getJustificationRetard())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.agent = value;
        this.etatRetard = value;
        this.justificationRetard = value;
    }
	
    public List<Retard> toItem(List<RetardDto> dtos) {
        List<Retard> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (RetardDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<RetardDto> toDto(List<Retard> items) {
        List<RetardDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Retard item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(RetardDto dto, Retard t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getAgent() != null)
        agentConverter.copy(dto.getAgent(), t.getAgent());
        if (dto.getEtatRetard() != null)
        etatRetardConverter.copy(dto.getEtatRetard(), t.getEtatRetard());
        if (dto.getJustificationRetard() != null)
        justificationRetardConverter.copy(dto.getJustificationRetard(), t.getJustificationRetard());
    }

    public List<Retard> copy(List<RetardDto> dtos) {
        List<Retard> result = new ArrayList<>();
        if (dtos != null) {
            for (RetardDto dto : dtos) {
                Retard instance = new Retard();
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
    public EtatRetardConverter getEtatRetardConverter(){
        return this.etatRetardConverter;
    }
    public void setEtatRetardConverter(EtatRetardConverter etatRetardConverter ){
        this.etatRetardConverter = etatRetardConverter;
    }
    public JustificationRetardConverter getJustificationRetardConverter(){
        return this.justificationRetardConverter;
    }
    public void setJustificationRetardConverter(JustificationRetardConverter justificationRetardConverter ){
        this.justificationRetardConverter = justificationRetardConverter;
    }
    public boolean  isAgent(){
        return this.agent;
    }
    public void  setAgent(boolean agent){
        this.agent = agent;
    }
    public boolean  isEtatRetard(){
        return this.etatRetard;
    }
    public void  setEtatRetard(boolean etatRetard){
        this.etatRetard = etatRetard;
    }
    public boolean  isJustificationRetard(){
        return this.justificationRetard;
    }
    public void  setJustificationRetard(boolean justificationRetard){
        this.justificationRetard = justificationRetard;
    }
}
