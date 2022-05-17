package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Persona;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;

public class FrmBusqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JList<Object> lstResultado;
	private JComboBox cbxMinimoHijo;
	private JComboBox cbxMaximoHijos;
	private JComboBox cbxMinimoEdad;
	private JComboBox cbxMaximoEdad;
	private LinkedList<Persona> personas;
	private FrmMenu menu;
	private JTextField txtApellido;
	private JCheckBox chkEdad;
	private JCheckBox chkHijos;
	/**
	 * Create the frame.
	 */
	public FrmBusqueda(FrmMenu menu,LinkedList<Persona> personas) {
		setTitle("B\u00FAsqueda - Dilbert Software ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmBusqueda.class.getResource("/imagenes/logo.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
		this.personas=personas;
		this.menu=menu;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 687, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 215, 377);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(76, 7, 117, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(19, 10, 51, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(19, 49, 51, 14);
		panel_1.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(76, 46, 117, 20);
		panel_1.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de hijos");
		lblNewLabel_1.setBounds(69, 89, 95, 29);
		panel_1.add(lblNewLabel_1);
		
		cbxMinimoHijo = new JComboBox();
		cbxMinimoHijo.setBounds(40, 155, 30, 22);
		panel_1.add(cbxMinimoHijo);
		
		cbxMaximoHijos = new JComboBox();
		cbxMaximoHijos.setBounds(160, 155, 30, 22);
		panel_1.add(cbxMaximoHijos);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00EDnimo");
		lblNewLabel_2.setBounds(40, 129, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E1ximo");
		lblNewLabel_3.setBounds(159, 129, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setBounds(82, 194, 76, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("M\u00EDnimo");
		lblNewLabel_2_1.setBounds(40, 219, 46, 14);
		panel_1.add(lblNewLabel_2_1);
		
		cbxMinimoEdad = new JComboBox();
		cbxMinimoEdad.setBounds(40, 245, 30, 22);
		panel_1.add(cbxMinimoEdad);
		
		cbxMaximoEdad = new JComboBox();
		cbxMaximoEdad.setBounds(160, 245, 30, 22);
		panel_1.add(cbxMaximoEdad);
		
		JLabel lblNewLabel_3_1 = new JLabel("M\u00E1ximo");
		lblNewLabel_3_1.setBounds(159, 219, 46, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(75, 306, 89, 23);
		panel_1.add(btnBuscar);
		
		chkHijos = new JCheckBox("");
		chkHijos.setBounds(6, 154, 21, 23);
		panel_1.add(chkHijos);
		
		chkEdad = new JCheckBox("");
		chkEdad.setBounds(6, 244, 21, 23);
		panel_1.add(chkEdad);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setBounds(75, 343, 89, 23);
		panel_1.add(btnVolver);
		
		JTextPane txtTituloBusqueda = new JTextPane();
		txtTituloBusqueda.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTituloBusqueda.setEditable(false);
		txtTituloBusqueda.setText("Realice una b\u00FAsqueda de persona por filtrado");
		txtTituloBusqueda.setBounds(225, 22, 410, 35);
		panel.add(txtTituloBusqueda);
		
		lstResultado = new JList();
		lstResultado.setBounds(225, 68, 410, 284);
		panel.add(lstResultado);
		lstResultado.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		for(int hijo=0;hijo<=10;hijo++)
		{
			cbxMinimoHijo.addItem(hijo+"");
			cbxMaximoHijos.addItem(hijo+"");
			
		}
		
		for(int edad=17; edad<=90;edad++)
		{
			cbxMinimoEdad.addItem(edad+"");
			cbxMaximoEdad.addItem(edad+"");
		}
		//Proxima mejoras
		//this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

	}

	protected void volver() {
		menu.setEnabled(true);
		dispose();
		
	}

	protected void buscar() {
		String nombre=txtNombre.getText().trim().toUpperCase();
		String apellido=txtApellido.getText().trim().toUpperCase();
		
		int cantidadHijosMinimo=cbxMinimoHijo.getSelectedIndex();
		int cantidadHijosMaximo=cbxMaximoHijos.getSelectedIndex();
		
		int edadMinima=cbxMinimoEdad.getSelectedIndex()+17;
		int edadMaxima=cbxMaximoEdad.getSelectedIndex()+17;
		LinkedList<Persona> resultado=new LinkedList<>();
		
		
		for(int indice=0;indice<personas.size();indice++)
		{
			Persona persona=personas.get(indice);
			try
			{
				if((nombre.isEmpty() || persona.getNombre().toUpperCase().contains(nombre)) && 
						(apellido.isEmpty() ||    persona.getApellido().toUpperCase().contains(apellido)) &&  
						(!chkEdad.isSelected() || (edadMinima<=  persona.edad() && persona.edad()<=edadMaxima) ) && 
						(!chkHijos.isSelected() || (cantidadHijosMinimo<=persona.getCantHijos() && persona.getCantHijos()<=cantidadHijosMaximo))  )
				{
					resultado.add(persona);
					
				}
			}catch(Exception ex)
			{
				
			}
		}
		lstResultado.setListData(resultado.toArray());
		
	}
}
