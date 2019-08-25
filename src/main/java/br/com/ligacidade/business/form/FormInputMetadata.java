package br.com.ligacidade.business.form;

import java.lang.reflect.Field;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@JsonInclude(Include.NON_EMPTY)
public class FormInputMetadata {
   private String value;
   private int minSize;
   private int maxSize;
   private String pattern;
   private boolean required;
   private String label;   
   private String wrole;
   private String rrole;
   private boolean confirm;
   private String type;
   private boolean readOnly;

   public void setInputMetadata(String attr, Object value) {
      if ("equals,toString,hashCode,annotationType".contains(attr))
         return;
      try {
         Field f = this.getClass().getDeclaredField(attr);
         f.setAccessible(true);
         f.set(this, value);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}