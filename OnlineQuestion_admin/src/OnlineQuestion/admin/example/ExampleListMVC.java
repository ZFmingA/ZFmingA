package OnlineQuestion.admin.example;

import java.util.HashMap;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Admin;
import OnlineQuestion.admin.db.Chapter;
import OnlineQuestion.admin.db.Course;
import af.web.mvc.AfSimpleMVC;

@WebServlet("/example.do")
public class ExampleListMVC extends AfSimpleMVC
{

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model)
			throws Exception
	{
		String courseSql = "select * from course order by id asc";
		String chapterSql = "select * from chapter order by number asc";
		
		List<Course> courseList = MyC3P0Factory.executeQuery(courseSql, Course.class);
		List<Chapter> chapterList = MyC3P0Factory.executeQuery(chapterSql, Chapter.class);
		
		
		model.put("courseListJ", new JSONArray(courseList));
		model.put("chapterListJ", new JSONArray(chapterList));
		
		return "/example.jhtml";
	}

}
