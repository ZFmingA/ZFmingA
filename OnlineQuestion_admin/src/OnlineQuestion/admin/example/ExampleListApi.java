package OnlineQuestion.admin.example;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.db.Example;
import af.web.restful.AfRestfulApi;

//select c.title as chapterTitle,e.*
//from example as e,chapter as c
//where e.chapter = c.number
//and e.course = c.course
//and c.course=5
//and c.number=1 
//order by e.chapter,e.rank

public class ExampleListApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int course = jreq.getInt("course");//课程
		int chapter = 0;
		if(jreq.has("chapter")) 
			chapter = jreq.getInt("chapter"); // 章节	
		
		if(course<0||chapter<0)
		   throw new Exception("course 或 chapter 小于0");
		
		String sql = "select c.title as chapterTitle,c.course,e.*"
					+" from example as e,chapter as c"
					+" where e.chapter = c.number"
					+" and e.course = c.course"
					+" and c.course="+course
					+" and c.number="+chapter
					+" order by e.chapter,e.rank";	
		JSONArray example_listJ = MyC3P0Factory.executeQuery2JSON(sql);
		
		return example_listJ;
	}

}
