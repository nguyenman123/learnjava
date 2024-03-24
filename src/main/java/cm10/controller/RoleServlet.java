package cm10.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm10.service.RoleService;

@WebServlet(name ="roleServlet", urlPatterns = "/role")
public class RoleServlet extends HttpServlet{
	
	private RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("role", roleService.getRoles());
		req.getRequestDispatcher("/role.jsp").forward(req, resp);
	}
}
