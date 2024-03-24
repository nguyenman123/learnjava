package cm10.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm10.config.MySQLConnection;
import cm10.model.User;

public class UserRepository {
	public List<User> getUserByUsernameAndPassword(String username, String password) {

		List<User> list = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String query = "select * from user where username = ? and password = ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			//thuc thi lenh querry
			//Luu ket qua querry vao bien ResultSet
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setFullname(resultSet.getString("fullname"));
				//user.setAge(resultSet.getInt("age"));
				user.setUsername(resultSet.getString("username"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;

	}
}
