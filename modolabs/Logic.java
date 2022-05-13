package ngrokUpdate;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Logic {
	public static void main(String[] args) throws InterruptedException, IOException { 

		String[] modules;
		String[][] data;
		int length = 0;

		Functions f = new Functions();
		Constants c = new Constants();

		sheetReader sheet = new sheetReader();
		sheet.fetchData(c.sheetName);
		//sheet.display();

		modules = sheet.modules;
		data = sheet.data;

		//checking the number of modules in array are matching with the number of links
		if(modules.length != data.length) {
			System.out.println("Data length is not matching");
			System.exit(0);
		}
		else 
			length = modules.length; 


		for(int i=0; i<length; i++) {

			String url = data[i][0];
			String ext = data[i][1];

			f.initializeDriver();
			f.launch(url);
			f.newLink(c.ngrok, ext);

			if(f.verify()) {
				System.out.println("Link is upto date for module = " +modules[i]);
				f.close();
				continue;
			}
			else {		
				f.replace();
				f.save();
				f.deploy();
				f.close();
			}





		}





	}
}