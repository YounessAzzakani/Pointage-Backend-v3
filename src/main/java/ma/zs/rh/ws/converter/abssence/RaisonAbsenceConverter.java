package  ma.zs.rh.ws.converter.abssence;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zbiblio.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zbiblio.util.StringUtil;
import ma.zs.rh.bean.core.abssence.RaisonAbsence;
import ma.zs.rh.ws.dto.abssence.RaisonAbsenceDto;

@Component
public class RaisonAbsenceConverter {


    public  RaisonAbsenceConverter() {
    }


    public RaisonAbsence toItem(RaisonAbsenceDto dto) {
        if (dto == null) {
            return null;
        } else {
        RaisonAbsence item = new RaisonAbsence();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public RaisonAbsenceDto toDto(RaisonAbsence item) {
        if (item == null) {
            return null;
        } else {
            RaisonAbsenceDto dto = new RaisonAbsenceDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<RaisonAbsence> toItem(List<RaisonAbsenceDto> dtos) {
        List<RaisonAbsence> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (RaisonAbsenceDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<RaisonAbsenceDto> toDto(List<RaisonAbsence> items) {
        List<RaisonAbsenceDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (RaisonAbsence item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(RaisonAbsenceDto dto, RaisonAbsence t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<RaisonAbsence> copy(List<RaisonAbsenceDto> dtos) {
        List<RaisonAbsence> result = new ArrayList<>();
        if (dtos != null) {
            for (RaisonAbsenceDto dto : dtos) {
                RaisonAbsence instance = new RaisonAbsence();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
