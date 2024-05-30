package ma.zs.rh.bean.core.commun;

import java.util.Collection;
import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.zs.rh.bean.core.pointage.Pointage;
import jakarta.persistence.*;
import ma.zs.rh.zynerator.security.bean.User;

@Entity
@Table(name = "agent")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_administrative")
    private EntiteAdministrative entiteAdministrative ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poste")
    private Poste poste ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plage_horaire")
    private PlageHoraire plageHoraire ;

    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private Collection<Pointage> pointages;

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

