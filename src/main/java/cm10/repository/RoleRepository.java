package cm10.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm10.config.MySQLConnection;
import cm10.model.Role;
import cm10.model.User;

public class RoleRepository {

	public List<Role> getRole() {

		List<Role> list = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String query = "select * from role";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			// thuc thi lenh querry
			// Luu ket qua querry vao bien ResultSet
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getString("id"));
				role.setRolename(resultSet.getString("rolename"));
				role.setDescription("description");

				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

	public int deleteRoleById(int id) {
		Connection connection = MySQLConnection.getConnection();
		String query = "delete from roles r where r.id = ? ";
		int IsDelete = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			//set parameter cho query
			preparedStatement.setInt(1, id);
			
			//executeUpdate dung de xu ly add,update,delete
			IsDelete = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return IsDelete;
	}

}
