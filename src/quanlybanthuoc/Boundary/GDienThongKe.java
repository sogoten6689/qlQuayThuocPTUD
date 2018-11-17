
package quanlybanthuoc.Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import quanlybanthuoc.Controller.DanhSachHoaDon;
import quanlybanthuoc.Controller.DanhSachKhachHang;
import quanlybanthuoc.Controller.DanhSachNhanVien;
import quanlybanthuoc.Controller.DanhSachThuoc;
import quanlybanthuoc.Entity.HoaDon;
import quanlybanthuoc.Entity.KhachHang;
import quanlybanthuoc.Entity.NhanVien;
import quanlybanthuoc.Entity.Thuoc;


public class GDienThongKe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablehoadon;
	DanhSachHoaDon dshoadon = new DanhSachHoaDon();
	ArrayList<HoaDon> listHoaDon = new ArrayList<>();
	DefaultTableModel modelhoadon;
	
	DanhSachNhanVien dsnhanvien = new DanhSachNhanVien();
	ArrayList<NhanVien> listNhanVien = new ArrayList<>();
	DefaultTableModel modelnhanvien;
	private JTable tablenhanvien;
	DanhSachThuoc dsthuoc = new DanhSachThuoc();
	ArrayList<Thuoc> list = new ArrayList<>();
	private JTable tablekhachhang;
	DanhSachKhachHang dskh = new DanhSachKhachHang();
	ArrayList<KhachHang> listKhachHang = new ArrayList<>();
//	private JTextField textTongTien;
	private JTable tableThuocHet;
	
	
	
//	DanhSachHoaDon dshoadon = new DanhSachHoaDon();
//	ArrayList<HoaDon> listHoaDon = new ArrayList<>();
//	DefaultTableModel modelhoadon;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GDienThongKe frame = new GDienThongKe("d","4");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the frame.
	 */
	public GDienThongKe(String manv,String macv) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("bin\\png\\heart.png"));
		setTitle("Nhân Viên Thống Kê");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80,60,1000, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NhanVien = new JPanel();
		NhanVien.setBackground(new Color(0, 250, 154));
		NhanVien.setBounds(0, 0, 984, 82);
		contentPane.add(NhanVien);
		NhanVien.setLayout(null);
		
		JLabel lblNhnVinBn = new JLabel("Nhân Viên Thống Kê");
		lblNhnVinBn.setForeground(new Color(0, 100, 0));
		lblNhnVinBn.setBounds(363, 12, 316, 54);
		NhanVien.add(lblNhnVinBn);
		lblNhnVinBn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		
		JLabel label = new JLabel("");
		label.setBounds(689, 11, 64, 64);
		NhanVien.add(label);
		label.setIcon(new ImageIcon("bin\\png\\007-growth.png"));
		
		JLabel lblThuov = new JLabel("");
		lblThuov.setIcon(new ImageIcon("bin\\png\\hospital.png"));
		lblThuov.setBounds(258, 11, 69, 70);
		NhanVien.add(lblThuov);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 155, 984, 406);
		contentPane.add(layeredPane);
		
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setBounds(0, 0, 984, 371);
		layeredPane.add(panelHoaDon);
		panelHoaDon.setLayout(null);
		
		
		JLabel lblHoaDon = new JLabel("Danh Sách Hóa Đơn");
		lblHoaDon.setBounds(401, 11, 187, 22);
		panelHoaDon.add(lblHoaDon);
		lblHoaDon.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane spHoaDon = new JScrollPane();
		spHoaDon.setBounds(75, 67, 843, 304);
		panelHoaDon.add(spHoaDon);
		
		tablehoadon = new JTable();
	
		tablehoadon.setModel(modelhoadon = new DefaultTableModel(
			new Object[][] {		},
			new String[] {
				"Mã Hóa đơn", "Mã Nhân Viên", "mã Khách Hàng","Ngày","Tổng Tiền"
			}
		));
		spHoaDon.setViewportView(tablehoadon);
		listHoaDon = dshoadon.docTuBang();
		for (HoaDon i : listHoaDon) {
			String[] rowhoadon = { i.mahd + "", i.getManv()+ "", i.getMakh() + "", i.getNgayLap().getDayOfMonth() + 
					"/"+i.getNgayLap().getMonthValue()+"/"+ i.getNgayLap().getYear() + "", i.getTongTien() + "" };
			//"Mã thuốc", "Tên thuốc", "Đơn giá","Công dụng","SL Tồn"
			modelhoadon.addRow(rowhoadon);	
		}
		tablehoadon.setModel(modelhoadon);
		
