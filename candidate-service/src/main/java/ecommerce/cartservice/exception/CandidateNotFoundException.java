package ecommerce.cartservice.exception;

import java.util.UUID;

public class CandidateNotFoundException extends Throwable {
    public CandidateNotFoundException(UUID id) {
        super("Cannot found candidate number [" + id + "]");
    }
}
