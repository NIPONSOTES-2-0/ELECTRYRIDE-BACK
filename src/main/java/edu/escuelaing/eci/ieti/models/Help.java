package edu.escuelaing.eci.ieti.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "help")
public class Help {
    
    
    @Id
    private String id;
    private String email;
    private String name;
    private String thelp;
    private String info;

    public Help(){}
    public Help(String id, String email, String name, String thelp, String info){
        this.id = id;
        this.email = email;
        this.name = name;
        this.thelp = thelp;
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

    public String getThelp(){
        return thelp;
    }

    public void setThelp(String thelp){
        this.thelp = thelp;
    }

    public String getInfo(){
        return info;
    }

    public void setInfo(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "Help{" +
                "ID=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", thelp='" + thelp + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

}
