import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.http.conn.BasicEofSensorWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.google.common.io.Files;
import com.thoughtworks.selenium.webdriven.commands.Click;

import jxl.read.biff.BiffException;

public class FireFoxInit {
	WebDriver driver;
	ExcelReader excelReader = new ExcelReader();
	List<ExcelHandler> list = new ArrayList<ExcelHandler>(excelReader.excelReader("E:\\ljy\\workspace\\FireFoxTest\\bugList.xls"));
	
	public void openFireFox(String url) {
		//打开浏览器，访问网址
		driver = new FirefoxDriver();
		driver.get(url);
	}

	public void createBug() throws InterruptedException{	
  
        //读取Excel
        
		Iterator<ExcelHandler> iterator = list.iterator();
		ExcelHandler excelHandler;
		
		while (iterator.hasNext()) {
			excelHandler = iterator.next();
			//登录
			
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys(excelHandler.getUserName()); //输入用户名
	        driver.findElement(By.name("password")).sendKeys(excelHandler.getPassWord()); //输入密码
	        Thread.sleep(1000);
	        //选择模式存储库
	        Select select_Schema = new Select(driver.findElement(By.name("schema")));
	        select_Schema.selectByVisibleText("sch_bug");
	        Thread.sleep(1000);
	        //选择数据库
	        Select select_UserDb = new Select(driver.findElement(By.name("userDb")));
	        select_UserDb.selectByVisibleText("ITS : 传输");
	        Thread.sleep(1000);
	        //点击登录
	        String mainHandle = driver.getWindowHandle();
	        System.out.println("mainHandle is " + mainHandle);
	        driver.findElement(By.className("tddark")).click();
	        Thread.sleep(1000);
	        
			WebElement topFrame = driver.findElement(By.name("bannerFrame"));  
	        //WebElement toolbarFrame = driver.findElement(By.id("toolbarIFrame")); 
			driver.switchTo().frame(topFrame);
			driver.switchTo().frame("toolbarIFrame");
	        driver.findElement(By.partialLinkText("新建")).click();
	        driver.switchTo().defaultContent();
	        WebElement childFrame = driver.findElement(By.name("contentFrame"));
	        driver.switchTo().frame(childFrame);
			
			String title = excelHandler.getTitle();
			driver.findElement(By.name("标题tab1")).sendKeys(title);
			//选择项目名称
			Select select_Product = new Select(driver.findElement(By.name("项目名称tab1")));
			String projet = excelHandler.getProject().trim();//trim裁剪掉两头的空格
			System.out.println(projet);
			//if(projet.equals("IPRAN产品 P100R002C10")) {
				//System.out.println("yes");
			//}
			//else {
				//System.out.println("NO");
			//}
			select_Product.selectByVisibleText(projet);
			driver.findElement(By.name("开发代表tab1CB")).sendKeys(excelHandler.getDeveloper());
			driver.findElement(By.name("产品系列tab1CB")).sendKeys(excelHandler.getProduct());
			
			Select select_firstC = new Select(driver.findElement(By.name("一级测试特性tab1")));
			String first = excelHandler.getFirstCharacteristic();
			System.out.println(first);
			select_firstC.selectByVisibleText(first);
			Thread.sleep(1000);
			
			Select select_SecondC = new Select(driver.findElement(By.name("二级测试特性tab1")));
			String second = excelHandler.getSecondCharacteristic();
			System.out.println(second);
			select_SecondC.selectByVisibleText(excelHandler.getSecondCharacteristic());
			Thread.sleep(1000);
			
			//发现版本
			driver.findElement(By.name("发现版本tab1LBSwitchableAnchor")).click();
			String[] handles = new String[driver.getWindowHandles().size()];
			driver.getWindowHandles().toArray(handles);
			for(String handle: handles) {
				System.out.println("Handles : " + handle);
			}
		
			WebDriver childWindow = driver.switchTo().window(handles[1]);
			System.out.println("1" + handles[1]);
			childWindow.findElement(By.name("choiceInput")).sendKeys(excelHandler.getVersion());
			childWindow.findElement(By.partialLinkText("添加")).click();
			childWindow.findElement(By.partialLinkText("确定")).click();
			Thread.sleep(1000);
			//切换到原来的句柄
			driver = childWindow.switchTo().window(handles[0]);
			System.out.println("0" + handles[0]);
			//切换到子Frame
			driver.switchTo().defaultContent();
		    driver.switchTo().frame(childFrame);
			driver.findElement(By.name("详细描述tab1")).sendKeys(excelHandler.getDescribe());
			
			//切换到基本信息二界面
			driver.findElement(By.partialLinkText("基本信息二")).click();
			
			Select select_Severity = new Select(driver.findElement(By.name("严重性tab2")));
			select_Severity.selectByVisibleText(excelHandler.getServerity());
			Select select_Type = new Select(driver.findElement(By.name("类别tab2")));
			select_Type.selectByVisibleText(excelHandler.getType());
			Select select_Re = new Select(driver.findElement(By.name("可复现性tab2")));
			select_Re.selectByVisibleText(excelHandler.getReproducibility());
			driver.findElement(By.name("测试用例编号tab2")).sendKeys(excelHandler.getTestCase());
			driver.findElement(By.name("测试方案名称tab2")).sendKeys(excelHandler.getTestSolution());
			
			//选择发现阶段
			Select select_Stage = new Select(driver.findElement(By.name("发现阶段newtab2")));
			String stage = excelHandler.getStage();
			System.out.println(stage);
			select_Stage.selectByVisibleText(stage);
			
			//切换到相关附件界面
			driver.findElement(By.partialLinkText("相关附件")).click();
			Thread.sleep(1000);
			
			//切割字符串
			StringTokenizer stringTokenizer = new StringTokenizer(excelHandler.getAttachment(), ";");
			int stringNum = stringTokenizer.countTokens();
			String attachment;
			//String attachmentName;
			//添加附件
			for(int i = 0; i < stringNum; i ++ ) {
				driver.findElement(By.partialLinkText("添加附件")).click();
				Thread.sleep(1000);
				String[] handles1 = new String[driver.getWindowHandles().size()];
				driver.getWindowHandles().toArray(handles1);
				WebDriver attachmentWindow = driver.switchTo().window(handles1[1]);
				attachment = stringTokenizer.nextToken();
				//attachmentName = Files.getNameWithoutExtension(attachment);//截取文件不带后缀的文件名
				System.out.println(attachment);
				attachmentWindow.findElement(By.name("userFile")).sendKeys(attachment);
				//attachmentWindow.findElement(By.name("userFileDesc")).sendKeys(attachmentName);//填写附件的名字
				attachmentWindow.findElement(By.partialLinkText("确定")).click();
				Thread.sleep(1000);
				
				//切换句柄
				driver = attachmentWindow.switchTo().window(handles1[0]);
				driver.switchTo().defaultContent();
			    driver.switchTo().frame(childFrame);
			}
			
			//driver.findElement(By.partialLinkText("保存")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(topFrame);
			driver.findElement(By.partialLinkText("注销")).click();
			
			driver = driver.switchTo().defaultContent();
		}
		closeFireFox();
	}
	//关闭浏览器
	public void closeFireFox(){
		driver.close();
	}

}
