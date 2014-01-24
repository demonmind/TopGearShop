package topgearshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import topgearshop.ConnectionManager;

public class TGMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 203025447676050605L;
	private JPanel contentPane;
	private String pathImage = "/Users/klkita/Documents/workspace/TopGearShop/src/topgearshop/lada2.jpg";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TGMain frame = new TGMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public TGMain() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("TopGear-Release 1.0");
		setContentPane(contentPane);
		add(new JLabel(new ImageIcon(pathImage)));
		Connection conn = ConnectionManager.getConnection();
	}
}
