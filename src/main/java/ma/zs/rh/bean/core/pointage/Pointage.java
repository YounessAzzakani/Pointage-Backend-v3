package ma.zs.rh.bean.core.pointage;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.rh.bean.core.commun.Agent;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pointage")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="pointage_seq",sequenceName="pointage_seq",allocationSize=1, initialValue = 1)
public class Pointage  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    private LocalDateTime datePointage ;

    @ManyToOne(fetch = FetchType.LAZY)
    private PointageSens pointageSens;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pointeuse pointeuse;

    private Agent agent ;


    public Pointage(){
        super();
    }

    public Pointage(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Pointage(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="pointage_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent")
    public Agent getAgent(){
        return this.agent;
    }
    public void setAgent(Agent agent){
        this.agent = agent;
    }
    public LocalDateTime getDatePointage(){
        return this.datePointage;
    }
    public void setDatePointage(LocalDateTime datePointage){
        this.datePointage = datePointage;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public PointageSens getPointageSens(){
        return this.pointageSens;
    }
    public void setPointageSens(PointageSens pointageSens){
        this.pointageSens = pointageSens;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Pointeuse getPointeuse(){
        return this.pointeuse;
    }
    public void setPointeuse(Pointeuse pointeuse){
        this.pointeuse = pointeuse;
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

}

