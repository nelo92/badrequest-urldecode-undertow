package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Redefine @PathVariable with URLDecoder.decode
 * @see org.springframework.web.bind.annotation.PathVariable
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface DecodedPathVariable {
    String value() default "";
}
