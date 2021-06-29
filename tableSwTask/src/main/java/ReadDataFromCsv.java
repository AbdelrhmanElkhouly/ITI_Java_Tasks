import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import java.util.ArrayList;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ReadDataFromCsv {

    public static void main(String[] args)throws IOException
    {

        Table titanicDf = readTableFromCsv("D:\\iti\\java\\JUPAI5_Examples\\titanic.csv");
       // to remove duplicates and missing values
        titanicDf.dropDuplicateRows();
        titanicDf.dropRowsWithMissingValues();
        //to get only last 3 rows in DF
       System.out.println("last 3 rows in titanic df "+ titanicDf.last(3));
        //to get first 3 rows in DF
        System.out.println("first  3 rows in titanic df "+ titanicDf.first(3));

        //to print all data frame
        //System.out.println(titanicDf);
        System.out.println("columns names is "+titanicDf.columnNames());

        System.in.read();

        System.out.println("structure of titanic data frame and columns details" +titanicDf.structure() );

        System.in.read();

        System.out.println("to see summary about data for every column " + titanicDf.summary());

        System.in.read();

        Table titanicDf1 = titanicDf.select("name","sex","age","cabin");
        // to remove duplicates and missing values
        titanicDf1.dropDuplicateRows();
        titanicDf1.dropRowsWithMissingValues();
        System.out.println("titanic df1 summary is "+titanicDf1.summary());

        Table titanicDf2 = titanicDf.retainColumns("name","survived","parch","sibsp");
        titanicDf2.dropDuplicateRows();
        titanicDf2.dropRowsWithMissingValues();
        System.out.println("titanic df2 summary is "+titanicDf2.summary());

        System.in.read();

        //to join 2 dataFrames together
        System.out.println("result of joining 2 dataFrames"+titanicDf1.joinOn("name").fullOuter(titanicDf2));

        System.in.read();

        Table vgsalesDf = readTableFromCsv("D:\\iti\\java\\JUPAI5_Examples\\vgsales.csv");

        Table newData = addDatColumn(vgsalesDf);
        System.out.println("sumarry of new table after adding date column"+newData.summary());

        System.out.println("concat 2 DFs with condition the same raw number ."+titanicDf1.retainColumns("sex","age","cabin").first(5).concat(vgsalesDf.first(5)));

    }
    //function to read csv file
    public static Table readTableFromCsv(String path)throws IOException
    {
        Table df = Table.read().csv(path);
        return df;

   }
    //function for adding date column
    public static Table addDatColumn(Table data)
    {
        int rowCount=data.rowCount();
        List<LocalDate> dateList=new ArrayList<LocalDate>();
        for(int i=0;i<rowCount;i++)
        {
            dateList.add(LocalDate.of(2021, 3, i%31==0?1:i%31));
        }
        DateColumn dateColumn= DateColumn.create("Fake Date",dateList);
        data.insertColumn(data.columnCount(),dateColumn);
        return data;
    }
    }

