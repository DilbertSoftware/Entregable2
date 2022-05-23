package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Avion;
import logica.Barco;
import logica.Persona;
import logica.Util;
import logica.Vehiculo;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmAltaVehiculo extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> cbxColor;
	private JLabel lblColor;
	private JLabel lblNewLabel_1;
	private JTextField txtNombre;
	private JLabel lblNewLabel_2;
	private JComboBox cbxTipo;
	private JLabel lblDistancia;
	private JTextField txtLongitud;
	private JLabel lblCantidad;
	private JTextField txtDato2;
	private JButton btnVolver;
	private Persona persona;
	private FrmVisualizar visualizar;
	/**
	 * Create the frame.
	 */
	public FrmAltaVehiculo(FrmVisualizar visualizar,  Persona persona) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
		this.persona=persona;
		this.visualizar=visualizar;
		setTitle("Alta Veh\u00EDculo - Dilbert Software");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 377, 345);
		contentPane = 
				new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cbxColor = new JComboBox();
		cbxColor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
					color();
			}
		});
		
		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, Color.BLACK, null));
		
		JLabel lblNewLabel = new JLabel("Colores");
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaVehiculo();
			}
		});
		
		lblNewLabel_1 = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Tipo");
		
		cbxTipo = new JComboBox();
		cbxTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				seleccionado();
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Avi\u00F3n", "Barco"}));
		
		lblDistancia = new JLabel("Longitud");
		
		txtLongitud = new JTextField();
		txtLongitud.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad Pasajeros");
		
		txtDato2 = new JTextField();
		txtDato2.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(98)
							.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDistancia)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantidad))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtLongitud, Alignment.LEADING)
										.addComponent(txtDato2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
										.addComponent(cbxTipo, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(11)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxColor, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(26))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDistancia)
								.addComponent(txtLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(cbxColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(cbxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(txtDato2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVolver)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		for(int i=0;i<Util.COLORES.length;i++)
		{
			String color=Util.COLORES[i];
			cbxColor.addItem(color);
		}
	}

	protected void seleccionado() {
		switch(cbxTipo.getSelectedIndex())
		{
			case 0:
				lblDistancia.setText("Distancia");
				lblCantidad.setText("Cantidad de pasajeros");
				break;
			default:
				lblDistancia.setText("Eslora");
				lblCantidad.setText("Manga");
				break;
		}
		
	}

	protected void volver() {
		visualizar.setEnabled(true);
		
		dispose();
	}

	protected void altaVehiculo() {
		try {
			String nombre=txtNombre.getText();
			String color=cbxColor.getSelectedItem().toString();
			String tipo=cbxTipo.getSelectedItem().toString();
			Vehiculo vehiculo;
			double longitud=Double.parseDouble(txtLongitud.getText());
			if(cbxTipo.getSelectedIndex()==0)
			{
				int cantidadPasajero= Integer.parseInt(txtDato2.getText());
				vehiculo=new Avion(nombre,color,longitud,cantidadPasajero);
			}
			else {
				double manga=Double.parseDouble(txtDato2.getText());
				vehiculo=new Barco(nombre,color,longitud,manga);
			}
			persona.agregar(vehiculo);
			visualizar.listadoVehiculo();
			limpiar();
			JOptionPane.showMessageDialog(this, "Se agreg\u00F3 correctamente");
		}catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this, "Tiene que ser num\u00E9rico");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
	}

	private void limpiar() {
		txtDato2.setText("");
		txtLongitud.setText("");
		txtNombre.setText("");
		
	}

	protected void color() {
		if(cbxColor.getSelectedIndex()>=0)
		{
			lblColor.setBackground(Util.COLORES_SISTEMA[cbxColor.getSelectedIndex()]);
			lblColor.repaint();
		}
	}

}
