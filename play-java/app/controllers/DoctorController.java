package controllers;

import java.sql.Timestamp;
import java.util.Date;

import models.Incident;
import models.Refugee;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class DoctorController extends Controller {
	public static Result declareNewIncident() {
		Form<Incident> form = Form.form(Incident.class).bindFromRequest();
		if (form.hasErrors()) {
			return TODO;
		}
		Incident incident = form.get();
		incident.save();
		return TODO;
	}

	public static Result registerNewRefugee() {
		Form<Refugee> refugeeForm = Form.form(Refugee.class).bindFromRequest();
		if (refugeeForm.hasErrors()) {
			return TODO;
		} else {
			Refugee refugee = refugeeForm.get();
			refugee.setArriveDate(new Timestamp(new Date().getTime()));
			refugee.save();
			return TODO;
		}
	}

	public static Result setRegisterHealthState(String refugeeLogin,
			String healthState) {
		Refugee refugee = (Refugee) Refugee.find.byId(refugeeLogin);
		if (refugee == null) {
			return TODO;
		} else {
			refugee.setHealthState(Refugee.RefugeeHealth.valueOf(healthState
					.toUpperCase()));
			return TODO;
		}
	}

	public static Result setRefugeeLeaveDate(String refugeeLogin) {
		Refugee refugee = (Refugee) Refugee.find.byId(refugeeLogin);
		if (refugee == null) {
			return TODO;
		} else {
			refugee.setLeaveDate(new Timestamp(new Date().getTime()));
			return TODO;
		}
	}

}
