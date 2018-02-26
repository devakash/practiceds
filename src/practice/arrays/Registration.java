package practice.arrays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





public class Registration extends oracle.jdbc.driver.OracleDriver{
	
	static String dbURL="jdbc:oracle:thin:pal/pal@//192.168.211.161:1521/indqa41";
	static String dbUname="read";
	static String dbPass="read";

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajain5\\Downloads\\chromedriver.exe");
	}

	public static void main(String[] args) throws Exception {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://l1mmhtmlmc.corp.yodlee.com:2443/moneycenter/mfalogin.yodlee.do");
		
		//Main line
		///driver.get("https://mainhtmlmc.corp.yodlee.com:1443/apps/mfalogin.ymc.do");
		driver.findElement(By.name("signup")).click();
		Thread.sleep(5000);

		//Calendar c=Calendar.getInstance();
		//String s="Migration"+c.getTimeInMillis();
		String s="integration";
		System.out.println(s);
		
		driver.findElement(By.name("LOGIN_NAME")).sendKeys(s);
		driver.findElement(By.name("PASSWORD")).sendKeys("Yodlee@123");
		driver.findElement(By.name("VERIFY_PASSWORD")).sendKeys("Yodlee@123");

		driver.findElement(By.id("pma0")).sendKeys("1");
		driver.findElement(By.id("pma1")).sendKeys("1");
		driver.findElement(By.id("pma2")).sendKeys("1");

		driver.findElement(By.name("pmi")).click();
		driver.findElement(By.id("name_image")).sendKeys("alliswell");

		driver.findElement(By.id("FIRST_NAME")).sendKeys("groupsetting");
		driver.findElement(By.id("LAST_NAME")).sendKeys("automation");

		driver.findElement(By.id("dropdown_COUNTRY")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//div[@id='custom_div_COUNTRY']//li[2]")).click();

		driver.findElement(By.id("ADDRESS_1")).sendKeys("New York City");
		driver.findElement(By.id("CITY")).sendKeys("New York");
		driver.findElement(By.id("ZIP_CODE_1")).sendKeys("12345");

		driver.findElement(By.id("EMAIL")).sendKeys("l2automation@yodlee.com");

		driver.findElement(By.id("customDropdownHolder_PREFERRED_DATE_FORMAT")).click();
		driver.findElement(By.xpath("//div[contains(@id,'custom_div_PREFERRED_DATE_FORMAT')]//li[1]")).click();

		driver.findElement(By.id("ESIGN_TNC")).click();
		driver.findElement(By.id("TNC")).click();
		driver.findElement(By.id("LEGAL_AGE")).click();
		driver.findElement(By.id("US_RESIDENT")).click();
		driver.findElement(By.id("SHARE_MY_DATA")).click();
		driver.findElement(By.id("Register")).click();

		driver.findElement(By.id("customDropdownHolder_STATE")).click();

		driver.findElement(By.xpath("//div[@id='custom_div_STATE']//li[2]")).click();
		driver.findElement(By.id("Register")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Submit")).click();
		String code=dbConnect(s);
		Thread.sleep(2500);
		driver.findElement(By.id("emailConfirmationCode")).sendKeys(code);
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		Thread.sleep(2500);
		driver.findElement(By.name("continue")).click();
		Thread.sleep(2500);
		
	}

	public static String dbConnect(String s) throws SQLException
	{
		String verifyCode="";
		Connection conn = DriverManager.getConnection(dbURL, dbUname, dbPass);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select verification_code from mem_alert_dest where mem_id in(select mem_id from mem where mem.login_name='"+s+"')");
		if(rs.next())
		{
			verifyCode=rs.getString("verification_code");
		}
		
		return verifyCode;
	}
	
}
