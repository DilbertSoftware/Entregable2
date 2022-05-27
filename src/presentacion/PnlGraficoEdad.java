package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Persona;

public class PnlGraficoEdad extends JPanel {

	private JPanel contentPane;
	private double resultado[];
	private final int GRADO=360;
	private LinkedList<Persona>personas;
	private String etapas[];
	private int menorEdad;
	private int mayorEdad;
	private double promedioEdad;
	private int sumaEdades;
	public PnlGraficoEdad(LinkedList<Persona>personas) {
		etapas=new String[] {"Menores de edad","Adolescente (18 a 35 años)","Madurez(36 a 64 años)","Tercera edad"};
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		this.personas=personas;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		resultado=new double[4];
		menorEdad=Integer.MAX_VALUE;
		mayorEdad=0;
		sumaEdades=0;
		for(Persona persona : personas)
		{
			if(persona.edad()<18)
				resultado[0]++;
			else
				if(persona.edad()<35)
					resultado[1]++;
				else
					if(persona.edad()<65)
						resultado[2]++;
					else
						resultado[3]++;
			
			sumaEdades+=persona.edad();
			if(menorEdad>persona.edad())
				menorEdad=persona.edad();
			else
				if(mayorEdad<persona.edad())
					mayorEdad=persona.edad();
		}
		
		
	}
	

	
	public void paint(Graphics g)
    {
        
        	
            double suma=0;
            int grados[]=new int[etapas.length];
            
            for(int i=0;i<etapas.length;i++)
            {
            	suma+=resultado[i];
            	
            }
            promedioEdad=sumaEdades/etapas.length;
            for(int i=0;i<etapas.length;i++)
            {
            	grados[i]=(int) (resultado[i]*GRADO/suma);
            	
            }
            int anterior=0;
            int rojo=0;
            int verde=0;
            int azul=0;
            int proximo=25;
            Random aleatorio=new Random();
            g.setColor(Color.BLACK);
            Font aux=getFont();
            g.setFont(new Font("Arial",Font.BOLD,14));
            g.drawString("Por franja de edad", 10, 10);
            g.setFont(aux);
            for(int i=0;i<etapas.length;i++)
            {
            	//Nuevo color
            	rojo=aleatorio.nextInt(255);
            	verde=aleatorio.nextInt(255);
            	azul=aleatorio.nextInt(255);
            	Color color=new Color(rojo,verde,azul);
            	
            	//Circulo
            	g.setColor(color);
                g.fillArc(10,150,150,150,anterior,grados[i]);
                
                
                //Aqui esta la tabla de referencia
                g.fillRect(0, proximo, 25, 30);
                g.setColor(Color.BLACK);
                g.drawString(etapas[i], 30, proximo+20);
                g.drawString(((int)resultado[i])+"", 2, proximo+20);
                
                
                
                anterior+=grados[i];
                proximo+=30;
            }
            
            g.drawString("Total de registrado : "+personas.size(), 0, 350);
            g.drawString("Menor de edad : "+menorEdad, 0, 370);
            g.drawString("Mayor de edad : "+mayorEdad, 0, 390);
            g.drawString("Promedio de edad : "+promedioEdad, 0, 410);
    }
	

}
