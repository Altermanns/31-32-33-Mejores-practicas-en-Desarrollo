package lsp;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Zoológico (Aplicando LSP) ---");

        Dog dog = new Dog();
        Fish fish = new Fish();

        System.out.println("\nDemostrando sonidos (Comportamiento Base):");
        makeAnimalSound(dog);
        makeAnimalSound(fish);

        System.out.println("\nDemostrando movimiento:");
        makeAnimalWalk(dog);


        System.out.println("El pez no implementa, por lo que el sistema no permite que camine.");
    }

    public static void makeAnimalSound(Animal animal) {
        System.out.println(animal.makeSound());
    }

    public static void makeAnimalWalk(Walkable walkingAnimal) {
        System.out.println(walkingAnimal.walk());
    }
}