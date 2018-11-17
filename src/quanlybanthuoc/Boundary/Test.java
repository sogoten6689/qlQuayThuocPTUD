package quanlybanthuoc.Boundary;
import quanlybanthuoc.Entity.ChiTietHoaDon;
import quanlybanthuoc.Entity.HoaDon;
import quanlybanthuoc.Entity.KhachHang;
import quanlybanthuoc.Entity.Thuoc;
import quanlybanthuoc.Controller.DanhSachChiTietHD;
import quanlybanthuoc.Controller.DanhSachHoaDon;
import quanlybanthuoc.Controller.DanhSachKhachHang;
import quanlybanthuoc.Controller.DanhSachThuoc;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Test extends JFrame {
	public static String a="a";
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	
//Ham mainnnn
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Test frame = new Test(a,"1");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	
	public JTextField textTim;
	private long tongTien = 0;
	public JTable tableDanhSachhd;
	public JTable tableChiTietHoaDon2;
	
	JTable tablehoadon = new JTable();
	DefaultTableModel modelhoadon;
	DefaultTableModel model;
	private ArrayList<String[]> list1 = new ArrayList<String[]>();
	public JTable jDanhSachThuoc;
	DefaultTableModel modelHoaDon;
	DefaultTableModel modelThuoc;
	public JTable jHoaDon;
	DanhSachChiTietHD dsChiTiet = new DanhSachChiTietHD();
	private List<ChiTietHoaDon> ls = new ArrayList<ChiTietHoaDon>();
	DanhSachChiTietHD dsChiTiet2 = new DanhSachChiTietHD();
	private List<ChiTietHoaDon> ls2 = new ArrayList<ChiTietHoaDon>();
	DefaultTableModel modelChitTiet;
	Thuoc thu;
	DanhSachThuoc dsthuoc = new DanhSachThuoc();
	ArrayList<Thuoc> list = new ArrayList<>();
	DanhSachHoaDon dshoadoc = new DanhSachHoaDon();
	ArrayList<HoaDon> listHoaDon = new ArrayList<>();
	DanhSachKhachHang dsKH = new DanhSachKhachHang();
	ArrayList<KhachHang> listKh = new ArrayList<>();
	
	
	private JTextField textKH;
	private JTextField textSDT;
	private JTextField textTongTien;
	private JTextField textNgayLap;
	private JTextField textmaHoaDon;

	
	public Test(String manv,String macv) {

		setIconImage(Toolkit.getDefaultToolkit().getImage("bin\\png\\heart.png"));
		setTitle("Nhân Viên Bán Thuốc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80,60,1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NhanVien = new JPanel();
		NhanVien.setBackground(SystemColor.desktop);
		NhanVien.setBounds(0, 0, 1000, 83);
		contentPane.add(NhanVien);
		NhanVien.setLayout(null);
		
		JLabel lblNhnVinBn = new JLabel("Nhân Viên Bán Thuốc");
		lblNhnVinBn.setBounds(419, 21, 375, 54);
		NhanVien.add(lblNhnVinBn);
		lblNhnVinBn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		
		JLabel label = new JLabel("");
		label.setBounds(345, 21, 64, 64);
		NhanVien.add(label);
		label.setIcon(new ImageIcon("bin\\png\\001-sale.png"));
		
		JLabel lblThuov = new JLabel("");
		lblThuov.setIcon(new ImageIcon("bin\\png\\hospital.png"));
		lblThuov.setBounds(258, 20, 69, 70);
		NhanVien.add(lblThuov);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(97, 83, 887, 478);
		contentPane.add(layeredPane);

	
		JPanel laphd = new JPanel();
		laphd.setBounds(0, 0, 888, 478);
		layeredPane.add(laphd);
		laphd.setLayout(null);
// Danh sach thuoc
		JScrollPane dsThuoc = new JScrollPane();
		dsThuoc.setBounds(26, 101, 328, 331);
		laphd.add(dsThuoc);

		JTable jDanhSachThuoc = new JTable();
		String[] tab = {"Mã thuốc", "Tên thuốc", "Đơn giá","Công dụng","SL Tồn" };
		modelThuoc = new DefaultTableModel(null, tab);
		list = dsthuoc.docTuBang();
		for (Thuoc i : list) {
			String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getCongdung() + "", i.getSoluongton() + "" };
	
			modelThuoc.addRow(rowdata);	
		}
		jDanhSachThuoc.setModel(modelThuoc);
	
		dsThuoc.setViewportView(jDanhSachThuoc);

		

//-- Them thuoc vao hoa don nhe !
		
		
		JButton btnThem = new JButton("");
		btnThem.setBounds(375, 147, 49, 41);
		btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent k) {
					
					Object e = k.getSource();
					int test = 1;
					int select = -1;
					select = jDanhSachThuoc.getSelectedRow();
					if (e.equals(btnThem) && !jDanhSachThuoc.isRowSelected(select)) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm trước khi thêm vào hóa đơn");
					}
					else {
					if(Integer.parseInt((String) jDanhSachThuoc.getValueAt(select, 4))==0)
						JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm khác vì sản phẩm này đã hết!");
					else {
					if (e.equals(btnThem)&& jDanhSachThuoc.isRowSelected(select)/**/) {
					
						String a;
						int maThuoc = 0;
						int sltonkho = 0;
						float dongiaaa = 0;
						int count = 1;
						try {
							do {
								a =  JOptionPane.showInputDialog(null, "Nhập số lượng cần mua");
							
								if (a.matches("\\d+")) {
									count = Integer.valueOf(a);
									maThuoc = Integer.parseInt((String) jDanhSachThuoc.getValueAt(select, 0));
									sltonkho =Integer.parseInt((String) jDanhSachThuoc.getValueAt(select, 4));
									dongiaaa = Float.parseFloat((String) jDanhSachThuoc.getValueAt(select, 2));
								} else {
									JOptionPane.showMessageDialog(null, "Nhập sai hoặc số lượng mua lớn hơn số lương còn lại!");
								}
							} while (!a.matches("\\d+")||count>sltonkho||count==0);
							
						} catch (NullPointerException e1) {
							JOptionPane.showMessageDialog(null, "Lỗi");
						}
						if (maThuoc != 0) {						
							String TenThuoc = (String) jDanhSachThuoc.getValueAt(select, 1);
							for (ChiTietHoaDon s : ls) {
								if (maThuoc == s.getThuoc()) {
									s.setSoluong(count);
									test = 2;
									tongTien=0;
									for (String[] a1 : list1) {
										if (String.valueOf(maThuoc).equals(a1[1])) {
											
											a1[4]= s.getSoluong()+"";
											a1[6]=s.getSoluong()*dongiaaa+"";
										}
										tongTien += Float.parseFloat(a1[6]) ;
									}
								}
							}
							if (test == 1) {
								ChiTietHoaDon ct = new ChiTietHoaDon(ls.size()+1,1,maThuoc, count,dongiaaa);
								ls.add(ct);
								String[] schon = {ls.size()+"", maThuoc+"", TenThuoc,sltonkho+"" ,String.valueOf(count), dongiaaa+"",dongiaaa*count+"" };
								list1.add(schon);
								tongTien += count * dongiaaa ;
							}
							for (@SuppressWarnings("unused") ChiTietHoaDon s : ls) {
								if (modelHoaDon.getRowCount() != 0)
									for (int i = modelHoaDon.getRowCount() - 1; i >= 0; i--)
										modelHoaDon.removeRow(i);
								for (String[] a1 : list1)
									modelHoaDon.addRow(a1);
								jHoaDon.setModel(modelHoaDon);
							}

							textTongTien.setText(String.valueOf(tongTien));
							jDanhSachThuoc.clearSelection();
							

						}
						
					}
					}
					}
				}

				
			});
		
		btnThem.setIcon(new ImageIcon("bin\\png\\002-next.png"));
		laphd.add(btnThem);
		
