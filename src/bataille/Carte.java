package bataille;

import bataille.Carte;

public class Carte {
	private String couleur;
	private int valeur;
	
	public Carte(String couleur, int valeur){
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	public boolean estSuperieurA(Carte uneCarte){
		boolean bool = false;
		if(this.valeur < uneCarte.valeur)
			bool = false;
		if(this.valeur > uneCarte.valeur)
			bool = true;
		
		return bool;
	}
	public int getValeur(){
		return this.valeur;
	}
	public String getCouleur(){
		return this.couleur;
	}
}
