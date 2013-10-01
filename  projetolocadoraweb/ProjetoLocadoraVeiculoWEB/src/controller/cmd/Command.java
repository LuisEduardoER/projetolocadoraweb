package controller.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
	
	public abstract String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
}
