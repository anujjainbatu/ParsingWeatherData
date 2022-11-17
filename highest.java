import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Author
 * @anujjainbatu
 */
public class highest {
    public CSVRecord getHighestofTwo(CSVRecord currentRow,CSVRecord highestSoFar,String prop) {
        if (highestSoFar == null) {
            highestSoFar = currentRow;
        } else {
            double currenTemp = Double.parseDouble(currentRow.get(prop));
            double highestTemp = Double.parseDouble(highestSoFar.get(prop));
            if (currenTemp > highestTemp) {
                highestSoFar = currentRow;
            }
        }
        return highestSoFar;
    }
    
    public CSVRecord warmestHourInDay(CSVParser parser) {
        CSVRecord highestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("TemperatureF")).equals("-9999"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "TemperatureF");
            }
        }
        return highestSoFar;
    }
    
    public CSVRecord warmestHour() {
        CSVRecord highestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = warmestHourInDay(fr.getCSVParser());
            if ((!(currentRow.get("TemperatureF")).equals("-9999"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "TemperatureF");
            }
        }
        return highestSoFar;
    }
    
    public void getWarmestHour() {
        CSVRecord highest = warmestHour();
        System.out.println("Highest Temperature was " + highest.get("TemperatureF") + " at " + highest.get("DateUTC"));
    }
    
    public CSVRecord maxHumidInDay(CSVParser parser) {
        CSVRecord highestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("Humidity")).equals("N/A"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "Humidity");
            }
        }
        return highestSoFar;
    }
    
    public CSVRecord maxHumid() {
        CSVRecord highestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = maxHumidInDay(fr.getCSVParser());
            if ((!(currentRow.get("Humidity")).equals("N/A"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "Humidity");
            }
        }
        return highestSoFar;
    }
    
    public void getMaxHumidHour() {
        CSVRecord highest = maxHumid();
        System.out.println("Maximum Humidity observered was " + highest.get("Humidity") + " at " + highest.get("DateUTC"));
    }
    
    public CSVRecord maxDewInDay(CSVParser parser) {
        CSVRecord highestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("Dew PointF")).equals("N/A"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "Dew PointF");
            }
        }
        return highestSoFar;
    }
    
    public CSVRecord maxDew() {
        CSVRecord highestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = maxDewInDay(fr.getCSVParser());
            if ((!(currentRow.get("Dew PointF")).equals("N/A"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "Dew PointF");
            }
        }
        return highestSoFar;
    }
    
    public void getMaxDewHour() {
        CSVRecord highest = maxDew();
        System.out.println("max Dew observered was " + highest.get("Dew PointF") + " at " + highest.get("DateUTC"));
    }
    
    public CSVRecord maxSeaPressureInDay(CSVParser parser) {
        CSVRecord highestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("Sea Level PressureIn")).equals("N/A"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "Sea Level PressureIn");
            }
        }
        return highestSoFar;
    }
    
    public CSVRecord maxSeaPressure() {
        CSVRecord highestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = maxSeaPressureInDay(fr.getCSVParser());
            if ((!(currentRow.get("Sea Level PressureIn")).equals("N/A"))) {
                highestSoFar = getHighestofTwo(currentRow, highestSoFar, "Sea Level PressureIn");
            }
        }
        return highestSoFar;
    }
    
    public void getMaxSeaLevelPressure() {
        CSVRecord highest = maxHumid();
        System.out.println("max Sea Level Pressure observered was " + highest.get("Sea Level PressureIn") + " at " + highest.get("DateUTC"));
    }
}
