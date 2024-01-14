package ro.uvt.info.designpatternslab2023.services;
import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;
@Component
public class GetBookById implements Command<Book>{
    private final BookService contextBooks;
    private Long id;

    public GetBookById(BookService contextBooks) {
        this.contextBooks = contextBooks;
    }

    @Override
    public Book execute() {
        return contextBooks.getBookById(id);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
