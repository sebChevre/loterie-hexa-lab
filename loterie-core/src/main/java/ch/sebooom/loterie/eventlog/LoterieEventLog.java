package ch.sebooom.loterie.eventlog;

import ch.sebooom.loterie.domain.DetailJoueur;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface LoterieEventLog {

    void ticketSubmitted(DetailJoueur details);

    /**
     * error submitting lottery ticket
     */
    void ticketSubmitError(DetailJoueur details);

    /**
     * lottery ticket did not win
     */
    void ticketDidNotWin(DetailJoueur details);

    /**
     * lottery ticket won
     */
    void ticketWon(DetailJoueur details, int prizeAmount);

    /**
     * error paying the prize
     */
    void prizeError(DetailJoueur details, int prizeAmount);
}
