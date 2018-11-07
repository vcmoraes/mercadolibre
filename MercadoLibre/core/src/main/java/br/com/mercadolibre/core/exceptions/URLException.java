package br.com.mercadolibre.core.exceptions;

public class URLException extends CoreException {
    public URLException() {
        super("Endpoint não encontrado");
    }
}
