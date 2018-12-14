package OnlineQuestion.admin.chapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Chapter;
import OnlineQuestion.admin.db.Course;
import af.web.mvc.AfSimpleMVC;

@WebServlet("/chapter.do")
public class ChapterMVC extends AfSimpleMVC
{

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse jresp, HashMap<String, Object> model)
			throws Exception
	{
		int id = Integer.valueOf(req.getParameter("id"));
		String sql = "select * from course where id = "+id;
		Course row = (Course) MyC3P0Factory.get(sql, Course.class);
		if(row==null)
			throw new Exception("无此课程，id="+id);
		
		String chaptersql = "select * from chapter where course = "+id+" order by number asc";
		List<Chapter> chapters = MyC3P0Factory.executeQuery(chaptersql, Chapter.class);
		if(chapters==null)
			System.out.println("课程内无章节信息！");
        
		model.put("course", row);
		model.put("courseJ", new JSONObject(row));
		
		model.put("chaptersJ", new JSONArray(chapters));
		
		return "/chapter.jhtml";
	}

}
