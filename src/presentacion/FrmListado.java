package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Idioma;
import logica.Persona;
import logica.ordenamiento.OrdernarPorEdad;

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

public class FrmListado extends JFrame {

	private JPanel contentPane;
	private JList<Object> lstPersona;
	private FrmMenu menu;
	private LinkedList<Persona>personas;
	private Idioma idioma;

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
		
		lstPersona = new JList();
		lstPersona.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				seleccionarPersona();
			}
		});
		lstPersona.setBounds(22, 30, 394, 295);
		this.lstPersona.setListData(personas.toArray());
		contentPane.add(lstPersona);
		
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
		
	}

	protected void listadoEdad() {
		Collections.sort(personas,new OrdernarPorEdad());
		lstPersona.setListData(personas.toArray());
	}

	protected void ordenarReversa() {
		Collections.reverse(personas);
		lstPersona.setListData(personas.toArray());
		
	}

	protected void listadoOrdenado() {
		Collections.sort(personas);
		lstPersona.setListData(personas.toArray());
		
	}

	protected void visualizar() {
		if(this.lstPersona.getSelectedIndex()>=0)
		{
			Persona persona=(Persona)this.lstPersona.getSelectedValue();
			new FrmVisualizar(this,persona).setVisible(true);;
			setEnabled(false);
		}
		
	}

	protected void seleccionarPersona() {
		if(this.lstPersona.getSelectedIndex()>=0)
		{
			Persona persona=(Persona)this.lstPersona.getSelectedValue();
			
		}
		
	}
	
	private void volver()
	{
		menu.setEnabled(true);
		dispose();
	}
}
