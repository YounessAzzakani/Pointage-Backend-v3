package ma.zs.rh.bean.core.pointage;

import java.util.Objects;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.zs.rh.bean.core.commun.Agent;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "pointage")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="pointage_seq",sequenceName="pointage_seq",allocationSize=1, initialValue = 1)
public class Pointage  extends BaseEntity     {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="pointage_seq")
    private Long id;

    @Column(length = 500)
    private String ref;

    private LocalDateTime datePointage ;

    @Enumerated(EnumType.STRING)
    private PointageSens pointageSens;

    @ManyToOne
    @JoinColumn(name = "agent")
    private Agent agent ;


    public Pointage(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Pointage(String ref){
        this.ref = ref ;
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
        Pointage pointage = (Pointage) o;
        return id != null && id.equals(pointage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




    public enum PointageSens {
        ENTRANCE,
        EXIT
    }
}

