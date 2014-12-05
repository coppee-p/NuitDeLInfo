package controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.Ebean;

import models.Camp;
import models.Event;
import models.Incident;
import models.Refugee;
import models.User;
import actions.AuthenticationAction;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

@With(AuthenticationAction.class)
public class StaffController extends Controller {

	public static Result listAll() {
		List<User> refugees = Refugee.find.all();
		return TODO;
	}
}
