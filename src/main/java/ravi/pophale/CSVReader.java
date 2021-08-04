package ravi.pophale;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.opencsv.CSVWriter;


public class CSVReader {

    static Map<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
    	

        String csvFile = "testdata//data.csv";
        String line = "";
        String cvsSplitBy = ",";
        String allData = "";
        System.out.println("Available Stock");
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        try {
            while ((line = br.readLine()) != null) {
                String[] column = line.replace("\"","").split(cvsSplitBy);
                map.put(column[2], column[3]);
            } 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	br.close();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String brand = entry.getKey();
            String price = entry.getValue();
            System.out.println("Product [Brand= " + brand + " , Price=" + price + "]");
        }
        
        String word = JOptionPane.showInputDialog("Enter your Product Name");
        String qty = JOptionPane.showInputDialog("Enter your Product Quantity");
        int qtyInt = Integer.parseInt(qty);
        System.out.println("" + word);
        JFrame f = new JFrame(); ;
        
        if(map.containsKey(word)) {
        	System.out.println("" + map.get(word));
        	BufferedReader br2 = new BufferedReader(new FileReader(csvFile));
            try {
                while ((line = br2.readLine()) != null) {
                    String[] column = line.replace("\"","").split(cvsSplitBy);
                    if(column[2].equals(word)) { 
                    	int newQty = Integer.parseInt(column[4]) - qtyInt;
                    	if(newQty < 0) {
                    		System.out.println("Not enough stock");
                    		allData = allData + line + "\n";
                    	}
                    	else allData = allData + "\"" + column[0] + "\","+ "\"" + column[1] + "\"," + "\"" + column[2] + "\","+ "\"" + column[3] + "\","+ "\"" + newQty + "\"" + "\n";
                    }
                    else allData = allData + line + "\n";
                } 
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            	br.close();
            }
            if (allData.length() != 0) {
	            System.out.println(allData);
	            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
	            try {
	    			writer.write(allData);
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	            writer.close();
	            JOptionPane.showMessageDialog(f, "Order Successfully Placed!");
            }
        }else {
        	System.out.println("search fail");
        	JOptionPane.showMessageDialog(f, "Nahi det ja");
        }     
        
    }

}
