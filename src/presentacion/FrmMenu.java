package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Espaniol;
import logica.Idioma;
import logica.Ingles;
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
	private Idioma idioma;
	private LinkedList<Persona> personas;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnNewMenu_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;


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
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Persona");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Alta");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPersona();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Buscar");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mnNewMenu_3 = new JMenu("Idioma");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_3 = new JMenuItem("Espa\u00F1ol");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idiomaEspaniol();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Ingles");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idiomaIngles();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		mnNewMenu_2 = new JMenu("Acerca de");
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
		
		btnNewButton = new JButton("");
		
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
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busqueda();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonBuscar.png")));
		btnNewButton_1.setBounds(16, 109, 66, 74);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonListado.png")));
		btnNewButton_1_1.setBounds(16, 202, 66, 74);
		contentPane.add(btnNewButton_1_1);
		idioma=new Espaniol();
	}

	

	protected void idiomaIngles() {
		idioma=new Ingles();
		idioma.inicializar();
		porDefecto();
		traduccion();
	}



	protected void idiomaEspaniol() {
		idioma=new Espaniol();
		idioma.inicializar();
		porDefecto();
		traduccion();
	}



	protected void listado() {
		FrmListado formulario=new FrmListado(this,personas,idioma);
		formulario.setVisible(true);
		
	}



	protected void busqueda() {
		FrmBusqueda formulario=new FrmBusqueda(this,personas,idioma);
		formulario.setVisible(true);
		this.setEnabled(false);
		
	}

	protected void altaPersona() {
		FrmAltaPersona formulario=new FrmAltaPersona(this,personas,idioma);
		formulario.setVisible(true);
		this.setEnabled(false);
	}
	
	private void porDefecto()
	{
		mnNewMenu.setText("archivo");
		mntmNewMenuItem.setText("salir");
		mnNewMenu_1.setText("persona");
		mntmNewMenuItem_1.setText("alta");
		mntmNewMenuItem_2.setText("buscar");
		mntmNewMenuItem_3.setText("espaniol");
		mntmNewMenuItem_4.setText("ingles");
		mnNewMenu_2.setText("acerca de");
		
	}
	
	private void traduccion()
	{
		mnNewMenu.setText(idioma.traduccion("archivo"));
		mntmNewMenuItem.setText(idioma.traduccion("salir"));
		mnNewMenu_1.setText(idioma.traduccion("persona"));
		mntmNewMenuItem_1.setText(idioma.traduccion("alta"));
		mntmNewMenuItem_2.setText(idioma.traduccion("buscar"));
		mntmNewMenuItem_3.setText(idioma.traduccion(mntmNewMenuItem_3.getText()));
		mntmNewMenuItem_4.setText(idioma.traduccion("ingles"));
		mnNewMenu_2.setText(idioma.traduccion("acerca de"));
	}
	
	
}
