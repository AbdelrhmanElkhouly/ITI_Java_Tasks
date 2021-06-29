import jdk.jfr.DataAmount;
import joinery.DataFrame;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataExploration {

    public static void main(String[] args) throws IOException {

     //reading titanic data frame from csv file
        DataFrame<Object> titanicDf = DataFrame.readCsv("D:\\iti\\java\\JUPAI5_Examples\\titanic.csv")
                .retain("age", "name", "ticket", "sex");
        //if i want to print all dta frame
        //  titanicDf.iterrows().forEachRemaining(System.out::println);

        //column age from the data frame
        List<Object> age = titanicDf.col("age");


        DataFrame<Object> vgSalesDf = DataFrame.readCsv("D:\\iti\\java\\JUPAI5_Examples\\vgsales.csv")
                //reading only some columns from data frame
                .retain("Year", "NA_Sales", "EU_Sales", "JP_Sales")
                //join 2 different  data frames together in 1 table
                .join(titanicDf)
                //only show first 5 row
                .head(5)
                //add an column to the joined 2 data frames of type object
                .add(age);
        System.out.println("result of join 2 df plus age column together");
        vgSalesDf.iterrows().forEachRemaining(System.out::println);

        System.in.read();
        // if i want all basic inf0

 System.out.println("all basic info about vg sales df"+vgSalesDf.describe());

 System.in.read();
        //if i want to show last 5 raw instead
        System.out.println("last 5 rows in titanic df"+titanicDf.tail(5));


        System.in.read();
        DataFrame<Object> vgSalesDf1 = DataFrame.readCsv("D:\\iti\\java\\JUPAI5_Examples\\vgsales.csv")
                .retain("Year", "NA_Sales", "EU_Sales", "JP_Sales","Global_Sales")
                .groupBy(r -> r.get(0));
        System.out.println("all columns grouped by year "+vgSalesDf1);

        System.out.println("max value in titanic df "+titanicDf.max());
        System.in.read();
        System.out.println("min value in titanic df "+titanicDf.min());
        System.in.read();
        System.out.println("standard deviation value in titanic df "+titanicDf.stddev());
        System.in.read();
        System.out.println("mean value in titanic df "+titanicDf.mean());

        System.in.read();

        DataFrame<Object> df2 = DataFrame.readCsv("D:\\iti\\java\\JUPAI5_Examples\\df2.csv");

        DataFrame<Object> df1 = DataFrame.readCsv("D:\\iti\\java\\JUPAI5_Examples\\df1.csv");
               System.out.println("result of merge 2 data frames is "+df1.merge(df2));



    }


    }




