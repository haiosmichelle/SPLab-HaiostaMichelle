package ro.uvt.info.designpatternslab2023.models;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.services.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class AllBooksSubject {
    private List<Observer> observers = new  ArrayList<>();


    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void add(Book book) throws IOException {
        notifyObservers(book);
    }

    private void notifyObservers(Book book) throws IOException {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
