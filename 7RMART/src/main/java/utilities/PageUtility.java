package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void confirmationAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}

	public void promptAlert(WebDriver driver) {
		driver.switchTo().alert().sendKeys("Jenisha");// for the text field
		driver.switchTo().alert().accept();
	}

	public void rightClick(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(dragableItem);
	}

	public void doubleClick(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(dragableItem);
	}

	public void moveElement(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(dragableItem);
	}

	public void dragandDrop(WebElement dragableItem, WebElement droppeditemlist, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragableItem, droppeditemlist);
	}

	public void jsExecuterClick(WebElement item, WebDriver driver) {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", item);

	}

	public void jsExecuterSendKeys(WebElement FieldItem, String value1, WebDriver driver) {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value=value1;", FieldItem);
	}

	public void jsScroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");

	}

	public static String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
}
