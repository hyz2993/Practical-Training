package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @category 数据库连接基类
 */
public class BaseDao {

	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	// 加载数据库驱动
	protected void regist() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	// 创建数据库连接
	protected void connection() {
		regist();
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/usermanager"
							+ "?useUnicode=true&characterEncoding=utf8",
					"root", "root");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 创建sql语句
	protected void getPst(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 执行sql返回结果集

	// 关闭数据库连接
	protected void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
