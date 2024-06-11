package  ma.zs.rh.dao.criteria.core.docadmin;



import ma.zs.rh.zbiblio.criteria.BaseCriteria;

public class TypeDocumentAdministratifCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String libelle;
    private String libelleLike;
    private String template;
    private String templateLike;



    public TypeDocumentAdministratifCriteria(){}

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

    public String getTemplate(){
        return this.template;
    }
    public void setTemplate(String template){
        this.template = template;
    }
    public String getTemplateLike(){
        return this.templateLike;
    }
    public void setTemplateLike(String templateLike){
        this.templateLike = templateLike;
    }


}
