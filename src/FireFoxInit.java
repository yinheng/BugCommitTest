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
		//���������������ַ
		driver = new FirefoxDriver();
		driver.get(url);
	}

	public void createBug() throws InterruptedException{	
  
        //��ȡExcel
        
		Iterator<ExcelHandler> iterator = list.iterator();
		ExcelHandler excelHandler;
		
		while (iterator.hasNext()) {
			excelHandler = iterator.next();
			//��¼
			
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys(excelHandler.getUserName()); //�����û���
	        driver.findElement(By.name("password")).sendKeys(excelHandler.getPassWord()); //��������
	        Thread.sleep(1000);
	        //ѡ��ģʽ�洢��
	        Select select_Schema = new Select(driver.findElement(By.name("schema")));
	        select_Schema.selectByVisibleText("sch_bug");
	        Thread.sleep(1000);
	        //ѡ�����ݿ�
	        Select select_UserDb = new Select(driver.findElement(By.name("userDb")));
	        select_UserDb.selectByVisibleText("ITS : ����");
	        Thread.sleep(1000);
	        //�����¼
	        String mainHandle = driver.getWindowHandle();
	        System.out.println("mainHandle is " + mainHandle);
	        driver.findElement(By.className("tddark")).click();
	        Thread.sleep(1000);
	        
			WebElement topFrame = driver.findElement(By.name("bannerFrame"));  
	        //WebElement toolbarFrame = driver.findElement(By.id("toolbarIFrame")); 
			driver.switchTo().frame(topFrame);
			driver.switchTo().frame("toolbarIFrame");
	        driver.findElement(By.partialLinkText("�½�")).click();
	        driver.switchTo().defaultContent();
	        WebElement childFrame = driver.findElement(By.name("contentFrame"));
	        driver.switchTo().frame(childFrame);
			
			String title = excelHandler.getTitle();
			driver.findElement(By.name("����tab1")).sendKeys(title);
			//ѡ����Ŀ����
			Select select_Product = new Select(driver.findElement(By.name("��Ŀ����tab1")));
			String projet = excelHandler.getProject().trim();//trim�ü�����ͷ�Ŀո�
			System.out.println(projet);
			//if(projet.equals("IPRAN��Ʒ P100R002C10")) {
				//System.out.println("yes");
			//}
			//else {
				//System.out.println("NO");
			//}
			select_Product.selectByVisibleText(projet);
			driver.findElement(By.name("��������tab1CB")).sendKeys(excelHandler.getDeveloper());
			driver.findElement(By.name("��Ʒϵ��tab1CB")).sendKeys(excelHandler.getProduct());
			
			Select select_firstC = new Select(driver.findElement(By.name("һ����������tab1")));
			String first = excelHandler.getFirstCharacteristic();
			System.out.println(first);
			select_firstC.selectByVisibleText(first);
			Thread.sleep(1000);
			
			Select select_SecondC = new Select(driver.findElement(By.name("������������tab1")));
			String second = excelHandler.getSecondCharacteristic();
			System.out.println(second);
			select_SecondC.selectByVisibleText(excelHandler.getSecondCharacteristic());
			Thread.sleep(1000);
			
			//���ְ汾
			driver.findElement(By.name("���ְ汾tab1LBSwitchableAnchor")).click();
			String[] handles = new String[driver.getWindowHandles().size()];
			driver.getWindowHandles().toArray(handles);
			for(String handle: handles) {
				System.out.println("Handles : " + handle);
			}
		
			WebDriver childWindow = driver.switchTo().window(handles[1]);
			System.out.println("1" + handles[1]);
			childWindow.findElement(By.name("choiceInput")).sendKeys(excelHandler.getVersion());
			childWindow.findElement(By.partialLinkText("���")).click();
			childWindow.findElement(By.partialLinkText("ȷ��")).click();
			Thread.sleep(1000);
			//�л���ԭ���ľ��
			driver = childWindow.switchTo().window(handles[0]);
			System.out.println("0" + handles[0]);
			//�л�����Frame
			driver.switchTo().defaultContent();
		    driver.switchTo().frame(childFrame);
			driver.findElement(By.name("��ϸ����tab1")).sendKeys(excelHandler.getDescribe());
			
			//�л���������Ϣ������
			driver.findElement(By.partialLinkText("������Ϣ��")).click();
			
			Select select_Severity = new Select(driver.findElement(By.name("������tab2")));
			select_Severity.selectByVisibleText(excelHandler.getServerity());
			Select select_Type = new Select(driver.findElement(By.name("���tab2")));
			select_Type.selectByVisibleText(excelHandler.getType());
			Select select_Re = new Select(driver.findElement(By.name("�ɸ�����tab2")));
			select_Re.selectByVisibleText(excelHandler.getReproducibility());
			driver.findElement(By.name("�����������tab2")).sendKeys(excelHandler.getTestCase());
			driver.findElement(By.name("���Է�������tab2")).sendKeys(excelHandler.getTestSolution());
			
			//ѡ���ֽ׶�
			Select select_Stage = new Select(driver.findElement(By.name("���ֽ׶�newtab2")));
			String stage = excelHandler.getStage();
			System.out.println(stage);
			select_Stage.selectByVisibleText(stage);
			
			//�л�����ظ�������
			driver.findElement(By.partialLinkText("��ظ���")).click();
			Thread.sleep(1000);
			
			//�и��ַ���
			StringTokenizer stringTokenizer = new StringTokenizer(excelHandler.getAttachment(), ";");
			int stringNum = stringTokenizer.countTokens();
			String attachment;
			//String attachmentName;
			//��Ӹ���
			for(int i = 0; i < stringNum; i ++ ) {
				driver.findElement(By.partialLinkText("��Ӹ���")).click();
				Thread.sleep(1000);
				String[] handles1 = new String[driver.getWindowHandles().size()];
				driver.getWindowHandles().toArray(handles1);
				WebDriver attachmentWindow = driver.switchTo().window(handles1[1]);
				attachment = stringTokenizer.nextToken();
				//attachmentName = Files.getNameWithoutExtension(attachment);//��ȡ�ļ�������׺���ļ���
				System.out.println(attachment);
				attachmentWindow.findElement(By.name("userFile")).sendKeys(attachment);
				//attachmentWindow.findElement(By.name("userFileDesc")).sendKeys(attachmentName);//��д����������
				attachmentWindow.findElement(By.partialLinkText("ȷ��")).click();
				Thread.sleep(1000);
				
				//�л����
				driver = attachmentWindow.switchTo().window(handles1[0]);
				driver.switchTo().defaultContent();
			    driver.switchTo().frame(childFrame);
			}
			
			//driver.findElement(By.partialLinkText("����")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(topFrame);
			driver.findElement(By.partialLinkText("ע��")).click();
			
			driver = driver.switchTo().defaultContent();
		}
		closeFireFox();
	}
	//�ر������
	public void closeFireFox(){
		driver.close();
	}

}
