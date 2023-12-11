package ro.uvt.info.designpatternslab2023.services;
import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;

public class PostBooks implements Command<Book>{
    private Book book;
    private BookService bookService;
    public PostBooks(){

    }

    public PostBooks(Book book, BookService bookService) {
        this.book = book;
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        return this.bookService.save(this.book);
    }
}
