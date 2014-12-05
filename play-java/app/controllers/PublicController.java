package controllers;

import java.util.List;

import models.Event;
import models.User;
import forms.LoginForm;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import play.data.*;

public class PublicController extends Controller {

	public static Result seeCamps() {
		return TODO;
	}

	public static Result readPreventions() {
		List<Event> news = Event.find.where()
				.eq("type", Event.EventType.PREVENTION).findList();

		return ok(prevention.render(news));
	}

	public static Result readNews() {
		List<Event> news = Event.find.where().eq("type", Event.EventType.NEWS)
				.findList();
		List<Event> alerts = Event.find.where()
				.eq("type", Event.EventType.ALERT).findList();
		return ok(index.render(alerts, news));
	}

	public static Result loginPage() {
		return ok(login.render(Form.form(LoginForm.class)));
	}

	public static Result authenticate() {
		Form<LoginForm> loginForm = Form.form(LoginForm.class)
				.bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			User u = User.find.byId(loginForm.get().login);
			if (u != null
					&& u.getPassword().equals(
							loginForm.get().getHashedPassword())) {
				session().clear();
				session("login", loginForm.get().login);
				String uri = session().get("previousPage");
				if (uri == null)
					return redirect(routes.PublicController.readNews());
				else
					return redirect(uri);
			}
			return badRequest(login.render(loginForm));
		}
	}

}
