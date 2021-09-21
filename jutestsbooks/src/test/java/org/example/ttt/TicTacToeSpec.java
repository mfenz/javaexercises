package org.example.ttt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class TicTacToeSpec {

    private TicTacToe ticTacToe;

    @BeforeEach
    public void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ticTacToe.play(5,2));
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ticTacToe.play(2, 5));
    }

    @Test
    public void whenOccupiedThenRuntimeException(){
        ticTacToe.play(2, 1);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ticTacToe.play(2,1));
    }

    @Test
    public void givenFirstTurnThenNextPlayerShouldByX(){
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO()
    {
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner(){
        String actual = ticTacToe.play(3, 3);
        assertEquals("No winner", actual);
    }

}