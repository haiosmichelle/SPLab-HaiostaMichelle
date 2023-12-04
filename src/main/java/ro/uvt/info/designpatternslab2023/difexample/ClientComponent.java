package ro.uvt.info.designpatternslab2023.difexample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.controller.BooksController;

@Component
public class ClientComponent {
    private final TransientComponent tc;
    private final SingletonComponent sc;
    private final BooksController bc;
    @Autowired
    public ClientComponent(TransientComponent tc, SingletonComponent
            sc, BooksController bc) {
        this.tc = tc;
        this.sc = sc;
        this.bc = bc;
        System.out.println("ClientComponent::ClientComponent = " +

                this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }
    public void operation() {
        System.out.println("Invoked ClientComponent::operation() on " +
                this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }
}
