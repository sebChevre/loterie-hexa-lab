package ch.sebooom.loterie.domain;

import ch.sebooom.loterie.banque.VirementBancaire;
import ch.sebooom.loterie.eventlog.LoterieEventLog;
import ch.sebooom.loterie.repository.TicketLoterieRepository;
import com.google.inject.Inject;

import java.util.Optional;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class LoterieService {

    private final TicketLoterieRepository repository;
    private final LoterieEventLog notifications;
    private final VirementBancaire virement;

    /**
     * Constructor
     */
    @Inject
    public LoterieService(TicketLoterieRepository repository, LoterieEventLog notifications,
                          VirementBancaire virement) {
        this.repository = repository;
        this.notifications = notifications;
        this.virement = virement;
    }

    /**
     * Submit lottery ticket to participate in the lottery
     */
    public Optional<TicketLoterieId> submitTicket(TicketLoterie ticket) {
        boolean result = virement.transferFunds(LoterieConstantes.PRIX_TICKET,
                ticket.getPlayerDetails().getBankAccount(), LoterieConstantes.SERVICE_COMPTE_BANCAIRE);
        if (!result) {
            notifications.ticketSubmitError(ticket.getPlayerDetails());
            return Optional.empty();
        }
        Optional<TicketLoterieId> optional = repository.save(ticket);
        if (optional.isPresent()) {
            notifications.ticketSubmitted(ticket.getPlayerDetails());
        }
        return optional;
    }

    /**
     * Check if lottery ticket has won
     */
    public TicketLoterieCheckResultat checkTicketForPrize(TicketLoterieId id, NumeroLoterie winningNumbers) {
        return LoterieUtils.checkTicketForPrize(repository, id, winningNumbers);
    }
}
