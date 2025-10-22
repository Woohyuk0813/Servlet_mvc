package com.ssg.member;

import java.sql.*;

public class MemberDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/root?serverTimezone=Asia/Seoul&charEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "root123";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int addMember(MemberVO member) {
        String INSERT_SQL = "INSERT INTO memberInfo (userid, password, gender, hobbies) VALUES (?, ?, ?, ?)";
        int result = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {

            pstmt.setString(1, member.getUserid());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getGender());
            pstmt.setString(4, member.getHobbies());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}