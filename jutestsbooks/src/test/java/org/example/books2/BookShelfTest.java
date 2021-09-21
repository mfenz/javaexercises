package org.example.books2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A bookshelf")
@ExtendWith(BooksParameterResolver.class)
class BookShelfTest {

    private BookShelf shelf;
    private Book effectiveJava;
    private Book codeComplete;

    @BeforeEach
    void init(Map<String, Book> books){
        shelf = new BookShelf();
        this.effectiveJava = books.get("Effective Java");
        this.codeComplete = books.get("Code Complete");
    }

    @Test
    public void newBookShelfIsEmpty(){
        System.out.println(effectiveJava);
        System.out.println(codeComplete);
        assertTrue(true);
    }

    @Test
    public void modifyUnmodifiableList(){

        List<String> list = Collections.unmodifiableList(Arrays.asList("A", "B", "C"));

        /**
         * assertThrows prüft ob der Aufruf von list.add("D")
         * eine UnsupportedOperationException wirft
         */
        assertThrows(UnsupportedOperationException.class, () -> list.add("D"));
    }
}