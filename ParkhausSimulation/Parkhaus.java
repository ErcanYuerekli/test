import java.util.ArrayList;

public class Parkhaus {
//ParkhausGroesse falsche Klassenlogik! Parkhaus Groesse sollte ein Attribut eines Parkhauses	
	
	
	//Attribute
    private String[][] parkhaus;
    private int etage;
    private int parkplaetzeProEtage;   
	private int geparkteFahrzeuge;
	
	
	
	
	//Konstruktor
	public Parkhaus() {
    	this(2, 2);
    }
    
    public Parkhaus(int etage, int parkplaetzeProEtage) {
    	this.etage = etage;
    	this.parkplaetzeProEtage = parkplaetzeProEtage;
    	this.setParkhaus(etage, parkplaetzeProEtage);
    
    }


    //Methoden
    public void fahrzeugFaehrtEin(int etage,int parkplaetzeProEtage,String x){
    	parkhaus[etage][parkplaetzeProEtage]= x;
    	System.out.println(parkhaus[etage][parkplaetzeProEtage]);
    	geparkteFahrzeuge++;
    }
    public void fahrzeugFaehrtRaus(int etage,int parkplaetzeProEtage,String x){
    	parkhaus[etage][parkplaetzeProEtage]= null;
    	geparkteFahrzeuge--;
    }
    

    public void freiePlaetze() {
    	
    	System.out.println("Freie Plaetze: " + (this.getGesamtParkplatze() - this.geparkteFahrzeuge));
    }

    public void vollePlaetze() {

        System.out.println("Volle plätze: "+this.getGeparkteFahrzeuge());
    }
    
    public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getParkplaetzeProEtage() {
		return parkplaetzeProEtage;
	}

	public void setParkplaetzeProEtage(int parkplaetzeProEtage) {
		this.parkplaetzeProEtage = parkplaetzeProEtage;
	}
	
	public void setParkhaus(int etage, int parkplaetzeProEtage) {
		this.parkhaus = new String[etage][parkplaetzeProEtage];
	}
    public String[][] getParkhaus() {
        return parkhaus;
    }
    
    public int getGesamtParkplatze () {
    	//Nennt man virtuelles Attribut, da es eigentlich für Aufrufer existiert die 
    	//Klasse es aber mit vorhandenen Attributen berechnet
    	return etage * parkplaetzeProEtage;
    }
    
    public int getGeparkteFahrzeuge() {
		return geparkteFahrzeuge;
	}

}
