package com.webapp.parkinglot.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.entity.ParkingSpot;
import com.webapp.parkinglot.entity.Reservation;
import com.webapp.parkinglot.entity.ReserveParking;
import com.webapp.parkinglot.entity.User;

@Repository
public class ParkingDaoIMPL implements ParkingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Parking> getParkingList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Parking> theQuery = 
				currentSession.createQuery("from Parking order by spacesInTotal",
											Parking.class);
		
		List<Parking> parkings = theQuery.getResultList();
		
		return parkings;
	}

	@Override
	public List<Parking> showAvailableParkings() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Parking> theQuery = 
				currentSession.createQuery("from Parking where freeSpaces != 0 and city"
						+ " = (Select city from User where isLogged=1) "
						+ "order by freeSpaces ",
						Parking.class);
		
		return theQuery.getResultList();
	}

	@Override
	public void reserveParkingSpot(Parking theParking) {
		Session currentSession = sessionFactory.getCurrentSession();

		String adress = theParking.getAdress();
		
		Query<Parking> theQuery = currentSession.createQuery("from Parking where adress = :adress and city"
				+ " = (Select city from User where isLogged=1) "
				+ "order by freeSpaces ",
				Parking.class);
		theQuery.setParameter("adress", adress);
		Parking reservedParking = theQuery.getSingleResult();
		
		Query<ParkingSpot> query = currentSession.createQuery("from ParkingSpot where parking = :parking and isOccupied = 0 order by spaceSignature");
		query.setParameter("parking", reservedParking);
		ParkingSpot parkingSpot = query.setMaxResults(1).getSingleResult();
		Query<User> querie = currentSession.createQuery("from User where isLogged=1", User.class);
		User user = querie.getSingleResult();
		Reservation reservation = new Reservation();
		
		reservation.setParking(reservedParking);
		reservation.setParkingSpot(parkingSpot);
		reservation.setUser(user);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();
		reservation.setStartDate(dtf.format(now));
		reservation.setEndDate(null);
		currentSession.save(reservation);
		
		parkingSpot.setIsOccupied(1);
		reservedParking.setFreeSpaces(reservedParking.getFreeSpaces() - 1);
	}

	@Override
	public List<ReserveParking> getReservations() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Reservation> query = currentSession.createQuery("from Reservation where"
				+ " user = (Select id from User where isLogged=1)", Reservation.class);
		List<Reservation> reservations = query.getResultList();
		List<ReserveParking> reserved = new ArrayList<>();
		for (Reservation reservation : reservations) {
			ReserveParking reserve = new ReserveParking();
			reserve.setEndDate(reservation.getEndDate());
			reserve.setStartDate(reservation.getStartDate());
			Query<Parking> querie = currentSession.createQuery("from Parking"
					+ " where id = :id", Parking.class).setParameter("id", reservation.getParking().getId());
			reserve.setParkingAdress(querie.uniqueResult().getAdress());
			Query<ParkingSpot> queries = currentSession.createQuery("from ParkingSpot"
					+ " where id = :id", ParkingSpot.class).setParameter("id", reservation.getParkingSpot().getId());
			reserve.setSpaceSignature(queries.uniqueResult().getSpaceSignature());
			reserved.add(reserve);
		}
		return reserved;
	}

	@Override
	public void releaseSpace(String[] list) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query querie = currentSession.createQuery("update Parking set freeSpaces = freeSpaces+1 "
				+ " where adress = :adress and city ="
				+ " (Select city from User where isLogged=1)").setParameter("adress", list[0]);
		querie.executeUpdate();
		Query<Parking> query = currentSession.createQuery("from Parking where adress = :adress and city = "
											+ " (Select city from User where isLogged=1)", Parking.class).setParameter("adress", list[0]);
		Parking parking = query.getSingleResult();

		Query<ParkingSpot> queras = currentSession.createQuery("from ParkingSpot where parking = :parking and spaceSignature = :space", ParkingSpot.class).setParameter("parking", parking).setParameter("space", list[1]);
		ParkingSpot parkingSpot = queras.getSingleResult();
		Query<Reservation> quer = currentSession.createQuery("from Reservation where parking "
				+ "= :parking and parkingSpot = :parkingSpot and user ="
				+ " (Select id from User where isLogged=1)", Reservation.class).setParameter("parking", parking).setParameter("parkingSpot", parkingSpot);
		Reservation reservation = quer.getSingleResult();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();
	    
		reservation.setEndDate(dtf.format(now));
		parkingSpot.setIsOccupied(0);
		currentSession.save(reservation);
		currentSession.save(parkingSpot);
	}
	
}
