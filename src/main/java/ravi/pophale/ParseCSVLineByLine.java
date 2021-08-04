package ravi.pophale;

import java.io.FileReader;
import java.util.Arrays;
 
import au.com.bytecode.opencsv.CSVReader;
 
public class ParseCSVLineByLine
{
   @SuppressWarnings("resource")
   public static void main(String[] args) throws Exception
   {
	   System.out.println("Available Stock");
      CSVReader reader = new CSVReader(new FileReader("testdata//data.csv"), ',' , '"' , 0);
       
    
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
         if (nextLine != null) {
           
        	
            System.out.println(Arrays.toString(nextLine));
         }
       }
   }
}
