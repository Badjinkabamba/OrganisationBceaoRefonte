package com.company.organisationbceaorefonte.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@JmixEntity
@Table(name = "PAYS")
@Entity
public class Pays {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @InstanceName
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "CODE_ISO2", length = 2)
    private String codeIso2;
    @Column(name = "CODE_ISO3", length = 3)
    private String codeIso3;
    @Column(name = "IS_UEMOA")
    private Boolean isUemoa = false;

    public Boolean getIsUemoa() {
        return isUemoa;
    }

    public void setIsUemoa(Boolean isUemoa) {
        this.isUemoa = isUemoa;
    }

    public String getCodeIso3() {
        return codeIso3;
    }

    public void setCodeIso3(String codeIso3) {
        this.codeIso3 = codeIso3;
    }

    public String getCodeIso2() {
        return codeIso2;
    }

    public void setCodeIso2(String codeIso2) {
        this.codeIso2 = codeIso2;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"codeIso2", "libelle"})
    public String getInstanceName(MetadataTools metadataTools) {
        return String.format("%s - %s",
                metadataTools.format(codeIso2),
                metadataTools.format(libelle));
    }
}