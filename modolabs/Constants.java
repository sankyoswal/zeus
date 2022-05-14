package ngrokUpdate;

public class Constants {

	//public String ngrok = "https://cf40-110-227-31-177.ngrok.io";
	public String ngrok = "https://04a4-136-232-247-226.ngrok.io";
	
	//Path of the excel sheet
	public static String sheetPath = "E:\\Sandbox links.xlsx";
	//public static String sheetPath = "E:\\Sandbox linkss.xlsx";
	
	//following array decides which sandbox needs to be updated
	public String[][] sheets = {{"modo4v3","1"},{"modo4v2","0"},{"btw","1"},{"btwTest","1"}};

	//following array will decide which module will be updated
	//{index, adminHome, siteListing, timeSlots, adminListing, manage, upload, download, qr, buddy}
	public int[] modo4v3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	public int[] modo4v2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	public int[] btw =     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	public int[] btwTest = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};

	public String username = "sanket.oswal@zeuslearning.com";
	public String password = "Zeus@123";
}
