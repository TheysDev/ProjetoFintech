package br.com.fiap.fintech.exception;

public class EntidadeNaoEcontradaException extends Exception {
    public EntidadeNaoEcontradaException() {
    }

    public EntidadeNaoEcontradaException(String message) {
        super(message);
    }

    public EntidadeNaoEcontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntidadeNaoEcontradaException(Throwable cause) {
        super(cause);
    }

    public EntidadeNaoEcontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
