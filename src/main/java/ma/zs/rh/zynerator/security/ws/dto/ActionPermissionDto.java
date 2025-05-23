package ma.zs.rh.zynerator.security.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.audit.Log;
import ma.zs.rh.zynerator.dto.AuditBaseDto;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActionPermissionDto  extends AuditBaseDto {

    private String reference  ;
    private String libelle  ;




    public ActionPermissionDto(){
        super();
    }




    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }


    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }








}
