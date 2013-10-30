/*
 * Created on May 26, 2005
 */
package com.agency.domain;



import java.util.List;

import net.sf.hibernate.*;


import com.agency.hibernate.SessionFactory;

/**
 * @author maki
 *
 */
public class HibernateActions {


	public static Session createSession() {
		Session session = null;
		try {
			session = SessionFactory.currentSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return session;
	}

	public static void save(Object obj) {
		Session session;
		try {
			session = createSession();
			Transaction tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		closeSession();
	}
	public static void load(Object obj,int index) {
		Session session;
		try {
			session = createSession();
			Transaction tx = session.beginTransaction();
			session.load(obj,new Integer(index));
			tx.commit();
			closeSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static void update(Object obj) {
		Session session;
		try {
			session = createSession();
			Transaction tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		closeSession();
	}


	public static void delete(Object obj) {
		Session session;
		try {
			session = createSession();
			Transaction tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();

		}
		closeSession();
	}


	public static List query(String q) {
        System.out.println("q = " + q);
        List l = null;
		Session session;
		try {
			session = createSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery(q);
			l = query.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();

		}
		closeSession();
		return l;
	}

	public static void closeSession(){
		try {
			SessionFactory.closeSession();
		} catch (HibernateException e) {

		}
	}

}
