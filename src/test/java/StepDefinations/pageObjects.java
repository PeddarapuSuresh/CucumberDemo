package StepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Currencyformate;
import utility.ReadExcel;

public class pageObjects {

	WebDriver driver;

	// This is my assumption that i am taking this tag as parent of the all the
	// labels as table
	// label list/tables
	WebElement Labellist = driver.findElement(By.xpath("//*[@id='lblval']/table[1]/tbody"));

	By Label1 = By.id("lbl_val_1");
	By Label2 = By.id("lbl_val_1");
	By Label3 = By.id("lbl_val_1");
	By Label4 = By.id("lbl_val_1");
	By Label5 = By.id("lbl_val_1");

	// This is my assumption that i am taking this tag as parent of all the value as
	// table
	// prices
	WebElement pricelist = driver.findElement(By.xpath("//*[@id='value']/table[1]/tbody"));

	By price_label1 = By.id("txt_val_1");
	By price_label2 = By.id("txt_val_2");
	By price_label3 = By.id("txt_val_3");
	By price_label4 = By.id("txt_val_4");
	By price_label5 = By.id("txt_val_5");

	By totalLabels = By.id("lbl_ttl_val");
	By totallabels_prices = By.id("txt_ttl_val");

	public void Verifylandonpage(String Expectedpagetitle) {
		String Currentpage = driver.getTitle();

		Assert.assertEquals(Expectedpagetitle, Currentpage);
	}

	public void verifylabelsavalibility() {
		try {
			boolean element = driver.findElement(Label1).isDisplayed();
			if (element) {
				System.out.println("Labels are displaying on the page");
			} else {
				System.out.println("No labels are displaying on the page");
			}
		} catch (Exception e) {
			e.printStackTrace();

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File("images\\verifylabelsavalibility.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public void VerifyingLabel_Count(int Expected) {
		// Assuming My lables are under the list or table
		// So that i will use list to get the count

		try {
			List<WebElement> getcount = Labellist.findElements(By.tagName("tr"));

			int actualCount = getcount.size();

			System.out.println("My Labels avaliable in the application are  :" + actualCount);

			// Considering the Expected results of the count from the data file xlsx
			Expected = ReadExcel.get(1, 1);

			Assert.assertEquals(Expected, actualCount);

		} catch (Exception e) {
			e.printStackTrace();
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File("images\\VerifyingLabel_Count.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// Provide any value which is more than zero here from scenario file.
	public void VerifyValuesGreaterThanZero(int value) {

		try {
			List<WebElement> pricevalue = pricelist.findElements(By.tagName("tr"));
			for (int i = 0; i <= pricevalue.size(); i++) {

				WebElement p_val = driver
						.findElement(By.xpath("//*[@id='value']/table[1]/tbody/tr/td" + "[" + i + "]/text_val"));
				String price = Currencyformate.convertCurrencyToNbr(p_val.getText());
				double price_value = Double.parseDouble(price);
				if (price_value > value) {

					WebElement vallabel = driver
							.findElement(By.xpath("//*[@id='lblval']/table[1]/tbody/tr/td" + "[" + i + "]/lbl_val"));
					System.out.println("values on the screen are greater than 0 " + vallabel.getAttribute("value"));
				} else if (price_value == 0) {
					System.out.println(" All prices are 0");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File("images\\VerifyValuesGreaterThanZero.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void Verifytotalbalance() {

		try {
			double totalrecords = 0;

			List<WebElement> pricevalue = pricelist.findElements(By.tagName("tr"));
			for (int i = 0; i <= pricevalue.size(); i++) {

				WebElement p_val = driver
						.findElement(By.xpath("//*[@id='value']/table[1]/tbody/tr/td" + "[" + i + "]/text_val"));
				String price = Currencyformate.convertCurrencyToNbr(p_val.getText());
				double price_value = Double.parseDouble(price);

				totalrecords = totalrecords + price_value;

				System.out.println("total prices of all values are : " + totalrecords);

			}

			String actualprice = driver.findElement(totallabels_prices).getText();
			double actuals = Double.parseDouble(actualprice);
			Assert.assertEquals(totalrecords, actuals);
		} catch (Exception e) {
			e.printStackTrace();
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File("images\\Verifytotalbalance.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void currencyvalidator() {
		try {

			List<WebElement> pricevalue = pricelist.findElements(By.tagName("tr"));
			for (int i = 0; i <= pricevalue.size(); i++) {

				WebElement p_val = driver
						.findElement(By.xpath("//*[@id='value']/table[1]/tbody/tr/td" + "[" + i + "]/text_val"));
				String price = Currencyformate.convertCurrencyToNbr(p_val.getText());

				double price_value = Double.parseDouble(price);
				double formate = Currencyformate.currencytype(price_value);
				Assert.assertEquals(price_value, formate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File("images\\currencyvalidator.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	// Created constructor for Page objects
	public pageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void VerifyValuesarenull() {
		try {
			List<WebElement> pricevalue = pricelist.findElements(By.tagName("tr"));
			for (int i = 0; i <= pricevalue.size(); i++) {

				WebElement p_val = driver
						.findElement(By.xpath("//*[@id='value']/table[1]/tbody/tr/td" + "[" + i + "]/text_val"));
				String price = Currencyformate.convertCurrencyToNbr(p_val.getText());
				double price_value = Double.parseDouble(price);
				if (price.equals("Null")) {
					System.out.println("Labels with prices are displaying as null");
					Assert.assertTrue(false);
				} else if (price_value == 0) {
					System.out.println(" All prices are 0");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File("images\\VerifyValuesarenull.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
