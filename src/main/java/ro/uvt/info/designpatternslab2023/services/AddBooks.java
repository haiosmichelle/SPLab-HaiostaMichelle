package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;
@Component
public class AddBooks implements Command<Book> {
    private final BookService contextbooks;

    private Book book;

    public AddBooks(BookService contextbooks) {
        this.contextbooks = contextbooks;
    }

    @Override
    public Book execute() {
        return contextbooks.save(book);
    }

    public void setAtribute(Book newBook){
        this.book = newBook;
    }
}
