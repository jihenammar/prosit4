package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instruction 1 et 2
        System.out.print("Entrez le nom du zoo: ");
        String zooName = scanner.nextLine();

        System.out.print("Entrez le nombre de cages: ");
        int nbrCages = scanner.nextInt();

        System.out.println(zooName + " comporte " + nbrCages + " cages");

        // Création du zoo
        Zoo myZoo = new Zoo(zooName, "Votre Ville");

        // Création d'animaux
        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Animal tiger = new Animal("Felidae", "Tiger", 3, true);

        // Ajout d'animaux au zoo
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);

        // Affichage des animaux
        myZoo.displayAnimals();

        // Recherche d'un animal
        System.out.println("Recherche de l'animal 'Lion': Indice = " + myZoo.searchAnimal(lion));
        System.out.println("Recherche de l'animal 'Tiger': Indice = " + myZoo.searchAnimal(tiger));

        // Test de l'ajout d'un animal déjà existant
        myZoo.addAnimal(lion);  // Essayer d'ajouter à nouveau le lion

        // Suppression d'un animal
        myZoo.removeAnimal(tiger);
        myZoo.displayAnimals();

        // Vérification si le zoo est plein
        System.out.println("Le zoo est-il plein ? " + myZoo.isZooFull());

        scanner.close();
    }
}
