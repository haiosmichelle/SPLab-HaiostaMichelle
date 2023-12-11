package ro.uvt.info.designpatternslab2023.services;

public interface Command<T> {
    T execute();
}
