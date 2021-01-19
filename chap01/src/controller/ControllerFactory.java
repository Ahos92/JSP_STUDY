package controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

	static Map<String, Controller> controllerMap = null;
	
	static {
		controllerMap = new HashMap<>();
		controllerMap.put("/home", new HomeCotroller());
		controllerMap.put("/loginpage", new LoginController());
		controllerMap.put("/logincheck", new LoginCheckController());
		controllerMap.put("/logout", new LogoutCotroller());
		controllerMap.put("/homeContent1", new HomeContentCotroller(1));
		controllerMap.put("/homeContent2", new HomeContentCotroller(2));
		controllerMap.put("/homeContent3", new HomeContentCotroller(3));
		controllerMap.put("/homeContent4", new HomeContentCotroller(4));
	}
	
	public static Controller getController(String uri) {
		return controllerMap.get(uri);
	}
}
