package de.stud.hskl.appmarketing;

public class Fahrer extends User{
    private String profil;
    private String hs;
    private Integer alt;

    public Fahrer(String profil, String hs, Integer alt) {
        this.profil = profil;
        this.hs = hs;
        this.alt = alt;
    }

    public Fahrer(String firstName, String lastName, String email, String profil, String hs, Integer alt) {
        super(firstName, lastName, email);
        this.profil = profil;
        this.hs = hs;
        this.alt = alt;
    }
}
