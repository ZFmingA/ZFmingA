<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>服务器线程信息</title>

  </head>
  
  <body>
    <pre>
    	<%
    		for(Map.Entry<Thread,StackTraceElement[]>stackTrace:Thread.getAllStackTraces().entrySet())
    		{
    		   Thread thread = (Thread) stackTrace.getKey();
    		   StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
    		   if(thread.equals(Thread.currentThread()))
    		   {
    		   		continue;
    		   }
    		   out.print("\n线程："+thread.getName()+"\n");
    		   for(StackTraceElement element : stack)
    		   {
    		   		out.print("\t"+element+"\n");
    		   }
    		}
    	 %>
    </pre>
  </body>
</html>
