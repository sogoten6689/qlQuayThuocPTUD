package quanlybanthuoc.Entity;

public class KhachHang {
	
	public int maKH;
	public String tenkh;
	public  String sdt;
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int maKH, String tenkh, String sdt) {
		super();
		this.maKH = maKH;
		this.tenkh = tenkh;
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenkh=" + tenkh + ", sdt=" + sdt + "]";
	}
	

}
