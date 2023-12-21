package Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Session1")
public class Session1 extends HttpServlet {


    private static final long serialVersionUID=1;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);


        HttpSession session =req.getSession();

        session.setAttribute("username","asd");
        session.setAttribute("password","123456");
//        req.getRequestDispatcher("asd").forward(req,resp);
        session.invalidate();
        resp.sendRedirect("Session2");

    }





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
