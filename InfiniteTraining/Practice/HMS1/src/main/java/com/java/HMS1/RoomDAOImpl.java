package com.java.HMS1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoomDAOImpl implements RoomDAO {

	SessionFactory sf;
	Session session;
	@Override
	public List<Room_Master> showRoomDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Room_Master.class);
		List<Room_Master> roomList = criteria.list();
		return roomList;
	}
	
}
