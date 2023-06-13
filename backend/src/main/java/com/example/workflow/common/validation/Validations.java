package com.example.workflow.common.validation;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Validations {
  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

  public static void validate(Validation validation) {
    validateAll(validation);
  }

  public static void validateAll(Validation... validations) {
    List<ValidationError> errors = Arrays.stream(validations)
        .map(Validation::validate)
        .flatMap(Optional::stream)
        .toList();

    if (!errors.isEmpty()) {
      throw new ValidationException(errors);
    }
  }

  public static Optional<ValidationError> failFast(Validation... validations) {
    return Arrays.stream(validations)
        .flatMap(v -> v.validate().stream())
        .findFirst();
  }

  public static Optional<ValidationError> notBlank(String value, String message) {
    if (value == null || value.isBlank()) {
      return Optional.of(new ValidationError(message));
    }

    return Optional.empty();
  }

  public static Optional<ValidationError> notNull(Object value, String message) {
    if (value == null) {
      return Optional.of(new ValidationError(message));
    }

    return Optional.empty();
  }

  public static Optional<ValidationError> positive(Integer value, String message) {
    if (value != null && value <= 0) {
      return Optional.of(new ValidationError(message));
    }

    return Optional.empty();
  }

  public static Optional<ValidationError> range(Integer value, Integer min, Integer max, String message) {
    if (value != null && (value < min || value > max)) {
      return Optional.of(new ValidationError(message));
    }

    return Optional.empty();
  }

  public static Optional<ValidationError> notNullOrEmpty(Collection<?> value, String message) {
    if (value == null || value.isEmpty()) {
      return Optional.of(new ValidationError(message));
    }

    return Optional.empty();
  }

  public static Optional<ValidationError> ofPattern(String value, Pattern pattern, String message) {
    if (value == null || !pattern.matcher(value).matches()) {
      return Optional.of(new ValidationError(message));
    }
    return Optional.empty();
  }

  public static Optional<ValidationError> isEqual(String value, String equalValue, String message) {
    if (!Objects.equals(value, equalValue)) {
      return Optional.of(new ValidationError(message));
    }
    return Optional.empty();
  }

  public static <T> Optional<ValidationError> satisfies(Supplier<Boolean> predicate, String message) {
    if (!predicate.get()) {
      return Optional.of(new ValidationError(message));
    }
    return Optional.empty();
  }

  public static Optional<ValidationError> isFuture(OffsetDateTime value, String message) {
    if (value == null || !value.isAfter(OffsetDateTime.now())) {
      return Optional.of(new ValidationError(message));
    }
    return Optional.empty();
  }

  public static Optional<ValidationError> isFutureOrPresent(OffsetDateTime value, String message) {
    if (value == null || value.isBefore(OffsetDateTime.now())) {
      return Optional.of(new ValidationError(message));
    }
    return Optional.empty();
  }

  public static <T> Optional<ValidationError> notEmpty(Optional<T> value, String message) {
    if (value == null || value.isEmpty()) {
      return Optional.of(new ValidationError(message));
    }
    return Optional.empty();
  }

  public static Optional<ValidationError> emailPattern(String value, String message) {
    if (value != null && !value.isBlank()) {
      return ofPattern(value, EMAIL_PATTERN, message);
    }
    return Optional.empty();
  }

  public interface Validation {
    Optional<ValidationError> validate();
  }

  public record ValidationError(String message) {
  }

}
