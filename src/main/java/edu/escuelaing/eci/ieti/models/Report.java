package edu.escuelaing.eci.ieti.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
public class Report {
    @Id
    private String id;
    private String trep;
    private String desc;
    private String email;

    public Report(){}
    public Report(String id, String trep, String desc, String email){
        this.id = id;
        this.trep = trep;
        this.desc = desc;
        this.email = email;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTrep(){
        return trep;
    }

    public void setTrep(String trep){
        this.trep = trep;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "ID=" + id +
                ", trep='" + trep + '\'' +
                ", desc='" + desc + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
