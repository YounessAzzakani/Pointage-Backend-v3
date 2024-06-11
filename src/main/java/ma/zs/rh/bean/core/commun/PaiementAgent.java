package ma.zs.rh.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zbiblio.bean.BaseEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "paiement_agent")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_agent_seq",sequenceName="paiement_agent_seq",allocationSize=1, initialValue = 1)
public class PaiementAgent  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    private Integer mois = 0;

    private Integer annee = 0;

    private BigDecimal thm = BigDecimal.ZERO;

    private Integer totalHoraireTravail = 0;

    private BigDecimal montantHoraireTravail = BigDecimal.ZERO;

    private BigDecimal totalHoraireAbsence = BigDecimal.ZERO;

    private BigDecimal montantHoraireAbsence = BigDecimal.ZERO;

    private BigDecimal totalHoraireSupplementaire = BigDecimal.ZERO;

    private BigDecimal montantHoraireSupplementaire = BigDecimal.ZERO;

    private BigDecimal salaireBase = BigDecimal.ZERO;

    private BigDecimal salaire = BigDecimal.ZERO;

    private Poste agent ;


    public PaiementAgent(){
        super();
    }

    public PaiementAgent(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public PaiementAgent(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="paiement_agent_seq")
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
    public Integer getMois(){
        return this.mois;
    }
    public void setMois(Integer mois){
        this.mois = mois;
    }
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent")
    public Poste getAgent(){
        return this.agent;
    }
    public void setAgent(Poste agent){
        this.agent = agent;
    }
    public BigDecimal getThm(){
        return this.thm;
    }
    public void setThm(BigDecimal thm){
        this.thm = thm;
    }
    public Integer getTotalHoraireTravail(){
        return this.totalHoraireTravail;
    }
    public void setTotalHoraireTravail(Integer totalHoraireTravail){
        this.totalHoraireTravail = totalHoraireTravail;
    }
    public BigDecimal getMontantHoraireTravail(){
        return this.montantHoraireTravail;
    }
    public void setMontantHoraireTravail(BigDecimal montantHoraireTravail){
        this.montantHoraireTravail = montantHoraireTravail;
    }
    public BigDecimal getTotalHoraireAbsence(){
        return this.totalHoraireAbsence;
    }
    public void setTotalHoraireAbsence(BigDecimal totalHoraireAbsence){
        this.totalHoraireAbsence = totalHoraireAbsence;
    }
    public BigDecimal getMontantHoraireAbsence(){
        return this.montantHoraireAbsence;
    }
    public void setMontantHoraireAbsence(BigDecimal montantHoraireAbsence){
        this.montantHoraireAbsence = montantHoraireAbsence;
    }
    public BigDecimal getTotalHoraireSupplementaire(){
        return this.totalHoraireSupplementaire;
    }
    public void setTotalHoraireSupplementaire(BigDecimal totalHoraireSupplementaire){
        this.totalHoraireSupplementaire = totalHoraireSupplementaire;
    }
    public BigDecimal getMontantHoraireSupplementaire(){
        return this.montantHoraireSupplementaire;
    }
    public void setMontantHoraireSupplementaire(BigDecimal montantHoraireSupplementaire){
        this.montantHoraireSupplementaire = montantHoraireSupplementaire;
    }
    public BigDecimal getSalaireBase(){
        return this.salaireBase;
    }
    public void setSalaireBase(BigDecimal salaireBase){
        this.salaireBase = salaireBase;
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
        PaiementAgent paiementAgent = (PaiementAgent) o;
        return id != null && id.equals(paiementAgent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

