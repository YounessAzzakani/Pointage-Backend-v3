package  ma.zs.rh.dao.criteria.core.retard;


import ma.zs.rh.dao.criteria.core.commun.AgentCriteria;

import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;

public class RetardCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private LocalDateTime dateRetard;
    private LocalDateTime dateRetardFrom;
    private LocalDateTime dateRetardTo;
    private String nombreHeure;
    private String nombreHeureMin;
    private String nombreHeureMax;

    private AgentCriteria agent ;
    private List<AgentCriteria> agents ;
    private EtatRetardCriteria etatRetard ;
    private List<EtatRetardCriteria> etatRetards ;
    private JustificationRetardCriteria justificationRetard ;
    private List<JustificationRetardCriteria> justificationRetards ;


    public RetardCriteria(){}

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

    public LocalDateTime getDateRetard(){
        return this.dateRetard;
    }
    public void setDateRetard(LocalDateTime dateRetard){
        this.dateRetard = dateRetard;
    }
    public LocalDateTime getDateRetardFrom(){
        return this.dateRetardFrom;
    }
    public void setDateRetardFrom(LocalDateTime dateRetardFrom){
        this.dateRetardFrom = dateRetardFrom;
    }
    public LocalDateTime getDateRetardTo(){
        return this.dateRetardTo;
    }
    public void setDateRetardTo(LocalDateTime dateRetardTo){
        this.dateRetardTo = dateRetardTo;
    }
    public String getNombreHeure(){
        return this.nombreHeure;
    }
    public void setNombreHeure(String nombreHeure){
        this.nombreHeure = nombreHeure;
    }   
    public String getNombreHeureMin(){
        return this.nombreHeureMin;
    }
    public void setNombreHeureMin(String nombreHeureMin){
        this.nombreHeureMin = nombreHeureMin;
    }
    public String getNombreHeureMax(){
        return this.nombreHeureMax;
    }
    public void setNombreHeureMax(String nombreHeureMax){
        this.nombreHeureMax = nombreHeureMax;
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
    public EtatRetardCriteria getEtatRetard(){
        return this.etatRetard;
    }

    public void setEtatRetard(EtatRetardCriteria etatRetard){
        this.etatRetard = etatRetard;
    }
    public List<EtatRetardCriteria> getEtatRetards(){
        return this.etatRetards;
    }

    public void setEtatRetards(List<EtatRetardCriteria> etatRetards){
        this.etatRetards = etatRetards;
    }
    public JustificationRetardCriteria getJustificationRetard(){
        return this.justificationRetard;
    }

    public void setJustificationRetard(JustificationRetardCriteria justificationRetard){
        this.justificationRetard = justificationRetard;
    }
    public List<JustificationRetardCriteria> getJustificationRetards(){
        return this.justificationRetards;
    }

    public void setJustificationRetards(List<JustificationRetardCriteria> justificationRetards){
        this.justificationRetards = justificationRetards;
    }
}
