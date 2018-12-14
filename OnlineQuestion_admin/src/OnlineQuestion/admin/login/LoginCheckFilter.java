package OnlineQuestion.admin.login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OnlineQuestion.admin.db.Admin;

@WebFilter("*.do")
public class LoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Admin admin = (Admin) req.getSession().getAttribute("admin");
		if(admin==null)
			resp.sendRedirect(req.getServletContext().getContextPath()+"/login.html");
		
		chain.doFilter(request, response);
	}

	
}
