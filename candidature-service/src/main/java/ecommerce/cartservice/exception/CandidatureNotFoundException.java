package ecommerce.cartservice.exception;


public class CandidatureNotFoundException extends Throwable {
    public CandidatureNotFoundException(String id) {
        super("Cannot found candidature number [" + id + "]");
    }
}
