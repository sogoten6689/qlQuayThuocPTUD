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

import javax.swing.JOptionPane;

import quanlybanthuoc.Database.Database;
import quanlybanthuoc.Entity.Thuoc;



public class DanhSachThuoc {
	ArrayList<Thuoc> list = new ArrayList<>();
		ArrayList<Thuoc> dsThuoc;
		Thuoc t;
		public DanhSachThuoc() {
			dsThuoc = new ArrayList<Thuoc>();
			t = new Thuoc();
		}
// một hai ba bốn
		// Ä‘á»�c dá»¯ liá»‡u tá»« báº£ng rá»“i cáº­p nháº­t dá»¯ liá»‡u lĂªn báº£ng
		public ArrayList<Thuoc> docTuBang() {
			ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
			try {
				Connection con = Database.getConnection();
				String sql = "Select * from Thuoc";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					// con trá»� báº£n ghi tiáº¿p
					int ma = rs.getInt(1);
					String ten = rs.getString(2);
					float dongia = rs.getFloat(3);
					int soluong = rs.getInt(4);
					Date ngay = rs.getDate(5);
					Instant instant = Instant.ofEpochMilli(ngay.getTime());
					LocalDateTime day = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
					String congdung = rs.getString(6);
					String trangthai =rs.getString(7);
					Thuoc s = new Thuoc(ma,ten,dongia,soluong,day,congdung,trangthai);
					dsThuoc.add(s);
				}
				 con.close();
				return dsThuoc;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		// thĂªm dá»¯ liá»‡u má»›i vĂ o báº£ng
		public boolean Create(int maThuoc, String tenThuoc, float dongia, int soluongton, LocalDateTime ngayNhap, String congdung,
				String trangThai) {
			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("Insert into Thuoc values (?,?,?,?,?,?,?)");
				stmt.setInt(1, maThuoc);
				stmt.setString(2, tenThuoc);
				stmt.setFloat(3, dongia);
				stmt.setInt(4, soluongton);
				Date ngay = new Date(System.currentTimeMillis());	
				stmt.setDate(5, ngay);
				stmt.setString(6, congdung);
				stmt.setString(7, trangThai);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println(e);
			} finally {

			}
			return n > 0;
		}

		// xĂ³a má»™t dá»¯ liá»‡u khá»�i báº£ng 
		public boolean Delete(int maThuoc) {

			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("delete from Thuoc where MaThuoc= ?");
				stmt.setInt(1, maThuoc);
				n = stmt.executeUpdate();
				//return n>0;
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "KhĂ´ng Thá»ƒ XĂ³a VĂ¬ thuá»‘c nĂ y náº±m trong hĂ³a Ä‘Æ¡n cÅ©!\n Báº¡n Chá»‰ cĂ³ thá»ƒ sá»­a thĂ´ng tin thuá»‘c !");
				return false;
			} finally {

			}
			return n > 0;
		}

		// cáº­p nháº­t láº¡i dá»¯ liá»‡u tá»« báº£ng
		public boolean Update(int maThuoc, String tenThuoc, float dongia, int soluongton, LocalDateTime ngayNhap, String congdung,
				String trangThai) {
			Connection con = Database.getConnection();
			
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("UPDATE Thuoc SET TenThuoc = ?, DonGia =?,SoLuongTon = ?,NgayNhap =?,CongDung = ?,TrangThai=? where MaThuoc=?");
				stmt.setInt(7, maThuoc);
				stmt.setString(1, tenThuoc);
				stmt.setFloat(2, dongia);
				stmt.setInt(3, soluongton);
				Date ngay = new Date(System.currentTimeMillis());
				stmt.setDate(4, ngay);
				stmt.setString(5, congdung);
				stmt.setString(6, trangThai);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

			}
			return n > 0;
		}
		
		public boolean Update2(int maThuoc,int soluong) {
			 list = docTuBang();
			Connection con = Database.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			int soluongton = 0;
			for(Thuoc thu : list)
				if(maThuoc==thu.maThuoc)
					soluongton = thu.soluongton-soluong;
				
			String trangThai ="Sá»‘ LÆ°á»£ng Ä�áº¡t";
			if(soluongton<10)
				trangThai="Sá»‘ LÆ°á»£ng KĂ©m";
			try {
				stmt = con.prepareStatement("UPDATE Thuoc SET SoLuongTon = ?,TrangThai=? where MaThuoc=?");
				stmt.setInt(3, maThuoc);
				stmt.setInt(1, soluongton);
				stmt.setString(2, trangThai);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {

			}
			return n > 0;
		}
				
		public ArrayList<Thuoc> TimThuoc(String tennn) {
			ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
			 //dsThuoc = null;
			dsThuoc.removeAll(dsThuoc);
			try {
				Connection con = Database.getConnection();

				
				String sql = "Select * from Thuoc where TenThuoc like '%"+tennn+"%' or TenThuoc like '"+tennn+"%' or TenThuoc like '%"+tennn+"'";
				Statement statement = con.createStatement();
				//System.out.println(sql);
				// excutequery tráº£ vá»� dá»¯ liá»‡u cá»§a báº£ng trong sql
				ResultSet rs = statement.executeQuery(sql);
			
		
				while (rs.next()) {
					// con trá»� báº£n ghi tiáº¿p
					int ma = rs.getInt(1);
					String ten = rs.getString(2);
					float dongia = rs.getFloat(3);
					int soluong = rs.getInt(4);
					Date ngay = rs.getDate(5);
					Instant instant = Instant.ofEpochMilli(ngay.getTime());
					LocalDateTime day = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
					String congdung = rs.getString(6);
					String trangthai =rs.getString(7);
					
					
					Thuoc s = new Thuoc(ma,ten,dongia,soluong,day,congdung,trangthai);
					dsThuoc.add(s);
					
				}
				// con.close();
				return dsThuoc;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		
		}
}

	


