package  ma.zs.rh.ws.dto.commun;

import ma.zs.rh.zbiblio.audit.Log;
import ma.zs.rh.zbiblio.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntiteAdministrativeDto  extends AuditBaseDto {

    private String ref  ;
    private String libelle  ;

    private AgentDto chefService ;



    public EntiteAdministrativeDto(){
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


    public AgentDto getChefService(){
        return this.chefService;
    }

    public void setChefService(AgentDto chefService){
        this.chefService = chefService;
    }






}
