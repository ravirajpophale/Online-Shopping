package ravi.pophale;

import java.awt.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVWriter;

import au.com.bytecode.opencsv.CSVReader;

public class writedatatoCSV {

	public static void main(String[] args) throws IOException {
		
		CSVWriter write = new CSVWriter(new FileWriter("testdata//sample.csv"));
		
		String set1[] =  {"Product Code", "Name", "Brand", "Price", "Stock available"};
		String set2[] =  {"P001", "Samsung", "Galexy S4", "65000", "500"};
		String set3[] =  {"P002", "Apple", "iPhone 12", "80000", "100"};
		String set4[] =  {"P003", "Allen Solly", "T-Shirt", "1200", "1500"};
		String set5[] =  {"P004", "LP", "Formal Shirt", "2000", "100"};
		

		ArrayList list = new ArrayList();
		list.add(set1);
		list.add(set2);
		list.add(set3);	
		list.add(set4);
	
		list.add(set5);
		write.writeAll(list);
		write.flush();
		
		System.out.println("Data Entered");
		
//...................................................................................		
		   System.out.println("Available Stock");
		      CSVReader reader = new CSVReader(new FileReader("testdata//data.csv"), ',' , '"' , 0);
		       
		    
		      String[] nextLine;
		      while ((nextLine = reader.readNext()) != null) {
		         if (nextLine != null) {
		           
		        	
		            System.out.println(Arrays.toString(nextLine));
		         }}
		
	}

}
