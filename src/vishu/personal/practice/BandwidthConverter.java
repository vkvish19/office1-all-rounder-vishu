package vishu.personal.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BandwidthConverter {

	public static void main(String[] args)/* throws Exception, IOException */{
		BufferedReader br = null;
		System.out.println("b4 try");
		try{
			String inputFile = "C:\\Users\\vishwanath_k03\\Documents\\BandwidthConverterSampleInput.csv";
			br = new BufferedReader(new FileReader(inputFile));
			System.out.println("InputFile= " +inputFile);
			
			int lineCount = 0;
			String line = br.readLine();
			while(line != null){
				lineCount++;
				System.out.println("Line: " +line);
				line = br.readLine();
			}
			System.out.println("End of File.\nTotal Lines: " +lineCount);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		finally 
	       {
		   try {
		      if (br != null){
		    	  br.close();
		      }
		   } 
		   catch (IOException ioe){
			   System.out.println("Error in closing the BufferedReader");
		   }
		}
	}

}
