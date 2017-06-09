package de.goldmann.portfolio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class HumanUserProfil implements Serializable {

    private static final long serialVersionUID = 7361025636654323215L;

    private static final int  MAXLEN_ANREDE    = 5;
    private static final int  MAXLEN_TELEFON   = 30;
    private static final int  MAXLEN_VORNAME   = 50;
    private static final int  MAXLEN_NACHNAME  = 50;

    @Column(name = "anrede", nullable = true, length = MAXLEN_ANREDE)
    @Enumerated(EnumType.STRING)
    private Salutation        anrede;

    @Column(name = "vorname", nullable = true, length = MAXLEN_VORNAME)
    private String firstname;

    @Column(name = "nachname", nullable = true, length = MAXLEN_NACHNAME)
    private String lastname;

    @Column(name = "telefon", nullable = true, length = MAXLEN_TELEFON)
    private String telefon;

    @Column(name = "verifiziert", nullable = true)
    private Boolean           verifiziert;

    public HumanUserProfil() {
        super();
    }

    public Salutation getAnrede() {
        return anrede;
    }

    public void setAnrede(final Salutation anrede) {
        this.anrede = anrede;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(final String telefon) {
        this.telefon = telefon;
    }

    public Boolean getVerifiziert() {
        return verifiziert;
    }

    public void setVerifiziert(final Boolean verifiziert) {
        this.verifiziert = verifiziert;
    }

}
