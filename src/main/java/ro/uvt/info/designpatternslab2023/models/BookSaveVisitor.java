package ro.uvt.info.designpatternslab2023.models;
import com.fasterxml.jackson.databind.ObjectMapper;
public interface BookSaveVisitor extends Visitor{
    void saveToJson(String filename);

}
