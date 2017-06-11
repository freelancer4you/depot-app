package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "benutzer")
public class HumanUser implements Serializable {

    private static final long serialVersionUID = 7043144934984899630L;
    private static final int  MAXLEN_PASSWORT  = 64;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long              id;

    @Column(name = "email", nullable = false, unique = true)
    private String            email;

    @Column(name = "passwort", nullable = false, length = MAXLEN_PASSWORT)
    private String            passwort;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "anrede", column = @Column(nullable = true)),
        @AttributeOverride(name = "vorname", column = @Column(nullable = true)),
        @AttributeOverride(name = "nachname", column = @Column(nullable = true)),
        @AttributeOverride(name = "telefon", column = @Column(nullable = true)),
        @AttributeOverride(name = "verifiziert", column = @Column(nullable = true)) })
    private HumanUserProfil   userProfil;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = false, cascade = CascadeType.ALL)
    private Set<Depot>        depots;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = false, cascade = CascadeType.ALL)
    private Set<MonitorEvent> events;

    HumanUser() {
        super();
    }

    public HumanUser(final String email, final String passwort) {
        super();
        this.email = email;
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }

    public HumanUserProfil getUserProfil() {
        if (userProfil == null) {
            userProfil = new HumanUserProfil();
        }
        return userProfil;
    }

    public Set<Depot> getDepots() {
        if (depots == null) {
            depots = new HashSet<>();
        }
        return Collections.unmodifiableSet(depots);
    }

    public Set<MonitorEvent> getEvents() {
        if (events == null) {
            this.events = new HashSet<>();
        }
        return Collections.unmodifiableSet(events);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (email == null ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HumanUser other = (HumanUser) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HumanUser ["
                + (email != null ? "email=" + email + ", " : "")
                + (passwort != null ? "passwort=" + passwort + ", " : "")
                + (userProfil != null ? "userProfil=" + userProfil : "")
                + "]";
    }

}
