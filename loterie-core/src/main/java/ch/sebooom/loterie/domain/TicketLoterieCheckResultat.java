package ch.sebooom.loterie.domain;

import java.util.Objects;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class TicketLoterieCheckResultat {

    public enum CheckResultat { GAGNANT, PERDANT, TICKET_NON_SOUMIS }

    private final CheckResultat checkResult;
    private final int montantPrix;

    /**
     * Constructor.
     */
    public TicketLoterieCheckResultat(CheckResultat result) {
        checkResult = result;
        montantPrix = 0;
    }

    /**
     * Constructor.
     */
    public TicketLoterieCheckResultat(CheckResultat result, int amount) {
        checkResult = result;
        montantPrix = amount;
    }

    /**
     * @return check result
     */
    public CheckResultat getResult() {
        return checkResult;
    }

    /**
     * @return prize amount
     */
    public int getPrizeAmount() {
        return montantPrix;
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkResult,montantPrix);
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
        TicketLoterieCheckResultat other = (TicketLoterieCheckResultat) obj;

        return Objects.equals(this.checkResult,other.checkResult)
                && Objects.equals(this.montantPrix,other.montantPrix);


    }
}
