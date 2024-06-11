package  ma.zs.rh.ws.converter.docadmin;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zbiblio.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zbiblio.util.StringUtil;
import ma.zs.rh.bean.core.docadmin.TypeDocumentAdministratif;
import ma.zs.rh.ws.dto.docadmin.TypeDocumentAdministratifDto;

@Component
public class TypeDocumentAdministratifConverter {


    public  TypeDocumentAdministratifConverter() {
    }


    public TypeDocumentAdministratif toItem(TypeDocumentAdministratifDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeDocumentAdministratif item = new TypeDocumentAdministratif();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getTemplate()))
                item.setTemplate(dto.getTemplate());



        return item;
        }
    }


    public TypeDocumentAdministratifDto toDto(TypeDocumentAdministratif item) {
        if (item == null) {
            return null;
        } else {
            TypeDocumentAdministratifDto dto = new TypeDocumentAdministratifDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getTemplate()))
                dto.setTemplate(item.getTemplate());


        return dto;
        }
    }


	
    public List<TypeDocumentAdministratif> toItem(List<TypeDocumentAdministratifDto> dtos) {
        List<TypeDocumentAdministratif> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (TypeDocumentAdministratifDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<TypeDocumentAdministratifDto> toDto(List<TypeDocumentAdministratif> items) {
        List<TypeDocumentAdministratifDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (TypeDocumentAdministratif item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(TypeDocumentAdministratifDto dto, TypeDocumentAdministratif t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<TypeDocumentAdministratif> copy(List<TypeDocumentAdministratifDto> dtos) {
        List<TypeDocumentAdministratif> result = new ArrayList<>();
        if (dtos != null) {
            for (TypeDocumentAdministratifDto dto : dtos) {
                TypeDocumentAdministratif instance = new TypeDocumentAdministratif();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
