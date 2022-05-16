package nl.hu.Todss.WasteBar.lalafoundation.domain;

import javax.persistence.*;

@Entity
public class Medewerker {

    @Id
    @GeneratedValue
    private Long id;
    private String voornaam;
    private String achternaam;

    public Medewerker(Long id, String voornaam, String achternaam) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public Medewerker() {
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}