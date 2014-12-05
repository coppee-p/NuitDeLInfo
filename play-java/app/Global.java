import java.lang.reflect.Method;
import java.util.Date;

import models.Camp;
import models.Event;
import models.Staff;

import com.avaje.ebean.Ebean;

import play.Application;
import play.GlobalSettings;
import play.mvc.Action;
import play.mvc.Http.Request;

public class Global extends GlobalSettings {

	public static boolean once = false;

	@Override
	public void onStart(Application arg0) {
		if (!once) {
			loadFixtures();
			once = true;
		}
		super.onStart(arg0);
	}

	public void loadFixtures() {
		try {
			new Camp("Camp du Gabon", 0.2548821d, 12.52441d, "Gabon", "Gabon",
					Camp.CampStatus.OPEN, 5).save();

			new Event(
					"Violences a Franceville",
					Event.EventType.ALERT,
					-1.63333,
					13.583333,
					"À Franceville, dans l’est du Gabon, les militaires et les bérets rouges – les agents des forces armées spéciales – ont investi le campus de l'université des sciences et techniques de Masuku (USTM) le samedi 29 novembre, à la suite de manifestations étudiantes. Outre les violences physiques et les arrestations, les étudiants ont subi un certain nombre d’humiliations de la part des forces de l’ordre.",
					new Date(Date.UTC(2014, 11, 29, 0, 0, 0)), new Date(Date
							.UTC(2014, 12, 15, 0, 0, 0))).save();
			new Event(
					"Se proteger des MST",
					Event.EventType.PREVENTION,
					-1.63333,
					13.583333,
					"Seul moyen de protection contre les infections sexuellement transmissibles, le préservatif se décline aussi au féminin. Découvrez tous les atouts de cet accessoire indispensable du safe sex.",
					new Date(Date.UTC(2014, 11, 29, 0, 0, 0)), new Date(Date
							.UTC(2014, 12, 15, 0, 0, 0))).save();
			new Event(
					"Diminution de la menace Ebola",
					Event.EventType.NEWS,
					-1.7662,
					13.0297,
					"On se felecite de la baisse du nombre d'infecte par l'ebola dans le sud du Gabon.",
					new Date(Date.UTC(2014, 12, 5, 0, 0, 0))).save();
			new Staff("admin", "admin", null, Staff.StaffRole.ADMINISTRATOR)
					.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
