import org.apache.commons.csv.CSVFormat;
import smile.classification.RandomForest;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.measure.NominalScale;
import smile.data.vector.IntVector;
import smile.data.vector.StringVector;
import smile.io.Read;

import java.io.IOException;
import java.net.URISyntaxException;

import static smile.io.Read.csv;

public class App {
    public static void main(String[] args) throws IOException {

        DataFrame trainData = readCSV("src/main/resources/data/titanic_train.csv");
        System.out.println("train data summary is"+trainData.summary());
        System.in.read();
        System.out.println("train data structure"+trainData.structure());

        System.out.println ("=======Encoding Non Numeric Data==============");
        trainData = trainData.merge(IntVector.of("encodedSex",encodeCategory(trainData,"Sex")));
        trainData = trainData.merge(IntVector.of("encodedPClass",encodeCategory(trainData,"Pclass")));
        System.out.println("trainData after encoding "+ trainData.structure());

        System.in.read();

        System.out.println ("=======Dropping non - encoded columns Column==============");
        trainData = trainData.drop("Name","Pclass","Sex");
        System.out.println("train data after dropping non-encoded columns"+trainData.structure());

        System.in.read();

        System.out.println("ommiting null rows");
        trainData = trainData.omitNullRows();
        System.out.println("data summary after ommiting null rows"+trainData.summary());

        System.in.read();

        System.out.println("training model by random Forest algorithm");

        RandomForest model =RandomForest.fit(Formula.lhs("Survived"),trainData);
        System.out.println("model importance is " +model.importance());
        System.out.println("model metrics is "+ model.metrics());

        System.in.read();

        System.out.println("preparing test data");

        DataFrame testData = readTestData("src/main/resources/data/titanic_test.csv");
        int[] result = model.predict(testData);
        for (int i : result)
        {

            System.out.println(i);
        }






    }

    //method for reading csv file
    public static DataFrame readCSV(String path)
    {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        DataFrame df = null;
        try
        {
            df = Read.csv(path,format);
            System.out.println("all data summary "+df.summary());
            df = df.select("Name","Pclass","Age","Sex","Survived");
            System.out.println("part of  data summary is" + df.summary());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (URISyntaxException e)
        {

            e.printStackTrace();
        }
        return df;
    }

    //method for encode any columns

    public static int[] encodeCategory(DataFrame df , String columnName)
    {
        String[] values = df.stringVector(columnName).distinct().toArray(new String[]{});
        int[] pclassValues = df.stringVector(columnName).factorize(new NominalScale(values)).toIntArray();
        return pclassValues;
     }

     public static DataFrame readTestData(String path)
     {

         CSVFormat format =CSVFormat.DEFAULT.withFirstRecordAsHeader();
         DataFrame df = null ;
         try {

             df =Read.csv(path,format);
             df = df.select("Pclass","Age","Sex");
             System.out.println("test data structure is " + df.structure());

             df = df.merge(IntVector.of("encodedSex", encodeCategory(df, "Sex")));
             //because in test data pclass column is int and we will transform to string
             df = df.merge(StringVector.of("stringPclass",df.intVector("Pclass").toStringArray()));
             df = df.merge(IntVector.of("encodedPClass", encodeCategory(df, "stringPclass")));
             df = df.drop("Pclass","Sex","stringPclass");
             df = df.omitNullRows();
             System.out.println("test data structure after encoding " + df.structure());

         }
         catch (IOException e)
            {
             e.printStackTrace();
            }
         catch (URISyntaxException e)
            {
                e.printStackTrace();
            }
         return df ;

     }



}
