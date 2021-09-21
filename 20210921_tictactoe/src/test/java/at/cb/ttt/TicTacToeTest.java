package at.cb.ttt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe ticTacToe;

    @BeforeEach
    public void initBeforeEach(){
        ticTacToe = new TicTacToe();
    }

    @Test
    @DisplayName("X darf nicht ausserhalb des Spielfelds platziert sein")
    public void wennXAusserhalbDesSpielfeldsDannRuntimeException(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ticTacToe.play(4, 2));
    }

    @Test
    @DisplayName("Y darf nicht ausserhalb des Spielfelds platziert sein")
    public void wennYAusserhalbDesSpielfeldsDannRuntimeException(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ticTacToe.play(2, 4));
    }

    @Test
    @DisplayName("Wenn Spielfeld schon besetzt ist, dann nicht noch einmal auswählbar")
    public void spielfeldNurEinmalAuswaehlbarSonstRuntimeException(){
        ticTacToe.play(1, 2);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ticTacToe.play(1, 2));
    }

    @Test
    @DisplayName("X soll erster Player sein")
    public void xSollErsterPlayerSein(){
        assertEquals('X', ticTacToe.getCurrentPlayer());
    }

    @Test
    @DisplayName("O soll zweiter Player sein")
    public void oSollZweiterPlayerSein(){
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.getCurrentPlayer());
    }

    @Test
    @DisplayName("Nach Spieler O kommt Spieler X")
    public void nachSpielerOKommtSpielerX(){
        ticTacToe.play(1, 2);
        ticTacToe.play(1, 1);
        assertEquals('X', ticTacToe.getCurrentPlayer());
    }

    @Test
    @DisplayName("Wenn ein Spielzug dann kein Gewinner")
    public void wennEinSpielzugDannKeinGewinner(){
        String actual = ticTacToe.play(3, 3);
        assertEquals("No winner", actual);
    }

    @Test
    @DisplayName("Spieler X gewinnt horizontal")
    public void spielerXGewinntHorizontal(){
        assertEquals("No winner", ticTacToe.play(1, 1)); // X
        assertEquals("No winner", ticTacToe.play(1, 2)); // O
        assertEquals("No winner", ticTacToe.play(2, 1)); // X
        assertEquals("No winner", ticTacToe.play(2, 2)); // O
        assertEquals("Winner X", ticTacToe.play(3, 1)); // X
    }

    @Test
    @DisplayName("Spieler X gewinnt vertikal")
    public void spielerXGewinntVertikal(){
        assertEquals("No winner", ticTacToe.play(1, 1)); // X
        assertEquals("No winner", ticTacToe.play(3, 1)); // O
        assertEquals("No winner", ticTacToe.play(1, 2)); // X
        assertEquals("No winner", ticTacToe.play(3, 2)); // O
        assertEquals("Winner X", ticTacToe.play(1, 3)); // X
    }

    @Test
    @DisplayName("Spieler O gewinnt horizontal")
    public void spielerOGewinntHorizontal(){
        assertEquals("No winner", ticTacToe.play(1, 1)); // X
        assertEquals("No winner", ticTacToe.play(1, 2)); // O
        assertEquals("No winner", ticTacToe.play(2, 1)); // X
        assertEquals("No winner", ticTacToe.play(2, 2)); // O
        assertEquals("No winner", ticTacToe.play(1, 3)); // X
        assertEquals("Winner O", ticTacToe.play(3, 2)); // O
    }

    @Test
    @DisplayName("Spieler O gewinnt vertikal")
    public void spielerOGewinntVertikal(){
        assertEquals("No winner", ticTacToe.play(1, 1)); // X
        assertEquals("No winner", ticTacToe.play(2, 1)); // O
        assertEquals("No winner", ticTacToe.play(1, 2)); // X
        assertEquals("No winner", ticTacToe.play(2, 2)); // O
        assertEquals("No winner", ticTacToe.play(3, 3)); // X
        assertEquals("Winner O", ticTacToe.play(2, 3)); // O
    }

    @Test
    @DisplayName("Spieler X gewinnt diagonal")
    public void spielerXGewinntDiagonal(){
        assertEquals("No winner", ticTacToe.play(1, 1)); // X
        assertEquals("No winner", ticTacToe.play(3, 1)); // O

        assertEquals("No winner", ticTacToe.play(2, 2)); // X
        assertEquals("No winner", ticTacToe.play(3, 2)); // Y

        assertEquals("Winner X", ticTacToe.play(3, 3)); // X
    }

    @Test
    @DisplayName("Spieler O gewinnt diagonal")
    public void spielerOGewinntDiagonal(){
        assertEquals("No winner", ticTacToe.play(1, 1)); // X
        assertEquals("No winner", ticTacToe.play(3, 1)); // O

        assertEquals("No winner", ticTacToe.play(1, 2)); // X
        assertEquals("No winner", ticTacToe.play(2, 2)); // O

        assertEquals("No winner", ticTacToe.play(2, 1)); // X
        assertEquals("Winner O", ticTacToe.play(1, 3)); // O
    }

    @Test
    @DisplayName("Unentschieden wenn alle Spielfelder belegt sind")
    public void unentschiedenWennAlleSpielfelderBelegtSind(){
        assertEquals("No winner", ticTacToe.play(1, 1)); // X
        assertEquals("No winner", ticTacToe.play(2, 1)); // O

        assertEquals("No winner", ticTacToe.play(3, 1)); // X
        assertEquals("No winner", ticTacToe.play(3, 2)); // O

        assertEquals("No winner", ticTacToe.play(1, 2)); // X
        assertEquals("No winner", ticTacToe.play(1, 3)); // O

        assertEquals("No winner", ticTacToe.play(2, 2)); // X
        assertEquals("No winner", ticTacToe.play(3, 3)); // O

        assertEquals("Draw", ticTacToe.play(2, 3)); // X
    }

}