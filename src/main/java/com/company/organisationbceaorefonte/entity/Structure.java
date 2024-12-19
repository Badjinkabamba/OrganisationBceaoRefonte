package com.company.organisationbceaorefonte.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "STRUCTURE", indexes = {
        @Index(name = "IDX_STRUCTURE_TYPE_STRUCTURE", columnList = "TYPE_STRUCTURE_ID"),
        @Index(name = "IDX_STRUCTURE_SITE", columnList = "SITE_ID"),
        @Index(name = "IDX_STRUCTURE_STRUCTURE_PARENT", columnList = "STRUCTURE_PARENT_ID")
})
@Entity
public class Structure {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;
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
    @Column(name = "CODE")
    private String code;
    @Column(name = "LIBELLE")
    private String libelle;
    @JoinColumn(name = "TYPE_STRUCTURE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TypeStructure typeStructure;
    @JoinColumn(name = "SITE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;
    @JoinColumn(name = "STRUCTURE_PARENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure structureParent;
    @Column(name = "LEVEL_PATH")
    private Integer levelPath;
    @Lob
    @Column(name = "TREE_PATH")
    private String treePath;
    @Column(name = "REFERENCE")
    private String reference;
    @Column(name = "COMMENTAIRE")
    @Lob
    private String commentaire;

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    public Integer getLevelPath() {
        return levelPath;
    }

    public void setLevelPath(Integer levelPath) {
        this.levelPath = levelPath;
    }

    public Structure getStructureParent() {
        return structureParent;
    }

    public void setStructureParent(Structure structureParent) {
        this.structureParent = structureParent;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public TypeStructure getTypeStructure() {
        return typeStructure;
    }

    public void setTypeStructure(TypeStructure typeStructure) {
        this.typeStructure = typeStructure;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"code", "libelle"})
    public String getInstanceName(MetadataTools metadataTools) {
        return String.format("%s - %s",
                metadataTools.format(code),
                metadataTools.format(libelle));
    }
}