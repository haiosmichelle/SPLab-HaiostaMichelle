package ro.uvt.info.designpatternslab2023.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2023.models.Author;
import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.repository.AuthorRepository;
import ro.uvt.info.designpatternslab2023.repository.BookRepository;

import java.util.*;

@Service
public class BookService {
    private Map<Long, Book> books = new HashMap<>();
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    private Long Id=1L;
    public Book saveBook(Book book){
//    { Long bookId = getNextId();
//        books.put(bookId,book);
        for (Author a : book.au)
        {authorRepository.save(a);}
        System.out.println(book.getTitle());
       bookRepository.save(book);
        return book;
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private synchronized Long getNextId() {
        return Id++;
    }
    public void delete(Long bookId)
    {
     bookRepository.deleteById(bookId);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book update(Long bookId, Book updatedBook) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Carte nu gasita cu ID: " + bookId));

        for (Author a : updatedBook.au) {
                authorRepository.save(a);
        }

        book.setTitle(updatedBook.getTitle());
        book.setAu(updatedBook.au);

        return bookRepository.save(book);
    }

    public Book getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }
}
