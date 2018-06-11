package com.example.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.example.entity.User;
import com.example.repository.UserDao;

public class AuthService {

    /**
     * ログイン処理
     * 
     * @param email
     *            メールアドレス
     * @param password
     *            パスワード
     * @return ログインユーザー
     * @throws SQLException
     * @throws NamingException
     */
    public User login(String email, String password) throws SQLException, NamingException {
        UserDao userDao = new UserDao();
        return userDao.selectByEmailAndPassword(email, password);
    }

}
