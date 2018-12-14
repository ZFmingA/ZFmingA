package OnlineQuestion.admin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OnlineQuestion.admin.db.Admin;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

@WebServlet("*.jhtml")
public class JHtmlSupport extends HttpServlet
{
	protected Configuration frmkConfig;
	
	@Override
	public void init() throws ServletException
	{
		// 取得APP所在目录 
		File appRoot = new File(getServletContext().getRealPath("/"));
		try{
			frmkConfig = new Configuration(Configuration.VERSION_2_3_28);
			frmkConfig.setDirectoryForTemplateLoading(appRoot); // 设置模板根目录
			frmkConfig.setDefaultEncoding("UTF-8");
			frmkConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			frmkConfig.setLogTemplateExceptions(false);
		}
		catch(Exception e)
		{		
			System.out.println("This Should Not Happen!");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		// 客户端要访问的HTML路径 
		String servletPath = req.getServletPath();
		
		// 首次运行时，加载HTML文件，解析预处理得到Template对象，并存到Configuration内的Template Cache里
		// 再次运行时，直接从Template Cache获取Template对象
		Template tp = null;
		try{
			tp = frmkConfig.getTemplate(servletPath); 
		}catch(TemplateNotFoundException ex)
		{
			resp.sendError(404, "File Not Exist: " + servletPath );
			return; // 目标HTML不存在，则直接返回404
		}
		
		// 处理并返回应答
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		try{
			HashMap<String,Object> model = new HashMap<String,Object>();
			model.put("basePath", req.getContextPath()+ "/");// 添加basePath变量
			tp.process(model, resp.getWriter()); // 输出给客户端
		}catch(Exception e)
		{
			e.printStackTrace();
			resp.sendError(500, e.getMessage());
		}
	}
}
