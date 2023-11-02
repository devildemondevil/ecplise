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
        // ��ʵ��Ӧ���У�ͨ���������Ĵ洢���룬���Ƕ�������й�ϣ����
        // ����ֻ��Ϊ����ʾĿ��ʹ����������
//        String hashedPassword = password;

        // ����һ��Cookie�������ϣ�������
//        Cookie cookie = new Cookie("password", hashedPassword);

//        // ����Cookie����Ч�ڣ��Ա�����������б���һ��ʱ��
//        cookie.setMaxAge(3600); // 1Сʱ
//
//        // ���Cookie��HTTP��Ӧ��
//        response.addCookie(cookie);

        //1����cookie
        Cookie usernameCookie=new Cookie("username",username);

        Cookie passwordCookie=new Cookie("password",password);

        //2�����ʱ��
        if (saveCookie!=null && "yes".equals(saveCookie[0])) {
            usernameCookie.setMaxAge(6000);
            passwordCookie.setMaxAge(6000);
        } else {
            usernameCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
        }

        //3����cookie
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);


        PrintWriter out = response.getWriter();
        out.println("Password saved in a cookie.");
    }
}