// == Xoa Thuoc Khoi hoa don		
		
		
		JButton btnXoa = new JButton("");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				Object e = k.getSource();
				if (e.equals(btnXoa)) {
					int i = jHoaDon.getSelectedRow();
						if (jHoaDon.isRowSelected(i)) {
							tongTien=0;
							if(ls.size()==1) {
								if (modelHoaDon.getRowCount() != 0) 
									for (int j = modelHoaDon.getRowCount() - 1; j >= 0; j--)
										modelHoaDon.removeRow(j);
								ls.remove(i);
								list1.remove(i);
							}
							else {
								modelHoaDon.removeRow(i);
								ls.remove(i);
								list1.remove(i);
								int stt =1;
								for (String[] a1 : list1)
								{
									a1[0]=String.valueOf(stt);
									stt++;
									tongTien+=Float.parseFloat(a1[6]);
								}
								if (modelHoaDon.getRowCount() != 0)
									for (int j = modelHoaDon.getRowCount() - 1; j >= 0; j--)
										modelHoaDon.removeRow(j);
								for (String[] a1 : list1)
									modelHoaDon.addRow(a1);
								jHoaDon.setModel(modelHoaDon);										
							
		
							}
							textTongTien.setText(String.valueOf(tongTien));
						} else {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xóa");
						}
				}
			}
		});
		btnXoa.setBounds(375, 234, 49, 34);
		btnXoa.setIcon(new ImageIcon("bin\\\\png\\003-back.png"));

		laphd.add(btnXoa);

