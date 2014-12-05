package controllers;

import models.User;
import forms.LoginForm;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import play.data.*;

public class PublicController extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result seeCamps() {
		return TODO;
	}

	public static Result readPreventions() {
		return TODO;
	}

	public static Result readNews() {
		return TODO;
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
					return redirect(routes.PublicController.index());
				else
					return redirect(uri);
			}
			return badRequest(login.render(loginForm));
		}
	}

}
