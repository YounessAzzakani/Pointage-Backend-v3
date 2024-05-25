package ma.zs.rh.bean.core.commun;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;




import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plage_horaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="plage_horaire_seq",sequenceName="plage_horaire_seq",allocationSize=1, initialValue = 1)
public class PlageHoraire  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String typeHoraire;

    private LocalDateTime heureDebut ;



    public PlageHoraire(){
        super();
    }

    public PlageHoraire(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public PlageHoraire(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="plage_horaire_seq")
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
    public String getTypeHoraire(){
        return this.typeHoraire;
    }
    public void setTypeHoraire(String typeHoraire){
        this.typeHoraire = typeHoraire;
    }
    public LocalDateTime getHeureDebut(){
        return this.heureDebut;
    }
    public void setHeureDebut(LocalDateTime heureDebut){
        this.heureDebut = heureDebut;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlageHoraire plageHoraire = (PlageHoraire) o;
        return id != null && id.equals(plageHoraire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

