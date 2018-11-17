package quanlybanthuoc.Boundary;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quanlybanthuoc.Database.Database;
import quanlybanthuoc.Entity.NhanVien;
import quanlybanthuoc.Entity.TaiKhoanNhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class GDienDangNhap extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel Chinh;
	private JTextField txtUser;
	private JPasswordField passwordField;
	JButton btnngNhp = new JButton("Đăng nhập");

	PreparedStatement stmt;
	ResultSet rs;


	/**
	 * Create the frame.
	 */
	public GDienDangNhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("bin\\png\\heart.png"));
		setTitle("Phần mềm quản lý quầy thuốc");
		
		//conn = KetNoiDatabase.getConnection();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Chinh = new JPanel();
		Chinh.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Chinh);
		Chinh.setLayout(null);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(39, 11, 351, 87);
		Chinh.add(panel);
		panel.setLayout(null);
		
		JLabel lblngNhp = new JLabel("Đăng nhập");
		lblngNhp.setBounds(139, 22, 169, 33);
		lblngNhp.setForeground(new Color(0, 100, 0));
		lblngNhp.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel.add(lblngNhp);
		
		JLabel lblicon = new JLabel("");
		lblicon.setIcon(new ImageIcon("bin\\png\\hospital.png"));
		lblicon.setBounds(42, 11, 75, 61);
		panel.add(lblicon);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setBounds(93, 109, 86, 14);
		Chinh.add(lblMNhnVin);
		
		txtUser = new JTextField();
		txtUser.setBounds(214, 106, 125, 20);
		Chinh.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:\r\n");
		lblMtKhu.setBounds(93, 154, 86, 14);
		Chinh.add(lblMtKhu);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 151, 125, 20);
		Chinh.add(passwordField);
		passwordField.addActionListener(this);
		
		btnngNhp.setBounds(167, 193, 107, 23);
		Chinh.add(btnngNhp);
		btnngNhp.addActionListener(this);
	}
	
		
	public  TaiKhoanNhanVien docDuLieuTaiKhoan(String maNV) throws SQLException
	{
		Connection con = Database.getConnection();
		try
		{
			String sql="select * from TaiKhoanNhanVien "+"where MaNV=?";
			PreparedStatement pretamt = con.prepareStatement(sql);
			pretamt.setString(1, maNV);
			ResultSet rs = pretamt.executeQuery();
			while(rs.next())
			{
				String manv = rs.getString(1);
				String mk = rs.getString(2);
				
				System.out.println(mk);

				return new TaiKhoanNhanVien(manv,mk);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Dangnhap(e);
	}

	private void Dangnhap(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.print("actionPerformed is called");

		Object resource = e.getSource();
		if (resource != btnngNhp && resource != passwordField ) { return ; }
		
		String userName	= txtUser.getText();
		String password	= new String(passwordField.getPassword());

		try {
			TaiKhoanNhanVien nv = docDuLieuTaiKhoan(userName);
			if(nv!=null)
			{
				if(nv.getMatkhau().equals(password))
				{
					System.out.println("mat khau ok!");
					
					NhanVien n = docDuLieuNhanVien(userName);
					if (n.getMacv().equals("1")) {
						//dispose();
						new GDienBanHang(userName,n.getMacv()).setVisible(true);
						dispose();
						
					}
					else
						if (n.getMacv().equals("2")) {
							//dispose();
							new GDienThuoc(userName,n.getMacv()).setVisible(true);
							//dispose();
							dispose();
							
						}
						else {
							
							new GDienThongKe(userName,n.getMacv()).setVisible(true);
						//dispose();
							dispose();
						}
					
				}
				else			
					JOptionPane.showMessageDialog(null,"Sai mật khẩu","Thông báo!",JOptionPane.INFORMATION_MESSAGE);

			}
			else
				JOptionPane.showMessageDialog(null,"Tài khoản không chính xác","Thông báo!",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}


	public  NhanVien docDuLieuNhanVien(String maNV) throws SQLException
	{
		Connection con = Database.getConnection();
		try
		{
			String sql="select * from NhanVien "+"where MaNV=?";
			PreparedStatement pretamt = con.prepareStatement(sql);
			pretamt.setString(1, maNV);
			ResultSet rs = pretamt.executeQuery();
			while(rs.next())
			{
				String manv = rs.getString(1);
				String ten = rs.getString(2);
				String email = rs.getString(3);
				boolean gioitinh = rs.getBoolean(4);
				Date ngay = rs.getDate(5);
				@SuppressWarnings("deprecation")
				LocalDateTime day = LocalDateTime.of(ngay.getYear(),ngay.getMonth(),ngay.getDay(),0,0);
				String macv =rs.getString(6);
				
				
	
				return new NhanVien(manv,ten,day,gioitinh,email,macv);
	//			 NhanVien(String maNV, String ten, LocalDateTime ngaysinh, boolean gioiTinh, String email, String macv)
			}
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
		return null;
	}
	
	}




	


		



