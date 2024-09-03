package petcaretycoon;

import java.util.Random;
import java.util.Scanner;

public class PetCareTycoon {
    private Pet[] pets;
    private int petCount;
    private Scanner scanner;
    private Random random;

    public PetCareTycoon() {
        pets = new Pet[10]; // Array to hold up to 10 pets
        petCount = 0;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    private void displayMenu() {
        System.out.println("\n--- Welcome to PetCareTycoon! ---");
        System.out.println("1. Interact with a pet");
        System.out.println("2. Adopt a new pet");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private void adoptPet() {
        if (petCount >= pets.length) {
            System.out.println("You can't adopt more pets. The pet care center is full!");
            return;
        }

        System.out.print("\nEnter the name of the new pet: ");
        String name = scanner.nextLine();

        System.out.print("Is it a Dog, Cat, or Bird? ");
        String type = scanner.nextLine().toLowerCase();

        if (type.equals("dog")) {
            pets[petCount] = new Dog(name);
            System.out.println(name + " the Dog has been adopted!");
        } else if (type.equals("cat")) {
            pets[petCount] = new Cat(name);
            System.out.println(name + " the Cat has been adopted!");
        } else if (type.equals("bird")) {
            pets[petCount] = new Bird(name);
            System.out.println(name + " the Bird has been adopted!");
        } else {
            System.out.println("Invalid pet type. Adoption failed.");
            return;
        }

        petCount++;
    }

    private void interactWithPet() {
        if (petCount == 0) {
            System.out.println("No pets available. Adopt a pet first!");
            return;
        }

        System.out.println("\nAvailable pets:");
        for (int i = 0; i < petCount; i++) {
            System.out.println((i + 1) + ". " + pets[i].getName() + " (Level " + pets[i].getLevel() + ")");
        }

        System.out.print("\nEnter the number of the pet you want to interact with: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice < 1 || choice > petCount) {
            System.out.println("Invalid choice.");
            return;
        }

        Pet pet = pets[choice - 1];

        System.out.println("\nWhat would you like to do with " + pet.getName() + "?");
        System.out.println("1. Feed");
        System.out.println("2. Play");
        System.out.println("3. Clean");
        System.out.println("4. Train/Groom/Teach");
        System.out.println("5. Show Stats");

        int action = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case 1:
                pet.feed();
                break;
            case 2:
                pet.play();
                break;
            case 3:
                pet.clean();
                break;
            case 4:
                pet.specialAction();
                break;
            case 5:
                pet.showStats();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        triggerRandomEvent(pet);
    }

    private void triggerRandomEvent(Pet pet) {
        int eventChance = random.nextInt(100);
        if (eventChance < 20) {
            System.out.println("\n--- Random Event ---");
            int eventType = random.nextInt(3);
            switch (eventType) {
                case 0:
                    System.out.println(pet.getName() + " found a hidden treasure! Happiness increased.");
                    pet.increaseHappiness(20);
                    break;
                case 1:
                    System.out.println(pet.getName() + " got a bit sick. Health decreased.");
                    pet.decreaseHealth(10);
                    break;
                case 2:
                    System.out.println(pet.getName() + " learned a new trick! Gained extra experience.");
                    pet.gainExperience(50);
                    break;
            }
            pet.showStats();
        }
    }

    public static void main(String[] args) {
        PetCareTycoon petCareTycoon = new PetCareTycoon();
        while (true) {
            petCareTycoon.displayMenu();
            int choice = Integer.parseInt(petCareTycoon.scanner.nextLine());

            switch (choice) {
                case 1:
                    petCareTycoon.interactWithPet();
                    break;
                case 2:
                    petCareTycoon.adoptPet();
                    break;
                case 3:
                    System.out.println("Exiting PetCareTycoon... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

// Abstract class for pets
abstract class Pet {
    protected String name;
    protected int hunger;
    protected int happiness;
    protected int cleanliness;
    protected int health;
    protected int experience;
    protected int level;

    public Pet(String name) {
        this.name = name;
        this.hunger = 100;
        this.happiness = 100;
        this.cleanliness = 100;
        this.health = 100;
        this.experience = 0;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void feed() {
        hunger = Math.min(100, hunger + 20);
        System.out.println(name + " has been fed. Hunger: " + hunger);
    }

    public void play() {
        happiness = Math.min(100, happiness + 30);
        System.out.println(name + " had a fun playtime. Happiness: " + happiness);
    }

    public void clean() {
        cleanliness = Math.min(100, cleanliness + 40);
        System.out.println(name + " has been cleaned. Cleanliness: " + cleanliness);
    }

    public void increaseHappiness(int amount) {
        happiness = Math.min(100, happiness + amount);
    }

    public void decreaseHealth(int amount) {
        health = Math.max(0, health - amount);
    }

    public void gainExperience(int amount) {
        experience += amount;
        if (experience >= 100) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        experience = 0;
        System.out.println(name + " leveled up! Now at level " + level);
    }

    public abstract void specialAction(); // Special action like training, grooming, or teaching

    public void showStats() {
        System.out.println("Pet: " + name + " | Level: " + level);
        System.out.println("Hunger: " + hunger);
        System.out.println("Happiness: " + happiness);
        System.out.println("Cleanliness: " + cleanliness);
        System.out.println("Health: " + health);
        System.out.println("Experience: " + experience + "/100");
    }
}

// Dog class extending Pet
class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void specialAction() {
        happiness = Math.min(100, happiness + 40);
        gainExperience(30);
        System.out.println(name + " has been trained. Happiness: " + happiness + ", Experience: " + experience + "/100");
    }
}

// Cat class extending Pet
class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void specialAction() {
        cleanliness = Math.min(100, cleanliness + 50);
        gainExperience(20);
        System.out.println(name + " has been groomed. Cleanliness: " + cleanliness + ", Experience: " + experience + "/100");
    }
}

// Bird class extending Pet
class Bird extends Pet {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void specialAction() {
        happiness = Math.min(100, happiness + 50);
        gainExperience(25);
        System.out.println(name + " has been taught a new song! Happiness: " + happiness + ", Experience: " + experience + "/100");
    }
}
