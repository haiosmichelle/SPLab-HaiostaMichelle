package ro.uvt.info.designpatternslab2023.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2023.models.*;
import ro.uvt.info.designpatternslab2023.repository.AuthorRepository;
import ro.uvt.info.designpatternslab2023.repository.BookRepository;
import ro.uvt.info.designpatternslab2023.repository.TableRepository;

import java.util.*;

@Service
public class BookService {
    private Map<Long, Book> books = new HashMap<>();
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    TableRepository tableRepository;
    private Long Id=1L;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book saveBook(Book book){
        for (Author a : book.au)
        {authorRepository.save(a);}
        for(Element e: book.el)
        {tableRepository.save((Table)e);}
       book=bookRepository.save(book);
        return book;
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
