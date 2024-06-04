//This class has the actions on the elements of the homepage

package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {

	ElementFetch ele = new ElementFetch();

	public void signInButton() {

		ele.getWebElement("XPATH", HomePageElements.signInButtonText).click();
	}
}
