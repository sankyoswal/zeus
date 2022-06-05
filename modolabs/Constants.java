package modolabs;

public class Constants {

	public String ngrok = "https://2c2e-27-57-255-175.ngrok.io";
	
	public static String sheetPath = "E:\\Sandbox links.xlsx";
//	public static String sheetPath = "E:\\Sandbox links(archita).xlsx";
	//public String sheetName = "modo4v3";
	
	//following array decides which sandbox needs to be updated
	public String[][] sheets = {{"modo4v3","0"},{"modo4v2","0"},{"btw","1"},{"btwTest","0"}};

	//following array will decide which module will be updated
	//{index, adminHome, siteListing, timeSlots, adminListing, manage, upload, download, qr, buddy}
	public int[] modo4v3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	public int[] modo4v2 = {1, 0, 1, 1, 0, 0, 0, 0, 0, 0};
//	public int[] btw =     {1, 0, 1, 1, 0, 0, 0, 0, 0, 0};
	public int[] btwTest = {1, 0, 1, 1, 0, 0, 0, 0, 0, 0};
	public int[] btw = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};

	public String username = "sanket.oswal@zeuslearning.com";
	public String password = "Zeus@123";
}