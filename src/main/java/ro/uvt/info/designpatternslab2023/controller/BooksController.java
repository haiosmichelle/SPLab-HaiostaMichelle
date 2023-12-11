package ro.uvt.info.designpatternslab2023.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2023.models.*;
import ro.uvt.info.designpatternslab2023.services.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/books")
public class BooksController {
    private List<Book> books = new ArrayList<>();
    private final GetBooks getBooks;
    private final GetBookById getBookById;
    private final UpdateBook updateBook;
    private final DeleteBooks deleteBooks;
    private final AddBooks addBooks;
   public BooksController(GetBooks getBooks, GetBookById getBookById, UpdateBook updateBook, DeleteBooks deleteBooks, AddBooks addBooks){
       this.getBooks = getBooks;
       this.getBookById = getBookById;
       this.updateBook = updateBook;
       this.deleteBooks = deleteBooks;
       this.addBooks = addBooks;
   }

    @GetMapping("/statistics")
    public ResponseEntity<?> printStatistics() {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));
        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
    @GetMapping("/books")
    public List<Book> getBooks()
    {

        return getBooks.execute();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
//        System.out.println("Get id: " + id);
//        return new Book("Cuore singur pe lume");
        this.getBookById.setId(id);
        return getBookById.execute();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book)
    {
        addBooks.setAtribute(book);
        return addBooks.execute();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
//        System.out.println("Update id: " + id);
//        return new Book(book.title);
        this.updateBook.setAtribute(id,book);
        return this.updateBook.execute();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
//        System.out.println("Delete id: " + id);
//        return HttpStatus.OK;
        this.deleteBooks.setAtribute(id);
        this.deleteBooks.execute();

    }

}