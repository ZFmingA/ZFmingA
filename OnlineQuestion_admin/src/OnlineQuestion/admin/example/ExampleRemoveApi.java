package OnlineQuestion.admin.example;

import org.json.JSONObject;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.Permissions;
import OnlineQuestion.admin.db.Admin;
import af.web.restful.AfRestfulApi;

public class ExampleRemoveApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		//权限检查
		Admin admin =new Permissions(this).CheckLogin();
		
		int id = jreq.getInt("id");
		
		String sql = "delete from course where id=" + id;
		MyC3P0Factory.execute(sql);

		return null;
	}

}
