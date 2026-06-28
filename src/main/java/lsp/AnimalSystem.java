package lsp;

abstract class Animal {
    public abstract String makeSound();
}

interface Walkable {
    String walk();
}

class Dog extends Animal implements Walkable {
    @Override
    public String makeSound() {
        return "Dog barks.";
    }

    @Override
    public String walk() {
        return "Dog is walking.";
    }
}

class Fish extends Animal {
    @Override
    public String makeSound() {
        return "Fish makes bubbles.";
    }
}