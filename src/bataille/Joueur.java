package bataille;

import java.util.ArrayList;

public class Joueur {
	private ArrayList<Carte> lesCartes = new ArrayList<Carte>();
	private int points;
	private String nom;
	
	public Joueur(String nom){
		this.nom = nom;
		this.points = 0;
	}
	public void ajouterCarte(Carte uneCarte){
		this.lesCartes.add(uneCarte);
		}
	public Carte jouerCarte(int index){
		Carte uneCarte = this.lesCartes.get(index);
		this.lesCartes.remove(index);
		return uneCarte;
	}
	public void ajouterPoint(){
		this.points++;
	}
	public int getPoint(){
		return this.points;
	}
	public ArrayList<Carte> getLesCartes(){
		return this.lesCartes;
	}
	public String getNom(){
		return this.nom;
	}
}
