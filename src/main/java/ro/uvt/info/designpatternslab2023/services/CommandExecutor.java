package ro.uvt.info.designpatternslab2023.services;


public interface CommandExecutor {
    abstract Request executeCommand(Command command, BookService bookService);
}