//		JComboBox comboBoxTu = new JComboBox();
//		comboBoxTu.setBounds(532, 36, 122, 20);
//		panelHoaDon.add(comboBoxTu);
//		//DefaultComboBoxModel< >
//		JComboBox comboBoxDen = new JComboBox();
//		comboBoxDen.setBounds(319, 36, 122, 20);
//		panelHoaDon.add(comboBoxDen);
		
//		JLabel lblT = new JLabel("Từ :");
//		lblT.setBounds(285, 39, 33, 14);
//		panelHoaDon.add(lblT);
//		
//		JLabel lbln = new JLabel("       -    Đến :");
//		lbln.setBounds(451, 42, 75, 14);
//		panelHoaDon.add(lbln);
		
		JPanel panelNhanVien = new JPanel();
		panelNhanVien.setBounds(0, 0, 984, 406);
		layeredPane.add(panelNhanVien);
		panelNhanVien.setLayout(null);
		
		JLabel lblDanhSchNhn = new JLabel("Danh Sách Nhân Viên");
		lblDanhSchNhn.setBounds(412, 0, 187, 22);
		panelNhanVien.add(lblDanhSchNhn);
		lblDanhSchNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchNhn.setFont(new Font("Tahoma", Font.ITALIC, 18));
		
		JScrollPane spNhanVien = new JScrollPane();
		spNhanVien.setBounds(0, 33, 984, 338);
		panelNhanVien.add(spNhanVien);
		
		tablenhanvien = new JTable();
		tablenhanvien.setBounds(0, 0, 982, 1);
		panelNhanVien.add(spNhanVien);
		
		tablenhanvien.setModel(modelnhanvien = new DefaultTableModel(
				new Object[][] {		},
				new String[] {
					"Mã Nhân Viên", "Tên Nhân Viên", "Sinh Nhật","Giới Tính","Email","Chức Vụ"
				}
			));
		spNhanVien.setViewportView(tablenhanvien);
		
			listNhanVien = dsnhanvien.docTuBang();
		
			String gioitinh="";
			String chucvu="";
			for (NhanVien i : listNhanVien) {
				if(i.isGioiTinh() != true)
					gioitinh = "Nữ";
				else
					gioitinh = "Nam";
				if(i.getMacv().equals("1"))
					chucvu = "Bán Thuốc";
				else 
					if(i.getMacv().equals("2"))
						chucvu = "Thuốc";
					else
						chucvu="Quản lý";
				String[] rownhanvien = { i.maNV + "", i.getTen()+ "", i.getNgaysinh().getDayOfMonth() + "/"+ i.getNgaysinh().getMonthValue()+"/"+ i.getNgaysinh().getYear() + "",  gioitinh, i.getEmail() + "",chucvu };
				//(String maNV, String ten, LocalDateTime ngaysinh, boolean gioiTinh, String email, String macv) 
				modelnhanvien.addRow(rownhanvien);	
			
			}
			tablenhanvien.setModel(modelnhanvien);
			
