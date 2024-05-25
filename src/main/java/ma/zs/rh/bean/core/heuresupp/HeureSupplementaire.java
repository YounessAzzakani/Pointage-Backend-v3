package ma.zs.rh.bean.core.heuresupp;

import java.util.Objects;





import ma.zs.rh.bean.core.commun.Agent;
import ma.zs.rh.bean.core.commun.EntiteAdministrative;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;

@Entity
@Table(name = "heure_supplementaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="heure_supplementaire_seq",sequenceName="heure_supplementaire_seq",allocationSize=1, initialValue = 1)
public class HeureSupplementaire  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String description;

    private Integer nbrHeure = 0;

    private BigDecimal thm = BigDecimal.ZERO;

    private TypeHeureSupplementaire typeHeureSupplementaire ;
    private Agent agent ;
    private EtatTypeHeureSupplementaire etatTypeHeureSupplementaire ;
    private EntiteAdministrative entiteAdministrative ;


    public HeureSupplementaire(){
        super();
    }

    public HeureSupplementaire(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public HeureSupplementaire(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="heure_supplementaire_seq")
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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Integer getNbrHeure(){
        return this.nbrHeure;
    }
    public void setNbrHeure(Integer nbrHeure){
        this.nbrHeure = nbrHeure;
    }
    public BigDecimal getThm(){
        return this.thm;
    }
    public void setThm(BigDecimal thm){
        this.thm = thm;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_heure_supplementaire")
    public TypeHeureSupplementaire getTypeHeureSupplementaire(){
        return this.typeHeureSupplementaire;
    }
    public void setTypeHeureSupplementaire(TypeHeureSupplementaire typeHeureSupplementaire){
        this.typeHeureSupplementaire = typeHeureSupplementaire;
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
    @JoinColumn(name = "etat_type_heure_supplementaire")
    public EtatTypeHeureSupplementaire getEtatTypeHeureSupplementaire(){
        return this.etatTypeHeureSupplementaire;
    }
    public void setEtatTypeHeureSupplementaire(EtatTypeHeureSupplementaire etatTypeHeureSupplementaire){
        this.etatTypeHeureSupplementaire = etatTypeHeureSupplementaire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entite_administrative")
    public EntiteAdministrative getEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
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
        HeureSupplementaire heureSupplementaire = (HeureSupplementaire) o;
        return id != null && id.equals(heureSupplementaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

