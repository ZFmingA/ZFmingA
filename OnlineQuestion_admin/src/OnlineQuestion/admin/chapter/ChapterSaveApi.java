package OnlineQuestion.admin.chapter;

import org.json.JSONArray;
import org.json.JSONObject;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.Permissions;
import OnlineQuestion.admin.db.Admin;
import OnlineQuestion.admin.db.Chapter;
import af.web.restful.AfRestfulApi;

public class ChapterSaveApi extends AfRestfulApi
{
	public ChapterSaveApi()
	{
		this.enableErrorLog = true;
	}
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		//权限检查
		Admin admin =new Permissions(this).CheckLogin();
		//课程id
		int course = jreq.getInt("course");
		//课程章节列表
		JSONArray chapter_list = jreq.getJSONArray("chapter_list");
		
		//先删除课程下的所有章节
		if(true)
		{
			String sql = "delete from chapter where course = " + course;
			MyC3P0Factory.execute(sql);
		}
		//再添加
		for(int i=0;i<chapter_list.length();i++)
		{
			String title = chapter_list.getString(i);
			Chapter row = new Chapter();
			row.setTitle(title);
			row.setCourse(course);
			row.setNumber(i+1);
			MyC3P0Factory.insert(row);
		}
		
		return null;
	}

}
