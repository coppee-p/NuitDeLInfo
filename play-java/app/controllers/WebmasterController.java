package controllers;

import com.avaje.ebean.Ebean;

import models.Camp;
import models.Event;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class WebmasterController extends Controller {
	public Result deleteCamp(Integer camp) {
		Ebean.delete(camp);
		return TODO;
	}

	public Result createCamp() {
		Form<Camp> campForm = Form.form(Camp.class);
		if (campForm.hasErrors())
			return TODO;
		Camp camp = campForm.get();
		camp.save();
		return TODO;
	}

	public Result createNewAlert() {
		Form<Event> eventForm = Form.form(Event.class);
		if (eventForm.hasErrors())
			return TODO;
		Event event = eventForm.get();
		event.save();
		return TODO;
	}

	public Result createNews() {
		Form<Event> eventForm = Form.form(Event.class);
		if (eventForm.hasErrors())
			return TODO;
		Event event = eventForm.get();
		event.save();
		return TODO;
	}

}
