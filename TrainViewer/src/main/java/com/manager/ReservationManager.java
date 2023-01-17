package com.manager;

import com.beans.Reservation;
import com.beans.Train;
import com.dao.ReservationDao;
import com.dao.impl.ReservationDaoImpl;

public class ReservationManager {
	ReservationDao resDao=new ReservationDaoImpl();
	public void setReservation(Reservation r) {
		resDao.create(r);
	}
}
