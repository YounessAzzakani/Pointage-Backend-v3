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
import ma.zs.rh.bean.core.abssence.EtatDemandeAbsence;
import ma.zs.rh.ws.dto.abssence.EtatDemandeAbsenceDto;

@Component
public class EtatDemandeAbsenceConverter {


    public  EtatDemandeAbsenceConverter() {
    }


    public EtatDemandeAbsence toItem(EtatDemandeAbsenceDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatDemandeAbsence item = new EtatDemandeAbsence();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public EtatDemandeAbsenceDto toDto(EtatDemandeAbsence item) {
        if (item == null) {
            return null;
        } else {
            EtatDemandeAbsenceDto dto = new EtatDemandeAbsenceDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<EtatDemandeAbsence> toItem(List<EtatDemandeAbsenceDto> dtos) {
        List<EtatDemandeAbsence> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (EtatDemandeAbsenceDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<EtatDemandeAbsenceDto> toDto(List<EtatDemandeAbsence> items) {
        List<EtatDemandeAbsenceDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (EtatDemandeAbsence item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(EtatDemandeAbsenceDto dto, EtatDemandeAbsence t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<EtatDemandeAbsence> copy(List<EtatDemandeAbsenceDto> dtos) {
        List<EtatDemandeAbsence> result = new ArrayList<>();
        if (dtos != null) {
            for (EtatDemandeAbsenceDto dto : dtos) {
                EtatDemandeAbsence instance = new EtatDemandeAbsence();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
