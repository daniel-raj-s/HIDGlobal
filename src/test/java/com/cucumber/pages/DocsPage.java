package com.cucumber.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.utils.CommonUtils;

public class DocsPage extends CommonUtils{
	
	public DocsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By btn_Docs = By.linkText("Docs");
	
	
	
	public void clickDocsTab() {
		try {
			getElement(btn_Docs).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void expandSection(String tabName) {
		By btn_section = By.xpath("//div[text()='"+tabName+"']");
		try {
			getElement(btn_section).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writeSubElementsIntoFile(String tabName) {
		By btn_section = By.xpath("//div[text()='"+tabName+"']");
		try {
			getElement(btn_section).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void storeSubmenusInTextFile(String URL, String sectionName) {
		 try {
			writer = new FileWriter(path +"\\"+sectionName+" Sub Menu"+".txt",false);
			
			By lst_element = By.xpath("//div[text()='"+sectionName+"']/../following-sibling::ul/li/a");
			
			List<WebElement> listOfElement = getElements(lst_element);
			
			for(WebElement ele: listOfElement) {
				writeTextToFile(writer,getText(ele)+" - "+ele.getAttribute("href"));
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void highLightSubElement(String tabName) {
		By lst_element = By.xpath("//div[text()='"+tabName+"']/../following-sibling::ul/li");
		try {
			List<WebElement> listOfElement = getElements(lst_element);
			
			for(WebElement ele: listOfElement) {
				highLightElement(ele);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
