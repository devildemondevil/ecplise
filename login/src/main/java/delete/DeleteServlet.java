package delete;

import Dao.Dao;
import Dao.DaoImpl.DaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("asd");
//        File file=new File("./a.txt");
//        FileWriter fileWriter=new FileWriter(file);
//        BufferedReader reader =req.getReader();
//
        PrintWriter writer=resp.getWriter();
//        char[] chars=new char[1024];
//        int len=0;
//        while ((len=reader.read(chars))!=-1){
//
//            fileWriter.write(chars,0,len);
//            System.out.println("1");
//
//            writer.write(chars,0,len);
//
//        }



        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Dao dao=new DaoImpl();
         String username= req.getParameter("username");
          String password= req.getParameter("password");

          writer.println(username);
          writer.println(password);

       int a= dao.delete(username,password);

        if (a>0) {
            resp.sendRedirect("login.html");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
