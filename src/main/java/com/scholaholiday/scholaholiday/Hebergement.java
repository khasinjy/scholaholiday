package com.scholaholiday.scholaholiday;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hebergement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private boolean type_hebergement;

    @OneToMany(mappedBy = "hebergement")
    private List<Reservation> reservations =  new ArrayList<Reservation>();

    public Hebergement() {
        this.id = 0;
        this.description = "";
        this.type_hebergement = false;
    }

    public Hebergement(int id, String description, boolean type_hebergement, List<Reservation> reservations) {
        this.id = id;
        this.description = description;
        this.type_hebergement = type_hebergement;
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getType_hebergement() {
        return type_hebergement;
    }

    public void setType_hebergement(boolean type_hebergement) {
        this.type_hebergement = type_hebergement;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Hebergement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", type_hebergement=" + type_hebergement +
                ", reservations=" + reservations +
                '}';
    }
}