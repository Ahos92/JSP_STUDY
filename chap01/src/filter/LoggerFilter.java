package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggerFilter implements Filter{
	
	private String charset = "EUC-KR";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init : 필터가 초기화 되는 부분");
		
		String value = filterConfig.getInitParameter("something");
		System.out.println("필터의 초기화 파라미터에서 가져온 값 : " + value);
		
		this.charset = filterConfig.getInitParameter("encoding");
		
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy : 필터 작업이 끝나고 메모리에서 사라지기 직전");
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoggerFilter가 작동 하였습니다");
		
		// 주소 로그찍기
		System.out.println(request.getRemoteAddr());
		// 인코딩
		request.setCharacterEncoding(charset);
		
		System.out.println("LoggerFilter가 끝났습니다");
		
		chain.doFilter(request, response);
		
	}

	
	
}

