package github.henriquewegner.teste_backend.web.dto.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorResponse(
        int status,
        String message,
        List<SingleError> errors
) {

    public static ErrorResponse unprocessableContent(String mensagem){
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_CONTENT.value(), mensagem, List.of());
    }



}
