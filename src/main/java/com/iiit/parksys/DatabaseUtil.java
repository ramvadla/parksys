package com.iiit.parksys;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class DatabaseUtil {

	public static boolean insertSearchControl(Vehicle vehicle) {
		if (vehicle == null)
			return false;

		String sql = "insert into vehicle (vehicle_number, auth_type, type) value (?,?,?)";
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
