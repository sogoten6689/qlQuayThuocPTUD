package quanlybanthuoc.Entity;

import java.time.LocalDateTime;

public class NhanVien {
	public String maNV;
	public String ten;
	public LocalDateTime ngaysinh;
	public boolean GioiTinh;
	public String email;
	public String macv;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public LocalDateTime getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(LocalDateTime ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public boolean isGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMacv() {
		return macv;
	}
	public void setMacv(String macv) {
		this.macv = macv;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV, String ten, LocalDateTime ngaysinh, boolean gioiTinh, String email, String macv) {
		super();
		this.maNV = maNV;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		GioiTinh = gioiTinh;
		this.email = email;
		this.macv = macv;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", GioiTinh=" + GioiTinh
				+ ", email=" + email + ", macv=" + macv + "]";
	}
	
	
	

}
