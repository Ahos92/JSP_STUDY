package controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

	static Map<String, Controller> controllerMap = null;
	
	static {
		controllerMap = new HashMap<>();
		controllerMap.put("/home", new HomeCotroller());
		controllerMap.put("/signup_check", new SignupController());
		controllerMap.put("/login", new LoginController());
		controllerMap.put("/logout", new LogoutCotroller());
		controllerMap.put("/homeContent1", new HomeContentCotroller());
		controllerMap.put("/homeContent2", new HomeContentCotroller());
		controllerMap.put("/homeContent3", new HomeContentCotroller());
		controllerMap.put("/homeContent4", new HomeContentCotroller());
	}
	
	public static Controller getController(String uri) {
		return controllerMap.get(uri);
	}
}
