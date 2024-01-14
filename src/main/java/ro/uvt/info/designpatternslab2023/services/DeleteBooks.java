package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;
@Component
public class DeleteBooks implements Command<Void> {
    private Book book;
    private final BookService bookService;
    private Long Id;

    public DeleteBooks(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public Void execute() {
       bookService.delete(Id);

        return null;
    }
    public void setAtribute(Long id){
        this.Id = id;
    }
}