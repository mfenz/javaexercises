package at.cb.book;

import java.time.LocalDate;

public class Book {
    private String title;
    private LocalDate release;

    public Book(String title, LocalDate release) {
        this.title = title;
        this.release = release;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }
}
