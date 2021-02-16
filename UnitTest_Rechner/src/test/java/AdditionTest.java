import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @Test
    void addition() {
        assertEquals(Addition.addition(5, 10), 15);
        assertEquals(Addition.addition(5.5f, 2.3f), 7.8);
    }

}