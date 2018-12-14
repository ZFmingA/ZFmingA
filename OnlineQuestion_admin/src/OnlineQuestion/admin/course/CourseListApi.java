package OnlineQuestion.admin.course;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import af.web.restful.AfRestfulApi;
import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Course;

public class CourseListApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String sql = "select * from course order by id ASC";
		List<Course> rows = MyC3P0Factory.executeQuery(sql, Course.class);
		
		return new JSONArray(rows);
	}

}

