package actions;

import controllers.PublicController;
import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Result;

public class AuthenticationAction extends Action<Result> {

	@Override
	public Promise<Result> call(Context arg0) throws Throwable {

		String login = arg0.session().get("login");
		if (login == null) {
			arg0.session().put("previousRoute", arg0.request().uri());
			return F.Promise.pure(PublicController.loginPage());
		}
		arg0.request().setUsername(login);
		return delegate.call(arg0);
	}
}
