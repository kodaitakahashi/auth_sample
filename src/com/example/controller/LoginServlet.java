package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.example.entity.User;
import com.example.exception.NotFoundException;
import com.example.service.AuthService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ログインページに遷移してきた場合、セッションを初期化
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // 必須チェック
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            req.setAttribute("message", "入力してください");
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        // ログイン処理
        AuthService authService = new AuthService();
        try {
            User loginUser = authService.login(email, password);
            session.setAttribute("loginUser", loginUser);
            session.setAttribute("message", "ログイン成功");
            resp.sendRedirect("/auth_sample/success");
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            String message = "処理中エラーが発生しました。もう一度ログインし直してください。";
            session.setAttribute("message", message);
            resp.sendRedirect("/auth_sample/error");
        } catch (NotFoundException e) {
            e.printStackTrace();
            req.setAttribute("message", "メールアドレスもしくはパスワードが間違えています");
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        }

    }
}
