package com.iiit.parksys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.iiit.parksys.service.ConnectionUtil;
import com.iiit.parksys.vo.Vehicle;

/**
 * It handles the database queries and updates
 * 
 * @author ramakrishna
 * 
 */
public class VehicleDAO {

	public static boolean createVehicle(Vehicle vehicle) {
		if (vehicle == null)
			return false;

		String sql = "insert into vehicle (vehicle_number, auth_type, type,in_time) value (?,?,?,?)";
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(sql);
			// `vehicle_number`,
			ps.setString(1, vehicle.getVehicleNumber());
			// `auth_type`,
			ps.setString(2, vehicle.getAuthType());
			// `type`,
			ps.setString(3, vehicle.getType());
			// `in_time`,
			ps.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public static List<Vehicle> getVehicles() {

		String sql = "select * from vehicle";
		Connection connection = null;
		Statement ps = null;
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.createStatement();
			ResultSet resultset = ps.executeQuery(sql);
			List<Vehicle> list = new ArrayList<Vehicle>();
			while (resultset.next()) {
				Vehicle v = new Vehicle();
				v.setId(resultset.getInt("id"));
				v.setVehicleNumber(resultset.getString("vehicle_number"));
				v.setInTime(new java.util.Date(resultset.getTimestamp("in_time").getTime()));
				v.setPaidAmount(resultset.getDouble("paid_amount"));
				v.setAuthType(resultset.getString("auth_type"));
				list.add(v);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static boolean updateVehicle(Vehicle vehicle) {
		if (vehicle == null)
			return false;

		String sql = "update vehicle set out_time=?, paid_amount=?, payment_type=? where id=?";
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(sql);
			// `out_time`,
			ps.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
			// `paid_amound`,
			ps.setDouble(2, vehicle.getPaidAmount());
			// `payment_type`,
			ps.setString(3, vehicle.getPaymentType());
			// `id`,
			ps.setInt(4, vehicle.getId());

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
