
package quanlybanthuoc.Controller;

import java.awt.EventQueue;
import quanlybanthuoc.Boundary.GDienDangNhap;



public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					new GDienDangNhap().setVisible(true);
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
