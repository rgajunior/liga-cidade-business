package br.com.ligacidade.business.model;

import br.com.ligacidade.business.annotation.forminput.EmailInput;
import br.com.ligacidade.business.annotation.forminput.FormInput;
import br.com.ligacidade.business.annotation.forminput.PasswordInput;
import lombok.Data;

@Data
public class User extends GenericEntity {

   @FormInput()
   private String id;

   @FormInput()
   private String name;

   @EmailInput()
   private String email;

   @PasswordInput()
   private String password;

   @FormInput()
   private String status;
}