package OnlineQuestion.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import OnlineQuestion.admin.db.Admin;
import af.web.restful.AfRestfulApi;
import af.web.restful.AfRestfulException;

public class Permissions
{
	HttpSession session;
	public Permissions(HttpSession seesion)
	{
		this.session = session;
	}
	public Permissions(AfRestfulApi api)
	{
		this.session = api.httpReq.getSession();
	}
	public Permissions(HttpServletRequest req)
	{
		this.session = req.getSession();
	}
	
	public Admin CheckLogin() throws Exception
	{
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null)
			throw new AfRestfulException(-90,"尚未登录，请登录后在进行操作！");
		
		return admin;
	}
}
