import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Author
 * @anujjainbatu
 */
public class lowest {
    public CSVRecord getLowestofTwo(CSVRecord currentRow,CSVRecord lowestSoFar,String prop) {
        if (lowestSoFar == null) {
            lowestSoFar = currentRow;
        } else {
            double currenTemp = Double.parseDouble(currentRow.get(prop));
            double lowestTemp = Double.parseDouble(lowestSoFar.get(prop));
            if (currenTemp < lowestTemp) {
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }
    
    public CSVRecord coldestHourInDay(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("TemperatureF")).equals("-9999"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "TemperatureF");
            }
        }
        return lowestSoFar;
    }
    
    public CSVRecord coldestHour() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInDay(fr.getCSVParser());
            if ((!(currentRow.get("TemperatureF")).equals("-9999"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "TemperatureF");
            }
        }
        return lowestSoFar;
    }
    
    public void getColdestHour() {
        CSVRecord lowest = coldestHour();
        System.out.println("Coldest Temperature was " + lowest.get("TemperatureF") + " at " + lowest.get("DateUTC"));
    }
    
    public CSVRecord leastHumidInDay(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("Humidity")).equals("N/A"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "Humidity");
            }
        }
        return lowestSoFar;
    }
    
    public CSVRecord leastHumid() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = leastHumidInDay(fr.getCSVParser());
            if ((!(currentRow.get("Humidity")).equals("N/A"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "Humidity");
            }
        }
        return lowestSoFar;
    }
    
    public void getLeastHumidHour() {
        CSVRecord lowest = leastHumid();
        System.out.println("Least Humidity observered was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
    
    public CSVRecord leastDewInDay(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("Dew PointF")).equals("N/A"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "Dew PointF");
            }
        }
        return lowestSoFar;
    }
    
    public CSVRecord leastDew() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = leastDewInDay(fr.getCSVParser());
            if ((!(currentRow.get("Dew PointF")).equals("N/A"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "Dew PointF");
            }
        }
        return lowestSoFar;
    }
    
    public void getLeastDewHour() {
        CSVRecord lowest = leastDew();
        System.out.println("Least Dew observered was " + lowest.get("Dew PointF") + " at " + lowest.get("DateUTC"));
    }
    
    public CSVRecord leastSeaPressureInDay(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            if ((!(currentRow.get("Sea Level PressureIn")).equals("N/A"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "Sea Level PressureIn");
            }
        }
        return lowestSoFar;
    }
    
    public CSVRecord leastSeaPressure() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = leastSeaPressureInDay(fr.getCSVParser());
            if ((!(currentRow.get("Sea Level PressureIn")).equals("N/A"))) {
                lowestSoFar = getLowestofTwo(currentRow, lowestSoFar, "Sea Level PressureIn");
            }
        }
        return lowestSoFar;
    }
    
    public void getLeastSeaLevelPressure() {
        CSVRecord lowest = leastHumid();
        System.out.println("Least Sea Level Pressure observered was " + lowest.get("Sea Level PressureIn") + " at " + lowest.get("DateUTC"));
    }
}
