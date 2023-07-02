package playground.abstracts;

public class AbstractPlayground {
    public static void main(String[] args) {
        Dog dog = Dog.builder()
                .name("dog")
                .build();

        dog.eat();
        dog.makeSound();
    }
}
