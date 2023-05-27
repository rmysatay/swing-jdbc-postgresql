package postgresqlOrnek;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class form extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String sorgu;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"İD","AD","SOYAD"};
	Object[] satirlar = new Object[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 734, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		veritabanı.baglan();
		
		sorgu = "select*from veriler";
		modelim.setColumnCount(0);
		modelim.setRowCount(0);
		modelim.setColumnIdentifiers(kolonlar);
		
		ResultSet rs = veritabanı.listele(sorgu);
		
		try {
			while(rs.next()) {
				satirlar[0]= rs.getString("id");
				satirlar[1]= rs.getString("ad");
				satirlar[2]= rs.getString("soyad");
				modelim.addRow(satirlar);
			}
			table.setModel(modelim);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
