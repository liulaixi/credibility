package controllers;

import java.util.List;

import models.form.Form;
import models.service.ServiceModel;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {

	public static void index() {
		List<ServiceModel> serviceModels = ServiceModel.findAll();
		render(serviceModels);
	}

	public static void push() {
		render();
	}

	public static void feedback() {
		render();
	}

	public static void getQueryForm(String modelId) {
		ServiceModel model = ServiceModel.findById(modelId);
		Form form = null;
		if (model != null) {
			form = model.queryForm;
		}
		renderJSON(form);
	}
}
