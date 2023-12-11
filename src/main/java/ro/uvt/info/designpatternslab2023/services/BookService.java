package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    private List<Book> books = new ArrayList<>();
    public Book save(Book book)
    {
        books.add(book);
        return book;
    }
    public Book delete(Book book)
    {
     books.remove(book);
     return book;
    }
    public Book update(Book updatedBook) {
        int index = books.indexOf(updatedBook);
        if (index != -1) {
            books.set(index, updatedBook);
            return updatedBook;
        } else {
            return null;
        }
    }
}
