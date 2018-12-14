package OnlineQuestion.admin.course;

import org.json.JSONObject;

import af.web.restful.AfRestfulApi;
import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.Permissions;
import OnlineQuestion.admin.db.Admin;
import OnlineQuestion.admin.db.Course;


public class CourseAddApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		//权限检查
		Admin admin =new Permissions(this).CheckLogin();
		
		Course row = new Course();
		row.setTitle(jreq.getString("title"));
		MyC3P0Factory.insert(row);
		
		return new JSONObject(row);
	}

}
