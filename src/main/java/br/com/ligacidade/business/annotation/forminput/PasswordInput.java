package br.com.ligacidade.business.annotation.forminput;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordInput {
   String value() default "";
   int minSize() default 6;
   int maxSize() default 10;
   String pattern() default "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
   boolean required() default true;
   String label() default "Senha";
   String roles() default "";
   boolean confirm() default true;
   String type() default "password";
}