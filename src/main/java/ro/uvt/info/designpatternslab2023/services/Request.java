package ro.uvt.info.designpatternslab2023.services;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Request<T> {
    private int id;
    private Command command;
    private boolean completed;
    private T result;

}
