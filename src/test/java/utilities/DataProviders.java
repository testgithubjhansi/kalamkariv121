package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="loginData")
	Object [][] loginData() {
		Object data[][]= {
				{"Support@slkalamkari.com","Support@slkw#12","valid"},
				
		};
		return data;

}}
