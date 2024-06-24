package week1.day2;

public class Browser {
	
	public String launchBrowser(String browserName)
	{
		System.out.println("Browser launched successfully");
		System.out.println(browserName);
		return browserName;
	}
	
	public void loadUrl()
	{
		System.out.println("Application url loaded successfully");
		
	}

 
	public static void main(String[] args) {
		Browser obj = new Browser();
		obj.launchBrowser("Chrome");
		obj.loadUrl();

	}


}
