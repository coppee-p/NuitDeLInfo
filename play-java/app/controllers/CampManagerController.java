package controllers;

import models.Camp;
import models.Refugee;
import play.mvc.Controller;
import play.mvc.Result;

public class CampManagerController extends Controller {

	public static Result setCampCapacity(Integer camp, Integer size) {
		Camp c = (Camp) Camp.finder.byId(camp);
		if (c == null) {
			return TODO;
		}
		c.setSize(size);
		c.save();
		return TODO;
	}

	public static Result consultReporting() {
		return TODO;
	}
}
