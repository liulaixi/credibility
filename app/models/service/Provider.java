package models.service;

import java.io.File;

import models.system.Area;
import models.system.Trade;
import play.data.validation.Email;
import play.data.validation.Phone;
import play.data.validation.Required;
import play.data.validation.URL;
import play.modules.morphia.Model;
import play.modules.morphia.Model.AutoTimestamp;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

@Entity
@AutoTimestamp
public class Provider extends Model{
	@Required
	public String name;
	public String linkName;
	public String linkTitle;
	@Phone
	public String telNum;
	@Phone
	public String fax;
	public String address;
	@URL
	public String url;
	@Email
	public String email;
	public String desc;
	public File license;
	
	@Reference
	public Area area;
	@Reference
	public Trade trade;
}
