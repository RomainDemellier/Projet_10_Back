package com.oc.projets.projet_10.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updateAt"},
		allowGetters = true)
public class Reservation implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livre_id", nullable = false)
    private Livre livre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usager_id", nullable = false)
    private Usager usager;

    private LocalDateTime date;

    private LocalDateTime dateLimit;

    private Boolean actif;

    public Reservation(){
        super();
    }


    public Reservation(Long id, Livre livre, Usager usager, LocalDateTime date, LocalDateTime dateLimit) {
        this.id = id;
        this.livre = livre;
        this.usager = usager;
        this.date = date;
        this.dateLimit = dateLimit;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livre getLivre() {
        return this.livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Usager getUsager() {
        return this.usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDateLimit() {
        return this.dateLimit;
    }

    public void setDateLimit(LocalDateTime dateLimit) {
        this.dateLimit = dateLimit;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", livre=" + livre +
                ", usager=" + usager +
                ", date=" + date +
                ", dateLimit=" + dateLimit +
                ", actif=" + actif +
                '}';
    }


}

