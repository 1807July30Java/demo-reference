package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDAOImpl implements CaveDAO {

	private String filename = "connection.properties";

	public CaveDAOImpl() {
	}

	@Override
	public List<Cave> getCaves() {
		List<Cave> cl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			// using a Statement - beware SQL injection
			String sql = "SELECT * FROM CAVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// move through ResultSet
			while (rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				cl.add(new Cave(id, name, maxBears));
			}
			con.close(); //not strictly necessary, because try with resources
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public Cave getCaveById(int id) {
		return null;
	}

}
