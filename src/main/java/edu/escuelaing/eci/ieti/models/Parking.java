package edu.escuelaing.eci.ieti.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parkings")
public class Parking {
    
    @Id
    private String id;
    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private Integer bikes_aviables;

    public Parking(String id, String name, String description, Double longitude, Double latitude, Integer bikes_aviables) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.bikes_aviables = bikes_aviables;
    }

    public Parking() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getBikes_aviables() {
        return bikes_aviables;
    }

    public void setBikes_aviables(Integer bikes_aviables) {
        this.bikes_aviables = bikes_aviables;
    }


    @Override
    public String toString() {
        return "Parking{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", bikes_aviables=" + bikes_aviables +
                '}';
    }
}
