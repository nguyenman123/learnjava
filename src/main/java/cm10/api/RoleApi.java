package cm10.api;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cm10.pageload.ResponseData;
import cm10.service.RoleService;

@WebServlet(name = "RoleApi",urlPatterns = {"/api/role"})
public class RoleApi extends HttpServlet {
	
	private RoleService roleService =  new RoleService();
	private Gson gson = new Gson();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		
		boolean IsSuccess = roleService.deleteRoleById(id);
		
		ResponseData data = new ResponseData();
		data.setIsSuccess(IsSuccess);
		data.setData("");
		data.setDescription("");
		
		String json = gson.toJson(data);
		
		resp.setContentType("appication/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.printf(json);
		printWriter.flush();
	}
}
