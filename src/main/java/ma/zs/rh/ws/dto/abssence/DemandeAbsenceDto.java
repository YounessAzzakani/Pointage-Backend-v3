package  ma.zs.rh.ws.dto.abssence;

import ma.zs.rh.zynerator.audit.Log;
import ma.zs.rh.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.rh.ws.dto.commun.AgentDto;
import ma.zs.rh.ws.dto.commun.EntiteAdministrativeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandeAbsenceDto  extends AuditBaseDto {

    private String ref  ;
    private String contenu  ;
    private String dateDepart ;
    private String dateFin ;
    private Integer nombreJour  = 0 ;

    private MotifRejetDemandeAbsenceDto motifRejetDemandeAbsence ;
    private EntiteAdministrativeDto entiteAdministrative ;
    private AgentDto manager ;
    private AgentDto agent ;
    private RaisonAbsenceDto raisonAbsence ;
    private EtatDemandeAbsenceDto etatDemandeAbsence ;



    public DemandeAbsenceDto(){
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
    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDepart(){
        return this.dateDepart;
    }
    public void setDateDepart(String dateDepart){
        this.dateDepart = dateDepart;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }

    @Log
    public Integer getNombreJour(){
        return this.nombreJour;
    }
    public void setNombreJour(Integer nombreJour){
        this.nombreJour = nombreJour;
    }


    public MotifRejetDemandeAbsenceDto getMotifRejetDemandeAbsence(){
        return this.motifRejetDemandeAbsence;
    }

    public void setMotifRejetDemandeAbsence(MotifRejetDemandeAbsenceDto motifRejetDemandeAbsence){
        this.motifRejetDemandeAbsence = motifRejetDemandeAbsence;
    }
    public EntiteAdministrativeDto getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeDto entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    public AgentDto getManager(){
        return this.manager;
    }

    public void setManager(AgentDto manager){
        this.manager = manager;
    }
    public AgentDto getAgent(){
        return this.agent;
    }

    public void setAgent(AgentDto agent){
        this.agent = agent;
    }
    public RaisonAbsenceDto getRaisonAbsence(){
        return this.raisonAbsence;
    }

    public void setRaisonAbsence(RaisonAbsenceDto raisonAbsence){
        this.raisonAbsence = raisonAbsence;
    }
    public EtatDemandeAbsenceDto getEtatDemandeAbsence(){
        return this.etatDemandeAbsence;
    }

    public void setEtatDemandeAbsence(EtatDemandeAbsenceDto etatDemandeAbsence){
        this.etatDemandeAbsence = etatDemandeAbsence;
    }






}
