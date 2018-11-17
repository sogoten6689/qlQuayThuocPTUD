package quanlybanthuoc.Entity;

public class ChiTietHoaDon {
	public int maChiTietHoaDon;
	public int maHoaDon;
	public int thuoc;
	public int soluong;
	public float dongia;
	public int getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(int maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getThuoc() {
		return thuoc;
	}
	public void setThuoc(int thuoc) {
		this.thuoc = thuoc;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(int maChiTietHoaDon, int maHoaDon, int thuoc, int soluong,float dongia) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maHoaDon = maHoaDon;
		this.thuoc = thuoc;
		this.soluong = soluong;
		this.dongia=dongia;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [maChiTietHoaDon=" + maChiTietHoaDon + ", maHoaDon=" + maHoaDon + ", thuoc=" + thuoc
				+ ", soluong=" + soluong +", dongia=" + dongia + "]";
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
		
}
