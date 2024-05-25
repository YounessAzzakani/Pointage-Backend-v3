package  ma.zs.rh.ws.converter.abssence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.abssence.MotifRejetDemandeAbsence;
import ma.zs.rh.ws.dto.abssence.MotifRejetDemandeAbsenceDto;

@Component
public class MotifRejetDemandeAbsenceConverter {


    public  MotifRejetDemandeAbsenceConverter() {
    }


    public MotifRejetDemandeAbsence toItem(MotifRejetDemandeAbsenceDto dto) {
        if (dto == null) {
            return null;
        } else {
        MotifRejetDemandeAbsence item = new MotifRejetDemandeAbsence();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public MotifRejetDemandeAbsenceDto toDto(MotifRejetDemandeAbsence item) {
        if (item == null) {
            return null;
        } else {
            MotifRejetDemandeAbsenceDto dto = new MotifRejetDemandeAbsenceDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<MotifRejetDemandeAbsence> toItem(List<MotifRejetDemandeAbsenceDto> dtos) {
        List<MotifRejetDemandeAbsence> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (MotifRejetDemandeAbsenceDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<MotifRejetDemandeAbsenceDto> toDto(List<MotifRejetDemandeAbsence> items) {
        List<MotifRejetDemandeAbsenceDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (MotifRejetDemandeAbsence item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(MotifRejetDemandeAbsenceDto dto, MotifRejetDemandeAbsence t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<MotifRejetDemandeAbsence> copy(List<MotifRejetDemandeAbsenceDto> dtos) {
        List<MotifRejetDemandeAbsence> result = new ArrayList<>();
        if (dtos != null) {
            for (MotifRejetDemandeAbsenceDto dto : dtos) {
                MotifRejetDemandeAbsence instance = new MotifRejetDemandeAbsence();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
