package  ma.zs.rh.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.rh.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.ws.converter.commun.PosteConverter;



import ma.zs.rh.zynerator.util.StringUtil;
import ma.zs.rh.zynerator.converter.AbstractConverter;
import ma.zs.rh.zynerator.util.DateUtil;
import ma.zs.rh.bean.core.commun.PaiementAgent;
import ma.zs.rh.ws.dto.commun.PaiementAgentDto;

@Component
public class PaiementAgentConverter {

    @Autowired
    private PosteConverter posteConverter ;
    private boolean agent;

    public  PaiementAgentConverter() {
        initObject(true);
    }


    public PaiementAgent toItem(PaiementAgentDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementAgent item = new PaiementAgent();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getMois()))
                item.setMois(dto.getMois());
            if(StringUtil.isNotEmpty(dto.getAnnee()))
                item.setAnnee(dto.getAnnee());
            if(StringUtil.isNotEmpty(dto.getThm()))
                item.setThm(dto.getThm());
            if(StringUtil.isNotEmpty(dto.getTotalHoraireTravail()))
                item.setTotalHoraireTravail(dto.getTotalHoraireTravail());
            if(StringUtil.isNotEmpty(dto.getMontantHoraireTravail()))
                item.setMontantHoraireTravail(dto.getMontantHoraireTravail());
            if(StringUtil.isNotEmpty(dto.getTotalHoraireAbsence()))
                item.setTotalHoraireAbsence(dto.getTotalHoraireAbsence());
            if(StringUtil.isNotEmpty(dto.getMontantHoraireAbsence()))
                item.setMontantHoraireAbsence(dto.getMontantHoraireAbsence());
            if(StringUtil.isNotEmpty(dto.getTotalHoraireSupplementaire()))
                item.setTotalHoraireSupplementaire(dto.getTotalHoraireSupplementaire());
            if(StringUtil.isNotEmpty(dto.getMontantHoraireSupplementaire()))
                item.setMontantHoraireSupplementaire(dto.getMontantHoraireSupplementaire());
            if(StringUtil.isNotEmpty(dto.getSalaireBase()))
                item.setSalaireBase(dto.getSalaireBase());
            if(StringUtil.isNotEmpty(dto.getSalaire()))
                item.setSalaire(dto.getSalaire());
            if(this.agent && dto.getAgent()!=null)
                item.setAgent(posteConverter.toItem(dto.getAgent())) ;




        return item;
        }
    }


    public PaiementAgentDto toDto(PaiementAgent item) {
        if (item == null) {
            return null;
        } else {
            PaiementAgentDto dto = new PaiementAgentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getMois()))
                dto.setMois(item.getMois());
            if(StringUtil.isNotEmpty(item.getAnnee()))
                dto.setAnnee(item.getAnnee());
            if(StringUtil.isNotEmpty(item.getThm()))
                dto.setThm(item.getThm());
            if(StringUtil.isNotEmpty(item.getTotalHoraireTravail()))
                dto.setTotalHoraireTravail(item.getTotalHoraireTravail());
            if(StringUtil.isNotEmpty(item.getMontantHoraireTravail()))
                dto.setMontantHoraireTravail(item.getMontantHoraireTravail());
            if(StringUtil.isNotEmpty(item.getTotalHoraireAbsence()))
                dto.setTotalHoraireAbsence(item.getTotalHoraireAbsence());
            if(StringUtil.isNotEmpty(item.getMontantHoraireAbsence()))
                dto.setMontantHoraireAbsence(item.getMontantHoraireAbsence());
            if(StringUtil.isNotEmpty(item.getTotalHoraireSupplementaire()))
                dto.setTotalHoraireSupplementaire(item.getTotalHoraireSupplementaire());
            if(StringUtil.isNotEmpty(item.getMontantHoraireSupplementaire()))
                dto.setMontantHoraireSupplementaire(item.getMontantHoraireSupplementaire());
            if(StringUtil.isNotEmpty(item.getSalaireBase()))
                dto.setSalaireBase(item.getSalaireBase());
            if(StringUtil.isNotEmpty(item.getSalaire()))
                dto.setSalaire(item.getSalaire());
            if(this.agent && item.getAgent()!=null) {
                dto.setAgent(posteConverter.toDto(item.getAgent())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.agent = value;
    }
	
    public List<PaiementAgent> toItem(List<PaiementAgentDto> dtos) {
        List<PaiementAgent> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (PaiementAgentDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<PaiementAgentDto> toDto(List<PaiementAgent> items) {
        List<PaiementAgentDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (PaiementAgent item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(PaiementAgentDto dto, PaiementAgent t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getAgent() != null)
        posteConverter.copy(dto.getAgent(), t.getAgent());
    }

    public List<PaiementAgent> copy(List<PaiementAgentDto> dtos) {
        List<PaiementAgent> result = new ArrayList<>();
        if (dtos != null) {
            for (PaiementAgentDto dto : dtos) {
                PaiementAgent instance = new PaiementAgent();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public PosteConverter getPosteConverter(){
        return this.posteConverter;
    }
    public void setPosteConverter(PosteConverter posteConverter ){
        this.posteConverter = posteConverter;
    }
    public boolean  isAgent(){
        return this.agent;
    }
    public void  setAgent(boolean agent){
        this.agent = agent;
    }
}
