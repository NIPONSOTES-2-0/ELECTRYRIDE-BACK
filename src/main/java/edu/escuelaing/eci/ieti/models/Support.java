package edu.escuelaing.eci.ieti.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "support")
public class Support {

    @Id
    private String id;
    private String email;
    private String name;
    private String info;
    
    public Support(){}
    public Support(String id, String email, String name, String info){
        this.id = id;
        this.email = email;
        this.name = name;
        this.info = info; 
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getInfo(){
        return info;
    }

    public void setInfo(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "Support{" +
                "ID=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

}
