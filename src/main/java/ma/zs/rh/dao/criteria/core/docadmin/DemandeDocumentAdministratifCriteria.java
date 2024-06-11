package  ma.zs.rh.dao.criteria.core.docadmin;


import ma.zs.rh.dao.criteria.core.commun.AgentCriteria;
import ma.zs.rh.dao.criteria.core.commun.EntiteAdministrativeCriteria;

import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import java.util.List;

public class DemandeDocumentAdministratifCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String libelle;
    private String libelleLike;

    private TypeDocumentAdministratifCriteria typeDocumentAdministratif ;
    private List<TypeDocumentAdministratifCriteria> typeDocumentAdministratifs ;
    private AgentCriteria agent ;
    private List<AgentCriteria> agents ;
    private EtatDemandeDocumentAdministratifCriteria etatDemandeDocumentAdministratif ;
    private List<EtatDemandeDocumentAdministratifCriteria> etatDemandeDocumentAdministratifs ;
    private EntiteAdministrativeCriteria entiteAdministrative ;
    private List<EntiteAdministrativeCriteria> entiteAdministratives ;


    public DemandeDocumentAdministratifCriteria(){}

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

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }


    public TypeDocumentAdministratifCriteria getTypeDocumentAdministratif(){
        return this.typeDocumentAdministratif;
    }

    public void setTypeDocumentAdministratif(TypeDocumentAdministratifCriteria typeDocumentAdministratif){
        this.typeDocumentAdministratif = typeDocumentAdministratif;
    }
    public List<TypeDocumentAdministratifCriteria> getTypeDocumentAdministratifs(){
        return this.typeDocumentAdministratifs;
    }

    public void setTypeDocumentAdministratifs(List<TypeDocumentAdministratifCriteria> typeDocumentAdministratifs){
        this.typeDocumentAdministratifs = typeDocumentAdministratifs;
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
    public EtatDemandeDocumentAdministratifCriteria getEtatDemandeDocumentAdministratif(){
        return this.etatDemandeDocumentAdministratif;
    }

    public void setEtatDemandeDocumentAdministratif(EtatDemandeDocumentAdministratifCriteria etatDemandeDocumentAdministratif){
        this.etatDemandeDocumentAdministratif = etatDemandeDocumentAdministratif;
    }
    public List<EtatDemandeDocumentAdministratifCriteria> getEtatDemandeDocumentAdministratifs(){
        return this.etatDemandeDocumentAdministratifs;
    }

    public void setEtatDemandeDocumentAdministratifs(List<EtatDemandeDocumentAdministratifCriteria> etatDemandeDocumentAdministratifs){
        this.etatDemandeDocumentAdministratifs = etatDemandeDocumentAdministratifs;
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
