package test;

import com.dao.ReservationDao;
import com.dao.TrainDao;
import com.dao.TripDao;
import com.dao.UserDao;
import com.dao.impl.ReservationDaoImpl;
import com.dao.impl.TrainDaoImpl;
import com.dao.impl.TripDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.strategy.Strategy;
import com.strategy.StrategyDB;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strategy s= new StrategyDB();
		/*Map<String, List<String>> map= s.dataMap();
		CheckChain chain=CheckChainBuilder.getChain(s);
		chain.check("china");*/
		
		/*String codiceTreno="HPPR";
		VagoneFactory vagoneFactoryFR = new FRFactory();
		TrenoBuilder builderFR = new ConcreteBuilder(vagoneFactoryFR);
		Treno tFR;
			try {
				tFR = builderFR.buildTreno(codiceTreno.toUpperCase());
				System.out.println("\n\nTreno FR");
				System.out.println(tFR);
			} catch (NumeroPostiInEccesso e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TrenoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		TripDao tripDao = new TripDaoImpl();
		UserDao userDao = new UserDaoImpl();
		TrainDao trainDao = new TrainDaoImpl();
		
		ReservationDao reservationDao = new ReservationDaoImpl();
		System.out.println(reservationDao.getReservationsForTrip(tripDao.get(1)));

	}

}
