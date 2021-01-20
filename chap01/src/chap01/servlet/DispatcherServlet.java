package chap01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ControllerFactory;

public class DispatcherServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			/*
			 	# web.xml
			 
				  <!-- servlet -->
				  <servlet>
				  	<servlet-name>dispatcher</servlet-name>
				  	<servlet-class>servlet.DispatcherServlet</servlet-class>
				  </servlet>
						
				  <!-- mapping -->
				  <servlet-mapping>
					<servlet-name>dispatcher</servlet-name>
					<url-pattern>/</url-pattern>
				  </servlet-mapping>
		 */
		
		// 1. 요청 주소를 web.xml으로부터 받아옴
		String path = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("사용자의 요청 주소 - " + path);

		// 2. ControllerFactory에 들어가 요청 주소에 맞는 Controller 객체를 반환 ( 팩토리 디자인 패턴 )
		// 3. Controller객체 안에서 파라미터 꺼내고 할거 함 ( 비즈니스 로직 구현 )	
		Controller controller = ControllerFactory.getController(path);
		
		// 4. 어느 페이지를 응답할지 결정 ( Controller객체의 리턴 값(jsp의 경로))
		String viewPath = controller.control(req, resp);
		
		// 5. 경로를 따라 페이지 이동
		if (viewPath.startsWith("redirect:")) {
			// 서블릿으로 다시 보내는 요청을 사용 할수도 있음
			resp.sendRedirect(viewPath.substring("redirect:".length()));
			
		} else {		
			req.getRequestDispatcher(viewPath).forward(req, resp);			
		}
		
	}
	
}
