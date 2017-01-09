package ch.sebooom.loterie.domain;

import java.util.Objects;

/**
 * Value Object Immuable représentant un ticket de loterie
 */
public class TicketLoterie {

    private TicketLoterieId id;
    private final DetailJoueur detailJoueur;
    private final NumeroLoterie numeroLoterie;

    /**
     * Constructor.
     */
    public TicketLoterie(TicketLoterieId id, DetailJoueur details, NumeroLoterie numbers) {
        this.id = id;
        detailJoueur = details;
        numeroLoterie = numbers;
    }

    /**
     * @return player details
     */
    public DetailJoueur getPlayerDetails() {
        return detailJoueur;
    }

    /**
     * @return lottery numbers
     */
    public NumeroLoterie getNumbers() {
        return numeroLoterie;
    }

    /**
     * @return id
     */
    public TicketLoterieId getId() {
        return id;
    }

    /**
     * set id
     */
    public void setId(TicketLoterieId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return detailJoueur.toString() + " " + numeroLoterie.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroLoterie,detailJoueur);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final TicketLoterie other = (TicketLoterie) obj;
        return Objects.equals(this.numeroLoterie,((TicketLoterie) obj).numeroLoterie);
    }
}
