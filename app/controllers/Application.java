package controllers;

import java.util.ArrayList;
import java.util.List;

import models.form.Field;
import models.form.FieldType;
import models.form.Form;
import models.form.ImageField;
import models.form.StringField;
import models.service.ModelType;
import models.service.ServiceModel;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void addServiceModel() {
		ServiceModel model = new ServiceModel();
		model.name = "企业招聘";
		model.description = "企业招聘";
		model.modelType = ModelType.subscribe;
		model.queryForm = getForm("jobs", "企业招聘");
		model.save();

		model = new ServiceModel();
		model.name = "融资贷款";
		model.description = "融资贷款";
		model.modelType = ModelType.subscribe;
		model.queryForm = getForm("daikuan", "融资贷款");
		model.save();

		model = new ServiceModel();
		model.name = "政策传达";
		model.description = "政策传达";
		model.modelType = ModelType.subscribe;
		model.queryForm = getForm("chuangda", "政策传达");
		model.save();
	}
	
	private static Form getForm(String name, String caption){
		Form form = new Form();
		form.caption = caption;
		form.name = name;
		List<Field> fields = new ArrayList<Field>();
		for (int i = 0; i < 4; i++) {
			StringField field = new StringField();
			field.name = "field" + i;
			field.label = "字段" + i;
			field.length = 0;
			field.type = FieldType.string;
			field.require = true;
			field.helpText = "必须输入";
			fields.add(field);
		}
		form.fields = fields;
		form.save();
		return form;
	}
	
	public static void addForm() {
		Form form = new Form();
		form.caption = "油烟机维修2";
		form.name = "youyanji2";

		List<Field> fields = new ArrayList<Field>();
		for (int i = 0; i < 10; i++) {
			StringField field = new StringField();
			field.name = "field" + i;
			field.label = "字段" + i;
			field.length = 0;
			field.type = FieldType.string;
			field.require = true;
			field.helpText = "必须输入";
			fields.add(field);
		}
		ImageField field = new ImageField();
		field.name = "image";
		field.label = "油烟机图片";
		field.type = FieldType.image;
		field.require = true;
		field.helpText = "必须输入";
		field.maxWidth = 100;
		field.maxHeight = 100;
		fields.add(field);

		form.fields = fields;
		form.save();

		renderJSON(form);
	}

}