// Tao, luu hoa don va tao chi tiet hoa don
		
		
		JButton saveButton = new JButton("");
		saveButton.setBounds(375, 328, 49, 34);
		saveButton.setIcon(new ImageIcon("bin\\png\\001-technology.png"));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent k) {
	//			saveBill();
				Object e = k.getSource();
				
				if (e.equals(saveButton)) {
							if (ls.size() == 0) {
						JOptionPane.showMessageDialog(null,"Vui lòng thêm thuốc cần mua vào hóa đơn ! ","Giỏ Hàng Rỗng",JOptionPane.INFORMATION_MESSAGE);
						//System.out.println(textSDT.getDocument().getLength());
							} 
				else {
					if(((!textKH.getText().equals(""))&&(!textSDT.getText().matches("\\d+")||
							(textSDT.getDocument().getLength()!=10&&textSDT.getDocument().getLength()!=11)))||
							(!textSDT.getText().equals("")&&textKH.getText().equals(""))
							){
						JOptionPane.showMessageDialog(null,"Nhập thông tin khách hàng lỗi ! ","Khách hàng",JOptionPane.INFORMATION_MESSAGE);
	} else {
					
						int maHD=listHoaDon.size()+1;
						maHD= listHoaDon.size();
						int maKH = 1;
						if(textKH.getText().equals("")) {
							 maKH = 1;
						}
						else {
							listKh = dsKH.docTuBang();
							maKH =listKh.size()+1;
							//System.out.println(maKH);
							dsKH.Create(maKH, textKH.getText(), textSDT.getText());
							listKh= dsKH.docTuBang();
						  }
						Date ngay = new Date();
						//System.out.printf(" %tB-%<te-%<tY", date);
						 Instant instant = Instant.ofEpochMilli(ngay.getTime());
							
						LocalDateTime dayy = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
				
						float sum = Float.valueOf((String)textTongTien.getText());
						listHoaDon=dshoadoc.docTuBang();
					//	System.out.println(listHoaDon.size());
						maHD=listHoaDon.size()+1;
						dshoadoc.Create(maHD, manv, maKH, sum, dayy);
						listHoaDon = dshoadoc.docTuBang();
						for (ChiTietHoaDon ct : ls) { 							
							dsChiTiet.CreateChiTietHoaDon(ct.maChiTietHoaDon+maHD*100000, maHD, ct.thuoc, ct.soluong,ct.dongia);
							dsthuoc.Update2(ct.thuoc,ct.soluong );
							
						}
						if (modelHoaDon.getRowCount() != 0)
							for (int j = modelHoaDon.getRowCount() - 1; j >= 0; j--)
								modelHoaDon.removeRow(j);
							ls.clear();
							list1.clear();
						
						
						tongTien=0;
						textTongTien.setText(String.valueOf(tongTien));
						if (modelThuoc.getRowCount() != 0)
							for (int j = modelThuoc.getRowCount() - 1; j >= 0; j--)
								modelThuoc.removeRow(j);
						list = dsthuoc.docTuBang();
						for (Thuoc i : list) {
							String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getCongdung() + "", i.getSoluongton() + "" };
							modelThuoc.addRow(rowdata);	
						}
						jDanhSachThuoc.setModel(modelThuoc);
						dsThuoc.setViewportView(jDanhSachThuoc);
						listHoaDon = dshoadoc.docTuBang();
						for (HoaDon i : listHoaDon) {
							String[] rowhoadon = { i.mahd + "", i.getManv()+ "", i.getMakh() + "", i.getNgayLap().getDayOfMonth() + "/"+i.getNgayLap().getMonthValue()+"/"+ i.getNgayLap().getYear() + "", i.getTongTien() + "" };
							
							modelhoadon.addRow(rowhoadon);	
						}
						tablehoadon.setModel(modelhoadon);
						JOptionPane.showMessageDialog(null, "Tạo thành công");
						textSDT.setText("");
						textKH.setText("");
	}
					}
				}
			}
		});
		laphd.add(saveButton);

		JScrollPane HoaDon = new JScrollPane();
		HoaDon.setBounds(434, 69, 444, 363);
		laphd.add(HoaDon);

		jHoaDon = new JTable();
		jHoaDon.setSurrendersFocusOnKeystroke(true);
		jHoaDon.setModel(modelHoaDon = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"STT",	"Mã thuốc", "Tên thuốc", "SL tồn","SL mua", "Đơn Giá","Thành tiền"
				}
		));
		

		jDanhSachThuoc.setModel(modelThuoc);
		HoaDon.setViewportView(jHoaDon);
		JLabel lblHoaDon = new JLabel("Hóa Đơn");
		lblHoaDon.setBounds(294, 11, 118, 23);
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		laphd.add(lblHoaDon);
		
