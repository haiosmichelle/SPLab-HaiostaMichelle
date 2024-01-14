package ro.uvt.info.designpatternslab2023.services;

import ro.uvt.info.designpatternslab2023.models.Book;

import java.io.IOException;

public interface Observer {
    void update(Book book) throws IOException;
}
