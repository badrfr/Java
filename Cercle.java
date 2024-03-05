import java.util.Scanner; // Importation de la classe Scanner pour la saisie utilisateur

public class Cercle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Création d'un objet Scanner pour la saisie utilisateur

        System.out.println("Veuillez entrer le rayon du cercle :"); // Demande à l'utilisateur d'entrer le rayon du cercle
        int rayon = scanner.nextInt(); // Lecture du rayon fourni par l'utilisateur

        dessinerCercle(rayon); // Appel de la méthode pour dessiner le cercle avec le rayon spécifié
    }

    // Méthode pour dessiner un cercle avec un rayon donné
    public static void dessinerCercle(int rayon) {
        
        
        
        for (int i = -rayon; i <= rayon; i++) { // Boucle pour chaque ligne du cercle
            for (int j = -rayon; j <= rayon; j++) { // Boucle pour chaque colonne du cercle
                if (i * i + j * j <= rayon * rayon) { // Vérification si le point (i, j) est à l'intérieur du cercle
                    //System.out.print("* "); // Affichage d'une étoile pour représenter une partie du cercle
                    System.out.print(i * i + j * j+" ");
                    
                } else {
                    System.out.print("  "); // Affichage d'un espace vide pour représenter l'extérieur du cercle
                    //Mise en évidence des points en dehors du cercle
                    System.out.print("\u001B[41m" + (i * i + j * j)+ "\u001B[0m");
                }
            }
            System.out.println(); // Saut de ligne pour passer à la ligne suivante du cercle
        }
    }
}
