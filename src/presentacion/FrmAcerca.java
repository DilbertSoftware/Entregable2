package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Persona;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

public class FrmAcerca extends JFrame {

	private JPanel contentPane;
	private FrmMenu menu;
	

	/**
	 * Create the frame.
	 * @param personas 
	 */
	public FrmAcerca(FrmMenu menu) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
		this.menu=menu;
		
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAcerca.class.getResource("/imagenes/logo.png")));
		setTitle("Acerca de - Dilbert Software");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 902, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setInheritsPopupMenu(false);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img= new ImageIcon(FrmAcerca.class.getResource("/imagenes/acerca.png")).getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(800, 400, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img2);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		setLocationRelativeTo(null);
	}

	protected void volver() {
		
		menu.setEnabled(true);
		dispose();
		
	}

}
