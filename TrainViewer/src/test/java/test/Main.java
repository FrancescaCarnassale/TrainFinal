package test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.CheckChainBuilder;
import com.TrenoFactory.builder.ConcreteBuilder;
import com.TrenoFactory.builder.TrenoBuilder;
import com.TrenoFactory.exceptions.NumeroPostiInEccesso;
import com.TrenoFactory.exceptions.TrenoException;
import com.TrenoFactory.factory.FRFactory;
import com.TrenoFactory.factory.TNFactory;
import com.TrenoFactory.factory.VagoneFactory;
import com.TrenoFactory.treno.Treno;
import com.beans.Country;
import com.beans.Train;
import com.beans.Trip;
import com.beans.User;
import com.dao.ReservationDao;
import com.dao.TripDao;
import com.dao.UserDao;
import com.dao.impl.ReservationDaoImpl;
import com.dao.impl.TripDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.manager.strategy.Strategy;
import com.manager.strategy.StrategyDB;



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
		
		ReservationDao reservationDao = new ReservationDaoImpl();
		
		TripDao tripDao = new TripDaoImpl();
		Trip t = new Trip();
		Train tr = new Train();
		tr.setIdTrain(1);
		tr.setBrand("Frecciarossa");
		tr.setSeats(50);
		tr.setSerialNumber("HPPP");
		Country c = new Country();
		c.setCountryName("Italia");
		Country c1 = new Country();
		c1.setCountryName("Germania");
		t.setIdTrip(3);
		t.setArrive(c);
		t.setDeparture(c1);
		t.setSeatsAvailable(50);
		t.setIdTrain(tr);
		t.setTimeArrive(Timestamp.valueOf("2023-01-18 10:17:28"));
		t.setTimeDeparture(Timestamp.valueOf("2023-01-18 10:17:28"));
		System.out.println(tripDao.updateSeats(t, 400));
		
		

	}

}
