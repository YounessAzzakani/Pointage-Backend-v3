package ma.zs.rh.bean.core.conge;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etat_demande_conge")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_demande_conge_seq",sequenceName="etat_demande_conge_seq",allocationSize=1, initialValue = 1)
public class EtatDemandeConge  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String libelle;



    public EtatDemandeConge(){
        super();
    }

    public EtatDemandeConge(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatDemandeConge(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="etat_demande_conge_seq")
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

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtatDemandeConge etatDemandeConge = (EtatDemandeConge) o;
        return id != null && id.equals(etatDemandeConge.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

