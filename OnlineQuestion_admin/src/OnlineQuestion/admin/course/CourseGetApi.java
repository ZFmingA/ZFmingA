package OnlineQuestion.admin.course;

import org.json.JSONObject;

import af.web.restful.AfRestfulApi;
import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Course;

public class CourseGetApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int id = jreq.getInt("id");
		String sql = "select * from course where id=" + id;
		Course row = (Course) MyC3P0Factory.get(sql,Course.class);
		if(row == null)
			throw new Exception("无此记录,id=" + id);
		
		return new JSONObject(row);
	}

}
