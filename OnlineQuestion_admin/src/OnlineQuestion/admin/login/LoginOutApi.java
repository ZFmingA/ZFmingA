package OnlineQuestion.admin.login;

import org.json.JSONObject;

import af.web.restful.AfRestfulApi;

public class LoginOutApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		httpReq.getSession().setAttribute("admin", null);
		
		return null;
	}

}
