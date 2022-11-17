import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Author
 * @anujjainbatu
 */
public class average {
    public double average(CSVParser parser,String prop) {
    double tempSum = 0.0;
    int count = 0;
    for(CSVRecord currentRow : parser) {
        if ((!(currentRow.get("TemperatureF")).equals("-9999")) && (!(currentRow.get("Humidity")).equals("N/A")) && (!(currentRow.get("Dew PointF")).equals("N/A")) && (!(currentRow.get("Sea Level PressureIn")).equals("N/A"))) {
            tempSum += Double.parseDouble(currentRow.get(prop));
            count++;
        } else {System.out.println("Some Weather Data is Missing");return 0.0;}
    }
    return tempSum/count;
    }
    
    public void getAveragePerimeter() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        Double aveTemp = average(parser, "TemperatureF");
        System.out.println("Average Temp was " + aveTemp);
        
        parser = fr.getCSVParser();
        Double aveHumid = average(parser, "Humidity");
        System.out.println("Average Humidity was " + aveHumid);
        
        parser = fr.getCSVParser();
        Double aveDew = average(parser, "Dew PointF");
        System.out.println("Average Dew was " + aveDew);
        
        parser = fr.getCSVParser();
        Double avePress = average(parser, "Sea Level PressureIn");
        System.out.println("Average Sea Level Pressure was " + avePress);
    }
}
