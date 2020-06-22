package util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsoleHandlerTest {

    @Test
    public void getDataFromUser() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        String[] dataFromUser = consoleHandler.getDataFromUser("FOLDING BIKE BMW", "1",
                "true", "silver", "1", "1", "1", "", "");
        assertEquals(new String[]{"FOLDING BIKE BMW", "1", "1", "1", "true", "silver", "1"}, dataFromUser);

        String[] data = consoleHandler.getDataFromUser("E-BIKE Gazelle", "1",
                "true", "silver", "1", "", "", "1", "1");
        assertEquals(new String[]{"E-BIKE Gazelle", "1", "1", "true", "1", "silver", "1"}, data);
    }
}
