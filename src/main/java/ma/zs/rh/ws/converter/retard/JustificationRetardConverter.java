package  ma.zs.rh.ws.converter.retard;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zbiblio.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zbiblio.util.StringUtil;
import ma.zs.rh.bean.core.retard.JustificationRetard;
import ma.zs.rh.ws.dto.retard.JustificationRetardDto;

@Component
public class JustificationRetardConverter {


    public  JustificationRetardConverter() {
    }


    public JustificationRetard toItem(JustificationRetardDto dto) {
        if (dto == null) {
            return null;
        } else {
        JustificationRetard item = new JustificationRetard();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public JustificationRetardDto toDto(JustificationRetard item) {
        if (item == null) {
            return null;
        } else {
            JustificationRetardDto dto = new JustificationRetardDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<JustificationRetard> toItem(List<JustificationRetardDto> dtos) {
        List<JustificationRetard> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (JustificationRetardDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<JustificationRetardDto> toDto(List<JustificationRetard> items) {
        List<JustificationRetardDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (JustificationRetard item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(JustificationRetardDto dto, JustificationRetard t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<JustificationRetard> copy(List<JustificationRetardDto> dtos) {
        List<JustificationRetard> result = new ArrayList<>();
        if (dtos != null) {
            for (JustificationRetardDto dto : dtos) {
                JustificationRetard instance = new JustificationRetard();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
