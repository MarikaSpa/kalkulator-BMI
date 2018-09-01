package KalkulatorBMI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Kalkulator {
	
	JFrame ramka;
	JTextField wzrost;
	JLabel wzrostL;
	JLabel wagaL;
	JTextField waga;
	JButton obliczBMI;
	JTextArea wynik;
	Double wzrostO, wagaO;
	Double wynikO;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kalkulator bmi = new Kalkulator();
		bmi.oblicz();
	}
	
	public void oblicz() {
		

	
	
	JPanel panelGlowny = new JPanel();
	//panelGlowny.setLayout(new BoxLayout(panelGlowny, BoxLayout.Y_AXIS));
	
	
	ramka = new JFrame("Kalkulator BMI");
	ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	wzrost = new JTextField(" np. 175 ", 10);
	wzrostL= new JLabel("Podaj swój wzrost w cm. : ");
	
	
	waga = new JTextField(" np. 75 ", 10);
	wagaL= new JLabel("Podaj swoj¹ wagê w kg. : ");
	
	wynik = new JTextArea(3, 20);
	wynik.setLineWrap(true);
	TitledBorder tytulW;
	tytulW = BorderFactory.createTitledBorder("Wynik BMI : ");
	wynik.setBorder(tytulW);
	
	obliczBMI = new JButton("Oblicz BMI");
	obliczBMI.addActionListener(new ObliczBMIListener());
	
	panelGlowny.add(wzrostL);
	panelGlowny.add(wzrost);
	
	panelGlowny.add(wagaL);
	panelGlowny.add(waga);
	
	panelGlowny.add(obliczBMI);
	
	panelGlowny.add(wynik);
	ramka.add(panelGlowny);
	ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
	ramka.setVisible(true);
	ramka.setSize(300, 300);
	}	

	
	
	
	public class ObliczBMIListener implements ActionListener {
		public void actionPerformed(ActionEvent zd){
		
			try{
				
				
				wzrostO = Double.parseDouble(wzrost.getText());
				wagaO = Double.parseDouble(waga.getText());
				wynikO = wagaO / (wzrostO/100 * wzrostO/100);
				if (wynikO < 18.5) 
				wynik.setText(String.valueOf(wynikO) + "\n" + "Masz niedowagê");
				else if (wynikO < 25 )
						wynik.setText(String.valueOf(wynikO) + "\n" + "Masz prawid³ow¹ wagê");
					else if (wynikO < 30) 
							wynik.setText(String.valueOf(wynikO) + "\n" + "Masz nadwagê");
						else 
							wynik.setText(String.valueOf(wynikO) + "\n" + "To ju¿ oty³oœæ!!!");
						
				
			} catch (NumberFormatException e) {
				
				wynik.setText("Podana wartoœæ wzrostu lub wagi ma nieprawid³owy format");
			}
			
		
			
		}

		
		
	
		
	}

}
