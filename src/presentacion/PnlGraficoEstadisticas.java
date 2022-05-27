package presentacion;

import javax.swing.JPanel;

import logica.Persona;

import javax.swing.JLabel;

import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class PnlGraficoEstadisticas extends JPanel {
	private JLabel lblAvion;
	private JLabel lblBarco;
	private LinkedList<Persona>personas;
	private HashMap<String,JLabel>listadoDepartamentos;
	private int cantidadAviones;
	private int cantidadBarcos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblUsuario;
	private JLabel lblUruguay;
	private JLabel lblSalto;
	private JLabel lblArtigas;
	private JLabel lblPaysandu;
	private JLabel lblTacurembo;
	private JLabel lblRivera;
	private JLabel lblCerroLargo;
	private JLabel lblDurazno;
	private JLabel lblTreintaYTres;
	private JLabel lblRocha;
	private JLabel lblMaldonado;
	private JLabel lblLavalleja;
	private JLabel lblFlorida;
	private JLabel lblCanelones;
	private JLabel lblFlores;
	private JLabel lblSoriano;
	private JLabel lblColonia;
	private JLabel lblMontevideo;
	private JLabel lblSanJose;
	private JLabel lblRioNegro;
	/**
	 * Create the panel.
	 */
	public PnlGraficoEstadisticas(LinkedList<Persona>personas) {
		setLayout(null);
		this.personas=personas;
		

		
		JLabel lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon(PnlGraficoEstadisticas.class.getResource("/imagenes/avion.png")));
		lbl3.setBounds(10, 48, 69, 49);
		add(lbl3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PnlGraficoEstadisticas.class.getResource("/imagenes/barco.png")));
		lblNewLabel_1.setBounds(115, 42, 69, 55);
		add(lblNewLabel_1);
		
		lblBarco = new JLabel("New label");
		lblBarco.setBounds(33, 114, 33, 14);
		add(lblBarco);
		
		lblAvion = new JLabel("New label");
		lblAvion.setBounds(135, 114, 26, 14);
		add(lblAvion);
		lblAvion.setText(cantidadAviones+"");
		lblBarco.setText(cantidadBarcos+"");
		
		lblNewLabel = new JLabel("Estadisticas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(54, 11, 90, 14);
		add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel();
		Image img= new ImageIcon(PnlGraficoEstadisticas.class.getResource("/imagenes/persona.png")).getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon(img2);
		lblNewLabel_2.setBounds(214, 26, 80, 71);
		add(lblNewLabel_2);
		
		lblUsuario = new JLabel("New label");
		lblUsuario.setBounds(248, 114, 46, 14);
		add(lblUsuario);
		lblUsuario.setText(personas.size()+"");
		
		lblSalto = new JLabel("");
		lblSalto.setToolTipText("0");
		lblSalto.setBounds(75, 250, 86, 42);
		add(lblSalto);
		
		lblArtigas = new JLabel("");
		lblArtigas.setToolTipText("0");
		lblArtigas.setBounds(75, 189, 86, 42);
		add(lblArtigas);
		
		lblUruguay = new JLabel("");
		lblUruguay.setIcon(new ImageIcon(PnlGraficoEstadisticas.class.getResource("/imagenes/mapaUruguay.png")));
		lblUruguay.setBounds(0, 150, 393, 431);
		add(lblUruguay);
		
		lblPaysandu = new JLabel("");
		lblPaysandu.setToolTipText("0");
		lblPaysandu.setBounds(54, 310, 86, 42);
		add(lblPaysandu);
		
		lblTacurembo = new JLabel("");
		lblTacurembo.setToolTipText("0");
		lblTacurembo.setBounds(170, 310, 86, 42);
		add(lblTacurembo);
		
		lblRivera = new JLabel("");
		lblRivera.setToolTipText("0");
		lblRivera.setBounds(208, 257, 86, 42);
		add(lblRivera);
		
		lblCerroLargo = new JLabel("");
		lblCerroLargo.setToolTipText("0");
		lblCerroLargo.setBounds(274, 334, 86, 42);
		add(lblCerroLargo);
		
		lblDurazno = new JLabel("");
		lblDurazno.setToolTipText("0");
		lblDurazno.setBounds(135, 386, 86, 42);
		add(lblDurazno);
		
		lblTreintaYTres = new JLabel("");
		lblTreintaYTres.setToolTipText("0");
		lblTreintaYTres.setBounds(259, 387, 86, 42);
		add(lblTreintaYTres);
		
		lblRocha = new JLabel("");
		lblRocha.setToolTipText("0");
		lblRocha.setBounds(296, 449, 86, 86);
		add(lblRocha);
		
		lblMaldonado = new JLabel("");
		lblMaldonado.setToolTipText("0");
		lblMaldonado.setBounds(232, 526, 51, 42);
		add(lblMaldonado);
		
		lblLavalleja = new JLabel("");
		lblLavalleja.setToolTipText("0");
		lblLavalleja.setBounds(232, 459, 46, 42);
		add(lblLavalleja);
		
		lblFlorida = new JLabel("");
		lblFlorida.setToolTipText("0");
		lblFlorida.setBounds(159, 448, 59, 42);
		add(lblFlorida);
		
		lblCanelones = new JLabel("");
		lblCanelones.setToolTipText("0");
		lblCanelones.setBounds(159, 509, 59, 25);
		add(lblCanelones);
		
		lblFlores = new JLabel("");
		lblFlores.setToolTipText("0");
		lblFlores.setBounds(110, 425, 33, 42);
		add(lblFlores);
		
		lblSoriano = new JLabel("");
		lblSoriano.setToolTipText("0");
		lblSoriano.setBounds(33, 425, 59, 42);
		add(lblSoriano);
		
		lblColonia = new JLabel("");
		lblColonia.setToolTipText("0");
		lblColonia.setBounds(20, 478, 86, 42);
		add(lblColonia);
		
		lblMontevideo = new JLabel("");
		lblMontevideo.setToolTipText("0");
		lblMontevideo.setBounds(115, 545, 70, 25);
		add(lblMontevideo);
		
		lblSanJose = new JLabel("");
		lblSanJose.setToolTipText("0");
		lblSanJose.setBounds(120, 478, 33, 57);
		add(lblSanJose);
		
		lblRioNegro = new JLabel("");
		lblRioNegro.setToolTipText("0");
		lblRioNegro.setBounds(39, 371, 80, 31);
		add(lblRioNegro);
		listadoDepartamentos=new HashMap<>();
		
		listadoDepartamentos.put("Artigas", lblArtigas);
		listadoDepartamentos.put("Canelones", lblCanelones);
		listadoDepartamentos.put("Cerro Largo", lblCerroLargo);
		listadoDepartamentos.put("Colonia", lblColonia);
		listadoDepartamentos.put("Durazno", lblDurazno);
		listadoDepartamentos.put("Flores", lblFlores);
		listadoDepartamentos.put("Florida", lblFlorida);
		listadoDepartamentos.put("Lavalleja", lblLavalleja);
		listadoDepartamentos.put("Maldonado", lblMaldonado);
		listadoDepartamentos.put("Montevideo", lblMontevideo);
		listadoDepartamentos.put("Paysandú", lblPaysandu);
		listadoDepartamentos.put("Río Negro", lblRioNegro);
		listadoDepartamentos.put("Rivera", lblRivera);
		listadoDepartamentos.put("Rocha", lblRocha);
		listadoDepartamentos.put("Salto", lblSalto);
		listadoDepartamentos.put("San José", lblSanJose);
		listadoDepartamentos.put("Soriano", lblSoriano);
		listadoDepartamentos.put("Tacuarembo", lblTacurembo);
		listadoDepartamentos.put("Treinta yTres", lblTreintaYTres);
		calcular();
	}
	
	private void calcular()
	{
		for(Persona persona:personas)
		{
			try
			{
				cantidadAviones+=persona.cantidadAviones();
				cantidadBarcos+=persona.cantidadBarcos();
				JLabel departamento=listadoDepartamentos.get(persona.getDeptoResidencia());
				int cantidad=Integer.parseInt(departamento.getToolTipText())+1;
				departamento.setToolTipText(cantidad+"");
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
		}
	}
	
}