//=== Tim thuoc theo tenn	
		
		
		JButton btnTm = new JButton("Tìm");
		btnTm.setBounds(208, 51, 59, 23);
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//modelThuoc.removeRow(ALLBITS);
				if(textTim.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Hãy Nhập Tên Thuốc nhé","Tìm Thuốc",JOptionPane.INFORMATION_MESSAGE);
					for (int i = modelThuoc.getRowCount() - 1; i >= 0; i--)
						modelThuoc.removeRow(i);
					list.clear();
					list = dsthuoc.docTuBang();
					for (Thuoc i : list) {
						String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getCongdung() + "", i.getSoluongton() + "" };
						modelThuoc.addRow(rowdata);	
					}
					jDanhSachThuoc.setModel(modelThuoc);
					
					
				}
				else {
					for (int i = modelThuoc.getRowCount() - 1; i >= 0; i--)
						modelThuoc.removeRow(i);
					String teen = textTim.getText();
					
					list = dsthuoc.TimThuoc(teen);
					for (Thuoc i : list) {
						String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getCongdung() + "", i.getSoluongton() + "" };
						modelThuoc.addRow(rowdata);	
					}
					jDanhSachThuoc.setModel(modelThuoc);
					if(list.size()==0) {
						JOptionPane.showMessageDialog(null,
								"Tìm không thấy","Tìm Thuốc",JOptionPane.INFORMATION_MESSAGE);
						list = dsthuoc.docTuBang();
						for (Thuoc i : list) {
							String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getCongdung() + "", i.getSoluongton() + "" };
							modelThuoc.addRow(rowdata);	
						}
					}
					textTim.setText("");
					
				}
				
			}
		});
		
		
		textTim = new JTextField();
		textTim.setBounds(45, 50, 152, 25);
		laphd.add(textTim);
		textTim.setColumns(10);
		laphd.add(btnTm);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng : ");
		lblTnKhchHng.setBounds(422, 10, 88, 24);
		laphd.add(lblTnKhchHng);
		
		JLabel lblStKhch = new JLabel("Số ĐT Khách :");
		lblStKhch.setBounds(422, 34, 88, 24);
		laphd.add(lblStKhch);
		
		textKH = new JTextField();
		textKH.setBounds(522, 10, 144, 20);
		laphd.add(textKH);
		textKH.setColumns(10);
		
		textSDT = new JTextField();
		textSDT.setBounds(520, 36, 144, 20);
		textSDT.setColumns(10);
		laphd.add(textSDT);
		
		JLabel lblTngTin = new JLabel("Tổng Tiền : ");
		lblTngTin.setBounds(535, 443, 88, 24);
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 14));
		laphd.add(lblTngTin);
		
		textTongTien = new JTextField();
		textTongTien.setBounds(633, 443, 194, 24);
		textTongTien.setEditable(false);
		textTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		laphd.add(textTongTien);
		textTongTien.setColumns(10);
		
		textNgayLap = new JTextField();
		textNgayLap.setBounds(745, 36, 75, 20);
		textNgayLap.setColumns(10);
		laphd.add(textNgayLap);
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		textNgayLap.setText(ft.format(date));
		
		JLabel lblNgyLp = new JLabel("Ngày lập :   ");
		lblNgyLp.setBounds(674, 34, 66, 24);
		laphd.add(lblNgyLp);
		
		
		JPanel panelXem = new JPanel();
		panelXem.setBounds(0, 0, 888, 478);
		layeredPane.add(panelXem);
		panelXem.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Danh Sách  Hóa Đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(278, 11, 240, 34);
		panelXem.add(lblNewLabel_1);
			
		JScrollPane spHoaDon = new JScrollPane();
		spHoaDon.setVisible(false);
		spHoaDon.setBounds(10, 75, 359, 377);
		panelXem.add(spHoaDon);

	
		
		tablehoadon.setModel(modelhoadon = new DefaultTableModel(
			new Object[][] {		},
			new String[] {
				"Mã HD", "Mã NV", "Mã KH","Ngày","Tổng Tiền"
			}
		));
		spHoaDon.setViewportView(tablehoadon);
		
		listHoaDon = dshoadoc.docTuBang();
		for (HoaDon i : listHoaDon) {
			String[] rowhoadon = { i.mahd + "", i.getManv()+ "", i.getMakh() + "", i.getNgayLap().getDayOfMonth() + "/"+i.getNgayLap().getMonthValue()+"/"+ i.getNgayLap().getYear() + "", i.getTongTien() + "" };
			
			modelhoadon.addRow(rowhoadon);	
		}
		tablehoadon.setModel(modelhoadon);
		
