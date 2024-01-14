package ro.uvt.info.designpatternslab2023;

import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.uvt.info.designpatternslab2023.difexample.ClientComponent;
import ro.uvt.info.designpatternslab2023.models.*;
import ro.uvt.info.designpatternslab2023.difexample.TransientComponent;
import ro.uvt.info.designpatternslab2023.difexample.SingletonComponent;
@SpringBootApplication
public class DesignPatternsLab2023Application {

 public static void createTableOfContent() {
  Book b = new Book("The book");
  Section cap1 = new Section("Chapter 1");
  Section cap11 = new Section("Subchapter 1.1");
  Section cap2 = new Section("Chapter 2");
  cap1.add(new Paragraph("Paragraph 1"));
  cap1.add(new Paragraph("Paragraph 2"));
  cap1.add(new Paragraph("Paragraph 3"));

  cap11.add(new ImageProxy("ImageOne"));
  cap11.add(new Image("ImageTwo"));

  cap2.add(new Paragraph("Paragraph 4"));
  cap1.add(cap11);
  cap1.add(new Paragraph("Some text"));
  cap1.add(new Table("Table 1"));
  b.addContent(cap1);
  b.addContent(cap2);
  TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
  b.accept(tocUpdate);
  tocUpdate.getToC().accept(new RenderContentVisitor());
 }
    public static void main(String[] args) {

     ApplicationContext context =
             SpringApplication.run(DesignPatternsLab2023Application.class, args);

     TransientComponent transientBean =
             context.getBean(TransientComponent.class);
     transientBean.operation();

     transientBean = context.getBean(TransientComponent.class);
     transientBean.operation();

     SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
     singletonBean.operation();

     singletonBean = context.getBean(SingletonComponent.class);
     singletonBean.operation();

     ClientComponent c = context.getBean(ClientComponent.class);
     c.operation();

     c = (ClientComponent)context.getBean("clientComponent");
     c.operation();

     createTableOfContent();
//     Book b = new Book("The book");
//     Section cap1 = new Section("Chapter 1");
//     Paragraph p1 = new Paragraph("Paragraph 1");
//     cap1.add(p1);
//     cap1.add(new ImageProxy("ImageOne"));
//     b.addContent(cap1);
//
//     BookSaveVisitor saveVisitor = new BookSaveVisitorImpl();
//     b.accept(saveVisitor);
        }
 @Bean
 public WebMvcConfigurer corsConfigurer() {
  return new WebMvcConfigurer() {
   @Override
   public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**");
   }
  };
 }
    }

