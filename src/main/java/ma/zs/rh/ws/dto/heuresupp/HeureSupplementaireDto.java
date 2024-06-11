package  ma.zs.rh.ws.dto.heuresupp;

import ma.zs.rh.zbiblio.audit.Log;
import ma.zs.rh.zbiblio.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.rh.ws.dto.commun.AgentDto;
import ma.zs.rh.ws.dto.commun.EntiteAdministrativeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeureSupplementaireDto  extends AuditBaseDto {

    private String ref  ;
    private String description  ;
    private Integer nbrHeure  = 0 ;
    private BigDecimal thm  ;

    private TypeHeureSupplementaireDto typeHeureSupplementaire ;
    private AgentDto agent ;
    private EtatTypeHeureSupplementaireDto etatTypeHeureSupplementaire ;
    private EntiteAdministrativeDto entiteAdministrative ;



    public HeureSupplementaireDto(){
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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public Integer getNbrHeure(){
        return this.nbrHeure;
    }
    public void setNbrHeure(Integer nbrHeure){
        this.nbrHeure = nbrHeure;
    }

    @Log
    public BigDecimal getThm(){
        return this.thm;
    }
    public void setThm(BigDecimal thm){
        this.thm = thm;
    }


    public TypeHeureSupplementaireDto getTypeHeureSupplementaire(){
        return this.typeHeureSupplementaire;
    }

    public void setTypeHeureSupplementaire(TypeHeureSupplementaireDto typeHeureSupplementaire){
        this.typeHeureSupplementaire = typeHeureSupplementaire;
    }
    public AgentDto getAgent(){
        return this.agent;
    }

    public void setAgent(AgentDto agent){
        this.agent = agent;
    }
    public EtatTypeHeureSupplementaireDto getEtatTypeHeureSupplementaire(){
        return this.etatTypeHeureSupplementaire;
    }

    public void setEtatTypeHeureSupplementaire(EtatTypeHeureSupplementaireDto etatTypeHeureSupplementaire){
        this.etatTypeHeureSupplementaire = etatTypeHeureSupplementaire;
    }
    public EntiteAdministrativeDto getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeDto entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }






}
