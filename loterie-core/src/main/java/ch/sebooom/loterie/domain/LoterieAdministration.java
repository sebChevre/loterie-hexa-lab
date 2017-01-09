package ch.sebooom.loterie.domain;

import ch.sebooom.loterie.banque.VirementBancaire;
import ch.sebooom.loterie.eventlog.LoterieEventLog;
import ch.sebooom.loterie.repository.TicketLoterieRepository;
import com.google.inject.Inject;

import java.util.Map;

/**
 * Loterie Adminstration Implementation
 *
 * premier port API
 */
public class LoterieAdministration {
    private final TicketLoterieRepository repository;
    private final LoterieEventLog notifications;
    private final VirementBancaire virement;

    /**
     * Constructor
     */
    @Inject
    public LoterieAdministration(TicketLoterieRepository repository, LoterieEventLog notifications,
                                 VirementBancaire virement) {
        this.repository = repository;
        this.notifications = notifications;
        this.virement = virement;
    }

    /**
     * Get all the lottery tickets submitted for lottery
     */
    public Map<TicketLoterieId, TicketLoterie> getAllSubmittedTickets() {
        
        return repository.findAll();
    }

    /**
     * Draw lottery numbers
     */
    public NumeroLoterie performLottery() {
        NumeroLoterie numbers = NumeroLoterie.createRandom();
        Map<TicketLoterieId, TicketLoterie> tickets = getAllSubmittedTickets();
        for (TicketLoterieId id : tickets.keySet()) {
            TicketLoterieCheckResultat result = LoterieUtils.checkTicketForPrize(repository, id, numbers);
            if (result.getResult().equals(TicketLoterieCheckResultat.CheckResultat.GAGNANT)) {
                boolean transferred = virement.transferFunds(LoterieConstantes.MONTANT_PRIX,
                        LoterieConstantes.SERVICE_COMPTE_BANCAIRE, tickets.get(id).getPlayerDetails().getBankAccount());
                if (transferred) {
                    notifications.ticketWon(tickets.get(id).getPlayerDetails(), LoterieConstantes.MONTANT_PRIX);
                } else {
                    notifications.prizeError(tickets.get(id).getPlayerDetails(), LoterieConstantes.MONTANT_PRIX);
                }
            } else if (result.getResult().equals(TicketLoterieCheckResultat.CheckResultat.PERDANT)) {
                notifications.ticketDidNotWin(tickets.get(id).getPlayerDetails());
            }
        }
        return numbers;
    }

    /**
     * Begin new lottery round
     */
    public void resetLottery() {
        repository.deleteAll();
    }
}
