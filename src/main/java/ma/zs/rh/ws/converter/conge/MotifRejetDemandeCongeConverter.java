package  ma.zs.rh.ws.converter.conge;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zbiblio.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zbiblio.util.StringUtil;
import ma.zs.rh.bean.core.conge.MotifRejetDemandeConge;
import ma.zs.rh.ws.dto.conge.MotifRejetDemandeCongeDto;

@Component
public class MotifRejetDemandeCongeConverter {


    public  MotifRejetDemandeCongeConverter() {
    }


    public MotifRejetDemandeConge toItem(MotifRejetDemandeCongeDto dto) {
        if (dto == null) {
            return null;
        } else {
        MotifRejetDemandeConge item = new MotifRejetDemandeConge();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public MotifRejetDemandeCongeDto toDto(MotifRejetDemandeConge item) {
        if (item == null) {
            return null;
        } else {
            MotifRejetDemandeCongeDto dto = new MotifRejetDemandeCongeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<MotifRejetDemandeConge> toItem(List<MotifRejetDemandeCongeDto> dtos) {
        List<MotifRejetDemandeConge> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (MotifRejetDemandeCongeDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<MotifRejetDemandeCongeDto> toDto(List<MotifRejetDemandeConge> items) {
        List<MotifRejetDemandeCongeDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (MotifRejetDemandeConge item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(MotifRejetDemandeCongeDto dto, MotifRejetDemandeConge t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<MotifRejetDemandeConge> copy(List<MotifRejetDemandeCongeDto> dtos) {
        List<MotifRejetDemandeConge> result = new ArrayList<>();
        if (dtos != null) {
            for (MotifRejetDemandeCongeDto dto : dtos) {
                MotifRejetDemandeConge instance = new MotifRejetDemandeConge();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
