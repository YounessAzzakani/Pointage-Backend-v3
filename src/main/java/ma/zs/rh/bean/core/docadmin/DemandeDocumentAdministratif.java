package ma.zs.rh.bean.core.docadmin;

import java.util.Objects;





import ma.zs.rh.bean.core.commun.Agent;
import ma.zs.rh.bean.core.commun.EntiteAdministrative;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zbiblio.bean.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "demande_document_administratif")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_document_administratif_seq",sequenceName="demande_document_administratif_seq",allocationSize=1, initialValue = 1)
public class DemandeDocumentAdministratif  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String libelle;

    private TypeDocumentAdministratif typeDocumentAdministratif ;
    private Agent agent ;
    private EtatDemandeDocumentAdministratif etatDemandeDocumentAdministratif ;
    private EntiteAdministrative entiteAdministrative ;


    public DemandeDocumentAdministratif(){
        super();
    }

    public DemandeDocumentAdministratif(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public DemandeDocumentAdministratif(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="demande_document_administratif_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_document_administratif")
    public TypeDocumentAdministratif getTypeDocumentAdministratif(){
        return this.typeDocumentAdministratif;
    }
    public void setTypeDocumentAdministratif(TypeDocumentAdministratif typeDocumentAdministratif){
        this.typeDocumentAdministratif = typeDocumentAdministratif;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent")
    public Agent getAgent(){
        return this.agent;
    }
    public void setAgent(Agent agent){
        this.agent = agent;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_demande_document_administratif")
    public EtatDemandeDocumentAdministratif getEtatDemandeDocumentAdministratif(){
        return this.etatDemandeDocumentAdministratif;
    }
    public void setEtatDemandeDocumentAdministratif(EtatDemandeDocumentAdministratif etatDemandeDocumentAdministratif){
        this.etatDemandeDocumentAdministratif = etatDemandeDocumentAdministratif;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_administrative")
    public EntiteAdministrative getEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeDocumentAdministratif demandeDocumentAdministratif = (DemandeDocumentAdministratif) o;
        return id != null && id.equals(demandeDocumentAdministratif.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

