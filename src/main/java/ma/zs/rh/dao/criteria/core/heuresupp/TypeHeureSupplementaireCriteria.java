package  ma.zs.rh.dao.criteria.core.heuresupp;



import ma.zs.rh.zbiblio.criteria.BaseCriteria;

public class TypeHeureSupplementaireCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String libelle;
    private String libelleLike;
    private String pourcentage;
    private String pourcentageMin;
    private String pourcentageMax;



    public TypeHeureSupplementaireCriteria(){}

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

    public String getPourcentage(){
        return this.pourcentage;
    }
    public void setPourcentage(String pourcentage){
        this.pourcentage = pourcentage;
    }   
    public String getPourcentageMin(){
        return this.pourcentageMin;
    }
    public void setPourcentageMin(String pourcentageMin){
        this.pourcentageMin = pourcentageMin;
    }
    public String getPourcentageMax(){
        return this.pourcentageMax;
    }
    public void setPourcentageMax(String pourcentageMax){
        this.pourcentageMax = pourcentageMax;
    }
      

}
