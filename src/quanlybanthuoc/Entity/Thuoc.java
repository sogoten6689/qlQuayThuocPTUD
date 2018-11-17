package quanlybanthuoc.Entity;

import java.time.LocalDateTime;

public class Thuoc {
	public int maThuoc;
	public String tenThuoc;
	public float dongia;
	public int soluongton;
	public LocalDateTime NgayNhap;
	public String Congdung;
	public String TrangThai;
	public int getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(int maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	public int getSoluongton() {
		return soluongton;
	}
	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}
	public LocalDateTime getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(LocalDateTime ngayNhap) {
		NgayNhap = ngayNhap;
	}
	public String getCongdung() {
		return Congdung;
	}
	public void setCongdung(String congdung) {
		Congdung = congdung;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public Thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Thuoc(int maThuoc, String tenThuoc, float dongia, int soluongton, LocalDateTime ngayNhap, String congdung,
			String trangThai) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.dongia = dongia;
		this.soluongton = soluongton;
		NgayNhap = ngayNhap;
		Congdung = congdung;
		TrangThai = trangThai;
	}
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", dongia=" + dongia + ", soluongton="
				+ soluongton + ", NgayNhap=" + NgayNhap + ", Congdung=" + Congdung + ", TrangThai=" + TrangThai + "]";
	}
	
	
}
