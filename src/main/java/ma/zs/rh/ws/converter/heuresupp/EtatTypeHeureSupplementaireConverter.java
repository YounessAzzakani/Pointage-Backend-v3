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
import ma.zs.rh.bean.core.heuresupp.EtatTypeHeureSupplementaire;
import ma.zs.rh.ws.dto.heuresupp.EtatTypeHeureSupplementaireDto;

@Component
public class EtatTypeHeureSupplementaireConverter {


    public  EtatTypeHeureSupplementaireConverter() {
    }


    public EtatTypeHeureSupplementaire toItem(EtatTypeHeureSupplementaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatTypeHeureSupplementaire item = new EtatTypeHeureSupplementaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public EtatTypeHeureSupplementaireDto toDto(EtatTypeHeureSupplementaire item) {
        if (item == null) {
            return null;
        } else {
            EtatTypeHeureSupplementaireDto dto = new EtatTypeHeureSupplementaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<EtatTypeHeureSupplementaire> toItem(List<EtatTypeHeureSupplementaireDto> dtos) {
        List<EtatTypeHeureSupplementaire> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (EtatTypeHeureSupplementaireDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<EtatTypeHeureSupplementaireDto> toDto(List<EtatTypeHeureSupplementaire> items) {
        List<EtatTypeHeureSupplementaireDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (EtatTypeHeureSupplementaire item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(EtatTypeHeureSupplementaireDto dto, EtatTypeHeureSupplementaire t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<EtatTypeHeureSupplementaire> copy(List<EtatTypeHeureSupplementaireDto> dtos) {
        List<EtatTypeHeureSupplementaire> result = new ArrayList<>();
        if (dtos != null) {
            for (EtatTypeHeureSupplementaireDto dto : dtos) {
                EtatTypeHeureSupplementaire instance = new EtatTypeHeureSupplementaire();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
