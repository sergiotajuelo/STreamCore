package es.sergiotajuelo.streamscore.accountservice.domain.exceptions;

public class DailyLimitExceededException extends RuntimeException {
    public DailyLimitExceededException() {
        super("Daily withdrawal limit has been exceeded");
    }
}