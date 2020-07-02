package com.scholaholiday.scholaholiday;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date_arrivee;
    private String date_depart;
    private double tarif;

    @ManyToOne()
    @JoinColumn(name = "client_id",referencedColumnName ="id")
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "hebergement_id",referencedColumnName ="id")
    private Hebergement hebergement;

    public Reservation() {
        this.id = 0;
        this.date_arrivee = "Date Arrivée";
        this.date_depart = "Date Départ";
        this.tarif = 0.0;
    }

    public Reservation(int id, String date_arrivee, String date_depart, double tarif, Client client, Hebergement hebergement) {
        this.id = id;
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.tarif = tarif;
        this.client = client;
        this.hebergement = hebergement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date_arrivee='" + date_arrivee + '\'' +
                ", date_depart='" + date_depart + '\'' +
                ", tarif=" + tarif +
                ", client=" + client +
                ", hebergement=" + hebergement +
                '}';
    }
}