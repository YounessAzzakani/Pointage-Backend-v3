package  ma.zs.rh.ws.converter.docadmin;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zbiblio.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zbiblio.util.StringUtil;
import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif;
import ma.zs.rh.ws.dto.docadmin.EtatDemandeDocumentAdministratifDto;

@Component
public class EtatDemandeDocumentAdministratifConverter {


    public  EtatDemandeDocumentAdministratifConverter() {
    }


    public EtatDemandeDocumentAdministratif toItem(EtatDemandeDocumentAdministratifDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatDemandeDocumentAdministratif item = new EtatDemandeDocumentAdministratif();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public EtatDemandeDocumentAdministratifDto toDto(EtatDemandeDocumentAdministratif item) {
        if (item == null) {
            return null;
        } else {
            EtatDemandeDocumentAdministratifDto dto = new EtatDemandeDocumentAdministratifDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<EtatDemandeDocumentAdministratif> toItem(List<EtatDemandeDocumentAdministratifDto> dtos) {
        List<EtatDemandeDocumentAdministratif> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (EtatDemandeDocumentAdministratifDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<EtatDemandeDocumentAdministratifDto> toDto(List<EtatDemandeDocumentAdministratif> items) {
        List<EtatDemandeDocumentAdministratifDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (EtatDemandeDocumentAdministratif item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(EtatDemandeDocumentAdministratifDto dto, EtatDemandeDocumentAdministratif t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<EtatDemandeDocumentAdministratif> copy(List<EtatDemandeDocumentAdministratifDto> dtos) {
        List<EtatDemandeDocumentAdministratif> result = new ArrayList<>();
        if (dtos != null) {
            for (EtatDemandeDocumentAdministratifDto dto : dtos) {
                EtatDemandeDocumentAdministratif instance = new EtatDemandeDocumentAdministratif();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
