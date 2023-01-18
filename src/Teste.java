import java.time.LocalDateTime;

import util.DataFormatada;

public class Teste {
  public static void main(String[] args) {
    
    LocalDateTime data1 = DataFormatada.stringParaLocalDateTime("22/07/1994 12:00");
    
    LocalDateTime data2 = DataFormatada.stringParaLocalDateTime("23/07/1994 12:00");

    System.out.println(data1.isAfter(data2));
  }
  
}
