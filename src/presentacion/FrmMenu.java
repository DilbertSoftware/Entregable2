package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Persona;
import logica.Util;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.Toolkit;

public class FrmMenu extends JFrame {

	
	private JPanel contentPane;
	private LinkedList<Persona> personas;


	/**
	 * Create the frame.
	 */
	public FrmMenu() {
		setTitle("Dilbert Software");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenu.class.getResource("/imagenes/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Persona");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alta");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPersona();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Buscar");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Acerca de");
		menuBar.add(mnNewMenu_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/logo.png")));
		lblNewLabel.setBounds(113, 11, 473, 440);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPersona();
			}
		});
		
		personas=new LinkedList<>();
		btnNewButton.setToolTipText("Alta de persona");
		btnNewButton.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonAgregar.png")));
		btnNewButton.setBounds(10, 11, 72, 74);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busqueda();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonBuscar.png")));
		btnNewButton_1.setBounds(16, 109, 66, 74);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonListado.png")));
		btnNewButton_1_1.setBounds(16, 202, 66, 74);
		contentPane.add(btnNewButton_1_1);
	}

	

	protected void listado() {
		FrmListado formulario=new FrmListado(this,personas);
		formulario.setVisible(true);
		
	}



	protected void busqueda() {
		FrmBusqueda formulario=new FrmBusqueda(this,personas);
		formulario.setVisible(true);
		this.setEnabled(false);
		
	}

	protected void altaPersona() {
		FrmAltaPersona formulario=new FrmAltaPersona(this,personas);
		formulario.setVisible(true);
		this.setEnabled(false);
	}
}
