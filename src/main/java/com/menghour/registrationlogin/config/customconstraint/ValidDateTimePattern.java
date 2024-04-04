package com.menghour.registrationlogin.config.customconstraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidDateTimePatternValidator.class)
public @interface ValidDateTimePattern {
    String message() default "Invalid datetime pattern";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
