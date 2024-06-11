package  ma.zs.rh.ws.converter.conge;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zbiblio.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zbiblio.util.StringUtil;
import ma.zs.rh.bean.core.conge.EtatDemandeConge;
import ma.zs.rh.ws.dto.conge.EtatDemandeCongeDto;

@Component
public class EtatDemandeCongeConverter {


    public  EtatDemandeCongeConverter() {
    }


    public EtatDemandeConge toItem(EtatDemandeCongeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatDemandeConge item = new EtatDemandeConge();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public EtatDemandeCongeDto toDto(EtatDemandeConge item) {
        if (item == null) {
            return null;
        } else {
            EtatDemandeCongeDto dto = new EtatDemandeCongeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<EtatDemandeConge> toItem(List<EtatDemandeCongeDto> dtos) {
        List<EtatDemandeConge> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (EtatDemandeCongeDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<EtatDemandeCongeDto> toDto(List<EtatDemandeConge> items) {
        List<EtatDemandeCongeDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (EtatDemandeConge item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(EtatDemandeCongeDto dto, EtatDemandeConge t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<EtatDemandeConge> copy(List<EtatDemandeCongeDto> dtos) {
        List<EtatDemandeConge> result = new ArrayList<>();
        if (dtos != null) {
            for (EtatDemandeCongeDto dto : dtos) {
                EtatDemandeConge instance = new EtatDemandeConge();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
