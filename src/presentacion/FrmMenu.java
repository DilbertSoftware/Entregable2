package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

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
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private JPanel panel;
	private JMenuItem mntmNewMenuItem_5;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JPanel pnlEdades;
	private JPanel panel_3;


	/**
	 * Create the frame.
	 */
	public FrmMenu() {
		setTitle("Dilbert Software");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenu.class.getResource("/imagenes/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 100, 1206, 656);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
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
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busqueda();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_5 = new JMenuItem("Listado");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		mnNewMenu_3 = new JMenu("Idioma");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_3 = new JMenuItem("Espa\u00F1ol");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idiomaEspaniol();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Ingl\u00E9s");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idiomaIngles();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		mnNewMenu_2 = new JMenu("Acerca de");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acercaDe();
			}
		});
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe();
			}
		});
		menuBar.add(mnNewMenu_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPersona();
			}
		});
		
		personas=new LinkedList<>();
		btnNewButton.setToolTipText("Alta de persona");
		btnNewButton.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonAgregar.png")));
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Filtro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busqueda();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonBuscar.png")));
		panel.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagenes/botonListado.png")));
		panel.add(btnNewButton_1_1);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("");
		
		Image img= new ImageIcon(FrmMenu.class.getResource("/imagenes/logo.png")).getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img2);
		panel_2.add(lblNewLabel);
		idioma=new Espaniol();
		
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("sistema.bin"));
			personas=(LinkedList<Persona>)oos.readObject();
			oos.close();
		}  catch (IOException e1) {
			personas=Util.precargado();
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Error inesperado, se cargara los datos por defecto");
			personas=Util.precargado();
		}
		
		setLocationRelativeTo(null);
		pnlEdades = new PnlGraficoEdad(personas);
		
		panel_1.add(pnlEdades);
		
		panel_3 = new PnlGraficoEstadisticas(personas);
		panel_1.add(panel_3);
		
	}

	protected void salir() {
		
		try {
			int pregunta=JOptionPane.showConfirmDialog(this, "Realmente desea salir");
			if(pregunta==JOptionPane.YES_OPTION)
			{
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sistema.bin"));
				oos.writeObject(personas);
				oos.close();
				JOptionPane.showMessageDialog(this,"Se respaldo correctamente");
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "No existe la ubicación del archivo");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Fallo el respaldo del archivo");
			e.printStackTrace();
		}
	}

	protected void acercaDe() {
		new FrmAcerca(this).setVisible(true);
		
		setEnabled(false);
		
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
		btnNewButton.setToolTipText("alta de persona");
		btnNewButton_1.setToolTipText("filtro");
		btnNewButton_1_1.setToolTipText("listado de persona");
		mnNewMenu_3.setText("idioma");
	}
	
	private void traduccion()
	{
		mnNewMenu.setText(idioma.traduccion(mnNewMenu.getText()));
		mntmNewMenuItem.setText(idioma.traduccion(mntmNewMenuItem.getText()));
		mnNewMenu_1.setText(idioma.traduccion(mnNewMenu_1.getText()));
		mntmNewMenuItem_1.setText(idioma.traduccion(mntmNewMenuItem_1.getText()));
		mntmNewMenuItem_2.setText(idioma.traduccion(mntmNewMenuItem_2.getText()));
		mntmNewMenuItem_3.setText(idioma.traduccion(mntmNewMenuItem_3.getText()));
		mntmNewMenuItem_4.setText(idioma.traduccion(mntmNewMenuItem_4.getText()));
		mnNewMenu_2.setText(idioma.traduccion(mnNewMenu_2.getText()));
		mnNewMenu_3.setText(idioma.traduccion(mnNewMenu_3.getText()));
		btnNewButton.setToolTipText(idioma.traduccion(btnNewButton.getToolTipText()));
		btnNewButton_1.setToolTipText(idioma.traduccion(btnNewButton_1.getToolTipText()));
		btnNewButton_1_1.setToolTipText(idioma.traduccion(btnNewButton_1_1.getToolTipText()));
	}
	
	public void paint(Graphics g)
    {
		super.paint(g);
    }

}
