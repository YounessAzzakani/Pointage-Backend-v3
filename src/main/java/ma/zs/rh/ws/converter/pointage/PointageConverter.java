package  ma.zs.rh.ws.converter.pointage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.ws.converter.commun.AgentConverter;



import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.pointage.Pointage;
import ma.zs.rh.ws.dto.pointage.PointageDto;

@Component
public class PointageConverter {

    @Autowired
    private AgentConverter agentConverter ;
    private boolean agent;

    public  PointageConverter() {
        initObject(true);
    }


    public Pointage toItem(PointageDto dto) {
        if (dto == null) {
            return null;
        } else {
        Pointage item = new Pointage();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDatePointage()))
                item.setDatePointage(DateUtil.stringEnToDate(dto.getDatePointage()));
            if (dto.getPointageSens() != null)
                item.setPointageSens(dto.getPointageSens());
            if (dto.getPointeuse() != null)
                item.setPointeuse(dto.getPointeuse());
            if(this.agent && dto.getAgent()!=null)
                item.setAgent(agentConverter.toItem(dto.getAgent())) ;




        return item;
        }
    }


    public PointageDto toDto(Pointage item) {
        if (item == null) {
            return null;
        } else {
            PointageDto dto = new PointageDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(item.getDatePointage()!=null)
                dto.setDatePointage(DateUtil.dateTimeToString(item.getDatePointage()));
            if (item.getPointageSens() != null)
                dto.setPointageSens(item.getPointageSens());
            if (item.getPointeuse() != null)
                dto.setPointeuse(item.getPointeuse());
            if(this.agent && item.getAgent()!=null) {
                dto.setAgent(agentConverter.toDto(item.getAgent())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.agent = value;
    }
	
    public List<Pointage> toItem(List<PointageDto> dtos) {
        List<Pointage> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (PointageDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<PointageDto> toDto(List<Pointage> items) {
        List<PointageDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Pointage item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(PointageDto dto, Pointage t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getAgent() != null)
        agentConverter.copy(dto.getAgent(), t.getAgent());
    }

    public List<Pointage> copy(List<PointageDto> dtos) {
        List<Pointage> result = new ArrayList<>();
        if (dtos != null) {
            for (PointageDto dto : dtos) {
                Pointage instance = new Pointage();
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
    public boolean  isAgent(){
        return this.agent;
    }
    public void  setAgent(boolean agent){
        this.agent = agent;
    }
}
