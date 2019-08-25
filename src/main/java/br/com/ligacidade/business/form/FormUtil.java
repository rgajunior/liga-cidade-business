package br.com.ligacidade.business.form;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FormUtil {
   private static HashMap<String, FormMetadata> hmap = new HashMap<String, FormMetadata>();

   private static final String pack = "br.com.ligacidade.business.model.";

   public static FormMetadata build(String entity) throws Exception {
      FormMetadata fmd = hmap.get(entity);
      if (fmd != null)
         return fmd;

      fmd = new FormMetadata(entity);

      Class<?> clazz = Class.forName(pack + entity);

      for (Field field : clazz.getDeclaredFields()) {
         Annotation a = getInputAnnotation(field);
         if (a == null)
            continue;

         Class<?> aClazz = a.getClass();

         if (a != null) {
            FormInputMetadata fimd = new FormInputMetadata();

            for (Method method : aClazz.getDeclaredMethods()) {
               Object value = getValue(aClazz, method, a);
               fimd.setInputMetadata(method.getName(), value);
            }

            fmd.inputs.add(fimd);
         }
      }

      hmap.put(entity, fmd);

      return fmd;
   }

   private static Object getValue(Class<?> aClazz, Method method, Annotation a) {
      try {
         return method.invoke(a);
      } catch (Exception e) {
         if (!"equals".contains(method.getName()))
            System.out.println(e.getMessage());
      }

      return null;
   }

   private static Annotation getInputAnnotation(Field field) {
      for (Annotation a : field.getAnnotations()) {
         if (a.annotationType().getName().contains("br.com.ligacidade.business.annotation.forminput"))
            return a;
      }

      return null;
   }
}