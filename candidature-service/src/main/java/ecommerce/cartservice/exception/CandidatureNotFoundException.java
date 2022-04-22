package ecommerce.cartservice.exception;


import java.util.UUID;

public class CandidatureNotFoundException extends Throwable {
    public CandidatureNotFoundException(UUID id) {
        super("Cannot found candidature number [" + id + "]");
    }
}
