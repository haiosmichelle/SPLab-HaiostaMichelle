package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;
@Component
public class UpdateBook implements Command<Book>{

    private final BookService contextBooks;
    Long id;
    Book book;

    public UpdateBook(BookService contextBooks) {
        this.contextBooks = contextBooks;
    }

    public void setAtribute(Long id, Book newBook){
        this.id = id;
        this.book = newBook;
    }

    @Override
    public Book execute() {
        contextBooks.update(id,book);
        return contextBooks.getBookById(id);
    }
}
