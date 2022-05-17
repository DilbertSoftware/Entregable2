package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;

import logica.Persona;
import logica.Util;
import logica.exception.CapacidadLlenaException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmAltaPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private FrmMenu menu;
	private LinkedList<Persona>personas;
	private JComboBox<String> cbxDepartamento;
	private JComboBox<String> cbxCantidadHijos;
	private DatePicker picker;


	/**
	 * Create the frame.
	 */
	public FrmAltaPersona(FrmMenu frmMenu, LinkedList<Persona> personas) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
		String[] departamentos=new String[] {"Artigas","Canelones","Cerro Largo","Colonia","Durazno","Flores","Florida","Lavalleja","Maldonado","Montevideo","Paysandú","Río Negro","Rivera","Rocha","Salto","San José","Soriano","Tacuarembo","Treinta yTres"};
		
		this.menu=frmMenu;
		this.personas=personas;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(35, 68, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(35, 97, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Departamento");
		lblNewLabel_2.setBounds(35, 122, 94, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad de hijos");
		lblNewLabel_3.setBounds(35, 153, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Nacimiento");
		lblNewLabel_4.setBounds(34, 186, 108, 14);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(121, 178, 300, 40);
		picker = new JDatePicker();
        picker.setTextEditable(true);
        picker.setShowYearButtons(true);
        panel.add((JComponent) picker);
		contentPane.add(panel);
		
		cbxCantidadHijos = new JComboBox<>();
		cbxCantidadHijos.setBounds(152, 149, 243, 22);
		for(int hijo=0;hijo<=10;hijo++)
		{
			cbxCantidadHijos.addItem(hijo+"");
		}
		
		contentPane.add(cbxCantidadHijos);
		
		cbxDepartamento = new JComboBox<>();
		cbxDepartamento.setBounds(152, 121, 243, 22);
		for(int i=0;i<departamentos.length;i++)
		{
			String departamento=departamentos[i];
			cbxDepartamento.addItem(departamento);
		}
		contentPane.add(cbxDepartamento);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(152, 94, 243, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(152, 65, 243, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		btnNewButton.setBounds(35, 239, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setBounds(306, 239, 89, 23);
		contentPane.add(btnVolver);
	}

	protected void volver() {
		menu.setEnabled(true);
		dispose();
	}

	protected void agregar()  {
		try {
			String nombre=txtNombre.getText();
			String apellido=txtApellido.getText();
			String departamento=cbxDepartamento.getSelectedItem().toString();
			byte cantidadHijos=(byte) cbxCantidadHijos.getSelectedIndex();
			int dia=picker.getModel().getDay();
			int mes=picker.getModel().getMonth();
			int anio=picker.getModel().getYear();
			LocalDate fechaNacimiento=LocalDate.of(anio, mes, dia);
			Persona persona=new Persona(nombre, apellido, departamento, cantidadHijos, fechaNacimiento);
		
			agregar(persona);
			JOptionPane.showMessageDialog(this, "Se ingreso correctamente");
		} catch (CapacidadLlenaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),"Sistema...",JOptionPane.OK_OPTION);
		}
	}

	
	public void agregar(Persona persona) throws CapacidadLlenaException
	{
		persona.setIdPersona(personas.size()+1);
		personas.add(persona);
	}
}
