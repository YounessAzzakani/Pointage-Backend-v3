package ma.zs.rh.bean.core.retard;

import java.util.Objects;

import java.time.LocalDateTime;


import ma.zs.rh.bean.core.commun.Agent;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zbiblio.bean.BaseEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "retard")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="retard_seq",sequenceName="retard_seq",allocationSize=1, initialValue = 1)
public class Retard  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    private LocalDateTime dateRetard ;

    private BigDecimal nombreHeure = BigDecimal.ZERO;

    private Agent agent ;
    private EtatRetard etatRetard ;
    private JustificationRetard justificationRetard ;


    public Retard(){
        super();
    }

    public Retard(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Retard(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="retard_seq")
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
    public LocalDateTime getDateRetard(){
        return this.dateRetard;
    }
    public void setDateRetard(LocalDateTime dateRetard){
        this.dateRetard = dateRetard;
    }
    public BigDecimal getNombreHeure(){
        return this.nombreHeure;
    }
    public void setNombreHeure(BigDecimal nombreHeure){
        this.nombreHeure = nombreHeure;
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
    @JoinColumn(name = "etat_retard")
    public EtatRetard getEtatRetard(){
        return this.etatRetard;
    }
    public void setEtatRetard(EtatRetard etatRetard){
        this.etatRetard = etatRetard;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "justification_retard")
    public JustificationRetard getJustificationRetard(){
        return this.justificationRetard;
    }
    public void setJustificationRetard(JustificationRetard justificationRetard){
        this.justificationRetard = justificationRetard;
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
        Retard retard = (Retard) o;
        return id != null && id.equals(retard.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

