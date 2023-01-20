package com.manager;

import com.beans.Reservation;
import com.dao.ReservationDao;
import com.dao.impl.ReservationDaoImpl;
/**
 * Class used to create an reservation manager to manage comunication with dao
 */
public class ReservationManager {
	ReservationDao resDao=new ReservationDaoImpl();
	public void setReservation(Reservation r) {
		resDao.create(r);
	}
}
