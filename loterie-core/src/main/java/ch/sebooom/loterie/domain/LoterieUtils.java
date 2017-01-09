package ch.sebooom.loterie.domain;

import ch.sebooom.loterie.repository.TicketLoterieRepository;

import java.util.Optional;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class LoterieUtils {

    private LoterieUtils() {
    }

    /**
     * Checks if lottery ticket has won
     */
    public static TicketLoterieCheckResultat checkTicketForPrize(TicketLoterieRepository repository, TicketLoterieId id,
                                                                 NumeroLoterie winningNumbers) {
        Optional<TicketLoterie> optional = repository.findById(id);
        if (optional.isPresent()) {
            if (optional.get().getNumbers().equals(winningNumbers)) {
                return new TicketLoterieCheckResultat(TicketLoterieCheckResultat.CheckResultat.WIN_PRIZE, 1000);
            } else {
                return new TicketLoterieCheckResultat(TicketLoterieCheckResultat.CheckResultat.NO_PRIZE);
            }
        } else {
            return new TicketLoterieCheckResultat(TicketLoterieCheckResultat.CheckResultat.TICKET_NOT_SUBMITTED);
        }
    }
}
