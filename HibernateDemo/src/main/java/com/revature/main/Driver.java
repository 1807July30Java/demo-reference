package com.revature.main;

import org.hibernate.Transaction;

import org.hibernate.Session;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		init();
	}

	static void init() {
		Session s = HibernateUtil.getSession();
		
		Transaction tx = s.beginTransaction();

		Bear b1 = new Bear("Marco",new Cave("Queens",7), new BearType("Grizzly","lol"),500);
		s.persist(b1);
		
		tx.commit();
		
		s.close();
	}

}
