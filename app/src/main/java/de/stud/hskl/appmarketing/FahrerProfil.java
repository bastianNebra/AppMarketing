package de.stud.hskl.appmarketing;

import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class FahrerProfil {
    private String adress_fahrer;
    private String fahrer ;
    private String adress_ziel ;
    private String swith1 ;
    private String  swith2;
    private String  auto;
    private String  autobeschreibun;
    private String anzahl_platz;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private String mail;

    public String getSendermail() {
        return sendermail;
    }

    public void setSendermail(String sendermail) {
        this.sendermail = sendermail;
    }

    private String sendermail;

    public FahrerProfil() {

    }

    public FahrerProfil(String editText, String fahrer, String adress_ziel, String swith1, String swith2, String auto, String autobeschreibun, String anzahl_platz) {
        this.adress_fahrer = editText;
        this.fahrer = fahrer;
        this.adress_ziel = adress_ziel;
        this.swith1 = swith1;
        this.swith2 = swith2;
        this.auto = auto;
        this.autobeschreibun = autobeschreibun;
        this.anzahl_platz = anzahl_platz;
    }

    public String getEditText() {
        return adress_fahrer;
    }

    public void setEditText(String editText) {
        this.adress_fahrer = editText;
    }

    public String getFahrer() {
        return fahrer;
    }

    public void setFahrer(String fahrer) {
        this.fahrer = fahrer;
    }

    public String getAdress_ziel() {
        return adress_ziel;
    }

    public void setAdress_ziel(String adress_ziel) {
        this.adress_ziel = adress_ziel;
    }

    public String getSwith1() {
        return swith1;
    }

    public void setSwith1(String swith1) {
        this.swith1 = swith1;
    }

    public String getSwith2() {
        return swith2;
    }

    public void setSwith2(String swith2) {
        this.swith2 = swith2;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getAutobeschreibun() {
        return autobeschreibun;
    }

    public void setAutobeschreibun(String autobeschreibun) {
        this.autobeschreibun = autobeschreibun;
    }

    public String getAnzahl_platz() {
        return anzahl_platz;
    }

    public void setAnzahl_platz(String anzahl_platz) {
        this.anzahl_platz = anzahl_platz;
    }
}
