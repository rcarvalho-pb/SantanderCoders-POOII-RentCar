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

  public static Boolean dataRetiradaValida(String dataRetirada){
    if(DataFormatada.stringParaLocalDateTime(dataRetirada).isBefore(LocalDateTime.now())) return false;
    return true;
  }

  public static Boolean dataDevolucaoAnteriorRetirada(String dataRetirada, String dataDevolucao){
    if (DataFormatada.stringParaLocalDateTime(dataDevolucao).isBefore(DataFormatada.stringParaLocalDateTime(dataRetirada))){
      System.out.println("Data inválida. Não é possível devolver o carro antes de alugar. ");
      return false;
    }
    return true;
  }
}
