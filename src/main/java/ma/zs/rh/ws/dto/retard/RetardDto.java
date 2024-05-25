package  ma.zs.rh.ws.dto.retard;

import ma.zs.rh.zynerator.audit.Log;
import ma.zs.rh.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.rh.ws.dto.commun.AgentDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetardDto  extends AuditBaseDto {

    private String ref  ;
    private String dateRetard ;
    private BigDecimal nombreHeure  ;

    private AgentDto agent ;
    private EtatRetardDto etatRetard ;
    private JustificationRetardDto justificationRetard ;



    public RetardDto(){
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
    public String getDateRetard(){
        return this.dateRetard;
    }
    public void setDateRetard(String dateRetard){
        this.dateRetard = dateRetard;
    }

    @Log
    public BigDecimal getNombreHeure(){
        return this.nombreHeure;
    }
    public void setNombreHeure(BigDecimal nombreHeure){
        this.nombreHeure = nombreHeure;
    }


    public AgentDto getAgent(){
        return this.agent;
    }

    public void setAgent(AgentDto agent){
        this.agent = agent;
    }
    public EtatRetardDto getEtatRetard(){
        return this.etatRetard;
    }

    public void setEtatRetard(EtatRetardDto etatRetard){
        this.etatRetard = etatRetard;
    }
    public JustificationRetardDto getJustificationRetard(){
        return this.justificationRetard;
    }

    public void setJustificationRetard(JustificationRetardDto justificationRetard){
        this.justificationRetard = justificationRetard;
    }






}
