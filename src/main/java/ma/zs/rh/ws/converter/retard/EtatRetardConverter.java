package  ma.zs.rh.ws.converter.retard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.retard.EtatRetard;
import ma.zs.rh.ws.dto.retard.EtatRetardDto;

@Component
public class EtatRetardConverter {


    public  EtatRetardConverter() {
    }


    public EtatRetard toItem(EtatRetardDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatRetard item = new EtatRetard();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public EtatRetardDto toDto(EtatRetard item) {
        if (item == null) {
            return null;
        } else {
            EtatRetardDto dto = new EtatRetardDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<EtatRetard> toItem(List<EtatRetardDto> dtos) {
        List<EtatRetard> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (EtatRetardDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<EtatRetardDto> toDto(List<EtatRetard> items) {
        List<EtatRetardDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (EtatRetard item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(EtatRetardDto dto, EtatRetard t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<EtatRetard> copy(List<EtatRetardDto> dtos) {
        List<EtatRetard> result = new ArrayList<>();
        if (dtos != null) {
            for (EtatRetardDto dto : dtos) {
                EtatRetard instance = new EtatRetard();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
