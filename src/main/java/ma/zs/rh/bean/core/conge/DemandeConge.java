package ma.zs.rh.bean.core.conge;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.rh.bean.core.commun.Agent;
import ma.zs.rh.bean.core.commun.EntiteAdministrative;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.rh.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "demande_conge")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_conge_seq",sequenceName="demande_conge_seq",allocationSize=1, initialValue = 1)
public class DemandeConge  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String ref;

    @Column(length = 500)
    private String contenu;

    private LocalDateTime dateDepart ;

    private LocalDateTime dateFin ;

    private Integer nombreJour = 0;

    private MotifRejetDemandeConge motifRejetDemandeConge ;
    private Agent manager ;
    private Agent agent ;
    private RaisonConge raisonConge ;
    private EtatDemandeConge etatDemandeConge ;
    private EntiteAdministrative entiteAdministrative ;


    public DemandeConge(){
        super();
    }

    public DemandeConge(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public DemandeConge(String ref){
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="demande_conge_seq")
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
    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motif_rejet_demande_conge")
    public MotifRejetDemandeConge getMotifRejetDemandeConge(){
        return this.motifRejetDemandeConge;
    }
    public void setMotifRejetDemandeConge(MotifRejetDemandeConge motifRejetDemandeConge){
        this.motifRejetDemandeConge = motifRejetDemandeConge;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager")
    public Agent getManager(){
        return this.manager;
    }
    public void setManager(Agent manager){
        this.manager = manager;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent")
    public Agent getAgent(){
        return this.agent;
    }
    public void setAgent(Agent agent){
        this.agent = agent;
    }
    public LocalDateTime getDateDepart(){
        return this.dateDepart;
    }
    public void setDateDepart(LocalDateTime dateDepart){
        this.dateDepart = dateDepart;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public Integer getNombreJour(){
        return this.nombreJour;
    }
    public void setNombreJour(Integer nombreJour){
        this.nombreJour = nombreJour;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raison_conge")
    public RaisonConge getRaisonConge(){
        return this.raisonConge;
    }
    public void setRaisonConge(RaisonConge raisonConge){
        this.raisonConge = raisonConge;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_demande_conge")
    public EtatDemandeConge getEtatDemandeConge(){
        return this.etatDemandeConge;
    }
    public void setEtatDemandeConge(EtatDemandeConge etatDemandeConge){
        this.etatDemandeConge = etatDemandeConge;
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
        DemandeConge demandeConge = (DemandeConge) o;
        return id != null && id.equals(demandeConge.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

