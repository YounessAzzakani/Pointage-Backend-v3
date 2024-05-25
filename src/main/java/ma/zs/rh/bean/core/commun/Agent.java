package ma.zs.rh.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;
import ma.zs.rh.zynerator.security.bean.User;

@Entity
@Table(name = "agent")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="agent_seq",sequenceName="agent_seq",allocationSize=1, initialValue = 1)
public class Agent  extends User    {


    public Agent(String username) {
        super(username);
    }


    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String adresse;

    private BigDecimal thm = BigDecimal.ZERO;

    private BigDecimal salaire = BigDecimal.ZERO;








    private EntiteAdministrative entiteAdministrative ;
    private Poste poste ;
    private PlageHoraire plageHoraire ;


    public Agent(){
        super();
    }

    public Agent(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="agent_seq")
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
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_administrative")
    public EntiteAdministrative getEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste")
    public Poste getPoste(){
        return this.poste;
    }
    public void setPoste(Poste poste){
        this.poste = poste;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plage_horaire")
    public PlageHoraire getPlageHoraire(){
        return this.plageHoraire;
    }
    public void setPlageHoraire(PlageHoraire plageHoraire){
        this.plageHoraire = plageHoraire;
    }
    public BigDecimal getThm(){
        return this.thm;
    }
    public void setThm(BigDecimal thm){
        this.thm = thm;
    }
    public BigDecimal getSalaire(){
        return this.salaire;
    }
    public void setSalaire(BigDecimal salaire){
        this.salaire = salaire;
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
        Agent agent = (Agent) o;
        return id != null && id.equals(agent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

