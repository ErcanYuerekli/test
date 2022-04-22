
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Simulation extends JFrame {
	private JTextField tfAnzahlAutos;
	private JTextField tfAnzahlMotorraeder;
	private JTextField tfAnzahlParketagen;
	private JTextField tfAnzahlParkplaetzeproEtage;
	private JTextField tfFahrzeugFaehrtRein;
	private JLabel lblAnzahlParpl‰tzeproEtage;
	private JLabel lblAnzahlParketagen;
	private JButton btnAnzahl‹bernehmen;
	private JButton btnEnde;
	private JButton btnbearbeiten;
	private JLabel lblFahrzeigeErzeugen;
	private JLabel lblAnzahlAutos;
	private JLabel lblAnzahlMotorraeder;
	private JButton btnFahrzeugAnzahl‹bernehmen;
	private JButton btnFahrzeugFaehrtEin;
    private JButton btnFahrzeugFaehrtRaus;
    private JLabel lblAnzeigePlatz;
    private JTextField tfFahrzeugFaehrtRaus;
    private JButton btnPlatzabfrage;
    private JTextPane tfPlatzabfrage;
    private JLabel lblPlatzabfrage;
    private JLabel lblFahrzeugFaehrtRaus;
	int anzahlAutos;
	int anzahlMotorraeder;
	
	
    Parkhaus parkhausGroesse;
	
	// Arraylist von unserer Fahrzeugklasse
    ArrayList<String> cars = Fahrzeug.getAutos();
    ArrayList<String> motorcycles =Fahrzeug.getMotorraeder();
    
    String[][] myParkhaus;
    private JButton btnFreiePlaetze;
    private JLabel lblFreiePlaetze;
    
    
    

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulation frame = new Simulation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		
	public Simulation() {
		setTitle("Parkhaus Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 433);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblAnzahlParketagen = new JLabel("Anzahl Parketagen");
		lblAnzahlParketagen.setBounds(350, 33, 119, 13);
		contentPane.add(lblAnzahlParketagen);
		
		lblAnzahlParpl‰tzeproEtage = new JLabel("Parkpl\u00E4tze pro Etage");
		lblAnzahlParpl‰tzeproEtage.setBounds(350, 59, 144, 13);
		contentPane.add(lblAnzahlParpl‰tzeproEtage);
		
		tfAnzahlParketagen = new JTextField();
		tfAnzahlParketagen.setBounds(483, 30, 110, 19);
		tfAnzahlParketagen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfAnzahlParkplaetzeproEtage.requestFocus();
			}
		}});
		contentPane.add(tfAnzahlParketagen);
		tfAnzahlParketagen.setColumns(10);
		
		tfAnzahlParkplaetzeproEtage = new JTextField();
		tfAnzahlParkplaetzeproEtage.setBounds(483, 56, 110, 19);
		tfAnzahlParkplaetzeproEtage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAnzahl‹bernehmen.doClick();
			}
			
		}});
		contentPane.add(tfAnzahlParkplaetzeproEtage);
		tfAnzahlParkplaetzeproEtage.setColumns(10);
		
		btnAnzahl‹bernehmen = new JButton("\u00DCbernehmen");
		btnAnzahl‹bernehmen.setBounds(483, 88, 110, 21);
		btnAnzahl‹bernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parkhausErstellen();
				
	
			}
		});
		contentPane.add(btnAnzahl‹bernehmen);
		
		btnEnde = new JButton("Ende");
		btnEnde.setBounds(483, 299, 110, 21);
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnEnde);
		
		btnbearbeiten = new JButton("bearbeiten");
		btnbearbeiten.setBounds(483, 88, 110, 21);
		btnbearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBearbeitenGUISichtbarkeit();
				
			}
		});
		contentPane.add(btnbearbeiten);
		
		lblFahrzeigeErzeugen = new JLabel("Bitte geben Sie ein wieviele Fahrzeuge sie erzeugen m\u00F6chten");
		lblFahrzeigeErzeugen.setBounds(10, 10, 358, 13);
		contentPane.add(lblFahrzeigeErzeugen);
		
		lblAnzahlAutos = new JLabel("Anzahl Autos");
		lblAnzahlAutos.setBounds(10, 33, 260, 13);
		contentPane.add(lblAnzahlAutos);
		
		lblAnzahlMotorraeder = new JLabel("Anzahl Motorr\u00E4der");
		lblAnzahlMotorraeder.setBounds(10, 59, 260, 13);
		contentPane.add(lblAnzahlMotorraeder);
		
		tfAnzahlAutos = new JTextField();
		tfAnzahlAutos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfAnzahlMotorraeder.requestFocus();
				}
			}
		});
		tfAnzahlAutos.setBounds(219, 30, 110, 19);
		contentPane.add(tfAnzahlAutos);
		tfAnzahlAutos.setColumns(10);
		
		tfAnzahlMotorraeder = new JTextField();
		tfAnzahlMotorraeder.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnFahrzeugAnzahl‹bernehmen.doClick();
				}
			}
		});
		tfAnzahlMotorraeder.setBounds(219, 56, 110, 19);
		contentPane.add(tfAnzahlMotorraeder);
		tfAnzahlMotorraeder.setColumns(10);
		
		btnFahrzeugAnzahl‹bernehmen = new JButton("\u00DCbernehmen");
		btnFahrzeugAnzahl‹bernehmen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				fahrzeugeErzeugen();
			
			}
		});
		btnFahrzeugAnzahl‹bernehmen.setBounds(219, 88, 110, 21);
		contentPane.add(btnFahrzeugAnzahl‹bernehmen);
		
		
		btnFahrzeugFaehrtEin = new JButton("Fahrzeug f\u00E4hrt rein");
		btnFahrzeugFaehrtEin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfFahrzeugFaehrtRein.requestFocus();
					tfFahrzeugFaehrtRein.selectAll();
				}
			}
		});
		btnFahrzeugFaehrtEin.setEnabled(false);
		btnFahrzeugFaehrtEin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				einfahren();
				
			}

		});
		btnFahrzeugFaehrtEin.setBounds(10, 177, 195, 21);
		contentPane.add(btnFahrzeugFaehrtEin);
		
		tfFahrzeugFaehrtRein = new JTextField();
		tfFahrzeugFaehrtRein.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnFahrzeugFaehrtEin.doClick();
				}
			}
		});
		tfFahrzeugFaehrtRein.setBounds(10, 208, 195, 19);
		contentPane.add(tfFahrzeugFaehrtRein);
		tfFahrzeugFaehrtRein.setColumns(10);

		btnFahrzeugFaehrtRaus = new JButton("Fahrzeug f\u00E4hrt raus");
		btnFahrzeugFaehrtRaus.setEnabled(false);
		btnFahrzeugFaehrtRaus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rausfahren();
			}
		});

		btnFahrzeugFaehrtRaus.setBounds(226, 177, 195, 21);
		contentPane.add(btnFahrzeugFaehrtRaus);
		
		tfFahrzeugFaehrtRaus = new JTextField();
		tfFahrzeugFaehrtRaus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnFahrzeugFaehrtRaus.doClick();
					tfFahrzeugFaehrtRaus.requestFocus();
				}
			}
		});
		tfFahrzeugFaehrtRaus.setBounds(226, 208, 195, 19);
		contentPane.add(tfFahrzeugFaehrtRaus);
		tfFahrzeugFaehrtRaus.setColumns(10);
		
		lblAnzeigePlatz = new JLabel(" ");
		lblAnzeigePlatz.setBounds(10, 237, 168, 13);
		contentPane.add(lblAnzeigePlatz);
		
		btnPlatzabfrage = new JButton("Platzabfrage");
		btnPlatzabfrage.setEnabled(false);
		btnPlatzabfrage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				platzabfrage();
			}
		});
		btnPlatzabfrage.setBounds(441, 177, 195, 21);
		contentPane.add(btnPlatzabfrage);
		
		tfPlatzabfrage = new JTextPane();
		tfPlatzabfrage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnPlatzabfrage.doClick();
				}
			}
		});
		tfPlatzabfrage.setBounds(441, 208, 195, 19);
		contentPane.add(tfPlatzabfrage);
		
		lblPlatzabfrage = new JLabel(" ");
		lblPlatzabfrage.setBounds(441, 237, 195, 13);
		contentPane.add(lblPlatzabfrage);
		
		lblFahrzeugFaehrtRaus = new JLabel(" ");
		lblFahrzeugFaehrtRaus.setBounds(226, 237, 195, 13);
		contentPane.add(lblFahrzeugFaehrtRaus);
		
		btnFreiePlaetze = new JButton("Freie Stellpl\u00E4tze");
		btnFreiePlaetze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int counter = 0;
				for(int i = 0; i < parkhausGroesse.getParkhaus().length; i++) {
		        	for(int j = 0; j < parkhausGroesse.getParkhaus()[i].length; j++) {
		        		if(parkhausGroesse.getParkhaus()[i][j] == null) {
		        			counter++;
		        		}
		        	}
				lblFreiePlaetze.setText(Integer.toString(counter)+" Pl‰tze sind frei");
			}
			}
		});
		btnFreiePlaetze.setBounds(10, 299, 195, 21);
		contentPane.add(btnFreiePlaetze);
		
		lblFreiePlaetze = new JLabel(" ");
		lblFreiePlaetze.setBounds(10, 330, 195, 13);
		contentPane.add(lblFreiePlaetze);
		
		
		
	}
		//erstellt das Parkhaus in den gew¸nschten dimensionen
		public void parkhausErstellen() {
				try {			
				
				parkhausGroesse = new Parkhaus(Integer.parseInt(tfAnzahlParketagen.getText()),
						Integer.parseInt(tfAnzahlParkplaetzeproEtage.getText()));
				
				myParkhaus = new String[parkhausGroesse.getEtage()][parkhausGroesse.getParkplaetzeProEtage()];
				
				parhausErstellenGUISichtbarkeit();
	
				System.out.println(Arrays.deepToString(parkhausGroesse.getParkhaus()));	
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(rootPane, "Bitte Zahlen in die Felder eintragen");
				}
		}
		
		
		//Erzeugt Fahrzeuge
		public void fahrzeugeErzeugen() {
			try {
				anzahlAutos = Integer.parseInt(tfAnzahlAutos.getText());
			
			
				anzahlMotorraeder = Integer.parseInt(tfAnzahlMotorraeder.getText());
			
				for(int i = 0; i< anzahlAutos; i++) {
					Fahrzeug.vergebenAutoID("A");
				}
				for(int i = 0; i< anzahlMotorraeder; i++) {
					Fahrzeug.vergebenMotorradID("M");
				}
			
				System.out.println(Fahrzeug.getAutos());
				System.out.println(Fahrzeug.getMotorraeder());
				lblAnzahlAutos.setText(" Autos erzeugt ID: A1 - A"+cars.size());
				lblAnzahlMotorraeder.setText(" Motorr‰der erzeugt ID: M1 - M"+motorcycles.size());
				tfAnzahlParketagen.requestFocus();

			}catch(NumberFormatException en){
				JOptionPane.showMessageDialog(rootPane, "Bitte Zahlen in die Felder eintragen");
			}
		}
	
		
		//kontrolliert alle nˆtigen punkte und f‰hrt das auto ins Parkhaus
		public void einfahren() {
			//Eingabe vom Fahrzeug das reinf‰hrt
			String fahrzeug = tfFahrzeugFaehrtRein.getText();
			
	        //checkt ob Fahrzeug in unserer carsListe vorhanden
	        boolean fahrzeugExistiert = false;
	        if(fahrzeug.charAt(0) == 'A'){                     //Typpr¸fung
	            for (int i = 0; i < cars.size(); i++) {        //Fahrzeug in vorhandener FahrzeugArrayListe
	                if(cars.get(i).equals(fahrzeug)) {
	                	System.out.println("Pups: " + cars.get(i));
	                    fahrzeugExistiert=true;
	                    System.out.println("fahrzeugExistiert: " + fahrzeugExistiert);
	                    break;
	                }
	            }
	        //checkt ob Fahrzeug in unserer motorcyclesListe vorhanden    
    	    } else {
	            for (int i = 0; i < motorcycles.size(); i++) {
	                if(motorcycles.get(i).equals(fahrzeug)){
	                    fahrzeugExistiert = true;
	                    break;
	                }
	            }
	        }
	        
	       
	        //checkt ob Fahrzeug bereits im Parkhaus ist
	        boolean fahrzeugBereitsGeparkt = false;
	        for(int i = 0; i < parkhausGroesse.getParkhaus().length; i++) {
	        	for(int j = 0; j < parkhausGroesse.getParkhaus()[i].length; j++) {
	        		if(parkhausGroesse.getParkhaus()[i][j] != null && parkhausGroesse.getParkhaus()[i][j].equals(fahrzeug)) {
	        			
	        			fahrzeugBereitsGeparkt = true;
	        			System.out.println("fahrzeugBereitsGeparkt: " + fahrzeugBereitsGeparkt);
	        		}
	        	}
	        }
	        
	        //Falls Fahrzeug nicht in Liste vorhanden
	        if(fahrzeugExistiert == false){
	            JOptionPane.showMessageDialog(rootPane, "ID nicht registriert bitte A1 - A"+anzahlAutos+ " oder M1 - M"+anzahlMotorraeder+" eingeben");
	            
	        }
	        else if(fahrzeugBereitsGeparkt == false){
	            //freie pl‰tze abfragen
	            parkhausGroesse.freiePlaetze();

	            //volle parkpl‰tze abfragen
	            parkhausGroesse.vollePlaetze();

	            //fahrzeug wird einem Stellplatz zugewiesen
	            String stellplatz="Parkhaus ist voll";
	            int etage = 0;
	            int platz = 0;
	            for (int i = 0; i < parkhausGroesse.getParkhaus().length; i++) {
	                for (int j = 0; j < parkhausGroesse.getParkhaus()[i].length; j++) {
	                    if(parkhausGroesse.getParkhaus()[i][j] == null) {
	                    	System.out.println("gefundene etage: " + i);
	                    	System.out.println("gefundener platz: " + j);
	                    	etage = i;
	                    	platz = j;
	                    	stellplatz= "Etage: "+ i+" Parkplatz: "+(j+1);
	                    }
	                } 
	            }
	            lblAnzeigePlatz.setText(stellplatz);
	           
	            //einfahren in parkhaus mit Platzzuweisung
	            parkhausGroesse.fahrzeugFaehrtEin(etage, platz, fahrzeug);
                
	            //printArr();
	            printParkhausGroesse();
	        } else {
	        	JOptionPane.showMessageDialog(rootPane, "Fahrzeug bereits geparkt");
	        }
	        parkhausGroesse.freiePlaetze();

            
            parkhausGroesse.vollePlaetze();
            
		}
	
		
		//dient zum verlassen der Fahrzeuge vom Parkhaus
		public void rausfahren() {
			//Eingabe welches Fahrzeug rausf‰hrt
			 String fahrzeug = tfFahrzeugFaehrtRaus.getText();
			 String ausgabe = "";
			 String ausgabeGUI = "";
		        for (int i = 0; i < parkhausGroesse.getParkhaus().length; i++) {
		            for (int j = 0; j < parkhausGroesse.getParkhaus()[i].length; j++) {
		                if(parkhausGroesse.getParkhaus()[i][j] !=null && parkhausGroesse.getParkhaus()[i][j].equals(fahrzeug)){
		                   ausgabe ="Etage: "+ i+" Parkplatz: "+j+" ist jetzt frei";
		                   ausgabeGUI ="Etage: "+ i+" Parkplatz: "+(j+1)+" ist jetzt frei";
		                }
		            }
		        }
		        try {
		        int etage =Integer.parseInt(Character.toString(ausgabe.charAt(7)));
		        int platz = Integer.parseInt(Character.toString(ausgabe.charAt(20)));
		        parkhausGroesse.fahrzeugFaehrtRaus(etage, platz, fahrzeug);
		        lblFahrzeugFaehrtRaus.setText(ausgabeGUI);
		        }catch(Exception es) {
		        	lblFahrzeugFaehrtRaus.setText("ist nicht im Parkhaus");
		        }
		        //printArr();
	            printParkhausGroesse();
		}
	
	
		//zeigt wo sich ein Fahrzeug befindet
		public void platzabfrage() {
			//Eingabe vom Fahrzeug f¸r die Platzabfrage
			String erwarteterPlatz = tfPlatzabfrage.getText();
			String output = "Ist nicht im Parkhaus";
	        for (int i = 0; i <  parkhausGroesse.getParkhaus().length; i++) {
	            for (int j = 0; j <  parkhausGroesse.getParkhaus()[i].length; j++) {
	                if(parkhausGroesse.getParkhaus()[i][j] != null && parkhausGroesse.getParkhaus()[i][j].equals(erwarteterPlatz)){
	                   output ="Etage: "+ i+" Parkplatz: "+(j+1);
	                }
	            }
	        }
	        lblPlatzabfrage.setText(output);
		}

	
		//zur kontrolle f¸r den Programmierer
		public void printArr() {
	     String str = "";
		 for (int i = 0; i < myParkhaus.length; i++) {
	            for (int j = 0; j < myParkhaus[i].length; j++) {
	                    str += myParkhaus[i][j]+"\t";
	            }
	            str += "\n";
	     }
		 System.out.println(str);
   }
		
		
		//zur kontrolle f¸r den Programmierer
		public void printParkhausGroesse() {
	   StringBuilder sb = new StringBuilder();
	   String[][] parkhaus = parkhausGroesse.getParkhaus();
	   for (int i = 0; i < parkhaus.length; i++) {
           for (int j = 0; j < parkhaus[i].length; j++) {
                   sb.append(parkhaus[i][j]+"\t");
           }
           sb.append("\n");
	   }
	   System.out.println(sb.toString());
   }
		

		public void btnBearbeitenGUISichtbarkeit() {
			tfAnzahlParketagen.setEditable(true);
			tfAnzahlParkplaetzeproEtage.setEditable(true);
			btnAnzahl‹bernehmen.setVisible(true);
			btnbearbeiten.setVisible(false);
			btnFahrzeugFaehrtEin.setEnabled(false);
			btnFahrzeugFaehrtRaus.setEnabled(false);
			btnPlatzabfrage.setEnabled(false);
			tfFahrzeugFaehrtRein.setText("");
			tfFahrzeugFaehrtRaus.setText("");
			tfPlatzabfrage.setText("");
			lblAnzeigePlatz.setText("");
			lblFahrzeugFaehrtRaus.setText("");
			lblPlatzabfrage.setText("");
			JOptionPane.showMessageDialog(rootPane, "Hinweis: Beim ‰ndern der Etagen und Parkpl‰tze wird das Parkhaus geleert");
		}


		public void parhausErstellenGUISichtbarkeit() {
			tfAnzahlParketagen.setEditable(false);
			tfAnzahlParkplaetzeproEtage.setEditable(false);
			btnAnzahl‹bernehmen.setVisible(false);
			btnbearbeiten.setVisible(true);
			
			btnFahrzeugFaehrtEin.setEnabled(true);
			btnFahrzeugFaehrtRaus.setEnabled(true);
			btnPlatzabfrage.setEnabled(true);
			tfFahrzeugFaehrtRein.requestFocus();
		}
}


