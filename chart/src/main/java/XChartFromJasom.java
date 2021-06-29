import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.colors.ChartColor;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class XChartFromJasom {

    public static void main(String[] args) {
        XChartFromJasom xChartFromJason = new XChartFromJasom();

        List<TitanicPassenger> allPassengers = xChartFromJason.readPassengerFromJasonFile();
        xChartFromJason.graphPassengerAges(allPassengers);
        try {

            System.in.read();

        }
        catch (IOException ex)
        {
            Logger.getLogger(XChartFromJasom.class.getName()).log(Level.SEVERE, null, ex);
        }
        xChartFromJason.graphPassengerClass(allPassengers);

    }
public List<TitanicPassenger> readPassengerFromJasonFile()
{
    List<TitanicPassenger> allPassengers = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    try(InputStream input = new FileInputStream("D:\\iti\\java\\titanic_csv.json"))
    {
        allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>() {});

    }
    catch (FileNotFoundException e)
    {
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace ();
    }
    return allPassengers;
}

public void graphPassengerAges(List<TitanicPassenger> passengerList)
{

    List<Float> pAges = passengerList.stream()
            .map(TitanicPassenger::getAge).limit(10).collect(Collectors.toList());

    List<String> pNames = passengerList.stream()
            .map(TitanicPassenger::getName).limit(10).collect(Collectors.toList());

    CategoryChart chart = new CategoryChartBuilder().width(1024)
            .height(768).title("age histogram")
            .xAxisTitle("names").yAxisTitle("ages").build();
    //let customized chart to default values
    chart.addSeries("passengers ages ",pNames,pAges);
    //to show it
    new SwingWrapper(chart).displayChart();
}

public void graphPassengerClass(List<TitanicPassenger> passengerList)
{
    Map<String,Long> result =
            passengerList.stream().collect(
                    Collectors.groupingBy(
                            TitanicPassenger::getPclass,Collectors.counting()
                    )
            );
    PieChart chart = new PieChartBuilder().width(800).height(600)
            .title(getClass().getSimpleName()).build();

    Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
    chart.getStyler().setSeriesColors(sliceColors);

    // Series
     chart.addSeries("First Class", result.get("1"));
     chart.addSeries("Second Class", result.get("2"));
     chart.addSeries("Third Class", result.get("3"));
     // Show it
    new SwingWrapper(chart).displayChart();
}

}
