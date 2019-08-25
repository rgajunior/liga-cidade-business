package br.com.ligacidade.annotation.forminput;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EmailInput{
   String value() default "";
   int minSize() default 5;
   int maxSize() default 100;
   String pattern() default "";   
   boolean required() default true;
   String label() default "Email";
   String roles() default "";
   boolean confirm() default true;
   String type() default "email";
}
