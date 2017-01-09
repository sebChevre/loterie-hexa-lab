package ch.sebooom.loterie.repository;

import ch.sebooom.loterie.domain.TicketLoterie;
import ch.sebooom.loterie.domain.TicketLoterieId;

import java.util.Map;
import java.util.Optional;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface TicketLoterieRepository {

    /**
     * Find lottery ticket by id
     */
    Optional<TicketLoterie> findById(TicketLoterieId id);

    /**
     * Save lottery ticket
     */
    Optional<TicketLoterieId> save(TicketLoterie ticket);

    /**
     * Get all lottery tickets
     */
    Map<TicketLoterieId, TicketLoterie> findAll();

    /**
     * Delete all lottery tickets
     */
    void deleteAll();
}
