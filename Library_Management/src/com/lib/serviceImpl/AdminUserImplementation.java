package com.lib.serviceImpl;

import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.lib.dao.SessionUtil;
import com.lib.pojo.UserDetails;
import com.lib.pojo.User_Auth;
import com.lib.serviceInterface.AdminUserInterface;

public class AdminUserImplementation implements AdminUserInterface{

	@Override
	public Response addUser(UserDetails user) {
		User_Auth newUser=new User_Auth();
		newUser.setPassword("12345");
		Session session = SessionUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			newUser.setUserId((Integer)session.save(newUser));
			user.setUserId(newUser.getUserId());
			session.save(user);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();

		}
		return Response.ok().build();
	}

	@Override
	public Response updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails FindUser(int id) {
		UserDetails usr = new UserDetails();

		//String usrID = String.valueOf(id);

		System.out.println("inside Find user");

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from UserDetails where userId=:usrID");
		query.setParameter("usrID", id);
		usr = (UserDetails) query.getSingleResult();
		return usr;
	}

}
