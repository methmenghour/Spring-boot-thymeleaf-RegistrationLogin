package com.menghour.registrationlogin.config.customconstraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDateTimePatternValidator implements ConstraintValidator<ValidDateTimePattern, String> {
    private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void initialize(ValidDateTimePattern constraintAnnotation) {
        // No initialization needed
    }


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
            return true; // Null values are considered valid
        }
        try {
            java.time.LocalDateTime.parse(value, java.time.format.DateTimeFormatter.ofPattern(DATETIME_PATTERN));
            return true;
        } catch (Exception e) {
            return false;
        }
	}
}