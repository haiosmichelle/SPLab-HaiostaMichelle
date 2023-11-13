package ro.uvt.info.designpatternslab2023;

import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ro.uvt.info.designpatternslab2023.difexample.ClientComponent;
import ro.uvt.info.designpatternslab2023.difexample.TransientComponent;
import ro.uvt.info.designpatternslab2023.difexample.SingletonComponent;
@SpringBootApplication
public class DesignPatternsLab2023Application {
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
        }
    }

