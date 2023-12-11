package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.util.List;
@Component
public class GetBooks implements Command<List<Book>>{
  private final BookService bookService;

    public GetBooks(BookService bookService, BookService bookService1) {
      this.bookService = bookService1;
    }

    @Override
    public List<Book> execute() {
        return bookService.getAllBooks();
    }
}
