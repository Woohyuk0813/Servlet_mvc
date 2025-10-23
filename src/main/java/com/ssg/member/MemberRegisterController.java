package com.ssg.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/register")
public class MemberRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        String gender = request.getParameter("gender");
        String[] hobby = request.getParameterValues("hobby"); //null 처리

        MemberVO member = new MemberVO();
        member.setUser_id(user_id);
        member.setUser_pwd(user_pwd);
        member.setGender(gender);
        member.setHobby(hobby);

        MemberDAO memberDAO = new MemberDAO();
        int result = memberDAO.addMember(member);

        String message = "";

        if (result > 0) {
            message = user_id + " 님 회원가입 성공하였습니다.";
        } else {
            message = "가입에 실패하였습니다. 다시 시도해주세요.";
        }

        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}