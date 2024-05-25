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
import ma.zs.rh.bean.core.pointage.Pointeuse;
import ma.zs.rh.ws.dto.pointage.PointeuseDto;

@Component
public class PointeuseConverter {


    public  PointeuseConverter() {
    }


    public Pointeuse toItem(PointeuseDto dto) {
        if (dto == null) {
            return null;
        } else {
        Pointeuse item = new Pointeuse();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());



        return item;
        }
    }


    public PointeuseDto toDto(Pointeuse item) {
        if (item == null) {
            return null;
        } else {
            PointeuseDto dto = new PointeuseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());


        return dto;
        }
    }


	
    public List<Pointeuse> toItem(List<PointeuseDto> dtos) {
        List<Pointeuse> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (PointeuseDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<PointeuseDto> toDto(List<Pointeuse> items) {
        List<PointeuseDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Pointeuse item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(PointeuseDto dto, Pointeuse t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<Pointeuse> copy(List<PointeuseDto> dtos) {
        List<Pointeuse> result = new ArrayList<>();
        if (dtos != null) {
            for (PointeuseDto dto : dtos) {
                Pointeuse instance = new Pointeuse();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
