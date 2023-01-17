import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import util.Data;

public class Teste {
  public static void main(String[] args) {

    String data1 = "22/07/1994 23:00";
    String data2 = "22/07/1995 23:00";
    
    LocalDateTime dataBefore = Data.stringParaLocalDateTime(data1);
    LocalDateTime dataAfter = Data.stringParaLocalDateTime(data2);
    
    long daysBetween = ChronoUnit.DAYS.between(dataBefore, dataAfter);

    System.out.println(daysBetween);
    
  }
  
}
