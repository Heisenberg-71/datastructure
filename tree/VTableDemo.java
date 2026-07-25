package tree;

class Animal {
    void sound() {
        System.out.println("Generic animal sound");
    }

    void breathe() {
        System.out.println("Breathing...");
    }
}

class Dog extends Animal {
    @Override
    void sound() {                        // overrides — new vtable entry
        System.out.println("Woof!");
    }
    // breathe() not overridden — inherits Animal's vtable pointer
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow!");
    }
}

public class VTableDemo {
    public static void main(String[] args) {
        Animal a1 = new Dog();  // declared Animal, actual Dog
        Animal a2 = new Cat();  // declared Animal, actual Cat

        a1.sound();   // JVM checks Dog's vtable   → Dog.sound()
        a2.sound();   // JVM checks Cat's vtable   → Cat.sound()
        a1.breathe(); // Dog has no override        → Animal.breathe()
    }
}