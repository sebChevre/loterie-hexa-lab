package ch.sebooom.loterie.domain;

import java.util.Objects;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class DetailJoueur {
    private final String adresseEmail;
    private final String numeroCompteBancaire;
    private final String numeroTelephone;

    /**
     * Constructor.
     */
    public DetailJoueur(String mail, String compte, String phone) {
        adresseEmail = mail;
        numeroCompteBancaire = compte;
        numeroTelephone = phone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return adresseEmail;
    }

    /**
     * @return bank account number
     */
    public String getBankAccount() {
        return numeroCompteBancaire;
    }

    /**
     * @return phone number
     */
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    @Override
    public String toString() {
        return "PlayerDetails{" + "adresseEmail='" + adresseEmail + '\''
                + ", numeroCompteBancaire='" + numeroCompteBancaire + '\''
                + ", numeroTelephone='" + numeroTelephone + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCompteBancaire,adresseEmail,numeroCompteBancaire);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DetailJoueur other = (DetailJoueur) obj;

        return Objects.equals(this.numeroCompteBancaire,other.numeroCompteBancaire)
                && Objects.equals(this.numeroTelephone,other.numeroTelephone)
                && Objects.equals(this.adresseEmail,other.adresseEmail);

    }


}
