//This is an interface with all the xpath of the textboxes and the buttons

package pageObjects;

public interface LoginPageElements {

	String loginText ="//div[contains(text(),'Login')]";
	String emailAddress="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]";
	String passwordField = "//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]";
}
