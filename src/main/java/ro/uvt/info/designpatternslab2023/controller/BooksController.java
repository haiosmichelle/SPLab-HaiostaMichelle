package ro.uvt.info.designpatternslab2023.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2023.models.*;

import java.util.List;

@RestController
//@RequestMapping("/books")
public class BooksController {
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

        return List.of(new Book("Ion"));
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        System.out.println("Get id: " + id);
        return new Book("Cuore singur pe lume");
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book)
    {

        return new Book(book.title);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable int id) {
        System.out.println("Update id: " + id);
        return new Book(book.title);
    }

    @DeleteMapping("/books/{id}")
    public HttpStatus deleteBook(@PathVariable int id) {
        System.out.println("Delete id: " + id);
        return HttpStatus.OK;
    }

}