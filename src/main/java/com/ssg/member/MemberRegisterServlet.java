package com.ssg.member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberRegister")
public class MemberRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobbies");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>회원가입 결과</title></head><body>");
        out.println("<h2>회원가입 정보</h2>");
        out.println("<p>아이디: " + userid + "</p>");

        if (!password.equals(passwordCheck)) {
            out.println("<p style='color:red;'>비밀번호가 일치하지 않습니다.</p>");
        } else {
            out.println("<p>비밀번호: " + password + "</p>");
        }

        out.println("<p>성별: " + gender + "</p>");
        out.println("<p>취미: " + (hobbies != null ? String.join(", ", hobbies) : "없음") + "</p>");
        out.println("</body></html>");
    }
}
