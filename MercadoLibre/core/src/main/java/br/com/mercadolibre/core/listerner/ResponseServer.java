package br.com.mercadolibre.core.listerner;

import br.com.mercadolibre.core.modelResponse.ErrorResponse;

public interface ResponseServer<MODEL> {

    void success(MODEL response);

    void error(ErrorResponse errorResponse);
}
