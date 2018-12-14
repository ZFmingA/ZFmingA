package OnlineQuestion.admin.profile;

import org.json.JSONObject;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Admin;
import af.sql.AfSqlUpdate;
import af.sql.AfSqlWhere;
import af.web.restful.AfRestfulApi;

public class ProfileUpdateApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String lowpword = jreq.getString("lowpword");
		String newpword = jreq.getString("newpword");
		
		Admin admin = (Admin) httpReq.getSession().getAttribute("admin");
		
		if(!admin.getPassword().equals(lowpword))
		{
			throw new Exception("初始密码错误");
		}else{
			AfSqlUpdate u = new AfSqlUpdate("admin").add2("password", newpword);
			AfSqlWhere w = new AfSqlWhere().add2("username", admin.getUsername());
			String sql = u+" "+w;
			System.out.println("密码更新语句："+sql);
			MyC3P0Factory.execute(sql);
		}
		return null;
	}

}
