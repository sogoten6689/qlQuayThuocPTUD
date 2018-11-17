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
import quanlybanthuoc.Entity.NhanVien;


public class DanhSachNhanVien {
	
		ArrayList<NhanVien> dsNhanVien;
		NhanVien nhan;
		
		public DanhSachNhanVien() {
			dsNhanVien = new ArrayList<NhanVien>();
			nhan = new NhanVien();
		}

		// Ä‘á»�c dá»¯ liá»‡u tá»« báº£ng rá»“i cáº­p nháº­t dá»¯ liá»‡u lĂªn báº£ng
		public ArrayList<NhanVien> docTuBang() {
			ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
			try {
				Connection con = Database.getConnection();

//				if (con == null)
//					System.out.println("Connect is NULL");
//				else
//					System.out.println("Connect is NULL");

				String sql = "Select * from NhanVien";
				Statement statement = con.createStatement();

				// excutequery tráº£ vá»� dá»¯ liá»‡u cá»§a báº£ng trong sql
				ResultSet rs = statement.executeQuery(sql);

//				if (rs != null) {
//					System.out.println("RS NOll NULL");
//				} else {
//					System.out.println("TS  NULL");
//				}

				while (rs.next()) {
					// con trá»� báº£n ghi tiáº¿p
					
					String manv = rs.getString(1);
					String tennv = rs.getString(2);
					Date ngay = rs.getDate(5);
					Instant instant = Instant.ofEpochMilli(ngay.getTime());
					LocalDateTime day = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
					int gt = rs.getInt(4);
					boolean gioitinh;
					if(gt==1)
						 gioitinh = true;
					else
						gioitinh = false;
					
					String email = rs.getString(3);
					String macv = rs.getString(6);
					
			
									
					NhanVien nv = new NhanVien(manv,tennv,day,gioitinh,email,macv);
			
					dsNhanVien.add(nv);
				
				}
				// con.close();
				return dsNhanVien;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		public boolean Update(String maNV, String ten,  boolean gioiTinh, String email) {
			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				
				stmt = con.prepareStatement("UPDATE NhanVien SET Ten = ?, Email =?,GioiTinh = ?, where MaThuoc= ? ");
				stmt.setString(2, email);
				stmt.setString(1, ten);
				
				//stmt.setString(3,ngay);
				int gt =0;
				if(gioiTinh)
				{
					gt=1;
				}
				stmt.setInt(3, gt);
				stmt.setString(4, maNV);
			
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

			}
			return n > 0;
		}

}

