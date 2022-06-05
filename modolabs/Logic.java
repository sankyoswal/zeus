package modolabs;

import java.io.IOException;

public class Logic {
	public static void main(String[] args) throws InterruptedException, IOException { 

		String[] modules;
		int[] flags;
		String[][] data;
		int length = 0;

		Functions f = new Functions();
		Constants c = new Constants();		
		sheetReader sheet = new sheetReader();

		for (int j=0; j<c.sheets.length; j++) {

			if(c.sheets[j][1].equals("0"))
				continue;
			else {
				flags = f.getFlags(c.sheets[j][0]);
				if(flags == null) {
					System.out.println("Flags for " +c.sheets[j][0]+ " not found");
					continue;
				}

				sheet.fetchData(c.sheets[j][0]);
				modules = sheet.modules;
				data = sheet.data;

				//checking the number of modules in array are matching with the number of links
				if(modules.length != data.length) {
					System.out.println("Data length is not matching. Please check if all the data is present");
					System.exit(0);
				}
				else
					length = data.length; 

				for(int i=0; i<length; i++) {
					try {

						if(flags[i] == 0)
							continue;

						String url = data[i][0];
						String ext = data[i][1];
						f.initializeDriver();
						f.launch(url);
						f.newLink(c.ngrok, ext);

						if(f.verify()) {
							System.out.println(modules[i]+ "URL is already updated");
							if(f.isDeployed()) {
								System.out.println(modules[i]+ "is already deployed");
								//f.close();
								continue;
							}
							else {
								System.out.println(modules[i]+ " is not deployed, deploying now");
								f.deploy();
								//f.close();
								continue;
							}
						}

						else {		
							f.replace();
							f.save();
							f.deploy();
							//f.close();
						}
					}
					catch (Exception e) {
						System.out.println(e);
						continue;
					}
				}
			}

		}
	}
}