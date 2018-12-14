package OnlineQuestion.admin.course;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import af.sql.AfSqlUpdate;
import af.sql.AfSqlWhere;
import af.web.restful.AfRestfulApi;
import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.Permissions;
import OnlineQuestion.admin.course.CourseUpdateApi;
import OnlineQuestion.admin.db.Admin;

public class CourseUpdateApi extends AfRestfulApi
{
	static Logger logger = Logger.getLogger(CourseUpdateApi.class);
	
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		//权限检查
		Admin admin =new Permissions(this).CheckLogin();
		
		int id = jreq.getInt("id");
		String title = jreq.getString("title");
		
		// UPDATE
		AfSqlUpdate u = new AfSqlUpdate("course").add2("title", title);
		AfSqlWhere w = new AfSqlWhere().add2("id", id);
		
		String sql = u + " " + w;
		logger.debug("更新Course, SQL:" + sql);
		
		MyC3P0Factory.execute(sql);
		
		return null;
	}

}

