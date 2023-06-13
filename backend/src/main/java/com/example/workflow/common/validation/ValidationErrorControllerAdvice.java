package com.example.workflow.common.validation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ValidationErrorControllerAdvice {

  @ExceptionHandler(ValidationException.class)
  ResponseEntity<ApiErrorResponse> handleValidationException(ValidationException ex) {
    List<String> errors = ex.getErrors().stream()
        .map(Validations.ValidationError::message)
        .toList();

    return ResponseEntity.badRequest()
        .body(new ApiErrorResponse(errors));
  }

  public record ApiErrorResponse(List<String> errors) {
  }

}
