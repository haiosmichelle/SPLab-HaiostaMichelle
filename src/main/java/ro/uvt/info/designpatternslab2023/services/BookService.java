package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private Map<Long, Book> books = new HashMap<>();
    private long Id = 1;
    public Book save(Book book)
    { long bookId = getNextId();
        books.put(bookId,book);
        return books.get(bookId);
    }
    private synchronized long getNextId() {
        return Id++;
    }
    public void delete(Long bookId)
    {
     books.remove(bookId);
    }
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    public void update(Long bookId,Book updatedBook) {
        if (books.containsKey(bookId)) {
            books.put(bookId, updatedBook);
        }}
    public Book getBookById(Long bookId) {
        return books.get(bookId);
    }
}
