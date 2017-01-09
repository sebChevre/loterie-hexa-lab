package ch.sebooom.loterie.banque;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface VirementBancaire {

    void setFunds(String bankAccount, int amount);

    /**
     * Get amount of funds for bank account
     */
    int getFunds(String bankAccount);

    /**
     * Transfer funds from one bank account to another
     */
    boolean transferFunds(int amount, String sourceBackAccount, String destinationBankAccount);

}
