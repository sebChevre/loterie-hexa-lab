package ch.sebooom.loterie.domain;

import java.util.Objects;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class TicketLoterieId {

    private static volatile int numAllocated;
    private final int id;

    public TicketLoterieId() {
        this.id = numAllocated + 1;
        numAllocated++;
    }

    public TicketLoterieId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d", id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TicketLoterieId other = (TicketLoterieId) o;

        return Objects.equals(this.id,other.id);

    }

    @Override
    public int hashCode() {
        return id;
    }
}
