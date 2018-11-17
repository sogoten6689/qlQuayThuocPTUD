package quanlybanthuoc.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class Database {
	private static Connection conn=null;
	public static Connection getConnection() {
		// TODO Auto-generated constructor stub
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=PTUD_DHKTPM_29","sa","1");
			System.out.println("ket noi thanh cong");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ket noi that bai");
			JOptionPane.showMessageDialog(null,"ket noi that bai",null, JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	} 
	
}
