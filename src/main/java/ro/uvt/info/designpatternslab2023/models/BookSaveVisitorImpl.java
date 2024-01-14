package ro.uvt.info.designpatternslab2023.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class BookSaveVisitorImpl implements BookSaveVisitor{
    private ArrayNode jsonElements = new ObjectMapper().createArrayNode();
    @Override
    public void saveToJson(String filename) {
        try {
            new ObjectMapper().writeValue(new File(filename), jsonElements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveElementToJson(String type, String data) {
        ObjectNode elementNode = new ObjectMapper().createObjectNode();
        elementNode.put("type", type);
        elementNode.put("data", data);
        jsonElements.add(elementNode);
    }
    @Override
    public void visitBook(Book book) {
        saveElementToJson(book.getClass().getSimpleName(), book.getTitle());
    }

    @Override
    public void visitSection(Section section) {
        ObjectNode sectionNode = new ObjectMapper().createObjectNode();
        sectionNode.put("type", section.getClass().getSimpleName());
        sectionNode.put("title", section.getTitle());

        ArrayNode elementsNode = new ObjectMapper().createArrayNode();
        for (Element element : section.el) {
            if (element instanceof Paragraph || element instanceof ImageProxy ||
                    element instanceof Image || element instanceof Table) {
                element.accept(this);
                elementsNode.add(jsonElements.get(jsonElements.size() - 1));
            }
    }
        sectionNode.set("elements", elementsNode);
        jsonElements.add(sectionNode);}

    @Override
    public void visitTableOfContents(TableOfContents table) {
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        saveElementToJson(paragraph.getClass().getSimpleName(), paragraph.getText());
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        saveElementToJson(imageProxy.getClass().getSimpleName(), imageProxy.getUrl());
    }

    @Override
    public void visitImage(Image image) {
        saveElementToJson(image.getClass().getSimpleName(), image.getImageName());
    }

    @Override
    public void visitTable(Table table) {
        saveElementToJson(table.getClass().getSimpleName(), table.getTitle());
    }
}
