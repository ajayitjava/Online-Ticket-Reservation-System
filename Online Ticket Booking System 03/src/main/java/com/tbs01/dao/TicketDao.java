package com.tbs01.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tbs01.pojo.Bus;
import com.tbs01.pojo.Ticket;
import com.tbs01.util.DBConnect;

public class TicketDao {
	
	Connection con = DBConnect.getConnection();
	
	
	public boolean addTicket(Ticket tic) {

		String sql = "insert into ticket(bus_id,user_id,source,destination,fare,pay_amount) values (?,?,?,?,?,?)";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setInt(1, tic.getBusid());
			ps.setInt(2, tic.getUserid());
			ps.setString(3, tic.getSource());
			ps.setString(4, tic.getDestination());
			ps.setDouble(5, tic.getFare());
			ps.setDouble(6, tic.getPayamount());
			
			
			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
	
	public List<Ticket> getBookingList() {
		//public List<Bus> getBusList(int uid) {  //(int uid) create for show only user id in list
			//String sql = "select * from bus where id";// user_id not available
			String sql = "select * from ticket";
			List<Ticket> inclist = new ArrayList<Ticket>();
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				//ps.setInt(1, uid);   
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					Ticket inc = new Ticket();
					
					inc.setUserid(rs.getInt("user_id"));
					inc.setBusid(rs.getInt("bus_id"));
					inc.setFare(rs.getDouble("fare"));
					inc.setBookingdate(rs.getDate("booking_date").toString());
					
					inclist.add(inc);
					
				}
				return inclist;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;

		}

}
