package com.tbs01.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tbs01.pojo.Amount;
import com.tbs01.util.DBConnect;

public class AmountDao {
	
	Connection con = DBConnect.getConnection();
	
	public boolean addamount(Amount amt) {

		String sql = "insert into amount(amount,amount_type,description,user_id) values (?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, amt.getAmount());
			ps.setString(2, amt.getAmount_type());
			ps.setString(3, amt.getDescription());
			ps.setInt(4, amt.getUser_id());

			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public List<Amount> getAmountList(int uid) {
		String sql = "select * from amount where user_id=?";
		List<Amount> inclist = new ArrayList<Amount>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Amount inc = new Amount();
				inc.setId(rs.getInt("id"));
				inc.setAmount(rs.getDouble("amount"));
				inc.setDescription(rs.getString("description"));
				inc.setAmount_date(rs.getDate("amount_date").toString());
				inc.setAmount_type(rs.getString("amount_type"));
				inc.setUser_id(rs.getInt("user_id"));
				inclist.add(inc);
			}
			return inclist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	public boolean updateAmount(Amount amt) {

		String sql = "update amount set amount=?,amount_type=?,description=?,user_id=? where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, amt.getAmount());
			ps.setString(2, amt.getAmount_type());
			ps.setString(3, amt.getDescription());
			ps.setInt(4, amt.getUser_id());
			ps.setInt(5, amt.getId());
			
			

			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean deleteamount(int id) {

		String sql = "delete from amount where id=?";

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
	
	public Amount getAmount(int id) {
		String sql = "select * from amount where id=?";
		Amount inc = new Amount();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				inc.setId(rs.getInt("id"));
				inc.setAmount(rs.getDouble("amount"));
				inc.setDescription(rs.getString("description"));
				inc.setAmount_date(rs.getDate("amount_date").toString());
				inc.setAmount_type(rs.getString("amount_type"));
				inc.setUser_id(rs.getInt("user_id"));
				return inc;

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	public List<Amount> getAmountListByDescription(int uid,String description) {
		String sql = "select * from amount where user_id=? and description like '%"+description+"%'";
		List<Amount> inclist = new ArrayList<Amount>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			//ps.setString(2, "'%"+descreption+"%'");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Amount inc = new Amount();
				inc.setId(rs.getInt("id"));
				inc.setDescription(rs.getString("description"));
				
				
				inc.setAmount(rs.getDouble("amount"));
				inc.setAmount_date(rs.getDate("amount_date").toString());
				inc.setAmount_type(rs.getString("amount_type"));
				inc.setUser_id(rs.getInt("user_id"));
				
				
				inclist.add(inc);

			}
			return inclist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	public List<Amount> getAmountListByType(int uid,String type) {
		String sql = "select * from amount where user_id=? and amount_type=?";
		List<Amount> inclist = new ArrayList<Amount>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, type);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Amount inc = new Amount();
				inc.setId(rs.getInt("id"));
				inc.setDescription(rs.getString("description"));
				
				inc.setAmount(rs.getDouble("amount"));
				inc.setAmount_date(rs.getDate("amount_date").toString());
				inc.setAmount_type(rs.getString("amount_type"));
				
				inc.setUser_id(rs.getInt("user_id"));
				inclist.add(inc);

			}
			return inclist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	public double getBalance(int user_idd) {
		String sql1 ="select sum(amount) as totalAmount from amount where user_id="+user_idd;
		
		try {
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				double totalAmount = rs.getDouble("totalAmount");
				//return totalAmount;  // change 1
				
				String sql2 = "select sum(pay_amount) as totalExpence from ticket where user_id="+user_idd;
			PreparedStatement ps2 = con.prepareStatement(sql2);
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					double totalExpence = rs2.getDouble("totalExpence");
					
					return totalAmount - totalExpence;
					
				}
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
		
	}

}
