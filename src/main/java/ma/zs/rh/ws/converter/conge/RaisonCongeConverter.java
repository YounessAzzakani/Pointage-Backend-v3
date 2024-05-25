package  ma.zs.rh.ws.converter.conge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.conge.RaisonConge;
import ma.zs.rh.ws.dto.conge.RaisonCongeDto;

@Component
public class RaisonCongeConverter {


    public  RaisonCongeConverter() {
    }


    public RaisonConge toItem(RaisonCongeDto dto) {
        if (dto == null) {
            return null;
        } else {
        RaisonConge item = new RaisonConge();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public RaisonCongeDto toDto(RaisonConge item) {
        if (item == null) {
            return null;
        } else {
            RaisonCongeDto dto = new RaisonCongeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<RaisonConge> toItem(List<RaisonCongeDto> dtos) {
        List<RaisonConge> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (RaisonCongeDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<RaisonCongeDto> toDto(List<RaisonConge> items) {
        List<RaisonCongeDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (RaisonConge item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(RaisonCongeDto dto, RaisonConge t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<RaisonConge> copy(List<RaisonCongeDto> dtos) {
        List<RaisonConge> result = new ArrayList<>();
        if (dtos != null) {
            for (RaisonCongeDto dto : dtos) {
                RaisonConge instance = new RaisonConge();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
