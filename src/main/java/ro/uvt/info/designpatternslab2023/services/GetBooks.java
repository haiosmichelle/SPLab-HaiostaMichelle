package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.util.List;

public class GetBooks implements Command<List<Book>>{

    @Override
    public List<Book> execute() {
        return List.of(new Book("Aladin"));
    }
}
