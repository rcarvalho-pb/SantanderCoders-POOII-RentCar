package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataFormatada {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");

    static public LocalDateTime data(String data){
        return LocalDateTime.parse(data, formatter);
    }
}
