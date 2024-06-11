package  ma.zs.rh.dao.criteria.core.abssence;


import ma.zs.rh.dao.criteria.core.commun.AgentCriteria;
import ma.zs.rh.dao.criteria.core.commun.EntiteAdministrativeCriteria;

import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;

public class DemandeAbsenceCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String contenu;
    private String contenuLike;
    private LocalDateTime dateDepart;
    private LocalDateTime dateDepartFrom;
    private LocalDateTime dateDepartTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private String nombreJour;
    private String nombreJourMin;
    private String nombreJourMax;

    private MotifRejetDemandeAbsenceCriteria motifRejetDemandeAbsence ;
    private List<MotifRejetDemandeAbsenceCriteria> motifRejetDemandeAbsences ;
    private EntiteAdministrativeCriteria entiteAdministrative ;
    private List<EntiteAdministrativeCriteria> entiteAdministratives ;
    private AgentCriteria manager ;
    private List<AgentCriteria> managers ;
    private AgentCriteria agent ;
    private List<AgentCriteria> agents ;
    private RaisonAbsenceCriteria raisonAbsence ;
    private List<RaisonAbsenceCriteria> raisonAbsences ;
    private EtatDemandeAbsenceCriteria etatDemandeAbsence ;
    private List<EtatDemandeAbsenceCriteria> etatDemandeAbsences ;


    public DemandeAbsenceCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    public String getContenuLike(){
        return this.contenuLike;
    }
    public void setContenuLike(String contenuLike){
        this.contenuLike = contenuLike;
    }

    public LocalDateTime getDateDepart(){
        return this.dateDepart;
    }
    public void setDateDepart(LocalDateTime dateDepart){
        this.dateDepart = dateDepart;
    }
    public LocalDateTime getDateDepartFrom(){
        return this.dateDepartFrom;
    }
    public void setDateDepartFrom(LocalDateTime dateDepartFrom){
        this.dateDepartFrom = dateDepartFrom;
    }
    public LocalDateTime getDateDepartTo(){
        return this.dateDepartTo;
    }
    public void setDateDepartTo(LocalDateTime dateDepartTo){
        this.dateDepartTo = dateDepartTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }
    public String getNombreJour(){
        return this.nombreJour;
    }
    public void setNombreJour(String nombreJour){
        this.nombreJour = nombreJour;
    }   
    public String getNombreJourMin(){
        return this.nombreJourMin;
    }
    public void setNombreJourMin(String nombreJourMin){
        this.nombreJourMin = nombreJourMin;
    }
    public String getNombreJourMax(){
        return this.nombreJourMax;
    }
    public void setNombreJourMax(String nombreJourMax){
        this.nombreJourMax = nombreJourMax;
    }
      

    public MotifRejetDemandeAbsenceCriteria getMotifRejetDemandeAbsence(){
        return this.motifRejetDemandeAbsence;
    }

    public void setMotifRejetDemandeAbsence(MotifRejetDemandeAbsenceCriteria motifRejetDemandeAbsence){
        this.motifRejetDemandeAbsence = motifRejetDemandeAbsence;
    }
    public List<MotifRejetDemandeAbsenceCriteria> getMotifRejetDemandeAbsences(){
        return this.motifRejetDemandeAbsences;
    }

    public void setMotifRejetDemandeAbsences(List<MotifRejetDemandeAbsenceCriteria> motifRejetDemandeAbsences){
        this.motifRejetDemandeAbsences = motifRejetDemandeAbsences;
    }
    public EntiteAdministrativeCriteria getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeCriteria entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    public List<EntiteAdministrativeCriteria> getEntiteAdministratives(){
        return this.entiteAdministratives;
    }

    public void setEntiteAdministratives(List<EntiteAdministrativeCriteria> entiteAdministratives){
        this.entiteAdministratives = entiteAdministratives;
    }
    public AgentCriteria getManager(){
        return this.manager;
    }

    public void setManager(AgentCriteria manager){
        this.manager = manager;
    }
    public List<AgentCriteria> getManagers(){
        return this.managers;
    }

    public void setManagers(List<AgentCriteria> managers){
        this.managers = managers;
    }
    public AgentCriteria getAgent(){
        return this.agent;
    }

    public void setAgent(AgentCriteria agent){
        this.agent = agent;
    }
    public List<AgentCriteria> getAgents(){
        return this.agents;
    }

    public void setAgents(List<AgentCriteria> agents){
        this.agents = agents;
    }
    public RaisonAbsenceCriteria getRaisonAbsence(){
        return this.raisonAbsence;
    }

    public void setRaisonAbsence(RaisonAbsenceCriteria raisonAbsence){
        this.raisonAbsence = raisonAbsence;
    }
    public List<RaisonAbsenceCriteria> getRaisonAbsences(){
        return this.raisonAbsences;
    }

    public void setRaisonAbsences(List<RaisonAbsenceCriteria> raisonAbsences){
        this.raisonAbsences = raisonAbsences;
    }
    public EtatDemandeAbsenceCriteria getEtatDemandeAbsence(){
        return this.etatDemandeAbsence;
    }

    public void setEtatDemandeAbsence(EtatDemandeAbsenceCriteria etatDemandeAbsence){
        this.etatDemandeAbsence = etatDemandeAbsence;
    }
    public List<EtatDemandeAbsenceCriteria> getEtatDemandeAbsences(){
        return this.etatDemandeAbsences;
    }

    public void setEtatDemandeAbsences(List<EtatDemandeAbsenceCriteria> etatDemandeAbsences){
        this.etatDemandeAbsences = etatDemandeAbsences;
    }
}
