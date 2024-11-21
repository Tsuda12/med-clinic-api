package br.com.tsuda.med_clinic_api.controller.exception;

import br.com.tsuda.med_clinic_api.controller.exception.response.ArgumentNotValidResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException exception) {
        List<FieldError> errors = exception.getFieldErrors();

        List<ArgumentNotValidResponseDTO> response = errors.stream()
                .map(e -> {
                    String field = e.getField();
                    String message = e.getDefaultMessage();

                    return new ArgumentNotValidResponseDTO(field, message);
                }).toList();

        return ResponseEntity.badRequest().body(response);
    }
}
