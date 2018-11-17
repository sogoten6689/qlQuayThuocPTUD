package quanlybanthuoc.Entity;

public class TaiKhoanNhanVien {
	public String maNV;
	public String matkhau;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public TaiKhoanNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoanNhanVien(String maNV, String matkhau) {
		super();
		this.maNV = maNV;
		this.matkhau = matkhau;
	}
	@Override
	public String toString() {
		return "TaiKhoanNhanVien [maNV=" + maNV + ", matkhau=" + matkhau + "]";
	}
	

}
