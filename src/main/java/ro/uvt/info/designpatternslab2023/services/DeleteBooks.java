package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;

public class DeleteBooks implements Command<Book> {
    private Book book;
    private BookService bookService;

    public DeleteBooks() {
    }

    public DeleteBooks(Book book, BookService bookService) {
        this.book = book;
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        // Assuming BookService has a delete method
        return this.bookService.delete(book);
    }
}