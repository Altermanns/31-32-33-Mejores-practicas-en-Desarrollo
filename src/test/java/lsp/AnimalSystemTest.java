package lsp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalSystemTest {

    @Test
    public void testDogBehaviors() {
        Dog dog = new Dog();

        // El perro debe ser sustituible por Animal
        Animal animalDog = dog;
        assertEquals("Dog barks.", animalDog.makeSound(), "El perro debería ladrar.");

        // El perro debe ser sustituible por Walkable
        Walkable walkableDog = dog;
        assertEquals("Dog is walking.", walkableDog.walk(), "El perro debería caminar.");
    }

    @Test
    public void testFishBehaviors() {
        Fish fish = new Fish();

        // El pez debe ser sustituible por Animal
        Animal animalFish = fish;
        assertEquals("Fish makes bubbles.", animalFish.makeSound(), "El pez debería hacer burbujas.");

        // Se valida indirectamente que Fish no es instancia de Walkable
        assertFalse(fish instanceof Walkable, "El pez NO debe implementar la interfaz Walkable.");
    }
}