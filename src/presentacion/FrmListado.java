package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Persona;

import javax.swing.JList;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmListado extends JFrame {

	private JPanel contentPane;
	private JList lstPersona;
	
	

	/**
	 * Create the frame.
	 * @param persona 
	 * @param frmListado 
	 */
	public FrmListado() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		contentPane.add(lstPersona);
		
		JButton btnNewButton = new JButton("Listado");
		btnNewButton.setBounds(426, 36, 120, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reversa");
		btnNewButton_1.setBounds(426, 74, 120, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizar();
			}
		});
		btnVisualizar.setBounds(426, 114, 120, 23);
		contentPane.add(btnVisualizar);
		
	}

	protected void visualizar() {
		if(this.lstPersona.getSelectedIndex()>=0)
		{
			Persona persona=(Persona)this.lstPersona.getSelectedValue();
			new FrmVisualizar(this,persona);
		}
		
	}

	protected void seleccionarPersona() {
		if(this.lstPersona.getSelectedIndex()>=0)
		{
			Persona persona=(Persona)this.lstPersona.getSelectedValue();
			
		}
		
	}
}
