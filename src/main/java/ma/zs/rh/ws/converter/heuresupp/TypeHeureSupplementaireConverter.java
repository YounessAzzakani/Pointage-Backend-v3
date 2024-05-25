package  ma.zs.rh.ws.converter.heuresupp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire;
import ma.zs.rh.ws.dto.heuresupp.TypeHeureSupplementaireDto;

@Component
public class TypeHeureSupplementaireConverter {


    public  TypeHeureSupplementaireConverter() {
    }


    public TypeHeureSupplementaire toItem(TypeHeureSupplementaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeHeureSupplementaire item = new TypeHeureSupplementaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getPourcentage()))
                item.setPourcentage(dto.getPourcentage());



        return item;
        }
    }


    public TypeHeureSupplementaireDto toDto(TypeHeureSupplementaire item) {
        if (item == null) {
            return null;
        } else {
            TypeHeureSupplementaireDto dto = new TypeHeureSupplementaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getPourcentage()))
                dto.setPourcentage(item.getPourcentage());


        return dto;
        }
    }


	
    public List<TypeHeureSupplementaire> toItem(List<TypeHeureSupplementaireDto> dtos) {
        List<TypeHeureSupplementaire> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (TypeHeureSupplementaireDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<TypeHeureSupplementaireDto> toDto(List<TypeHeureSupplementaire> items) {
        List<TypeHeureSupplementaireDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (TypeHeureSupplementaire item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(TypeHeureSupplementaireDto dto, TypeHeureSupplementaire t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<TypeHeureSupplementaire> copy(List<TypeHeureSupplementaireDto> dtos) {
        List<TypeHeureSupplementaire> result = new ArrayList<>();
        if (dtos != null) {
            for (TypeHeureSupplementaireDto dto : dtos) {
                TypeHeureSupplementaire instance = new TypeHeureSupplementaire();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
