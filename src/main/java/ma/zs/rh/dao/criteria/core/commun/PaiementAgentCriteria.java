package  ma.zs.rh.dao.criteria.core.commun;



import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import java.util.List;

public class PaiementAgentCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String mois;
    private String moisMin;
    private String moisMax;
    private String annee;
    private String anneeMin;
    private String anneeMax;
    private String thm;
    private String thmMin;
    private String thmMax;
    private String totalHoraireTravail;
    private String totalHoraireTravailMin;
    private String totalHoraireTravailMax;
    private String montantHoraireTravail;
    private String montantHoraireTravailMin;
    private String montantHoraireTravailMax;
    private String totalHoraireAbsence;
    private String totalHoraireAbsenceMin;
    private String totalHoraireAbsenceMax;
    private String montantHoraireAbsence;
    private String montantHoraireAbsenceMin;
    private String montantHoraireAbsenceMax;
    private String totalHoraireSupplementaire;
    private String totalHoraireSupplementaireMin;
    private String totalHoraireSupplementaireMax;
    private String montantHoraireSupplementaire;
    private String montantHoraireSupplementaireMin;
    private String montantHoraireSupplementaireMax;
    private String salaireBase;
    private String salaireBaseMin;
    private String salaireBaseMax;
    private String salaire;
    private String salaireMin;
    private String salaireMax;

    private PosteCriteria agent ;
    private List<PosteCriteria> agents ;


    public PaiementAgentCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getMois(){
        return this.mois;
    }
    public void setMois(String mois){
        this.mois = mois;
    }   
    public String getMoisMin(){
        return this.moisMin;
    }
    public void setMoisMin(String moisMin){
        this.moisMin = moisMin;
    }
    public String getMoisMax(){
        return this.moisMax;
    }
    public void setMoisMax(String moisMax){
        this.moisMax = moisMax;
    }
      
    public String getAnnee(){
        return this.annee;
    }
    public void setAnnee(String annee){
        this.annee = annee;
    }   
    public String getAnneeMin(){
        return this.anneeMin;
    }
    public void setAnneeMin(String anneeMin){
        this.anneeMin = anneeMin;
    }
    public String getAnneeMax(){
        return this.anneeMax;
    }
    public void setAnneeMax(String anneeMax){
        this.anneeMax = anneeMax;
    }
      
    public String getThm(){
        return this.thm;
    }
    public void setThm(String thm){
        this.thm = thm;
    }   
    public String getThmMin(){
        return this.thmMin;
    }
    public void setThmMin(String thmMin){
        this.thmMin = thmMin;
    }
    public String getThmMax(){
        return this.thmMax;
    }
    public void setThmMax(String thmMax){
        this.thmMax = thmMax;
    }
      
    public String getTotalHoraireTravail(){
        return this.totalHoraireTravail;
    }
    public void setTotalHoraireTravail(String totalHoraireTravail){
        this.totalHoraireTravail = totalHoraireTravail;
    }   
    public String getTotalHoraireTravailMin(){
        return this.totalHoraireTravailMin;
    }
    public void setTotalHoraireTravailMin(String totalHoraireTravailMin){
        this.totalHoraireTravailMin = totalHoraireTravailMin;
    }
    public String getTotalHoraireTravailMax(){
        return this.totalHoraireTravailMax;
    }
    public void setTotalHoraireTravailMax(String totalHoraireTravailMax){
        this.totalHoraireTravailMax = totalHoraireTravailMax;
    }
      
    public String getMontantHoraireTravail(){
        return this.montantHoraireTravail;
    }
    public void setMontantHoraireTravail(String montantHoraireTravail){
        this.montantHoraireTravail = montantHoraireTravail;
    }   
    public String getMontantHoraireTravailMin(){
        return this.montantHoraireTravailMin;
    }
    public void setMontantHoraireTravailMin(String montantHoraireTravailMin){
        this.montantHoraireTravailMin = montantHoraireTravailMin;
    }
    public String getMontantHoraireTravailMax(){
        return this.montantHoraireTravailMax;
    }
    public void setMontantHoraireTravailMax(String montantHoraireTravailMax){
        this.montantHoraireTravailMax = montantHoraireTravailMax;
    }
      
    public String getTotalHoraireAbsence(){
        return this.totalHoraireAbsence;
    }
    public void setTotalHoraireAbsence(String totalHoraireAbsence){
        this.totalHoraireAbsence = totalHoraireAbsence;
    }   
    public String getTotalHoraireAbsenceMin(){
        return this.totalHoraireAbsenceMin;
    }
    public void setTotalHoraireAbsenceMin(String totalHoraireAbsenceMin){
        this.totalHoraireAbsenceMin = totalHoraireAbsenceMin;
    }
    public String getTotalHoraireAbsenceMax(){
        return this.totalHoraireAbsenceMax;
    }
    public void setTotalHoraireAbsenceMax(String totalHoraireAbsenceMax){
        this.totalHoraireAbsenceMax = totalHoraireAbsenceMax;
    }
      
    public String getMontantHoraireAbsence(){
        return this.montantHoraireAbsence;
    }
    public void setMontantHoraireAbsence(String montantHoraireAbsence){
        this.montantHoraireAbsence = montantHoraireAbsence;
    }   
    public String getMontantHoraireAbsenceMin(){
        return this.montantHoraireAbsenceMin;
    }
    public void setMontantHoraireAbsenceMin(String montantHoraireAbsenceMin){
        this.montantHoraireAbsenceMin = montantHoraireAbsenceMin;
    }
    public String getMontantHoraireAbsenceMax(){
        return this.montantHoraireAbsenceMax;
    }
    public void setMontantHoraireAbsenceMax(String montantHoraireAbsenceMax){
        this.montantHoraireAbsenceMax = montantHoraireAbsenceMax;
    }
      
    public String getTotalHoraireSupplementaire(){
        return this.totalHoraireSupplementaire;
    }
    public void setTotalHoraireSupplementaire(String totalHoraireSupplementaire){
        this.totalHoraireSupplementaire = totalHoraireSupplementaire;
    }   
    public String getTotalHoraireSupplementaireMin(){
        return this.totalHoraireSupplementaireMin;
    }
    public void setTotalHoraireSupplementaireMin(String totalHoraireSupplementaireMin){
        this.totalHoraireSupplementaireMin = totalHoraireSupplementaireMin;
    }
    public String getTotalHoraireSupplementaireMax(){
        return this.totalHoraireSupplementaireMax;
    }
    public void setTotalHoraireSupplementaireMax(String totalHoraireSupplementaireMax){
        this.totalHoraireSupplementaireMax = totalHoraireSupplementaireMax;
    }
      
    public String getMontantHoraireSupplementaire(){
        return this.montantHoraireSupplementaire;
    }
    public void setMontantHoraireSupplementaire(String montantHoraireSupplementaire){
        this.montantHoraireSupplementaire = montantHoraireSupplementaire;
    }   
    public String getMontantHoraireSupplementaireMin(){
        return this.montantHoraireSupplementaireMin;
    }
    public void setMontantHoraireSupplementaireMin(String montantHoraireSupplementaireMin){
        this.montantHoraireSupplementaireMin = montantHoraireSupplementaireMin;
    }
    public String getMontantHoraireSupplementaireMax(){
        return this.montantHoraireSupplementaireMax;
    }
    public void setMontantHoraireSupplementaireMax(String montantHoraireSupplementaireMax){
        this.montantHoraireSupplementaireMax = montantHoraireSupplementaireMax;
    }
      
    public String getSalaireBase(){
        return this.salaireBase;
    }
    public void setSalaireBase(String salaireBase){
        this.salaireBase = salaireBase;
    }   
    public String getSalaireBaseMin(){
        return this.salaireBaseMin;
    }
    public void setSalaireBaseMin(String salaireBaseMin){
        this.salaireBaseMin = salaireBaseMin;
    }
    public String getSalaireBaseMax(){
        return this.salaireBaseMax;
    }
    public void setSalaireBaseMax(String salaireBaseMax){
        this.salaireBaseMax = salaireBaseMax;
    }
      
    public String getSalaire(){
        return this.salaire;
    }
    public void setSalaire(String salaire){
        this.salaire = salaire;
    }   
    public String getSalaireMin(){
        return this.salaireMin;
    }
    public void setSalaireMin(String salaireMin){
        this.salaireMin = salaireMin;
    }
    public String getSalaireMax(){
        return this.salaireMax;
    }
    public void setSalaireMax(String salaireMax){
        this.salaireMax = salaireMax;
    }
      

    public PosteCriteria getAgent(){
        return this.agent;
    }

    public void setAgent(PosteCriteria agent){
        this.agent = agent;
    }
    public List<PosteCriteria> getAgents(){
        return this.agents;
    }

    public void setAgents(List<PosteCriteria> agents){
        this.agents = agents;
    }
}
