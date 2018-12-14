package OnlineQuestion.admin.example;

import java.util.HashMap;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Chapter;
import OnlineQuestion.admin.db.Course;
import af.web.mvc.AfSimpleMVC;

@WebServlet("/example_edit.do")
public class ExampleEditMVC extends AfSimpleMVC
{

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> model)
			throws Exception
	{
		int courseID = Integer.valueOf(req.getParameter("course"));
		
		String sql1 = "select * from course where id = "+courseID;
		Course course = (Course) MyC3P0Factory.get(sql1,Course.class);
		if(course == null)
			throw new Exception("无此课程，id="+courseID);
		
		String sql2 = "select * from chapter where course = "+courseID+" ORDER BY course ASC, number ASC";
		List<Chapter> chapter_list = MyC3P0Factory.executeQuery(sql2, Chapter.class);
		
		model.put("course", course);
		model.put("chapter_list", chapter_list);
		
		return "/example_edit.jhtml";
	}

}
