package Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] saveCookie=request.getParameterValues("saveCookie");
        // 在实际应用中，通常不会明文存储密码，而是对密码进行哈希处理
        // 这里只是为了演示目的使用明文密码
//        String hashedPassword = password;

        // 创建一个Cookie来保存哈希后的密码
//        Cookie cookie = new Cookie("password", hashedPassword);

//        // 设置Cookie的有效期，以便它在浏览器中保存一段时间
//        cookie.setMaxAge(3600); // 1小时
//
//        // 添加Cookie到HTTP响应中
//        response.addCookie(cookie);

        //1创建cookie
        Cookie usernameCookie=new Cookie("username",username);

        Cookie passwordCookie=new Cookie("password",password);

        //2设置最长时间
        if (saveCookie!=null && "yes".equals(saveCookie[0])) {
            usernameCookie.setMaxAge(6000);
            passwordCookie.setMaxAge(6000);
        } else {
            usernameCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
        }

        //3加入cookie
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);


        PrintWriter out = response.getWriter();
        out.println("Password saved in a cookie.");
    }
}

