package login;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import Dao.Dao;
import Dao.DaoImpl.DaoImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//resp.setContentType("text/utf-8");

		PrintWriter out=resp.getWriter();

		String name=req.getParameter("username");
		
		String password=req.getParameter("password");
		
		Dao dao=(Dao)new DaoImpl();
		
		boolean re= dao.logIn(name,password);
		if(re==false) {
			out.write("false");
		}else {
			out.print("true");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
