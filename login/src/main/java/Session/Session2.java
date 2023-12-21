package Session;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/Session2")
public class Session2 extends HttpServlet {

    private static final long serialVersionUID=1;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);


        HttpSession session =req.getSession();
        String username=(String) session.getAttribute("username");
        String password=(String) session.getAttribute("password");


        Writer writer= resp.getWriter();

        writer.write(username+"\n"+password);


    }





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



}
