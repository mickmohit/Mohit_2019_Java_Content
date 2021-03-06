package com.mohit.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MohitCouseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MohitCourseCode {

	//define course code
	public String value() default "LUV";
	
	//define course code error
	public String message() default "must start with LUV";
	
	// define default groups
	public Class<?>[] groups() default {};
	
	//default payload
	public Class<? extends Payload>[] payload() default {};
}
