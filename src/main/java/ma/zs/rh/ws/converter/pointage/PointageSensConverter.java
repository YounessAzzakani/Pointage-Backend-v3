package  ma.zs.rh.ws.converter.pointage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.pointage.PointageSens;
import ma.zs.rh.ws.dto.pointage.PointageSensDto;

@Component
public class PointageSensConverter {


    public  PointageSensConverter() {
    }


    public PointageSens toItem(PointageSensDto dto) {
        if (dto == null) {
            return null;
        } else {
        PointageSens item = new PointageSens();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public PointageSensDto toDto(PointageSens item) {
        if (item == null) {
            return null;
        } else {
            PointageSensDto dto = new PointageSensDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<PointageSens> toItem(List<PointageSensDto> dtos) {
        List<PointageSens> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (PointageSensDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<PointageSensDto> toDto(List<PointageSens> items) {
        List<PointageSensDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (PointageSens item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(PointageSensDto dto, PointageSens t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<PointageSens> copy(List<PointageSensDto> dtos) {
        List<PointageSens> result = new ArrayList<>();
        if (dtos != null) {
            for (PointageSensDto dto : dtos) {
                PointageSens instance = new PointageSens();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
