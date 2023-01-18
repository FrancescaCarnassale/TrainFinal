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
import com.manager.TripManager;

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
		TripManager tm= new TripManager();
		Trip t=new Trip();
		t= tm.getTripDao().get(1);
		System.out.println(tm.updateSeats(t, 1));

	}

}
