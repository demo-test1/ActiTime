package qsp;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest {

	@Parameters({"city", "area"})
	@Test
	public void testA(String city, String area)
	{
		Reporter.log(city,true);
		//city is provided in xml
		Reporter.log(area,true);
	}
}
