package com.company.organisationbceaorefonte.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "AGENT", indexes = {
        @Index(name = "IDX_AGENT_STRUCTURE", columnList = "STRUCTURE_ID"),
        @Index(name = "IDX_AGENT_SITE_BUDGETAIRE", columnList = "SITE_BUDGETAIRE_ID"),
        @Index(name = "IDX_AGENT_SITE_AFFECTATION", columnList = "SITE_AFFECTATION_ID")
})
@Entity
public class Agent {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;
    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;
    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;
    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;
    @NotNull
    @Column(name = "MATRICULE", nullable = false, length = 5)
    private String matricule;
    @Column(name = "NOM")
    private String nomPatronomique;
    @Column(name = "PRENOMS")
    private String prenoms;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;
    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;
    @Column(name = "NATIONNALITE")
    private String nationnalite;
    @Column(name = "SEXE")
    private String sexe;
    @Column(name = "DATE_EMBAUCHE")
    private LocalDate dateEmbauche;
    @JoinColumn(name = "STRUCTURE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure structure;
    @JoinColumn(name = "SITE_BUDGETAIRE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Site siteBudgetaire;
    @JoinColumn(name = "SITE_AFFECTATION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Site siteAffectation;

    public Site getSiteAffectation() {
        return siteAffectation;
    }

    public void setSiteAffectation(Site siteAffectation) {
        this.siteAffectation = siteAffectation;
    }

    public Site getSiteBudgetaire() {
        return siteBudgetaire;
    }

    public void setSiteBudgetaire(Site siteBudgetaire) {
        this.siteBudgetaire = siteBudgetaire;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe == null ? null : sexe.getId();
    }

    public Sexe getSexe() {
        return sexe == null ? null : Sexe.fromId(sexe);
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getNomPatronomique() {
        return nomPatronomique;
    }

    public void setNomPatronomique(String nom) {
        this.nomPatronomique = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public OffsetDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(OffsetDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"matricule"})
    public String getInstanceName(MetadataTools metadataTools) {
        return metadataTools.format(matricule);
    }
}