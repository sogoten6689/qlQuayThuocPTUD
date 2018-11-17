package quanlybanthuoc.Entity;

import java.time.LocalDateTime;

public class HoaDon {
	public int mahd;
	public String manv;
	public int makh;
	public float TongTien;
	public LocalDateTime NgayLap;
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	public LocalDateTime getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		NgayLap = ngayLap;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(int mahd, String manv, int makh, float tongTien, LocalDateTime ngayLap) {
		super();
		this.mahd = mahd;
		this.manv = manv;
		this.makh = makh;
		TongTien = tongTien;
		NgayLap = ngayLap;
	}
	@Override
	public String toString() {
		return "HoaDon [mahd=" + mahd + ", manv=" + manv + ", makh=" + makh + ", TongTien=" + TongTien + ", NgayLap="
				+ NgayLap + "]";
	}
	

}
