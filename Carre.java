import java.util.Scanner; // Importation de la classe Scanner pour la saisie utilisateur

public class Carre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Création d'un objet Scanner pour la saisie utilisateur

        System.out.println("Veuillez entrer la longueur du côté du carré :"); // Demande à l'utilisateur d'entrer la longueur d'un côté du carré
        int cote = scanner.nextInt(); // Lecture de la longueur du côté fournie par l'utilisateur

        dessinerCarre(cote); // Appel de la méthode pour dessiner un carré avec la longueur du côté spécifiée
    }

    // Méthode pour dessiner un carré avec un côté de longueur donnée
    public static void dessinerCarre(int cote) {
        for (int i = 0; i < cote; i++) { // Boucle pour chaque ligne du carré
            for (int j = 0; j < cote; j++) { // Boucle pour chaque colonne du carré
                System.out.print("* "); // Affichage d'une étoile pour représenter un coin du carré
            }
            System.out.println(); // Saut de ligne pour passer à la ligne suivante du carré
        }
    }
}
