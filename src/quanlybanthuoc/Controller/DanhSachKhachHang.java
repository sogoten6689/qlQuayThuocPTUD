package quanlybanthuoc.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import quanlybanthuoc.Database.Database;
import quanlybanthuoc.Entity.KhachHang;


public class DanhSachKhachHang {
	
		ArrayList<KhachHang> dskhach;
		KhachHang t;

		public DanhSachKhachHang() {
			dskhach = new ArrayList<KhachHang>();
			t = new KhachHang();
		}

		// đọc dữ liệu từ bảng rồi cập nhật dữ liệu lên bảng
		public ArrayList<KhachHang> docTuBang() {
			ArrayList<KhachHang> dskhach = new ArrayList<KhachHang>();
			try {
				Connection con = Database.getConnection();

//				if (con == null)
//					System.out.println("Connect is NULL");
//				else
//					System.out.println("Connect is NULL");

				String sql = "Select * from KhachHang";
				Statement statement = con.createStatement();

				// excutequery trả về dữ liệu của bảng trong sql
				ResultSet rs = statement.executeQuery(sql);
//
//				if (rs != null) {
//					System.out.println("RS NOll NULL");
//				} else {
//					System.out.println("TS  NULL");
//				}

				while (rs.next()) {
					// con trỏ bản ghi tiếp
					int ma = rs.getInt(1);
					String ten = rs.getString(2);
					String sdt = rs.getString(3);
					
	
					
					KhachHang s = new KhachHang(ma,ten,sdt);
					dskhach.add(s);
				}
				// con.close();
				return dskhach;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		// thêm dữ liệu mới vào bảng
		public boolean Create(int maKhachHang, String tenKhachHang, String sdt) {
		//	maKhachHang =dskhach.size();
			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("Insert into KhachHang values (?,?,?)");
				stmt.setInt(1, maKhachHang);
				stmt.setString(2, tenKhachHang);
			
				stmt.setString(3, sdt);
				
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println(e);
			} finally {

			}

			return n > 0;
		}

		// xóa một dữ liệu khỏi bảng theo mã sinh viên
		public boolean Delete(int maKhachHang) {

			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("delete from KhachHang where maKhachHang =?");
				// lệnh dưới dùng để thêm giá trị vào dáu chấm hói tại vị trí bla
				// bla(từ vị trí 1 tới =n)
				stmt.setInt(1, maKhachHang);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

			}
			return n > 0;
		}

		// cập nhật lại dữ liệu từ bảng
		public boolean Update(int maKhachHang, String tenKhachHang,	String sdt) {
			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				// stmt = con.prepareStatement("UPDATE KhachHang" + "SET tenLop = ?," +
				// "giaoVienCN =?" + "WHERE maLop=?");
				stmt = con.prepareStatement("UPDATE KhachHang SET TenKH=?, SDT =? where MaKH=?");
				stmt.setInt(3, maKhachHang);
				stmt.setString(1, tenKhachHang);
				
				stmt.setString(2, sdt);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

			}
			return n > 0;
		}
	}


