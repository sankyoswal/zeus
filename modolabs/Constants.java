package ngrokUpdate;

public class Constants {

	//public String ngrok = "https://cf40-110-227-31-177.ngrok.io";
	
	public String ngrok = "https://04a4-136-232-247-226.ngrok.io";
	
	public static String sheetPath = "E:\\Sandbox links.xlsx";
//	public static String sheetPath = "E:\\Sandbox linkss.xlsx";
	//public String sheetName = "modo4v3";
	
	//following array decides which sandbox needs to be updated
	public String[][] sheets = {{"modo4v3","1"},{"modo4v2","0"},{"btw","1"},{"btwTest","1"}};

	//{index, adminHome, siteListing, timeSlots, adminListing, manage, upload, download, qr, buddy} - following array will decide which module will be updated
	public int[] modo4v3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	public int[] modo4v2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	public int[] btw =     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	public int[] btwTest = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
//	public String[][] sheets = {{"modo4v3","0"},{"modo4v2","1"},{"btw","0"},{"btwTest","0"}};
//	public int[] modo4v3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//	public int[] modo4v2 = {1, 1, 01, 1, 1, 1, 1, 1, 1, 1};
//	public int[] btw =     {1, 1, 0, 1, 1, 1, 1, 1, 1, 0};
//	public int[] btwTest = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	public String username = "sanket.oswal@zeuslearning.com";
	public String password = "Zeus@123";
}