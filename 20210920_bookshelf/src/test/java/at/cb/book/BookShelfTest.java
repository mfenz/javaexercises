package at.cb.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BookShelfTest {

    private BookShelf shelf;
    private Book derStein;
    private Book grasAdventures;
    private Book baum;

    @BeforeEach
    public void initBeforeEach(){
        shelf = new BookShelf();
        derStein = new Book("Der Stein", LocalDate.of(2021, 1, 1));
        grasAdventures = new Book("Gras-Adventures", LocalDate.of(1900, 10, 1));
        baum = new Book("Baum", LocalDate.of(2000, 12, 5));
    }

    @Test
    public void createBookShelfWith0Books() {
        BookShelf shelf = new BookShelf();
        List<Book> books = shelf.getBooks();
        // Sind in einem neuen Bücherregal 0 Bücher?
        int bookCount = books.size();
        assertEquals(0, bookCount);
    }

    @Test
    @DisplayName("Book shelf should contain 1 book")
    public void addOneBookToBookshelfExpectOneBookInBookShelf() {
        BookShelf shelf = new BookShelf();
        Book derStein = new Book("Der Stein", LocalDate.of(2021, 1, 1));
        shelf.addBooks(derStein);
        assertEquals(1, shelf.getBooks().size());
    }

    @Test
    @DisplayName("Book shelf should contain 2 books")
    public void addTwoBooksToBookshelfExpectTwoBooksInShelf() {
        BookShelf shelf = new BookShelf();
        Book derStein = new Book("Der Stein", LocalDate.of(2021, 1, 1));
        Book dasGras = new Book("Gras-Adventures", LocalDate.of(1900, 10, 1));
        shelf.addBooks(derStein, dasGras);
        assertEquals(2, shelf.getBooks().size());
    }

    @Test
    @DisplayName("Book shelf should contain books in insertion order")
    public void bookShelfShouldContainBooksInInsertionOrder() {
        /*BookShelf shelf = new BookShelf();
        Book derStein = new Book("Der Stein", LocalDate.of(2021, 1, 1));
        Book dasGras = new Book("Gras-Adventures", LocalDate.of(1900, 10, 1));
        Book baum = new Book("Baum", LocalDate.of(2000, 12, 5));*/
        shelf.addBooks(derStein, grasAdventures, baum);

        List<String> actualBookNames = shelf
                .getBooks()
                .stream()
                .map(buch -> buch.getTitle())
                .collect(Collectors.toList());

        assertEquals(List.of("Der Stein", "Gras-Adventures", "Baum"), actualBookNames);

        //assertThat(actualBookNames).
    }

    @Test
    @DisplayName("Books in book shelf should be arranged by title")
    public void getBooksInBookShelfArrangedByTitle(){
        BookShelf shelf = new BookShelf();
        Book derStein = new Book("Der Stein", LocalDate.of(2021, 1, 1));
        Book dasGras = new Book("Gras-Adventures", LocalDate.of(1900, 10, 1));
        Book baum = new Book("Baum", LocalDate.of(2000, 12, 5));
        shelf.addBooks(derStein, dasGras, baum);

        List<Book> books = shelf.getBooksArrangedByTitle();

        List<String> actualBookTitles = books.stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());

        assertEquals(List.of("Baum", "Der Stein", "Gras-Adventures"), actualBookTitles);
    }

    @Test
    @DisplayName("Arranging books by title should not affect insertion order")
    public void arrangingBooksByTitleShouldNotAffectInsertionOrder(){
        shelf.addBooks(derStein, grasAdventures, baum);

        shelf.getBooksArrangedByTitle();

        List<String> actualBookNames = shelf
                .getBooks()
                .stream()
                .map(buch -> buch.getTitle())
                .collect(Collectors.toList());

        assertEquals(List.of("Der Stein", "Gras-Adventures", "Baum"), actualBookNames);
    }

    @Test
    @DisplayName("Book list returned from book shelf should not be modifiable")
    public void bookListReturnedFromBookShelfShouldNotBeModifiable(){
        BookShelf shelf = new BookShelf();
        Book derStein = new Book("Der Stein", LocalDate.of(2021, 1, 1));

        assertThrows(UnsupportedOperationException.class, () -> shelf.getBooks().add(derStein));
        assertThrows(UnsupportedOperationException.class, () -> shelf.getBooksArrangedByTitle().add(derStein));
    }

}