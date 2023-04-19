package es.upm.pproject.sokoban;

import org.junit.jupiter.api.Test;

import es.upm.pproject.sokoban.model.gamelevel.Board;
import es.upm.pproject.sokoban.model.gamelevel.LevelLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Nested
    @DisplayName("Board level loading tests")
    class BoardLevelLoadingTests {
        @Test
        @DisplayName("Correct board")
        void testCorrectBoard() {
            String correctBoard = "++++    \n" + "+  +    \n" + "+  +++++\n" + "+      +\n" + "++W*+# +\n" + "+   +  +\n"
                    + "+   ++++\n" + "+++++   \n";
            Board board = LevelLoader.loadBoard("resources/Levels/level1.txt");
            assertEquals(correctBoard, board.toString());
        }
    }
}
