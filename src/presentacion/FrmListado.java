package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Idioma;
import logica.Persona;
import logica.ordenamiento.OrdernarPorEdad;
import tabla.TablaPersona;

import javax.swing.JList;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;

public class FrmListado extends JFrame {

	private JPanel contentPane;
	private FrmMenu menu;
	private LinkedList<Persona>personas;
	private Idioma idioma;
	private JTable tblPersona;

	/**
	 * Create the frame.
	 * @param personas 
	 * @param idioma 
	 * @param frmMenu 
	 * @param persona 
	 * @param frmListado 
	 */
	public FrmListado(FrmMenu menu, LinkedList<Persona> personas, Idioma idioma) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
		
		this.menu=menu;
		this.personas=personas;
		this.idioma=idioma;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 623, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Listado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoOrdenado();
			}
		});
		btnNewButton.setBounds(426, 36, 120, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reversa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenarReversa();
			}
		});
		btnNewButton_1.setBounds(426, 74, 120, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizar();
			}
		});
		btnVisualizar.setBounds(426, 201, 120, 23);
		contentPane.add(btnVisualizar);
		
		JButton btnNewButton_1_1 = new JButton("Edad");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoEdad();
			}
		});
		btnNewButton_1_1.setBounds(426, 117, 120, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setBounds(426, 302, 120, 23);
		contentPane.add(btnVolver);
		
		tblPersona = new JTable(new TablaPersona(personas));
		tblPersona.setBounds(22, 36, 394, 293);
		contentPane.add(tblPersona);
		
	}

	protected void listadoEdad() {
		Collections.sort(personas,new OrdernarPorEdad());
		tblPersona.setModel(new TablaPersona(personas));
	}

	protected void ordenarReversa() {
		Collections.reverse(personas);
		tblPersona.setModel(new TablaPersona(personas));
		
	}

	protected void listadoOrdenado() {
		Collections.sort(personas);
		tblPersona.setModel(new TablaPersona(personas));
		
	}

	protected void visualizar() {
		if(this.tblPersona.getSelectedRow()>=0)
		{
			int posicion=this.tblPersona.getSelectedRow();
			Persona persona=personas.get(posicion);
			new FrmVisualizar(this,persona).setVisible(true);;
			setEnabled(false);
		}
		
	}
	
	private void volver()
	{
		menu.setEnabled(true);
		dispose();
	}
}