// Xem chi tiet trong hoa don cu
		
		
		JButton buttonXemChiTiet = new JButton("");
		buttonXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k ) {
				
				Object e = k.getSource();
				int select = -1;
				int maHD;
				select = tablehoadon.getSelectedRow();
				if (e.equals(buttonXemChiTiet) && !tablehoadon.isRowSelected(select)) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một hóa đơn cần xem !");
				}
				else {
					System.out.println("okkk");
					maHD = Integer.parseInt((String) tablehoadon.getValueAt(select, 0));
					ls2 = dsChiTiet.docTuBang();
					System.out.println(ls2.size());
					if (modelChitTiet.getRowCount() != 0)
						for (int j = modelChitTiet.getRowCount() - 1; j >= 0; j--)
							modelChitTiet.removeRow(j);
					for (ChiTietHoaDon i : ls2) {
						if(maHD==i.maHoaDon) {
						String [] rowChitiet = { i.maChiTietHoaDon + "", i.thuoc+ "",i.dongia+"",i.soluong+"",i.soluong*i.dongia+""};
						modelChitTiet.addRow(rowChitiet);
						i.toString();
						}
					}
					textmaHoaDon.setText(maHD+"");
					
					
					tableChiTietHoaDon2.setModel(modelChitTiet);
				}
				
			}
		});
		buttonXemChiTiet.setIcon(new ImageIcon("bin\\png\\002-next.png"));
		buttonXemChiTiet.setBounds(393, 208, 49, 41);
		panelXem.add(buttonXemChiTiet);
		buttonXemChiTiet.setVisible(false);

		
		JLabel lblDanhSachHoa = new JLabel("Danh sách hóa đơn");
		lblDanhSachHoa.setBounds(131, 50, 113, 14);
		panelXem.add(lblDanhSachHoa);
		
		
		JScrollPane jsChiTietHoaDon = new JScrollPane();
		jsChiTietHoaDon.setBounds(465, 75, 389, 392);
		panelXem.add(jsChiTietHoaDon);
		tableChiTietHoaDon2 = new JTable();
		
	
		tableChiTietHoaDon2.setModel(modelChitTiet = new DefaultTableModel(
			new Object[][] {		},
			new String[] {
				"Mã CT ", "Mã Thuốc", "Đơn Giá","Số Lượng ","Thành Tiền"
			}
		));
		jsChiTietHoaDon.setViewportView(tableChiTietHoaDon2);
		tableChiTietHoaDon2.setModel(modelChitTiet);

		JLabel lblHoaDon_1 = new JLabel("Hóa đơn");
		lblHoaDon_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHoaDon_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon_1.setBounds(603, 16, 105, 27);
		panelXem.add(lblHoaDon_1);
		
		textmaHoaDon = new JTextField();
		textmaHoaDon.setBounds(677, 47, 105, 20);
		panelXem.add(textmaHoaDon);
		textmaHoaDon.setColumns(10);
		textmaHoaDon.setVisible(false);
		
		JLabel lblSHan = new JLabel("Số Hóa Đơn :");
		lblSHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSHan.setBounds(552, 47, 105, 20);
		panelXem.add(lblSHan);
		
	
		JPanel congcu = new JPanel();
		congcu.setBackground(SystemColor.textHighlight);
		congcu.setBounds(0, 83, 96, 478);
		contentPane.add(congcu);
		congcu.setLayout(null);

		//-- Lap hoa don
		JButton btnTaohd = new JButton("");
		btnTaohd.setBounds(10, 32, 73, 65);
		congcu.add(btnTaohd);
		btnTaohd.setForeground(SystemColor.info);
		btnTaohd.setIcon(new ImageIcon("bin\\png\\medical-history.png"));
		btnTaohd.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				laphd.setVisible(true);
				textmaHoaDon.setVisible(false);
				panelXem.setVisible(false);
				textTim.setVisible(true);
				spHoaDon.setVisible(false);
			}
		});
