package bataille;

import java.util.ArrayList;

public class Bataille {
	private ArrayList<Carte> jeu = new ArrayList<Carte>();
	private String[] tabCouleur = { "Pique", "Carreau", "Trefle", "Coeur" };

	public static void main(String[] args) {
		Bataille partie = new Bataille();

		Joueur Elise = new Joueur("Elise");
		Joueur Dimitri = new Joueur("Dimitri");
		partie.initialiser();
		partie.melanger(partie.jeu);
		partie.distribuer(Elise, Dimitri);
		partie.jouer(Elise, Dimitri);
	}

	public void initialiser() {
		for (String couleur : tabCouleur) {
			for (int i = 0; i < 13; i++) {
				this.jeu.add(new Carte(couleur, i));
			}
		}
	}

	public void distribuer(Joueur j1, Joueur j2) {
		if (this.jeu.size() != 0) {
			for (Carte uneCarte : this.jeu) {
				if (this.jeu.indexOf(uneCarte) % 2 == 0)
					j1.ajouterCarte(uneCarte);
				else
					j2.ajouterCarte(uneCarte);
			}
		}
	}

	public void jouer(Joueur j1, Joueur j2) {
		this.jouerTour(j1, j2);
		this.gagner(j1, j2);
	}

	private void jouerTour(Joueur j1, Joueur j2) {
		for (int i = 25; i >= 0; i--) {
			Carte carteJ1 = j1.jouerCarte(i);
			System.out.println(j1.getNom() + " joue : "
					+ (carteJ1.getValeur() + 1) + " de "
					+ carteJ1.getCouleur());
			Carte carteJ2 = j2.jouerCarte(i);
			System.out.println(j2.getNom() + " joue : "
					+ (carteJ2.getValeur() + 1) + " de "
					+ carteJ2.getCouleur());

			this.gagnantDuTour(carteJ1, carteJ2, j1, j2);
		}
	}

	private void gagnantDuTour(Carte carteJ1, Carte carteJ2,
			Joueur j1, Joueur j2) {
		if (carteJ1.estSuperieurA(carteJ2)) {
			j1.ajouterPoint();
			System.out.println(j1.getNom() + " gagne ce tour " + "\n");
		}
		if (carteJ2.estSuperieurA(carteJ1)) {
			j2.ajouterPoint();
			System.out.println(j2.getNom() + " gagne ce tour " + "\n");
		}
		if(carteJ1.getValeur() == carteJ2.getValeur()){
			System.out.println("Egalité \n");
		}
	}

	private void gagner(Joueur j1, Joueur j2) {
		if (j1.getPoint() > j2.getPoint()){
			System.out.println("\n" + j1.getNom() + " gagne la partie avec " + j1.getPoint() + " points");
		}else{
			System.out.println("\n" + j2.getNom() + " gagne la partie avec " + j2.getPoint() + " points !!");
		}
	}

	public void melanger(ArrayList<Carte> jeu) {
		int i = 0;
		for (int j = 0; j < jeu.size(); j++) {
			int k = (int) Math.abs((Math.random() * jeu.size()));
			int l = (int) Math.abs((Math.random() * jeu.size()));

			if (k != l) {
				Carte uneCarte = jeu.get(k);
				Carte ancienneCarte = jeu.set(l, uneCarte);
				jeu.set(k, ancienneCarte);
			}
			i++;
		}
		if (i < 2) {
			melanger(jeu);
		}
	}
}
