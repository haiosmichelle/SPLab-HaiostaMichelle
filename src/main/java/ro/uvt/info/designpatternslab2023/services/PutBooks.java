package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;


public class PutBooks implements Command<Book> {
    private Book updatedBook;
    private BookService bookService;

    public PutBooks() {
    }

    public PutBooks(Book updatedBook, BookService bookService) {
        this.updatedBook = updatedBook;
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        return this.bookService.update(updatedBook);
    }
}