package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataFormatada {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  public static LocalDateTime stringParaLocalDateTime(String data){
    return LocalDateTime.parse(data, formatter);
  }

  public static String localDateTimeParaString(LocalDateTime data){
    return data.format(formatter);
  }

  public static LocalDateTime pegarLocalDateTime(String frase){
    String data = ConsoleUIHelper.askSimpleInput(frase);
    return stringParaLocalDateTime(data);

  }
}
