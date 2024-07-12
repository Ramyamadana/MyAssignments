package week1.day2.classassignment;

public class Browser {
	
	//Method returns browser name

	public String launchBrowser(String browserName) {
		System.out.println("Browser launched successfully");
		System.out.println(browserName);
		return browserName;
	}

	//Method prints application url loaded message 
	public void loadUrl() {
		System.out.println("Application url loaded successfully");

	}

	//Object creation and method access
	public static void main(String[] args) {
		Browser obj = new Browser();
		obj.launchBrowser("Chrome");
		obj.loadUrl();
	}

}
