package ro.uvt.info.designpatternslab2023.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2023.models.AllBooksSubject;
import ro.uvt.info.designpatternslab2023.models.SseObserver;

@RestController
public class BooksSseController {
    private AllBooksSubject allBooksSubject;
    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @RequestMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
         allBooksSubject.attach(new SseObserver(emitter));
        return emitter;
    }

}
