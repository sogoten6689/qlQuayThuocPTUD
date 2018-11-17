package quanlybanthuoc.Boundary;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import quanlybanthuoc.Controller.DanhSachThuoc;
import quanlybanthuoc.Entity.Thuoc;

import java.awt.Color;
import java.awt.Toolkit;

public class GDienThuoc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMa;
	private JTextField textFTen;
	private JTextField textCongDung;
	private JTextField textDonGia;
	private JTextField txtSoLuong;
	private JTextField textMa2;
	private JTextField textTen2;
	private JTextField textCongDung2;
	private JTextField textDonGia2;
	private JTextField textSoLuong2;
	JPanel DanhSach = new JPanel();
	JScrollPane dsThuoc = new JScrollPane();
	JPanel SuaThuoc = new JPanel();
	DanhSachThuoc dsthuoc = new DanhSachThuoc();
	ArrayList<Thuoc> list = new ArrayList<>();
	String[] tab = {"Mã thuốc", "Tên thuốc", "Đơn giá","SL Tồn" ,"Ngày Nhập","Công dụng","Trạng thái"};
	//[MaThuoc],[TenThuoc]    ,[DonGia]    ,[SoLuongTon]    ,[NgayNhap]    ,[CongDung],[TrangThai]
	DefaultTableModel modelThuoc = new DefaultTableModel(null, tab);
	JTable jDanhSachThuoc = new JTable();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GDienThuoc frame = new GDienThuoc("b","2");
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
	public GDienThuoc(String manv,String macv ) {
		list = dsthuoc.docTuBang();
		setIconImage(Toolkit.getDefaultToolkit().getImage("bin\\png\\heart.png"));
		setTitle("Nhân Viên Thuốc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80,60,1000, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NhanVien = new JPanel();
		NhanVien.setBackground(new Color(85, 107, 47));
		NhanVien.setBounds(0, 0, 984, 109);
		contentPane.add(NhanVien);
		NhanVien.setLayout(null);
		
		JLabel lblNhnVinBn = new JLabel("Nhân Viên Thuốc");
		lblNhnVinBn.setBounds(419, 21, 375, 54);
		NhanVien.add(lblNhnVinBn);
		lblNhnVinBn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		
		JLabel label = new JLabel("");
		label.setBounds(345, 21, 64, 64);
		NhanVien.add(label);
		label.setIcon(new ImageIcon("bin\\png\\pills.png"));
		
		JLabel lblThuov = new JLabel("");
		lblThuov.setIcon(new ImageIcon("bin\\png\\hospital.png"));
		lblThuov.setBounds(258, 20, 69, 70);
		NhanVien.add(lblThuov);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 190, 984, 371);
		contentPane.add(layeredPane);
		
		JPanel themthuoc = new JPanel();
		themthuoc.setBounds(0, 0, 984, 371);
		layeredPane.add(themthuoc);
		themthuoc.setLayout(null);
		themthuoc.setVisible(false);
		
		JButton btnLuu = new JButton("");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = dsthuoc.docTuBang();
				int mathuoc = 0;
				for(Thuoc a : list) {
					mathuoc = a.getMaThuoc()+1;
				}
				String tenThuoc = null;
				float dongia = 0;
				int soluongton = 0;
				String congdung = null;
				String trangThai="Số Lượng Kém";
				LocalDateTime ngayNhap = null;	
				if(textCongDung.getText().equals("")||textFTen.getText().equals("")||!txtSoLuong.getText().matches("\\d+")||!textDonGia.getText().matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Nhập sai!");
				}else {
					soluongton = Integer.parseInt((String)txtSoLuong.getText());
					tenThuoc = (String)textFTen.getText();
						congdung = (String)textCongDung.getText();
						dongia = Float.valueOf((String)textDonGia.getText());
								if(soluongton>=10)
									trangThai ="Số Lượng Đạt";
								dsthuoc.Create(mathuoc, tenThuoc, dongia, soluongton, ngayNhap, congdung, trangThai);
								list = dsthuoc.docTuBang();
						textCongDung.setText("");
						txtSoLuong.setText("");
						textDonGia.setText("");
						textFTen.setText("");
						textMa.setText(String.valueOf(list.size()+1));
						
						if (modelThuoc.getRowCount() != 0)
							for (int j = modelThuoc.getRowCount() - 1; j >= 0; j--)
								modelThuoc.removeRow(j);
						for (Thuoc i : list) {
							String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getSoluongton() + "",i.getNgayNhap().getDayOfMonth() 
									+ "/"+i.getNgayNhap().getMonthValue()+"/"+ i.getNgayNhap().getYear() + "", i.getCongdung() + "",i.getTrangThai() };
							//[MaThuoc],[TenThuoc]    ,[DonGia]    ,[SoLuongTon]    ,[NgayNhap]    ,[CongDung],[TrangThai]
							modelThuoc.addRow(rowdata);	
						}
						jDanhSachThuoc.setModel(modelThuoc);

						DanhSach.setVisible(true);
						
						themthuoc.setVisible(false);
						
						textCongDung.setVisible(false);
						
						textDonGia.setVisible(false);
						
						textFTen.setVisible(false);
						
						txtSoLuong.setVisible(false);
						
						textMa.setVisible(false);
						
						dsThuoc.setVisible(true);
						
						SuaThuoc.setVisible(false);
						
						JOptionPane.showMessageDialog(null, "Đã Lưu Thành Công !");
						
				}
			}
		});
		btnLuu.setIcon(new ImageIcon("bin\\png\\001-technology.png"));
		btnLuu.setBounds(375, 273, 65, 34);
		themthuoc.add(btnLuu);
		
		JLabel lblHoaDon = new JLabel("Thêm Thuốc");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblHoaDon.setBounds(375, 11, 205, 23);
		themthuoc.add(lblHoaDon);
		
		textMa = new JTextField();
		textMa.setEnabled(false);
		textMa.setBounds(455, 70, 152, 25);
		themthuoc.add(textMa);
		
		JLabel lblTnThuc = new JLabel("Mã thuốc");
		lblTnThuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnThuc.setBounds(316, 72, 73, 19);
		themthuoc.add(lblTnThuc);
		
		textFTen = new JTextField();
		textFTen.setColumns(10);
		textFTen.setBounds(453, 102, 152, 25);
		themthuoc.add(textFTen);
		
		JLabel label_1 = new JLabel("Tên thuốc :");

		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		label_1.setBounds(316, 104, 73, 19);
		
		themthuoc.add(label_1);
				
		
		textCongDung = new JTextField();
		
		textCongDung.setColumns(10);
		
		textCongDung.setBounds(453, 142, 152, 25);
		
		themthuoc.add(textCongDung);
		
		
						
		
		JLabel lblCngDng = new JLabel("Công dụng :");
		
		lblCngDng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblCngDng.setBounds(316, 134, 73, 33);
		
		themthuoc.add(lblCngDng);
		
		
		
		textDonGia = new JTextField();
		
		textDonGia.setColumns(10);
		
		textDonGia.setBounds(453, 178, 152, 25);
		
		themthuoc.add(textDonGia);
		
		
		
		JLabel lblnGi = new JLabel("Đơn Giá :");
		
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblnGi.setBounds(314, 180, 73, 19);
		
		themthuoc.add(lblnGi);
		
		
		
		JLabel lblSLng = new JLabel("Số lượng");
		
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblSLng.setBounds(316, 219, 73, 19);
		
		themthuoc.add(lblSLng);
		
		
		
		txtSoLuong = new JTextField();
		
		txtSoLuong.setColumns(10);
		
		txtSoLuong.setBounds(455, 217, 152, 25);
		
		themthuoc.add(txtSoLuong);
		
		
		
		JButton btnRa = new JButton("");
		
		btnRa.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {


				DanhSach.setVisible(true);
				
				themthuoc.setVisible(false);
				
				textCongDung.setVisible(false);
				
				textDonGia.setVisible(false);
				
				textFTen.setVisible(false);
				
				txtSoLuong.setVisible(false);
				
				textMa.setVisible(false);
				
				dsThuoc.setVisible(true);
				
				SuaThuoc.setVisible(false);
				
			}
			
		});
		
		btnRa.setIcon(new ImageIcon("bin\\png\\015-sign-in.png"));
		
		btnRa.setBounds(511, 273, 44, 34);
		
		themthuoc.add(btnRa);
		
		
		
		SuaThuoc.setBounds(0, 0, 984, 371);
		
		layeredPane.add(SuaThuoc);
		
		SuaThuoc.setLayout(null);
		SuaThuoc.setVisible(false);
		
		textMa2 = new JTextField();
		textMa2.setColumns(10);
		textMa2.setBounds(455, 70, 152, 25);
		SuaThuoc.add(textMa2);
		textMa2.setEnabled(false);
		
		JLabel label_3 = new JLabel("Mã thuốc");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(316, 72, 73, 19);
		SuaThuoc.add(label_3);
		
		textTen2 = new JTextField();
		textTen2.setColumns(10);
		textTen2.setBounds(453, 102, 152, 25);
		SuaThuoc.add(textTen2);
		
		JLabel label_4 = new JLabel("Tên thuốc :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(316, 104, 73, 19);
		SuaThuoc.add(label_4);
		
		textCongDung2 = new JTextField();
		textCongDung2.setColumns(10);
		textCongDung2.setBounds(453, 142, 152, 25);
		SuaThuoc.add(textCongDung2);
		
		JLabel label_5 = new JLabel("Công dụng :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(316, 134, 73, 33);
		SuaThuoc.add(label_5);
		
		textDonGia2 = new JTextField();
		textDonGia2.setColumns(10);
		textDonGia2.setBounds(453, 178, 152, 25);
		SuaThuoc.add(textDonGia2);
		
		JLabel label_6 = new JLabel("Đơn Giá :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(314, 180, 73, 19);
		SuaThuoc.add(label_6);
		
		JLabel label_7 = new JLabel("Số lượng");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(316, 219, 73, 19);
		SuaThuoc.add(label_7);
		
		textSoLuong2 = new JTextField();
		textSoLuong2.setColumns(10);
		textSoLuong2.setBounds(455, 217, 152, 25);
		SuaThuoc.add(textSoLuong2);
		
		JLabel lblSaThuc = new JLabel("Sửa Thuốc");
		lblSaThuc.setBounds(402, 11, 126, 29);
		SuaThuoc.add(lblSaThuc);
		lblSaThuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaThuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		
		JButton buttonSave = new JButton("");
		buttonSave.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
			
				list = dsthuoc.docTuBang();
				if(!textMa2.getText().equals("")) {
				int mathuoc = Integer.parseInt((String)textMa2.getText());
				String tenThuoc = null;
				float dongia = 0;
				int soluongton = 0;
				String congdung = null;
				String trangThai ="Số Lượng Đạt";
				
				LocalDateTime ngayNhap = null;	
				if(textCongDung2.getText().equals("")||textTen2.getText().equals("")||!textSoLuong2.getText().matches("\\d+")||!textDonGia2.getText().matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Nhập sai!");
				}else {
					soluongton = Integer.parseInt((String)textSoLuong2.getText());
					tenThuoc = (String)textTen2.getText();
						congdung = (String)textCongDung2.getText();
						dongia = Float.valueOf((String)textDonGia2.getText());
						if(soluongton<10)
							trangThai="Số Lượng Kém";
						dsthuoc.Update(mathuoc, tenThuoc, dongia, soluongton, ngayNhap, congdung, trangThai);
						textCongDung2.setText("");
						textSoLuong2.setText("");
						textDonGia2.setText("");
						textTen2.setText("");
						textMa2.setText("");
						list = dsthuoc.docTuBang();
						if (modelThuoc.getRowCount() != 0)
							for (int j = modelThuoc.getRowCount() - 1; j >= 0; j--)
								modelThuoc.removeRow(j);
						for (Thuoc i : list) {
							String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getSoluongton() + "",i.getNgayNhap().getDayOfMonth() + "/"+i.getNgayNhap().getMonthValue()+"/"+ i.getNgayNhap().getYear() + "", i.getCongdung() + "",i.getTrangThai() };
							modelThuoc.addRow(rowdata);	
						}
						jDanhSachThuoc.setModel(modelThuoc);
						JOptionPane.showMessageDialog(null, "Đã Sửa  Thành Công !");
						DanhSach.setVisible(true);
						
						themthuoc.setVisible(false);
						
						textCongDung.setVisible(false);
						
						textDonGia.setVisible(false);
						
						textFTen.setVisible(false);
						
						txtSoLuong.setVisible(false);
						
						textMa.setVisible(false);
						
						dsThuoc.setVisible(true);
						
						SuaThuoc.setVisible(false);
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc khác!");

					DanhSach.setVisible(true);
					//dispose();
					themthuoc.setVisible(false);
					textCongDung.setVisible(false);
					textDonGia.setVisible(false);
					textFTen.setVisible(false);
					txtSoLuong.setVisible(false);
					textMa.setVisible(false);
					dsThuoc.setVisible(true);
					SuaThuoc.setVisible(false);
				}
			}
		});
		buttonSave.setBounds(498, 301, 65, 34);
		SuaThuoc.add(buttonSave);
		buttonSave.setIcon(new ImageIcon("bin\\png\\001-technology.png"));
		
		JButton btnXoa = new JButton("");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					list = dsthuoc.docTuBang();
					int mathuoc = Integer.parseInt((String)textMa2.getText());
					
					if(dsthuoc.Delete(mathuoc)) {
						textCongDung2.setText("");
						textSoLuong2.setText("");
						textDonGia2.setText("");
						textTen2.setText("");
						textMa2.setText("");
						list.clear();
						System.out.println(list.size()+"");
						list = dsthuoc.docTuBang();
						System.out.println(list.size()+"");
						if (modelThuoc.getRowCount() != 0)
						for (int j = modelThuoc.getRowCount() - 1; j >= 0; j--)
							modelThuoc.removeRow(j);
						for (Thuoc i : list) {
							String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getSoluongton() + "",i.getNgayNhap().getDayOfMonth() + "/"+i.getNgayNhap().getMonthValue()+"/"+ i.getNgayNhap().getYear() + "", i.getCongdung() + "",i.getTrangThai() };
						modelThuoc.addRow(rowdata);	
						}
						jDanhSachThuoc.setModel(modelThuoc);
								
						
					
						DanhSach.setVisible(true);
						themthuoc.setVisible(false);
						textCongDung.setVisible(false);
						textDonGia.setVisible(false);
						textFTen.setVisible(false);
						txtSoLuong.setVisible(false);
						textMa.setVisible(false);
						dsThuoc.setVisible(true);
						SuaThuoc.setVisible(false);
					
					}
					
						
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXoa.setIcon(new ImageIcon("bin\\png\\broom.png"));
		btnXoa.setBounds(327, 301, 65, 34);
		SuaThuoc.add(btnXoa);
		btnXoa.setVisible(false);
		buttonSave.setVisible(false);
		
		
		DanhSach.setBounds(0, 0, 984, 371);
		layeredPane.add(DanhSach);
		dsThuoc.setBounds(0, 40, 984, 331);
		//dsThuoc.setVisible(false);
			DanhSach.setLayout(null);
		
			DanhSach.add(dsThuoc);
			
					
				
					dsThuoc.setViewportView(jDanhSachThuoc);
					
					
					JLabel lblNewLabel_1 = new JLabel("Danh Sách Thuốc");
					lblNewLabel_1.setBounds(395, -5, 187, 34);
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					DanhSach.add(lblNewLabel_1);
		
		list = dsthuoc.docTuBang();
		for (Thuoc i : list) {
			String[] rowdata = { i.getMaThuoc() + "", i.getTenThuoc() + "", i.getDongia() + "", i.getSoluongton() + "",i.getNgayNhap().getDayOfMonth() + "/"+i.getNgayNhap().getMonthValue()+"/"+ i.getNgayNhap().getYear() + "", i.getCongdung() + "",i.getTrangThai() };
			//"Mã thuốc", "Tên thuốc", "Đơn giá","Công dụng","SL Tồn"
			modelThuoc.addRow(rowdata);	
			
		}
		jDanhSachThuoc.setModel(modelThuoc);
		JPanel congcu = new JPanel();
		congcu.setBackground(SystemColor.textHighlight);
		congcu.setBounds(0, 109, 984, 70);
		contentPane.add(congcu);
		congcu.setLayout(null);
		
		JButton btnThem = new JButton("");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = dsthuoc.docTuBang();
				int mathuoc = 0;
				for(Thuoc a : list) {
					mathuoc = a.getMaThuoc()+1;
				}
					
				textMa.setText(String.valueOf(mathuoc));
				DanhSach.setVisible(false);
				SuaThuoc.setVisible(false);
				themthuoc.setVisible(true);
				textMa.setVisible(true);
				textCongDung.setVisible(true);
				textDonGia.setVisible(true);
				textFTen.setVisible(true);
				txtSoLuong.setVisible(true);
				
				
			}
		});
		btnThem.setBounds(327, 0, 73, 65);
		congcu.add(btnThem);
		btnThem.setForeground(SystemColor.info);
		btnThem.setIcon(new ImageIcon("bin\\png\\pills.png"));
		
		JButton btnXem = new JButton("");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();

				DanhSach.setVisible(true);
				//dispose();
				themthuoc.setVisible(false);
				textCongDung.setVisible(false);
				textDonGia.setVisible(false);
				textFTen.setVisible(false);
				txtSoLuong.setVisible(false);
				textMa.setVisible(false);
				dsThuoc.setVisible(true);
				SuaThuoc.setVisible(false);
				
			}
		});
		btnXem.setBounds(144, 0, 73, 65);
		congcu.add(btnXem);
		btnXem.setIcon(new ImageIcon("bin\\png\\002-text-lines.png"));
		
		JButton btnNv = new JButton("");
		btnNv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDienTaiKhoan(manv,macv).setVisible(true);;
				dispose();
				
			}
		});
		btnNv.setBounds(648, 0, 73, 65);
		congcu.add(btnNv);
		btnNv.setIcon(new ImageIcon("bin\\png\\002-employee-1.png"));
		
		JButton btnThoat = new JButton("");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDienDangNhap().setVisible(true);
				dispose();
			
			}
		});
		btnThoat.setBounds(829, 0, 73, 65);
		congcu.add(btnThoat);
		btnThoat.setIcon(new ImageIcon("bin\\png\\001-exit.png"));
		
		JButton btSua = new JButton("");
		btSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				Object e = k.getSource();
				if (e.equals(btSua)) {
					int index = jDanhSachThuoc.getSelectedRow();
					if (jDanhSachThuoc.isRowSelected(index)) {
					 textMa2.setText((String)(modelThuoc.getValueAt(index,0))); 
					 textTen2.setText((String)(modelThuoc.getValueAt(index,1))); 
					 textCongDung2.setText((String)(modelThuoc.getValueAt(index,5))); 
					
					 float dongiai =  Float.parseFloat((String)(modelThuoc.getValueAt(index,2)));
					 int dongia = (int)dongiai;
					 textDonGia2.setText((String.valueOf(dongia))); 
					 textSoLuong2.setText((String)(modelThuoc.getValueAt(index,3))); 		
					 SuaThuoc.setVisible(true);
					 DanhSach.setVisible(false);
					 themthuoc.setVisible(false);

						btnXoa.setVisible(true);
						buttonSave.setVisible(true);
				
					}
					else{
						
						DanhSach.setVisible(true);
						themthuoc.setVisible(false);
						textCongDung.setVisible(false);
						textDonGia.setVisible(false);
						textFTen.setVisible(false);
						txtSoLuong.setVisible(false);
						textMa.setVisible(false);
						dsThuoc.setVisible(true);
						SuaThuoc.setVisible(false);
						JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn sửa !");
					}
				}		
			}
		});
		btSua.setIcon(new ImageIcon("bin\\png\\paint-roller.png"));
		btSua.setBounds(483, 0, 73, 65);
		congcu.add(btSua);
		}
}
