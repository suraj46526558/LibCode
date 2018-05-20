package com.lib.serviceImpl;

import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.lib.dao.SessionUtil;
import com.lib.pojo.UserDetails;
import com.lib.pojo.UserAuth;
import com.lib.serviceInterface.AdminUserInterface;

public class AdminUserImplementation implements AdminUserInterface{
	
	UserDetails newUser=null;
	Session session = SessionUtil.getSession();
	Transaction tx = null;

	@Override
	public Response addUser(UserDetails user) {
		UserAuth usr=new UserAuth();
		usr.setPassword("12345");
		usr.setUserId(user.getUserId());
		usr.setUserName(user.getUserName());
		usr.setUserType(user.getUserType());
		usr.setUserStatus(user.getUserStatus());
		
		//Session session = SessionUtil.getSession();
		//Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(usr);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();

		}
		return Response.ok().build();
	}

	@Override
	public Response updateUser(UserDetails user) {
		newUser=new UserDetails();
		
		tx=session.beginTransaction();
		session.update(user);
		tx.commit();
		return Response.ok().build();
		
		
	}

	@Override
	public Response deleteUser(int id) {
		UserDetails usr = new UserDetails();
		Session session = SessionUtil.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Query query = session.createQuery("from UserDetails where userId=:usrID");
		query.setParameter("usrID", id);
		usr = (UserDetails) query.getSingleResult();
		usr.setUserStatus("expired");
		session.save(usr);
		tx.commit();
		return Response.ok().build();
	}

	@Override
	public UserDetails FindUser(int id) {
		UserDetails usr = new UserDetails();
		System.out.println("inside Find user");
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from UserDetails where userId=:usrID");
		query.setParameter("usrID", id);
		usr = (UserDetails) query.getSingleResult();
		return usr;
	}

}
