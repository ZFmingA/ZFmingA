package OnlineQuestion.admin.db; 

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

@AFTABLE(name="example")  
@AFCOLUMNS(auto=true,generated="id") 
public class Example 
{ 
 
	public Integer id ; //ID
	public String title ; //习题标题
	public Integer creator ; //创建者
	public Integer course ; //课程
	public Integer chapter ; //章
	public Integer section ; //节
	public Byte rank ; //难度1-5
	public String digest ; //摘要显示
	public String content ; //题目内容
	public String hint ; //提示
	public String answer ; //题目答案
	public Byte status ; //状态
	public Byte priority ; //显示优先级1-9
	public Date timeCreated ; //创建时间
	public Date timeModified ; //修改时间


	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setCreator(Integer creator)
	{
		this.creator=creator;
	}
	public Integer getCreator()
	{
		return this.creator;
	}
	public void setCourse(Integer cource)
	{
		this.course=cource;
	}
	public Integer getCourse()
	{
		return this.course;
	}
	public void setChapter(Integer chapter)
	{
		this.chapter=chapter;
	}
	public Integer getChapter()
	{
		return this.chapter;
	}
	public void setSection(Integer section)
	{
		this.section=section;
	}
	public Integer getSection()
	{
		return this.section;
	}
	public void setRank(Byte rank)
	{
		this.rank=rank;
	}
	public Byte getRank()
	{
		return this.rank;
	}
	public void setDigest(String digest)
	{
		this.digest=digest;
	}
	public String getDigest()
	{
		return this.digest;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setHint(String hint)
	{
		this.hint=hint;
	}
	public String getHint()
	{
		return this.hint;
	}
	public void setAnswer(String answer)
	{
		this.answer=answer;
	}
	public String getAnswer()
	{
		return this.answer;
	}
	public void setStatus(Byte status)
	{
		this.status=status;
	}
	public Byte getStatus()
	{
		return this.status;
	}
	public void setPriority(Byte priority)
	{
		this.priority=priority;
	}
	public Byte getPriority()
	{
		return this.priority;
	}
	public void setTimeCreated(Date timeCreated)
	{
		this.timeCreated=timeCreated;
	}
	public Date getTimeCreated()
	{
		return this.timeCreated;
	}
	public void setTimeModified(Date timeModified)
	{
		this.timeModified=timeModified;
	}
	public Date getTimeModified()
	{
		return this.timeModified;
	}

} 
 