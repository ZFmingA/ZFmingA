package OnlineQuestion.admin.example;

import java.util.Date;

import org.json.JSONObject;

import OnlineQuestion.admin.MyC3P0Factory;
import OnlineQuestion.admin.Permissions;
import OnlineQuestion.admin.db.Admin;
import OnlineQuestion.admin.db.Example;
import af.sql.AfSqlUpdate;
import af.sql.AfSqlWhere;
import af.web.restful.AfRestfulApi;

public class ExampleSaveApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		//权限检查
		Admin admin =new Permissions(this).CheckLogin();
		
		Example row = new Example();
		row.course = Integer.valueOf(jreq.getInt("course"));//课程号
		row.chapter = Integer.valueOf(jreq.getInt("chapter"));//章节号
		row.rank = Byte.valueOf(  jreq.getString("rank"));//难度
		row.content = jreq.getString("content");//题目内容
		row.answer = jreq.getString("answer");//题目答案
	
		if(jreq.has("example_id"))
		{
			int example_id = jreq.getInt("example_id");
			update(example_id,row);
		}
		else
		{
			save(row);
		}
		
		return null;
	}
	private void save(Example row) throws Exception
	{
		
		//预留字段
		row.setTimeCreated(new Date());
		row.setTimeModified(new Date());
		row.setStatus((byte)0);
		
		MyC3P0Factory.insert(row);
	}
	
	private void update(int example_id,Example row) throws Exception
	{
		AfSqlUpdate u = new AfSqlUpdate("example");
		u.add2("chapter", row.chapter);
		u.add2("rank", (int)row.rank);
		u.add2("content", row.content);
		u.add2("answer", row.answer);
		AfSqlWhere w = new AfSqlWhere().add2("id", example_id);
		
		//插入数据库
		String sql = "" + u + w;
		MyC3P0Factory.execute(sql);
	}
}
