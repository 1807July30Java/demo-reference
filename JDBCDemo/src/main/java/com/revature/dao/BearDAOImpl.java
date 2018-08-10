package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class BearDAOImpl implements BearDAO {
	
private static String filename = "connection.properties";
	
	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		CaveDAOImpl cdi = new CaveDAOImpl();
		BearTypeDAOImpl btdi = new BearTypeDAOImpl();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM BEAR";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("BEAR_ID");
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				LocalDate birthdate = rs.getDate("BEAR_BIRTHDATE").toLocalDate();
				bl.add(new Bear(id,name,cave,bt,weight,birthdate));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bl;
	}

	@Override
	public Bear getBearById(int id) {
		PreparedStatement pstmt = null;
		CaveDAOImpl cdi = new CaveDAOImpl();
		BearTypeDAOImpl btdi = new BearTypeDAOImpl();
		Bear bear = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				LocalDate birthdate = rs.getDate("BEAR_BIRTHDATE").toLocalDate();
				bear = new Bear(id,name,cave,bt,weight,birthdate);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {	
			e1.printStackTrace();
		}
		return bear;
	}
	
}
