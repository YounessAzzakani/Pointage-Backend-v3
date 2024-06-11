package  ma.zs.rh.dao.criteria.core.commun;



import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import java.util.List;

public class AgentCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String adresse;
    private String adresseLike;
    private String thm;
    private String thmMin;
    private String thmMax;
    private String salaire;
    private String salaireMin;
    private String salaireMax;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean passwordChanged;
    private String username;
    private String usernameLike;
    private String password;
    private String passwordLike;

    private EntiteAdministrativeCriteria entiteAdministrative ;
    private List<EntiteAdministrativeCriteria> entiteAdministratives ;
    private PosteCriteria poste ;
    private List<PosteCriteria> postes ;
    private PlageHoraireCriteria plageHoraire ;
    private List<PlageHoraireCriteria> plageHoraires ;


    public AgentCriteria(){}

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

    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public String getAdresseLike(){
        return this.adresseLike;
    }
    public void setAdresseLike(String adresseLike){
        this.adresseLike = adresseLike;
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
      
    public Boolean getCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public Boolean getEnabled(){
        return this.enabled;
    }
    public void setEnabled(Boolean enabled){
        this.enabled = enabled;
    }
    public Boolean getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }
    public Boolean getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }
    public Boolean getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsernameLike(){
        return this.usernameLike;
    }
    public void setUsernameLike(String usernameLike){
        this.usernameLike = usernameLike;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPasswordLike(){
        return this.passwordLike;
    }
    public void setPasswordLike(String passwordLike){
        this.passwordLike = passwordLike;
    }


    public EntiteAdministrativeCriteria getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeCriteria entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    public List<EntiteAdministrativeCriteria> getEntiteAdministratives(){
        return this.entiteAdministratives;
    }

    public void setEntiteAdministratives(List<EntiteAdministrativeCriteria> entiteAdministratives){
        this.entiteAdministratives = entiteAdministratives;
    }
    public PosteCriteria getPoste(){
        return this.poste;
    }

    public void setPoste(PosteCriteria poste){
        this.poste = poste;
    }
    public List<PosteCriteria> getPostes(){
        return this.postes;
    }

    public void setPostes(List<PosteCriteria> postes){
        this.postes = postes;
    }
    public PlageHoraireCriteria getPlageHoraire(){
        return this.plageHoraire;
    }

    public void setPlageHoraire(PlageHoraireCriteria plageHoraire){
        this.plageHoraire = plageHoraire;
    }
    public List<PlageHoraireCriteria> getPlageHoraires(){
        return this.plageHoraires;
    }

    public void setPlageHoraires(List<PlageHoraireCriteria> plageHoraires){
        this.plageHoraires = plageHoraires;
    }
}
