package ma.zs.rh.bean.core.pointage;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zbiblio.bean.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "pointeuse")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="pointeuse_seq",sequenceName="pointeuse_seq",allocationSize=1, initialValue = 1)
public class Pointeuse  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String libelle;

    @Column(length = 500)
    private String description;



    public Pointeuse(){
        super();
    }

    public Pointeuse(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Pointeuse(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="pointeuse_seq")
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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
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
        Pointeuse pointeuse = (Pointeuse) o;
        return id != null && id.equals(pointeuse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

