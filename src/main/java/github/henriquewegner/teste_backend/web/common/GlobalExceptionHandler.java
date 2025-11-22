package github.henriquewegner.teste_backend.web.common;


import github.henriquewegner.teste_backend.web.common.exception.SaldoInconsistenteException;
import github.henriquewegner.teste_backend.web.dto.response.ErrorResponse;
import github.henriquewegner.teste_backend.web.dto.response.SingleError;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Erro de validação: {}", e.getMessage());

        List<FieldError> fieldErrors = e.getFieldErrors();

        List<SingleError> errorsList = fieldErrors.stream().map(fe ->
                new SingleError(fe.getField(),
                        fe.getDefaultMessage())).collect(Collectors.toList());

        return new ErrorResponse(
                HttpStatus.UNPROCESSABLE_CONTENT.value(),
                "Erro de validação",
                errorsList);
    }

    @ExceptionHandler(SaldoInconsistenteException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    public ErrorResponse handleExternalApiException(SaldoInconsistenteException e) {
        return ErrorResponse.unprocessableContent(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleNonTreatedExceptions(RuntimeException e){
        log.error("Unexpected error: {}", e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Um erro inesperado aconteceu, contate o administrador.",
                List.of());
    }

    private Throwable getRootCause(Throwable ex) {
        Throwable cause = ex;
        while (cause.getCause() != null && cause.getCause() != cause) {
            cause = cause.getCause();
        }
        return cause;
    }
}
