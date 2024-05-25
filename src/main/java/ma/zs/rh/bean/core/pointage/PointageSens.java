package ma.zs.rh.bean.core.pointage;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pointage_sens")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="pointage_sens_seq",sequenceName="pointage_sens_seq",allocationSize=1, initialValue = 1)
public class PointageSens  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String libelle;



    public PointageSens(){
        super();
    }

    public PointageSens(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public PointageSens(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="pointage_sens_seq")
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
        PointageSens pointageSens = (PointageSens) o;
        return id != null && id.equals(pointageSens.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

