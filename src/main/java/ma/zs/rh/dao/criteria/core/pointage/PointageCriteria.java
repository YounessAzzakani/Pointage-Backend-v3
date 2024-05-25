package  ma.zs.rh.dao.criteria.core.pointage;


import ma.zs.rh.dao.criteria.core.commun.AgentCriteria;

import ma.zs.rh.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PointageCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private LocalDateTime datePointage;
    private LocalDateTime datePointageFrom;
    private LocalDateTime datePointageTo;
    private String pointageSens;
    private String pointageSensMin;
    private String pointageSensMax;
    private String pointeuse;
    private String pointeuseMin;
    private String pointeuseMax;

    private AgentCriteria agent ;
    private List<AgentCriteria> agents ;


    public PointageCriteria(){}

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

    public LocalDateTime getDatePointage(){
        return this.datePointage;
    }
    public void setDatePointage(LocalDateTime datePointage){
        this.datePointage = datePointage;
    }
    public LocalDateTime getDatePointageFrom(){
        return this.datePointageFrom;
    }
    public void setDatePointageFrom(LocalDateTime datePointageFrom){
        this.datePointageFrom = datePointageFrom;
    }
    public LocalDateTime getDatePointageTo(){
        return this.datePointageTo;
    }
    public void setDatePointageTo(LocalDateTime datePointageTo){
        this.datePointageTo = datePointageTo;
    }
    public String getPointageSens(){
        return this.pointageSens;
    }
    public void setPointageSens(String pointageSens){
        this.pointageSens = pointageSens;
    }   
    public String getPointageSensMin(){
        return this.pointageSensMin;
    }
    public void setPointageSensMin(String pointageSensMin){
        this.pointageSensMin = pointageSensMin;
    }
    public String getPointageSensMax(){
        return this.pointageSensMax;
    }
    public void setPointageSensMax(String pointageSensMax){
        this.pointageSensMax = pointageSensMax;
    }
      
    public String getPointeuse(){
        return this.pointeuse;
    }
    public void setPointeuse(String pointeuse){
        this.pointeuse = pointeuse;
    }   
    public String getPointeuseMin(){
        return this.pointeuseMin;
    }
    public void setPointeuseMin(String pointeuseMin){
        this.pointeuseMin = pointeuseMin;
    }
    public String getPointeuseMax(){
        return this.pointeuseMax;
    }
    public void setPointeuseMax(String pointeuseMax){
        this.pointeuseMax = pointeuseMax;
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
}
