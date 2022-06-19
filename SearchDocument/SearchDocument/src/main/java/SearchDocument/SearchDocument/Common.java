package SearchDocument.SearchDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class Common {
	public static List<String> stopWords = new ArrayList<String>();;
	public static List<String> filterInput(String input) {
		System.out.println("_____FILTER WORD_____");
		String result = "";
		result = input.replaceAll("[^a-zA-Z0-9]", " ");
		String[] listWord = result.split(" ");
		List<String> listFilter = new ArrayList<>(Arrays.asList(listWord));
		getStopword();
		for(int i = 0 ; i < stopWords.size() ; i ++ ) {
			System.out.println(stopWords.get(i));
			for(int j = 0 ; j < listFilter.size(); j ++ ) {
				if(stopWords.get(i).equals(listFilter.get(j))) {
					listFilter.remove(j);
					System.out.println(listFilter.size());
				}
			}
			
		}
		System.out.println("_____FILTER WORD END_____");
		return listFilter;
	}
	
	public static void getStopword(){
			System.out.println("______READ FILE_____");
			try {
				File file = new File("D:\\datav2final\\stopword.txt");
				   Scanner scanner = new Scanner(file);
				   while (scanner.hasNext()) {
				    String temp = scanner.next();
				    stopWords.add(temp);
				   }
				   scanner.close();
				  } catch (FileNotFoundException e) {
				   e.printStackTrace();
				  } 
		    
	}
}
