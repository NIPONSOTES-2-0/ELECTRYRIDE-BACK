package edu.escuelaing.eci.ieti.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Bike {

    @Id
    private String id;
    private STATE state;
    private Date date;
    private Boolean availability;
    private Location location;

    public Bike(){};

    public Bike(String id, STATE state, Date date, Boolean availability, Location location) {
        this.id = id;
        this.state = state;
        this.date = date;
        this.availability = availability;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", date=" + date +
                ", availability=" + availability +
                ", location=" + location +
                '}';
    }
}
