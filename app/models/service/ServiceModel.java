package models.service;

import java.util.List;

import models.form.Form;
import play.data.validation.Required;
import play.modules.morphia.Model;
import play.modules.morphia.Model.AutoTimestamp;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;


@Entity
@AutoTimestamp
public class ServiceModel extends Model{
	@Required
	public String name;
	public String description;
	
	@Required
	public ModelType modelType;
	
	@Reference
	public Form serviceForm;	//服务内容表单
	
	@Reference	
	public Form queryForm;		//查询表单
	
	@Reference	
	public Form subscribeForm;	//订阅表单
	
}
