package  ma.zs.rh.ws.dto.pointage;

import ma.zs.rh.bean.core.pointage.PointageSens;
import ma.zs.rh.bean.core.pointage.Pointeuse;
import ma.zs.rh.zynerator.audit.Log;
import ma.zs.rh.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.rh.ws.dto.commun.AgentDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointageDto  extends AuditBaseDto {

    private String ref  ;
    private String datePointage ;
    private PointageSens pointageSens;
    private Pointeuse pointeuse;

    private AgentDto agent ;



    public PointageDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePointage(){
        return this.datePointage;
    }
    public void setDatePointage(String datePointage){
        this.datePointage = datePointage;
    }

    @Log
    public PointageSens getPointageSens(){
        return this.pointageSens;
    }
    public void setPointageSens(PointageSens pointageSens){
        this.pointageSens = pointageSens;
    }

    @Log
    public Pointeuse getPointeuse(){
        return this.pointeuse;
    }
    public void setPointeuse(Pointeuse pointeuse){
        this.pointeuse = pointeuse;
    }


    public AgentDto getAgent(){
        return this.agent;
    }

    public void setAgent(AgentDto agent){
        this.agent = agent;
    }






}
