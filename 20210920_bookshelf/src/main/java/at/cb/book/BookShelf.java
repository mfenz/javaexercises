package at.cb.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookShelf {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks(){
        return Collections.unmodifiableList(books);
    }

    public void addBooks(Book... books){
        this.books.addAll(Arrays.asList(books));
    }

    public List<Book> getBooksArrangedByTitle(){
        return books.stream()
                .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
                .collect(Collectors.toUnmodifiableList());
    }
}
