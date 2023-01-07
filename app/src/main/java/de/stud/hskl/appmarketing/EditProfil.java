package de.stud.hskl.appmarketing;

public class EditProfil
{

    private String name;
    private String email;
    private String standort;
    private String alter;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStandort() {
        return standort;
    }

    public String getAlter() {
        return alter;
    }

    public void setAlter(String alter) {
        this.alter = alter;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EditProfil(String name, String email, String standort, String alter){

  this.name= name;
  this.email=email;
  this.standort=standort;
  this.alter =alter;
}
    public EditProfil(){

    }
}
