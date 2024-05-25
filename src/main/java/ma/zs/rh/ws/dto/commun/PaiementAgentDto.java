package  ma.zs.rh.ws.dto.commun;

import ma.zs.rh.zynerator.audit.Log;
import ma.zs.rh.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaiementAgentDto  extends AuditBaseDto {

    private String ref  ;
    private Integer mois  = 0 ;
    private Integer annee  = 0 ;
    private BigDecimal thm  ;
    private Integer totalHoraireTravail  = 0 ;
    private BigDecimal montantHoraireTravail  ;
    private BigDecimal totalHoraireAbsence  ;
    private BigDecimal montantHoraireAbsence  ;
    private BigDecimal totalHoraireSupplementaire  ;
    private BigDecimal montantHoraireSupplementaire  ;
    private BigDecimal salaireBase  ;
    private BigDecimal salaire  ;

    private PosteDto agent ;



    public PaiementAgentDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public Integer getMois(){
        return this.mois;
    }
    public void setMois(Integer mois){
        this.mois = mois;
    }

    @Log
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    @Log
    public BigDecimal getThm(){
        return this.thm;
    }
    public void setThm(BigDecimal thm){
        this.thm = thm;
    }

    @Log
    public Integer getTotalHoraireTravail(){
        return this.totalHoraireTravail;
    }
    public void setTotalHoraireTravail(Integer totalHoraireTravail){
        this.totalHoraireTravail = totalHoraireTravail;
    }

    @Log
    public BigDecimal getMontantHoraireTravail(){
        return this.montantHoraireTravail;
    }
    public void setMontantHoraireTravail(BigDecimal montantHoraireTravail){
        this.montantHoraireTravail = montantHoraireTravail;
    }

    @Log
    public BigDecimal getTotalHoraireAbsence(){
        return this.totalHoraireAbsence;
    }
    public void setTotalHoraireAbsence(BigDecimal totalHoraireAbsence){
        this.totalHoraireAbsence = totalHoraireAbsence;
    }

    @Log
    public BigDecimal getMontantHoraireAbsence(){
        return this.montantHoraireAbsence;
    }
    public void setMontantHoraireAbsence(BigDecimal montantHoraireAbsence){
        this.montantHoraireAbsence = montantHoraireAbsence;
    }

    @Log
    public BigDecimal getTotalHoraireSupplementaire(){
        return this.totalHoraireSupplementaire;
    }
    public void setTotalHoraireSupplementaire(BigDecimal totalHoraireSupplementaire){
        this.totalHoraireSupplementaire = totalHoraireSupplementaire;
    }

    @Log
    public BigDecimal getMontantHoraireSupplementaire(){
        return this.montantHoraireSupplementaire;
    }
    public void setMontantHoraireSupplementaire(BigDecimal montantHoraireSupplementaire){
        this.montantHoraireSupplementaire = montantHoraireSupplementaire;
    }

    @Log
    public BigDecimal getSalaireBase(){
        return this.salaireBase;
    }
    public void setSalaireBase(BigDecimal salaireBase){
        this.salaireBase = salaireBase;
    }

    @Log
    public BigDecimal getSalaire(){
        return this.salaire;
    }
    public void setSalaire(BigDecimal salaire){
        this.salaire = salaire;
    }


    public PosteDto getAgent(){
        return this.agent;
    }

    public void setAgent(PosteDto agent){
        this.agent = agent;
    }






}
