
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;



	public class FbRegister {
	   WebDriver driver;
	   FbRegister(WebDriver d)
	   {
		   driver=d;
	   }
	   public void open()
	   {
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		   driver.get("https://www.facebook.com");
	   }
	   public void Month() throws IOException
	   {
		   FileInputStream fin=new FileInputStream("D:\\data.xlsx");
			XSSFWorkbook wb=new  XSSFWorkbook(fin);
			XSSFSheet ws=wb.getSheet("sheet7");
			Row row;
			
				row=ws.getRow(0);
				
				List<WebElement> lst=driver.findElements(By.xpath("//select[@id='month']/option"));
			    
			int i=1;
				for(int c=0;c<row.getLastCellNum();c++)
				{
					System.out.println(c);
				String str=String.valueOf(row.getCell(c).getStringCellValue());	
				
				if((lst.get(i++).getText()).equals(str))
				{
					Reporter.log("<font color='green'><b>"+String.valueOf(row.getCell(c).getStringCellValue())+"VALIDATED</b></font> ");
					System.out.println("validated");
				}
				}
		
	   }
		
	}

