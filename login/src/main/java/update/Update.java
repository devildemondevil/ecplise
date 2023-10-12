package update;

import Dao.Dao;
import Dao.DaoImpl.DaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Update")
public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        String newpwd=req.getParameter("newpassword");
        String pwd=req.getParameter("password");
        String user=req.getParameter("username");

        Dao dao=new DaoImpl();

       int re= dao.update(user,pwd,newpwd);
    if (re>0){
        out.println(newpwd);
    }
    else {
        out.println("err");
    }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
