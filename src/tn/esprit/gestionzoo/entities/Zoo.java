package tn.esprit.gestionzoo.entities;

public class Zoo {
    private final int nbrCages = 25;  // Constante
    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount = 0;  // Compteur d'animaux

    // Constructeur paramétré
    public Zoo(String name, String city) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne doit pas être vide.");
        }
        this.name = name;
        this.city = city;
        this.animals = new Animal[nbrCages];
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter cet animal.");
            return false;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println("Cet animal existe déjà dans le zoo.");
                return false;  // Animal déjà présent
            }
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                animals[i] = animals[animalCount - 1];  // Remplace l'animal supprimé par le dernier
                animals[animalCount - 1] = null;  // Évite les références aux objets supprimés
                animalCount--;
                return true;
            }
        }
        return false;  // Animal non trouvé
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public void displayAnimals() {
        System.out.println("Animaux dans le zoo " + name + ":");
        for (int i = 0; i < animalCount; i++) {
            System.out.println("- " + animals[i].getName());
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;  // Retourne l'indice de l'animal
            }
        }
        return -1;  // Animal non trouvé
    }

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount > z2.animalCount) ? z1 : z2;
    }
}
