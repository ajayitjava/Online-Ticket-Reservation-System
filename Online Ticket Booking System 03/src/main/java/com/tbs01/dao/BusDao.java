package com.tbs01.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tbs01.pojo.Amount;
import com.tbs01.pojo.Bus;
import com.tbs01.util.DBConnect;

public class BusDao {
	
	Connection con = DBConnect.getConnection();
	
	
	public boolean addBus(Bus inc) {

		String sql = "insert into bus(bus_number,source,destination,distance,fare) values (?,?,?,?,?)";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, inc.getBus_number());
			ps.setString(2, inc.getSource());
			ps.setString(3, inc.getDestination());
			ps.setInt(4, inc.getDistance());
			ps.setDouble(5, inc.getFare());
			
			

			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
	
	
	public List<Bus> getBusList() {
	//public List<Bus> getBusList(int uid) {  //(int uid) create for show only user id in list
		//String sql = "select * from bus where id";// user_id not available
		String sql = "select * from bus";
		List<Bus> inclist = new ArrayList<Bus>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setInt(1, uid);   
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Bus inc = new Bus();

				inc.setId(rs.getInt("id"));
				inc.setBus_number(rs.getString("bus_number"));
				inc.setSource(rs.getString("source"));
				inc.setDestination(rs.getString("destination"));
				inc.setDistance(rs.getInt("distance"));
				inc.setFare(rs.getDouble("fare"));
				
				inclist.add(inc);
				
			}
			return inclist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public boolean updateBus(Bus bus) {

		String sql = "update bus set bus_number=?,source=?,destinaion=?,distance=?,fare=? where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bus.getBus_number());
			ps.setString(2, bus.getSource());
			ps.setString(3, bus.getDestination());
			ps.setInt(4, bus.getDistance());
			ps.setDouble(5, bus.getFare());
			
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean deleteBus(int id) {

		String sql = "delete from bus where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public Bus getBus(int id) {
		String sql = "select * from bus where id=?";
		Bus inc = new Bus();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				inc.setId(rs.getInt("id"));
				inc.setBus_number(rs.getString("bus_number"));
				inc.setSource(rs.getString("source"));
				inc.setDestination(rs.getString("destination"));
				inc.setDistance(rs.getInt("distance"));
				inc.setFare(rs.getDouble("fare"));
					
				return inc;

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	//public List<Bus> getBusListByDescription(int uid,String description) {
	public List<Bus> getBusListByDescription(int uid,String description) {
		String sql = "select * from bus where id=? and source like '%"+description+"%'";
		List<Bus> inclist = new ArrayList<Bus>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			//ps.setString(2, "'%"+descreption+"%'");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bus inc = new Bus();
				
				inc.setId(rs.getInt("id"));
				inc.setBus_number(rs.getString("bus_number"));
				inc.setSource(rs.getString("source"));
				inc.setDestination(rs.getString("destination"));
				inc.setDistance(rs.getInt("distance"));
				inc.setFare(rs.getDouble("fare"));
				
				inclist.add(inc);

			}
			return inclist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	
	public List<Bus> getBusListByType(int uid,String source) {
		String sql = "select * from bus where id=? and source=?";
		List<Bus> inclist = new ArrayList<Bus>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, source);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bus inc = new Bus();
				
				inc.setId(rs.getInt("id"));
				inc.setBus_number(rs.getString("bus_number"));
				inc.setSource(rs.getString("source"));
				inc.setDestination(rs.getString("destination"));
				inc.setDistance(rs.getInt("distance"));
				inc.setFare(rs.getDouble("fare"));
				
				
				inclist.add(inc);

			}
			return inclist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
/*	public List<Bus> getBusList() {
		String sql = "select * from user";

		List<Bus> ul = new ArrayList<Bus>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Bus b = new Bus();
				
				b.setId(rs.getInt("id"));
				b.setBus_number(rs.getString("bus_number"));
				b.setSource(rs.getString("source"));
				b.setDestination(rs.getString("destination"));
				b.setDistance(rs.getInt("distance"));
				b.setFare(rs.getDouble("fare"));
				
				ul.add(b);

			}
			return ul;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}  */
		
}
