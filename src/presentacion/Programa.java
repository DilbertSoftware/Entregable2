package 
presentacion;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Programa extends JFrame {

	private JPanel contentPane;
	private JLabel lblPos1;
	private JLabel lblPos2;
	private JLabel lblPos3;
	private JLabel lblPos5;
	private int ultimaImagen;
	private Timer timer;
	private JLabel lblNewLabel;
	/**
	 * Launch the application. 
	 */

	public static void main(String args[])
	{
		new Programa().setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public Programa() {
		setUndecorated(true);
		ultimaImagen=0;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Programa.class.getResource("/imagenes/Proyecto Java.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 494, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPos4 = new JLabel("");
		lblPos4.setVisible(false);
		lblPos4.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/imagen_2022-05-07_022213161.png")));
		lblPos4.setBounds(333, 430, 60, 51);
		contentPane.add(lblPos4);
		
		lblPos2 = new JLabel("");
		lblPos2.setVisible(false);
		lblPos2.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/imagen_2022-05-07_022425447.png")));
		lblPos2.setBounds(112, 427, 60, 54);
		contentPane.add(lblPos2);
		
		lblPos3 = new JLabel("");
		lblPos3.setVisible(false);
		lblPos3.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/imagen_2022-05-07_021748678.png")));
		lblPos3.setBounds(219, 430, 60, 51);
		contentPane.add(lblPos3);
		
		lblPos1 = new JLabel("");
		lblPos1.setVisible(false);
		lblPos1.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/imagen_2022-05-07_021550098.png")));
		lblPos1.setBounds(-7, 427, 60, 54);
		contentPane.add(lblPos1);
		
		lblPos5 = new JLabel("");
		lblPos5.setVisible(false);
		lblPos5.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/imagen_2022-05-07_021300064.png")));
		lblPos5.setBounds(437, 430, 73, 54);
		contentPane.add(lblPos5);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/ProyectoJava.png")));
		lblNewLabel.setBounds(-7, 0, 507, 481);
		contentPane.add(lblNewLabel);
		TimerTask tarea = new TimerTask()
	     {
	         public void run() 
	         {
	             switch(ultimaImagen)
	             {
	             	case 0:
	             		break;
	             	case 1:
	             		lblPos1.setVisible(true);
	             		break;
	             	case 2:
	             		lblPos2.setVisible(true);
	             		break;
	             	case 3:
	             		lblPos3.setVisible(true);
	             		break;
	             	case 4:
	             		lblPos4.setVisible(true);
	             		break;
	             	case 5:
	             		lblPos5.setVisible(true);
	             		break;
	             	default:
	             		//Creamos el objeto FrmMenu
	             		FrmMenu menu=new FrmMenu();
	             		menu.setVisible(true);
	             		//Frena el reloj del objeto
	             		timer.cancel();
	             		//Elimina la memoria el jframe 
	             		dispose();
	             		
	             }
	             ultimaImagen++;
	         }    
	     };
	     // Aquí se pone en marcha el timer cada segundo.
	     timer = new Timer();
	     // Dentro de 0 milisegundos avísame cada 1000 milisegundos
	     timer.scheduleAtFixedRate(tarea, 0, 2000);
	}
}
