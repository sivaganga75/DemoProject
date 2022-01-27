package com.buffalocart.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.buffalocart.pages.ForgotPasswordPage;
import com.buffalocart.pages.Login;
import com.buffalocart.utility.DataRead;

public class ForgotPasswordTestCase extends TestBase{
	DataRead dataRead = new DataRead(driver);
	Login loginPage;
	ForgotPasswordPage forgotPasswordPage;
	
	@Test
	public void forgotPasswordTestCase() throws IOException {
		forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.forgotPassword();
	}

}

