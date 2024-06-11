package  ma.zs.rh.dao.criteria.core.heuresupp;


import ma.zs.rh.dao.criteria.core.commun.AgentCriteria;
import ma.zs.rh.dao.criteria.core.commun.EntiteAdministrativeCriteria;

import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import java.util.List;

public class HeureSupplementaireCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String description;
    private String descriptionLike;
    private String nbrHeure;
    private String nbrHeureMin;
    private String nbrHeureMax;
    private String thm;
    private String thmMin;
    private String thmMax;

    private TypeHeureSupplementaireCriteria typeHeureSupplementaire ;
    private List<TypeHeureSupplementaireCriteria> typeHeureSupplementaires ;
    private AgentCriteria agent ;
    private List<AgentCriteria> agents ;
    private EtatTypeHeureSupplementaireCriteria etatTypeHeureSupplementaire ;
    private List<EtatTypeHeureSupplementaireCriteria> etatTypeHeureSupplementaires ;
    private EntiteAdministrativeCriteria entiteAdministrative ;
    private List<EntiteAdministrativeCriteria> entiteAdministratives ;


    public HeureSupplementaireCriteria(){}

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

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getNbrHeure(){
        return this.nbrHeure;
    }
    public void setNbrHeure(String nbrHeure){
        this.nbrHeure = nbrHeure;
    }   
    public String getNbrHeureMin(){
        return this.nbrHeureMin;
    }
    public void setNbrHeureMin(String nbrHeureMin){
        this.nbrHeureMin = nbrHeureMin;
    }
    public String getNbrHeureMax(){
        return this.nbrHeureMax;
    }
    public void setNbrHeureMax(String nbrHeureMax){
        this.nbrHeureMax = nbrHeureMax;
    }
      
    public String getThm(){
        return this.thm;
    }
    public void setThm(String thm){
        this.thm = thm;
    }   
    public String getThmMin(){
        return this.thmMin;
    }
    public void setThmMin(String thmMin){
        this.thmMin = thmMin;
    }
    public String getThmMax(){
        return this.thmMax;
    }
    public void setThmMax(String thmMax){
        this.thmMax = thmMax;
    }
      

    public TypeHeureSupplementaireCriteria getTypeHeureSupplementaire(){
        return this.typeHeureSupplementaire;
    }

    public void setTypeHeureSupplementaire(TypeHeureSupplementaireCriteria typeHeureSupplementaire){
        this.typeHeureSupplementaire = typeHeureSupplementaire;
    }
    public List<TypeHeureSupplementaireCriteria> getTypeHeureSupplementaires(){
        return this.typeHeureSupplementaires;
    }

    public void setTypeHeureSupplementaires(List<TypeHeureSupplementaireCriteria> typeHeureSupplementaires){
        this.typeHeureSupplementaires = typeHeureSupplementaires;
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
    public EtatTypeHeureSupplementaireCriteria getEtatTypeHeureSupplementaire(){
        return this.etatTypeHeureSupplementaire;
    }

    public void setEtatTypeHeureSupplementaire(EtatTypeHeureSupplementaireCriteria etatTypeHeureSupplementaire){
        this.etatTypeHeureSupplementaire = etatTypeHeureSupplementaire;
    }
    public List<EtatTypeHeureSupplementaireCriteria> getEtatTypeHeureSupplementaires(){
        return this.etatTypeHeureSupplementaires;
    }

    public void setEtatTypeHeureSupplementaires(List<EtatTypeHeureSupplementaireCriteria> etatTypeHeureSupplementaires){
        this.etatTypeHeureSupplementaires = etatTypeHeureSupplementaires;
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
