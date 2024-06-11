package  ma.zs.rh.ws.dto.docadmin;

import ma.zs.rh.zbiblio.audit.Log;
import ma.zs.rh.zbiblio.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeDocumentAdministratifDto  extends AuditBaseDto {

    private String ref  ;
    private String libelle  ;
    private String template  ;




    public TypeDocumentAdministratifDto(){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getTemplate(){
        return this.template;
    }
    public void setTemplate(String template){
        this.template = template;
    }








}
