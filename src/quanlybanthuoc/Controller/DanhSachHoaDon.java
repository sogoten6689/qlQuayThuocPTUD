package quanlybanthuoc.Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import quanlybanthuoc.Database.Database;
import quanlybanthuoc.Entity.HoaDon;

public class DanhSachHoaDon {
	
		ArrayList<HoaDon> dsHoaDon;
		HoaDon t;
		
		
		public DanhSachHoaDon() {
			dsHoaDon = new ArrayList<HoaDon>();
			t = new HoaDon();
		}

		// đọc dữ liệu từ bảng rồi cập nhật dữ liệu lên bảng
		public ArrayList<HoaDon> docTuBang() {
			ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
			try {
				Connection con = Database.getConnection();

//				if (con == null)
//					System.out.println("Connect is NULL");
//				else
//					System.out.println("Connect is NULL");

				String sql = "Select * from HoaDon";
				Statement statement = con.createStatement();

				// excutequery trả về dữ liệu của bảng trong sql
				ResultSet rs = statement.executeQuery(sql);

//				if (rs != null) {
//					System.out.println("RS NOll NULL");
//				} else {
//					System.out.println("TS  NULL");
//				}

				while (rs.next()) {
					// con trỏ bản ghi tiếp
					int maHD = rs.getInt(1);
					String maNV = rs.getString(2);
					int maKH = rs.getInt(3);
					float TongTien = rs.getFloat(4);
					Date ngay = rs.getDate(5);
			
					Instant instant = Instant.ofEpochMilli(ngay.getTime());
					
					LocalDateTime day = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
									
					HoaDon s = new HoaDon(maHD,maNV,maKH,TongTien,day);
					
					//System.err.println(s.getNgayLap().getDayOfMonth() + "/"+s.getNgayLap().getMonthValue()+"/"+ s.getNgayLap().getYear() + "");
					dsHoaDon.add(s);
				}
				// con.close();
				return dsHoaDon;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		// thêm dữ liệu mới vào bảng
		public boolean Create(int mahd, String manv, int makh, float tongTien, LocalDateTime ngayLap) {
		//	mahd=dsHoaDon.size()+1;
			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("Insert into HoaDon values (?,?,?,?,?)");
				stmt.setInt(1, mahd);
				stmt.setString(2, manv);
				stmt.setInt(3,makh );
				stmt.setFloat(4, tongTien);
				Date dat = new Date(System.currentTimeMillis());		
				stmt.setDate(5,dat);
				
				n = stmt.executeUpdate();
				
				
			} catch (SQLException e) {
				 e.printStackTrace();
			
			} finally {

			}

			return n > 0;
		}

		// xóa một dữ liệu khỏi bảng theo
		public boolean Delete(int mahd) {

			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("delete from HoaDon where MaHD=?");
				// lệnh dưới dùng để thêm giá trị vào dáu chấm hói tại vị trí bla
				// bla(từ vị trí 1 tới =n)
				stmt.setInt(1, mahd);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

			}
			return n > 0;
		}

		// cập nhật lại dữ liệu từ bảng
		public boolean Update(int mahd, String manv, int makh, float tongTien, LocalDateTime ngayLap) {
			mahd=dsHoaDon.size();
			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				
				stmt = con.prepareStatement("UPDATE Thuoc SET TenThuoc = ?, DonGia =?,SoLuongTon = ?,NgayNhap =?,CongDung = ?,TrangThai=? where MaThuoc=?");
				stmt.setInt(1, mahd);
				stmt.setString(2, manv);
				stmt.setInt(3,makh );
				stmt.setFloat(4, tongTien);
				Date ngay = Date.valueOf(ngayLap.toLocalDate());
				stmt.setDate(5, ngay);
				
				
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

			}
			return n > 0;
		}
	}


