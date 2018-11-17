package quanlybanthuoc.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quanlybanthuoc.Database.Database;
import quanlybanthuoc.Entity.ChiTietHoaDon;
import quanlybanthuoc.Entity.Thuoc;

public class DanhSachChiTietHD {

	ArrayList<ChiTietHoaDon> dsChiTietHD;
	Thuoc t;

	public DanhSachChiTietHD() {
		dsChiTietHD = new ArrayList<ChiTietHoaDon>();
	//	ChiTietHoaDon s = new ChiTietHoaDon();
	}

	// đọc dữ liệu từ bảng rồi cập nhật dữ liệu lên bảng
	public ArrayList<ChiTietHoaDon> docTuBang() {
		ArrayList<ChiTietHoaDon> dsChiTietHD = new ArrayList<ChiTietHoaDon>();
		try {
			Connection con = Database.getConnection();

			if (con == null)
				System.out.println("Connect is ok");
			else
				System.out.println("Connect is NULL");

			String sql = "Select * from ChiTietHD  ";
			Statement statement = con.createStatement();

			// excutequery trả về dữ liệu của bảng trong sql
			ResultSet rs = statement.executeQuery(sql);

			if (rs != null) {
				System.out.println("RS NOll NULL");
			} else {
				System.out.println("TS  NULL");
			}

			while (rs.next()) {
				// con trỏ bản ghi tiếp
				int maChiTietHoaDon = rs.getInt(1);
				int maHD = rs.getInt(2);
				int thuoc = rs.getInt(3);
				int soluong = rs.getInt(4);
				float dongia =rs.getFloat(5);
				ChiTietHoaDon s = new ChiTietHoaDon( maChiTietHoaDon, maHD, thuoc, soluong,dongia);
				dsChiTietHD.add(s);
			}
			return dsChiTietHD;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// thêm dữ liệu mới vào bảng
	public boolean CreateChiTietHoaDon(int maChiTietHoaDon, int maHoaDon, int thuoc, int soluong,float dongia) {
		
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into ChiTietHD values (?,?,?,?,?)");
			stmt.setInt(1, maChiTietHoaDon);
			stmt.setInt(2, maHoaDon);
			stmt.setInt(3, thuoc);
			stmt.setInt(4, soluong);
			stmt.setFloat(5, dongia);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e);
		} finally {

		}

		return n > 0;
	}



}