// Giao Dien xem lai danh sach hoa don
		JButton btnXem = new JButton("");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTim.setVisible(false);
				laphd.setVisible(false);
				panelXem.setVisible(true);	
				textmaHoaDon.setVisible(true);
			//	button_6.setVisible(true);
				buttonXemChiTiet.setVisible(true);
				//	button_7.setVisible(true);
				spHoaDon.setVisible(true);
			}
			
		});
		btnXem.setBounds(10, 146, 73, 65);
		congcu.add(btnXem);
		btnXem.setIcon(new ImageIcon("bin\\png\\004-paper.png"));
// Xem tai khoan cua minh 
		JButton buttonTaiKhoan = new JButton("");
		buttonTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDienTaiKhoan(manv,macv).setVisible(true);;
				dispose();
				
				
			}
		});
		buttonTaiKhoan.setBounds(10, 252, 73, 65);
		congcu.add(buttonTaiKhoan);
		buttonTaiKhoan.setIcon(new ImageIcon("bin\\png\\002-employee-1.png"));
// Xem Thoat khoi chuong trinh		
		JButton buttonDangXuat = new JButton("");
		buttonDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new GDienDangNhap().setVisible(true);
			}
		});
		buttonDangXuat.setBounds(10, 375, 73, 65);
		congcu.add(buttonDangXuat);
		buttonDangXuat.setIcon(new ImageIcon("bin\\png\\001-exit.png"));
	}
}

