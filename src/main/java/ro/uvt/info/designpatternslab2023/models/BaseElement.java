    package ro.uvt.info.designpatternslab2023.models;
    import com.fasterxml.jackson.annotation.JsonSubTypes;
    import com.fasterxml.jackson.annotation.JsonTypeInfo;
    import jakarta.persistence.*;
    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class BaseElement implements Element {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    }