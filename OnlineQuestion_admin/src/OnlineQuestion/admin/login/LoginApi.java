package OnlineQuestion.admin.login;

import org.json.JSONObject;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Admin;
import af.web.restful.AfRestfulApi;

public class LoginApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String username = jreq.getString("username");
		String password = jreq.getString("password");
		
		String sql = "select * from admin where username = '"+username+"'";
		Admin admin = (Admin) MyC3P0Factory.get(sql, Admin.class);
		
		if(admin == null)
		    throw new Exception("用户名或密码错误");
		if(!(admin.getPassword().equals(password)))
			throw new Exception("用户名或密码错误");
		
		httpReq.getSession().setAttribute("admin", admin);
		
		return null;
	}

}
