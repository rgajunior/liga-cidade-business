package br.com.ligacidade.annotation.forminput;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FormInput {
   String value() default "";
   int minSize() default 0;
   int maxSize() default 4000;
   String pattern() default "*";
   boolean required() default false;
   String label() default "";
   String roles() default "";
   boolean confirm() default false;
   String type() default "text";
   boolean readOnly() default false;
}
