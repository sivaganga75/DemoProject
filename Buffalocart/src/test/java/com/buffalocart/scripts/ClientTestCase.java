package com.buffalocart.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.buffalocart.pages.ClientPage;
import com.buffalocart.pages.Login;
import com.buffalocart.utility.DataRead;
import com.buffalocart.utility.ExcelUtility;

public class ClientTestCase extends TestBase{
	DataRead dataRead = new DataRead(driver);
	ExcelUtility excelUtility = new ExcelUtility();
	Login loginPage;
	ClientPage clientsPage;
	
	ArrayList<String> clients = new ArrayList<String>();
	ArrayList<String> contacts = new ArrayList<String>();
	
	ArrayList<String> clientsFilter = new ArrayList<String>();
	
	@Test
	public void goToClientTestCase() {
		clientsPage = new ClientPage(driver);
		clientsPage.goToClient();
	}
	
	@Test
	public void goToContactsTestCase() {
		clientsPage.goToContacts();
	}
	
	@Test
	public void addClientAndContacts() throws IOException {	
		clients=excelUtility.readExcel(1, "AddClient");
		contacts=excelUtility.readExcel(1, "ClientContacts");
        clientsPage.addClientAndContacts(clients, contacts);	
	}
	
	/*
	 * @Test public void filteringClientsTestCase() throws IOException {
	 * clientsFilter=excelUtility.readExcel(1, "QuickFiltersClient");
	 * clientsPage.filteringClients(clientsFilter); }
	 */
	
	@Test
	public void downloadExcelContractsTestCase() throws IOException {
		clientsPage.downloadExcelClientsFile();
	}

}

