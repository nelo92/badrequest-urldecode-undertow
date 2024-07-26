package com.example.demo;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface DecodedPathVariable {
    String value() default "";
}