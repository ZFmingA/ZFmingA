package OnlineQuestion.admin.profile;

import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import af.web.mvc.AfSimpleMVC;

@WebServlet("/profile.do")
public class ProfileMVC extends AfSimpleMVC
{
	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model)
			throws Exception
	{
		
		return "/profile.jhtml";
	}

}
