package quanlybanthuoc.Entity;

public class ChucVuNhanVien {
	public String maCV;
	public String ChucVu;
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	private ChucVuNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	private ChucVuNhanVien(String maCV, String chucVu) {
		super();
		this.maCV = maCV;
		ChucVu = chucVu;
	}
	@Override
	public String toString() {
		return "ChucVuNhanVien [maCV=" + maCV + ", ChucVu=" + ChucVu + "]";
	}
	

}
