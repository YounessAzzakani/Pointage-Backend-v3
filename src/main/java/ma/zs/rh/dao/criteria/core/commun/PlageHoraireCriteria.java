package  ma.zs.rh.dao.criteria.core.commun;



import ma.zs.rh.zbiblio.criteria.BaseCriteria;

import java.time.LocalDateTime;

public class PlageHoraireCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String typeHoraire;
    private String typeHoraireLike;
    private LocalDateTime heureDebut;
    private LocalDateTime heureDebutFrom;
    private LocalDateTime heureDebutTo;



    public PlageHoraireCriteria(){}

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

    public String getTypeHoraire(){
        return this.typeHoraire;
    }
    public void setTypeHoraire(String typeHoraire){
        this.typeHoraire = typeHoraire;
    }
    public String getTypeHoraireLike(){
        return this.typeHoraireLike;
    }
    public void setTypeHoraireLike(String typeHoraireLike){
        this.typeHoraireLike = typeHoraireLike;
    }

    public LocalDateTime getHeureDebut(){
        return this.heureDebut;
    }
    public void setHeureDebut(LocalDateTime heureDebut){
        this.heureDebut = heureDebut;
    }
    public LocalDateTime getHeureDebutFrom(){
        return this.heureDebutFrom;
    }
    public void setHeureDebutFrom(LocalDateTime heureDebutFrom){
        this.heureDebutFrom = heureDebutFrom;
    }
    public LocalDateTime getHeureDebutTo(){
        return this.heureDebutTo;
    }
    public void setHeureDebutTo(LocalDateTime heureDebutTo){
        this.heureDebutTo = heureDebutTo;
    }

}
