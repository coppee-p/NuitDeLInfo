package controllers;

import java.sql.Timestamp;
import java.util.Date;

import models.Refugee;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class RefugeeController extends Controller {
	public static Result register() {
		Form<Refugee> refugeeForm = Form.form(Refugee.class).bindFromRequest();
		if (refugeeForm.hasErrors()) {
			return TODO;
		} else {
			Refugee refugee = refugeeForm.get();
			refugee.save();
			return TODO;
		}
	}

}
