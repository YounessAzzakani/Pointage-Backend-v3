package  ma.zs.rh.ws.dto.docadmin;

import ma.zs.rh.zbiblio.audit.Log;
import ma.zs.rh.zbiblio.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.rh.ws.dto.commun.AgentDto;
import ma.zs.rh.ws.dto.commun.EntiteAdministrativeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandeDocumentAdministratifDto  extends AuditBaseDto {

    private String ref  ;
    private String libelle  ;

    private TypeDocumentAdministratifDto typeDocumentAdministratif ;
    private AgentDto agent ;
    private EtatDemandeDocumentAdministratifDto etatDemandeDocumentAdministratif ;
    private EntiteAdministrativeDto entiteAdministrative ;



    public DemandeDocumentAdministratifDto(){
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


    public TypeDocumentAdministratifDto getTypeDocumentAdministratif(){
        return this.typeDocumentAdministratif;
    }

    public void setTypeDocumentAdministratif(TypeDocumentAdministratifDto typeDocumentAdministratif){
        this.typeDocumentAdministratif = typeDocumentAdministratif;
    }
    public AgentDto getAgent(){
        return this.agent;
    }

    public void setAgent(AgentDto agent){
        this.agent = agent;
    }
    public EtatDemandeDocumentAdministratifDto getEtatDemandeDocumentAdministratif(){
        return this.etatDemandeDocumentAdministratif;
    }

    public void setEtatDemandeDocumentAdministratif(EtatDemandeDocumentAdministratifDto etatDemandeDocumentAdministratif){
        this.etatDemandeDocumentAdministratif = etatDemandeDocumentAdministratif;
    }
    public EntiteAdministrativeDto getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeDto entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }






}
