package br.com.ligacidade.business.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FormMetadata {
   String entity;
   List<FormInputMetadata> inputs;

   public FormMetadata(String entity){
      this.entity = entity;
      this.inputs = new ArrayList<FormInputMetadata>();
   }
}