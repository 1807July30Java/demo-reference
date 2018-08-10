package com.revature.main;

import java.util.List;

import com.revature.beans.Cave;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;

public class Driver {

	public static void main(String[] args) {
	/*	try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		CaveDAO cd = new CaveDAOImpl();
		List<Cave> caves = cd.getCaves();
		for (Cave c : caves) {
			System.out.println(c);
		}
		
		//watch out for null caves! 
		Cave c = cd.getCaveById(2);
		System.out.println(c);
	}

}
