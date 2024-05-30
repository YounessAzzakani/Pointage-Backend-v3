package  ma.zs.rh.ws.dto.pointage;

import ma.zs.rh.zynerator.audit.Log;
import ma.zs.rh.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.rh.ws.dto.commun.AgentDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointageDto  extends AuditBaseDto {

    private String ref  ;
    private String datePointage ;


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


   


    public AgentDto getAgent(){
        return this.agent;
    }

    public void setAgent(AgentDto agent){
        this.agent = agent;
    }






}
