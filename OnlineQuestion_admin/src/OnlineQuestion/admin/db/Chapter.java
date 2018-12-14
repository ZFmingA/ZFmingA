package OnlineQuestion.admin.db; 

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

@AFTABLE(name="chapter")  
@AFCOLUMNS(auto=true,generated="id") 
public class Chapter 
{ 
 
	private Integer id ; 
	private String title ; 
	private Integer course ; 
	private Integer number ; 


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
	public void setCourse(Integer course)
	{
		this.course=course;
	}
	public Integer getCourse()
	{
		return this.course;
	}
	public void setNumber(Integer number)
	{
		this.number=number;
	}
	public Integer getNumber()
	{
		return this.number;
	}

} 
 