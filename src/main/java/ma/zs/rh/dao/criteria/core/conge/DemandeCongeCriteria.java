package  ma.zs.rh.dao.criteria.core.conge;


import ma.zs.rh.dao.criteria.core.commun.AgentCriteria;
import ma.zs.rh.dao.criteria.core.commun.EntiteAdministrativeCriteria;

import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;

public class DemandeCongeCriteria extends  BaseCriteria  {

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

    private MotifRejetDemandeCongeCriteria motifRejetDemandeConge ;
    private List<MotifRejetDemandeCongeCriteria> motifRejetDemandeConges ;
    private AgentCriteria manager ;
    private List<AgentCriteria> managers ;
    private AgentCriteria agent ;
    private List<AgentCriteria> agents ;
    private RaisonCongeCriteria raisonConge ;
    private List<RaisonCongeCriteria> raisonConges ;
    private EtatDemandeCongeCriteria etatDemandeConge ;
    private List<EtatDemandeCongeCriteria> etatDemandeConges ;
    private EntiteAdministrativeCriteria entiteAdministrative ;
    private List<EntiteAdministrativeCriteria> entiteAdministratives ;


    public DemandeCongeCriteria(){}

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
      

    public MotifRejetDemandeCongeCriteria getMotifRejetDemandeConge(){
        return this.motifRejetDemandeConge;
    }

    public void setMotifRejetDemandeConge(MotifRejetDemandeCongeCriteria motifRejetDemandeConge){
        this.motifRejetDemandeConge = motifRejetDemandeConge;
    }
    public List<MotifRejetDemandeCongeCriteria> getMotifRejetDemandeConges(){
        return this.motifRejetDemandeConges;
    }

    public void setMotifRejetDemandeConges(List<MotifRejetDemandeCongeCriteria> motifRejetDemandeConges){
        this.motifRejetDemandeConges = motifRejetDemandeConges;
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
    public RaisonCongeCriteria getRaisonConge(){
        return this.raisonConge;
    }

    public void setRaisonConge(RaisonCongeCriteria raisonConge){
        this.raisonConge = raisonConge;
    }
    public List<RaisonCongeCriteria> getRaisonConges(){
        return this.raisonConges;
    }

    public void setRaisonConges(List<RaisonCongeCriteria> raisonConges){
        this.raisonConges = raisonConges;
    }
    public EtatDemandeCongeCriteria getEtatDemandeConge(){
        return this.etatDemandeConge;
    }

    public void setEtatDemandeConge(EtatDemandeCongeCriteria etatDemandeConge){
        this.etatDemandeConge = etatDemandeConge;
    }
    public List<EtatDemandeCongeCriteria> getEtatDemandeConges(){
        return this.etatDemandeConges;
    }

    public void setEtatDemandeConges(List<EtatDemandeCongeCriteria> etatDemandeConges){
        this.etatDemandeConges = etatDemandeConges;
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
}
