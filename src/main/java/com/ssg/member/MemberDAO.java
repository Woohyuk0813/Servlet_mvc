package com.ssg.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

    private Connection conn;
    private PreparedStatement pstmt;

    private void ConnDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/root?serverTimezone=Asia/Seoul&charEncoding=UTF-8","root","root123");
            System.out.println("Connection 생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addMember(MemberVO member) {
        int result = 0;
        try {
            ConnDB();

            String user_id = member.getUser_id();
            String user_pwd = member.getUser_pwd();
            String gender = member.getGender();
            String hobby = String.join(",", member.getHobby());

            String sql = "INSERT INTO memberInfo (user_id, user_pwd, gender, hobby) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user_id);
            pstmt.setString(2, user_pwd);
            pstmt.setString(3, gender);
            pstmt.setString(4, hobby);

            result = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}