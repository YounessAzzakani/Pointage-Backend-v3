package ma.zs.rh.bean.core.heuresupp;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;

@Entity
@Table(name = "type_heure_supplementaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_heure_supplementaire_seq",sequenceName="type_heure_supplementaire_seq",allocationSize=1, initialValue = 1)
public class TypeHeureSupplementaire  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String libelle;

    private BigDecimal pourcentage = BigDecimal.ZERO;



    public TypeHeureSupplementaire(){
        super();
    }

    public TypeHeureSupplementaire(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeHeureSupplementaire(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_heure_supplementaire_seq")
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
    public BigDecimal getPourcentage(){
        return this.pourcentage;
    }
    public void setPourcentage(BigDecimal pourcentage){
        this.pourcentage = pourcentage;
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
        TypeHeureSupplementaire typeHeureSupplementaire = (TypeHeureSupplementaire) o;
        return id != null && id.equals(typeHeureSupplementaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

