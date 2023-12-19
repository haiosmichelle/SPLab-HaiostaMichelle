package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.repository.BookRepository;

import java.util.*;

@Service
public class BookService {
    private Map<Long, Book> books = new HashMap<>();
    BookRepository bookRepository;

    private long Id = 1;
    public Book save(Book book)
    { long bookId = getNextId();
        books.put(bookId,book);
        return books.get(bookId);
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private synchronized long getNextId() {
        return Id++;
    }
    public void delete(Long bookId)
    {
     bookRepository.deleteById(bookId);
    }
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    public void update(Long bookId,Book updatedBook) {
        if (books.containsKey(bookId)) {
            books.put(bookId, updatedBook);
        }}
    public Book getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }
}
