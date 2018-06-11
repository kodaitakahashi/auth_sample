package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * コネクションプーリング
 * 
 * @author kodaitakahashi
 *
 */
public class CP {

    /**
     * コネクションを取得
     * 
     * @return Connection
     * @throws NamingException
     * @throws SQLException
     */
    public Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/auth");
        return ds.getConnection();

    }

}
