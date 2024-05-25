package  ma.zs.rh.ws.dto.conge;

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
public class DemandeCongeDto  extends AuditBaseDto {

    private String ref  ;
    private String contenu  ;
    private String dateDepart ;
    private String dateFin ;
    private Integer nombreJour  = 0 ;

    private MotifRejetDemandeCongeDto motifRejetDemandeConge ;
    private AgentDto manager ;
    private AgentDto agent ;
    private RaisonCongeDto raisonConge ;
    private EtatDemandeCongeDto etatDemandeConge ;
    private EntiteAdministrativeDto entiteAdministrative ;



    public DemandeCongeDto(){
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


    public MotifRejetDemandeCongeDto getMotifRejetDemandeConge(){
        return this.motifRejetDemandeConge;
    }

    public void setMotifRejetDemandeConge(MotifRejetDemandeCongeDto motifRejetDemandeConge){
        this.motifRejetDemandeConge = motifRejetDemandeConge;
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
    public RaisonCongeDto getRaisonConge(){
        return this.raisonConge;
    }

    public void setRaisonConge(RaisonCongeDto raisonConge){
        this.raisonConge = raisonConge;
    }
    public EtatDemandeCongeDto getEtatDemandeConge(){
        return this.etatDemandeConge;
    }

    public void setEtatDemandeConge(EtatDemandeCongeDto etatDemandeConge){
        this.etatDemandeConge = etatDemandeConge;
    }
    public EntiteAdministrativeDto getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeDto entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }






}
