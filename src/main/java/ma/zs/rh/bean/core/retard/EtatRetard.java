package ma.zs.rh.bean.core.retard;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zbiblio.bean.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "etat_retard")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_retard_seq",sequenceName="etat_retard_seq",allocationSize=1, initialValue = 1)
public class EtatRetard  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String libelle;



    public EtatRetard(){
        super();
    }

    public EtatRetard(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatRetard(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="etat_retard_seq")
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
        EtatRetard etatRetard = (EtatRetard) o;
        return id != null && id.equals(etatRetard.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

