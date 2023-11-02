package Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/CookieLogin")
public class LoginCookieServlet extends HttpServlet {

    private final static long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;chatset=utf-8");

        PrintWriter writer=resp.getWriter();

        String username="";
        String password="";
        //ªÒ»°cookie
        Cookie[] cookies=req.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();

                }

                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();

                }
            }

        }


        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"CookieTest\" method=\"post\">\n" +
                "        <label for=\"username\">username</label>  \n" +
                "        <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"username\" value =\""+username +"\""+
                "             <br>\n" +
                "        <label for=\"password\">password</label>  \n" +
                "        <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"password\" value =\""+password +"\""+
                "             <br>\n" +
                "        ±£¥Ê√‹¬Î<input name=\"saveCookie\" type=\"checkbox\" value=\"yes\">\n" +
                "        <button type=\"submit\">submit</button>\n" +
                "        \n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
