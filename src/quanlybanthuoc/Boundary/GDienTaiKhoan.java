package quanlybanthuoc.Boundary;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quanlybanthuoc.Controller.DanhSachNhanVien;
import quanlybanthuoc.Entity.NhanVien;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GDienTaiKhoan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textma;
	private JTextField textGTinh;
	private JTextField tethoten;
	private JTextField textEmail;
	private JTextField textNgaysinh;
	DanhSachNhanVien dsnhanvien = new DanhSachNhanVien();
	ArrayList<NhanVien> listNhanVien = new ArrayList<>();
	private JTextField textChucVu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GDienTaiKhoan frame = new GDienTaiKhoan("a","1");
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
	public GDienTaiKhoan(String manv,String macv) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("bin\\png\\heart.png"));
		setAlwaysOnTop(true);
		setTitle("Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhnVinBn = new JLabel("NHÂN VIÊN");
		lblNhnVinBn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNhnVinBn.setForeground(Color.RED);
		lblNhnVinBn.setBounds(182, 11, 103, 24);
		contentPane.add(lblNhnVinBn);
		
		JLabel lblM = new JLabel("Mã Nhân Viên :");
		lblM.setBounds(99, 47, 72, 19);
		contentPane.add(lblM);
		
		textma = new JTextField();
		textma.setEditable(false);
		textma.setBounds(192, 46, 183, 20);
		contentPane.add(textma);
		textma.setColumns(10);
		
		textGTinh = new JTextField();
		textGTinh.setEditable(false);
		textGTinh.setColumns(10);
		textGTinh.setBounds(192, 171, 183, 20);
		contentPane.add(textGTinh);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setBounds(99, 172, 72, 19);
		contentPane.add(lblGioiTinh);
		
		tethoten = new JTextField();
		tethoten.setEditable(false);
		tethoten.setColumns(10);
		tethoten.setBounds(192, 77, 183, 20);
		contentPane.add(tethoten);
		
		JLabel lblHavaTen = new JLabel("Họ và Tên :\r\n");
		lblHavaTen.setBounds(99, 78, 72, 19);
		contentPane.add(lblHavaTen);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(192, 108, 183, 20);
		contentPane.add(textEmail);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(99, 109, 72, 19);
		contentPane.add(lblEmail);
		
		textNgaysinh = new JTextField();
		textNgaysinh.setEditable(false);
		textNgaysinh.setColumns(10);
		textNgaysinh.setBounds(192, 140, 183, 20);
		contentPane.add(textNgaysinh);
		
		JLabel lblNgySinh_1 = new JLabel("Ngày sinh :");
		lblNgySinh_1.setBounds(99, 142, 72, 19);
		contentPane.add(lblNgySinh_1);
		
		JButton btnChnhSa = new JButton("Lưu");
		btnChnhSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tethoten.setEditable(false);
				
				textGTinh.setEditable(false);
				textEmail.setEditable(false);
				textNgaysinh.setEditable(false);
//				//String day = String.valueOf(textNgaysinh.getText(),1,8);
//				
//				if(textGTinh.getText().equals("Nam"))
//					dsnhanvien.Update(textma.getText(), tethoten.getText(),true, textEmail.getText());
//				dsnhanvien.Update(textma.getText(), tethoten.getText(), false, textEmail.getText());
			}
		});
		btnChnhSa.setBounds(196, 227, 89, 23);
		contentPane.add(btnChnhSa);
		
		JButton button = new JButton("Chỉnh sửa");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tethoten.setEditable(true);
				
				textGTinh.setEditable(true);
				textEmail.setEditable(true);
				textNgaysinh.setEditable(true);
				
				
				
				
			}
		});
		button.setBounds(60, 227, 111, 23);
		contentPane.add(button);
		
		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (macv.equals("1")) {
					new GDienBanHang(manv,macv).setVisible(true);
						dispose();
					
				}
				else
					if (macv.equals("2")) {
						new GDienThuoc(manv,macv).setVisible(true);
						dispose();
					}
					else 
						new GDienThongKe(manv,macv).setVisible(true);
					dispose();
			}
		});
		btnQuayLi.setBounds(312, 227, 89, 23);
		contentPane.add(btnQuayLi);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("bin\\png\\003-employee.png"));
		label.setBounds(10, 11, 64, 70);
		contentPane.add(label);
		
		JLabel labelchuccu = new JLabel("Chức vụ");
		labelchuccu.setBounds(99, 202, 72, 19);
		contentPane.add(labelchuccu);
		
		textChucVu = new JTextField();
		textChucVu.setEditable(false);
		textChucVu.setColumns(10);
		textChucVu.setBounds(192, 201, 183, 20);
		contentPane.add(textChucVu);
		nhanvien(manv);
	}
	void nhanvien(String manv) {
		listNhanVien = dsnhanvien.docTuBang();
		
		for (NhanVien i : listNhanVien) {
			
			if(i.getMaNV().equals(manv) ) {
				if(i.isGioiTinh() != true)
					textGTinh.setText("Nữ");
				else
					textGTinh.setText("Nam");
				if(i.getMacv().equals("1"))
					textChucVu.setText("Bán Thuốc");
				else 
					if(i.getMacv().equals("2"))
						textChucVu.setText("Thuốc");
					else
						textChucVu.setText("Quản lý");
				
				textma.setText(i.getMaNV());
				tethoten.setText(i.getTen());
				textNgaysinh.setText(i.getNgaysinh().toString());
				textEmail.setText(i.getEmail());
				
				
			}
		
		}
		
	}
}
