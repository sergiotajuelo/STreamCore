package es.sergiotajuelo.streamscore.accountservice.domain.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Domain service responsible for generating random account numbers.
 * All account numbers follow the same format and length for consistency.
 */
@Service
public class AccountNumberGenerator {

    private static final int ACCOUNT_NUMBER_LENGTH = 12;
    private static final String ACCOUNT_PREFIX = "ACC";
    private static final String NUMERIC_CHARS = "0123456789";

    private final Random random;

    /**
     * Constructs a new AccountNumberGenerator with a secure random generator.
     */
    public AccountNumberGenerator() {
        this.random = new SecureRandom();
    }

    /**
     * Generates a random account number with consistent format.
     * Format: ACC + 9 random digits (total length: 12 characters)
     *
     * @return A randomly generated account number
     */
    public String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder(ACCOUNT_PREFIX);

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH - ACCOUNT_PREFIX.length(); i++) {
            int randomIndex = random.nextInt(NUMERIC_CHARS.length());
            accountNumber.append(NUMERIC_CHARS.charAt(randomIndex));
        }

        return accountNumber.toString();
    }

    /**
     * Validates if the provided account number follows the required format.
     *
     * @param accountNumber The account number to validate
     * @return true if the account number is valid, false otherwise
     */
    public boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.length() != ACCOUNT_NUMBER_LENGTH) {
            return false;
        }

        if (!accountNumber.startsWith(ACCOUNT_PREFIX)) {
            return false;
        }

        String numericPart = accountNumber.substring(ACCOUNT_PREFIX.length());
        return numericPart.matches("\\d+");
    }
}