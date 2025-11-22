package github.henriquewegner.teste_backend.web.common.exception;

public class SaldoInconsistenteException extends RuntimeException {
    public SaldoInconsistenteException(String message) {
        super(message);
    }
}
