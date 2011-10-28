package models.service;

import models.form.Form;
import play.data.validation.Required;
import play.modules.morphia.Model;
import play.modules.morphia.Model.AutoTimestamp;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;


@Entity
@AutoTimestamp
public class Service extends Model{	
	@Reference
	public ServiceModel model;
	
	@Reference
	public Provider provider;
	
	@Required
	public Integer stauts;
	
	@Embedded
	public Object data;
}
