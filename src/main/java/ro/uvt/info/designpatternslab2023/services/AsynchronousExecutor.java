package ro.uvt.info.designpatternslab2023.services;



public class AsynchronousExecutor implements CommandExecutor{
    @Override
    public Request executeCommand(Command command, BookService bookService) {
        return new Request<>(0, command, false, null);
    }
}
