package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.example.CP;
import com.example.entity.User;
import com.example.exception.NotFoundException;

public class UserDao {

    private CP cp;

    public UserDao() {
        cp = new CP();
    }

    /**
     * emailが一致するユーザーテーブルのレコードを取得
     * 
     * @param email
     *            メールアドレス
     * @param password
     *            パスワード
     * @return ユーザー情報
     * @throws NamingException
     * @throws SQLException
     */
    public User selectByEmailAndPassword(String email, String password) throws SQLException, NamingException {
        try (Connection con = cp.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("select id, email, name from user where email = ? and password = ?");) {

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                return user;
            }

        }
        throw new NotFoundException("UserDto#selectByEmail: 指定されたemailのユーザーが存在しない");
    }

}
