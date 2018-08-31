package hpe.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hpe.po.User;

public class UserOptionImpl_jdbc implements IUserOption_jdbc {

	@Override
	public List<User> queryAll() throws Exception {

		InputStream fInputStream = ClassLoader.getSystemResourceAsStream("db.properties");
		Properties properties = new Properties();
		properties.load(fInputStream);
		// jdbc�Ĵ����
		String driver = properties.getProperty("jdbc.driver");
		String url =  properties.getProperty("jdbc.url");
		String username =  properties.getProperty("jdbc.username");
		String pwd =  properties.getProperty("jdbc.pwd");

		// ��������
		Class.forName(driver);
		
		// ��ȡ����
		Connection connection = DriverManager.getConnection(url, username, pwd);
		
		// ����statmentִ�ж���
		String sql = "select * from user";
		PreparedStatement pStatment = connection.prepareStatement(sql);

		// ִ��sql
		ResultSet resultSet = pStatment.executeQuery();
		
		// TODO:���������
		List<User> ary = new ArrayList();
		
		while (resultSet.next()) {
			
			User user = new User();
			
			user.setId(resultSet.getInt(1));
			user.setAddress(resultSet.getString("address"));
			
			ary.add(user);
		}
		
		// �ͷ���Դ
		resultSet.close();
		pStatment.close();
		connection.close();
		
		return ary;
	}

}