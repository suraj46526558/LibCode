package com.lib.serviceImpl;

import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.lib.dao.SessionUtil;
import com.lib.pojo.UserDetails;
import com.lib.serviceInterface.AdminUserInterface;

public class AdminUserImplementation implements AdminUserInterface{

	@Override
	public Response addUser(UserDetails user) {
		// TODO Auto-generated method stub
		return null;
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

		String usrID = String.valueOf(id);

		System.out.println("inside Find user");

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from UserDetails where userId=:usrID");
		query.setParameter("usrID", usrID);
		usr = (UserDetails) query.getSingleResult();
		return usr;
	}

}
