package petcaretycoon;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PetCareTycoonTest {

    private Pet dog;
    private Pet cat;
    private Pet bird;

    @Before
    public void setUp() {
        dog = new Dog("Buddy");
        cat = new Cat("Whiskers");
        bird = new Bird("Tweety");
    }

    @Test
    public void testFeedPet() {
        dog.feed();
        assertEquals(100, dog.hunger); 
        dog.hunger = 80;
        dog.feed();
        assertEquals(100, dog.hunger); 
    }

    @Test
    public void testPlayWithPet() {
        cat.play();
        assertEquals(100, cat.happiness); 
        cat.happiness = 50;
        cat.play();
        assertEquals(80, cat.happiness); 
    }

    @Test
    public void testCleanPet() {
        bird.clean();
        assertEquals(100, bird.cleanliness); 
        bird.cleanliness = 60;
        bird.clean();
        assertEquals(100, bird.cleanliness);
    }

    @Test
    public void testDogSpecialAction() {
        dog.specialAction();
        assertEquals(100, dog.happiness);
        assertEquals(30, dog.experience); 
    }

    @Test
    public void testCatSpecialAction() {
        cat.specialAction();
        assertEquals(100, cat.cleanliness);
        assertEquals(20, cat.experience);
    }

    @Test
    public void testBirdSpecialAction() {
        bird.specialAction();
        assertEquals(100, bird.happiness);
        assertEquals(25, bird.experience);
    }

    @Test
    public void testLevelUp() {
        dog.gainExperience(100);
        assertEquals(2, dog.level);
        assertEquals(0, dog.experience);
    }
}