//			JLabel lblTngTinHa = new JLabel("Tổng Tiền Hóa Đơn :");
//			lblTngTinHa.setBounds(550, 373, 118, 22);
//			panelNhanVien.add(lblTngTinHa);
//			
//			textTongTien = new JTextField();
//			textTongTien.setBounds(675, 374, 153, 20);
//			panelNhanVien.add(textTongTien);
//			textTongTien.setColumns(10);
//			textTongTien.setEditable(false);
			
			JPanel panelThuoc = new JPanel();
			panelThuoc.setLayout(null);
			panelThuoc.setBounds(0, 0, 984, 406);
			layeredPane.add(panelThuoc);
			
			JLabel lblDanhSchThuc = new JLabel("Danh Sách Thuốc");
			lblDanhSchThuc.setHorizontalAlignment(SwingConstants.CENTER);
			lblDanhSchThuc.setFont(new Font("Tahoma", Font.ITALIC, 18));
			lblDanhSchThuc.setBounds(412, 0, 187, 22);
			panelThuoc.add(lblDanhSchThuc);
			
			JScrollPane dsThuoc = new JScrollPane();
			dsThuoc.setBounds(0, 33, 984, 338);
			panelThuoc.add(dsThuoc);
			JTable jDanhSachThuoc = new JTable();
			dsThuoc.setViewportView(jDanhSachThuoc);		
			String[] tab = {"Mã thuốc", "Tên thuốc", "Đơn giá","SL Tồn" ,"Ngày Nhập","Công dụng","Trạng thái"};
			DefaultTableModel modelThuoc = new DefaultTableModel(null, tab);
			list = dsthuoc.docTuBang();
			for (Thuoc i : list) {
				String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getSoluongton() + "",i.getNgayNhap().getDayOfMonth() + "/"+i.getNgayNhap().getMonthValue()+"/"+ i.getNgayNhap().getYear() + "", i.getCongdung() + "",i.getTrangThai() };
				
				modelThuoc.addRow(rowdata);	
				
			}
			jDanhSachThuoc.setModel(modelThuoc);
			dsThuoc.setViewportView(jDanhSachThuoc);
			
			JPanel panelKhachHang = new JPanel();
			panelKhachHang.setLayout(null);
			panelKhachHang.setBounds(0, 0, 984, 406);
			layeredPane.add(panelKhachHang);
			
			JLabel lblDanhSchKhch = new JLabel("Danh Sách Khách Hàng");
			lblDanhSchKhch.setHorizontalAlignment(SwingConstants.CENTER);
			lblDanhSchKhch.setFont(new Font("Tahoma", Font.ITALIC, 18));
			lblDanhSchKhch.setBounds(412, 0, 187, 22);
			panelKhachHang.add(lblDanhSchKhch);
			
			JScrollPane scrollPaneKhachHang = new JScrollPane();
			scrollPaneKhachHang.setBounds(75, 68, 842, 303);
			panelKhachHang.add(scrollPaneKhachHang);
		
			tablekhachhang = new JTable();
			
			String[] tabkhachhang = {"Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại" };
			DefaultTableModel modelKhachHang = new DefaultTableModel(null, tabkhachhang);
			listKhachHang = dskh.docTuBang();
			for (KhachHang i : listKhachHang) {
				String[] rowdata = { i.getMaKH() + "", i.getTenkh() + "", i.getSdt() + "" };
				
				modelKhachHang.addRow(rowdata);	
				
			}
			tablekhachhang.setModel(modelKhachHang);
			scrollPaneKhachHang.setViewportView(tablekhachhang);
			
			JPanel panelThuocHet = new JPanel();
			panelThuocHet.setLayout(null);
			panelThuocHet.setBounds(0, 0, 984, 406);
			layeredPane.add(panelThuocHet);
			
			JLabel lblDanhSchThuc_1 = new JLabel("Danh Sách Thuốc Hết");
			lblDanhSchThuc_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblDanhSchThuc_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
			lblDanhSchThuc_1.setBounds(412, 0, 187, 22);
			panelThuocHet.add(lblDanhSchThuc_1);
			
			JScrollPane scrollPaneThuocHet = new JScrollPane();
			scrollPaneThuocHet.setBounds(0, 33, 984, 338);
			panelThuocHet.add(scrollPaneThuocHet);
			
			tableThuocHet = new JTable();
			scrollPaneThuocHet.setViewportView(tableThuocHet);
			
			
			String[] tabThuocHet = {"Mã thuốc", "Tên thuốc", "Đơn giá","SL Tồn" ,"Ngày Nhập","Công dụng","Trạng thái"};
			DefaultTableModel modelThuocHet = new DefaultTableModel(null, tabThuocHet);
			list = dsthuoc.docTuBang();
			for (Thuoc i : list) {
				if(i.getSoluongton()<10) {
				String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getSoluongton() + "",i.getNgayNhap().getDayOfMonth() + "/"+i.getNgayNhap().getMonthValue()+"/"+ i.getNgayNhap().getYear() + "", i.getCongdung() + "",i.getTrangThai() };
				modelThuocHet.addRow(rowdata);	
				}
			}
			tableThuocHet.setModel(modelThuocHet);
			
			
		
		JPanel congcu = new JPanel();
		congcu.setBackground(SystemColor.textHighlight);
		congcu.setBounds(0, 78, 984, 75);
		contentPane.add(congcu);
		congcu.setLayout(null);
		
		JButton btnHoaDon = new JButton("");
		btnHoaDon.setBounds(224, 11, 73, 65);
		congcu.add(btnHoaDon);
		btnHoaDon.setForeground(SystemColor.info);
		btnHoaDon.setIcon(new ImageIcon("bin\\png\\004-business-1.png"));
		btnHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelHoaDon.setVisible(true);
				panelNhanVien.setVisible(false);
				panelKhachHang.setVisible(false);
				panelThuoc.setVisible(false);
				panelThuocHet.setVisible(false);
				
				
			}
		});
		
		JButton btnThuochet = new JButton("");
		btnThuochet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHoaDon.setVisible(false);
				panelNhanVien.setVisible(false);
				panelKhachHang.setVisible(false);
				panelThuoc.setVisible(false);
				panelThuocHet.setVisible(true);
			}
		});
		btnThuochet.setBounds(671, 11, 73, 65);
		congcu.add(btnThuochet);
		btnThuochet.setIcon(new ImageIcon("bin\\png\\003-business-2.png"));
		
		JButton btnNhanVien = new JButton("");
		btnNhanVien.setBounds(329, 11, 73, 65);
		congcu.add(btnNhanVien);
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHoaDon.setVisible(false);
				panelNhanVien.setVisible(true);
				panelKhachHang.setVisible(false);
				panelThuoc.setVisible(false);
				panelThuocHet.setVisible(false);
				
				
			}
		});
		btnNhanVien.setIcon(new ImageIcon("bin\\png\\001-business-4.png"));
		
		JButton btnNv = new JButton("");
		btnNv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDienTaiKhoan(manv,macv).setVisible(true);;
				dispose();
			}
		});
		btnNv.setBounds(90, 11, 73, 65);
		congcu.add(btnNv);
		btnNv.setIcon(new ImageIcon("bin\\png\\002-employee-1.png"));
		
		JButton btnThoat = new JButton("");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDienDangNhap().setVisible(true);
				dispose();
			}
		});
		btnThoat.setBounds(783, 11, 73, 65);
		congcu.add(btnThoat);
		btnThoat.setIcon(new ImageIcon("bin\\png\\001-exit.png"));
		
		JButton btThuoc = new JButton("");
		btThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHoaDon.setVisible(false);
				panelNhanVien.setVisible(false);
				panelThuoc.setVisible(true);
				
				panelKhachHang.setVisible(false);
			
				panelThuocHet.setVisible(false);
				
			}
		});
		btThuoc.setIcon(new ImageIcon("bin\\png\\006-analytics.png"));
		btThuoc.setBounds(441, 11, 73, 65);
		congcu.add(btThuoc);
		
		JButton btnKhachhang = new JButton("");
		btnKhachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHoaDon.setVisible(false);
				panelNhanVien.setVisible(false);
				panelThuoc.setVisible(false);
				panelKhachHang.setVisible(true);
				
				//panelHoaDon.setVisible(true);
				panelNhanVien.setVisible(false);
				//panelKhachHang.setVisible(false);
				panelThuoc.setVisible(false);
				panelThuocHet.setVisible(false);
				
				
			}
		});
		btnKhachhang.setIcon(new ImageIcon("bin\\png\\005-business.png"));
		btnKhachhang.setBounds(554, 11, 73, 65);
		congcu.add(btnKhachhang);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
