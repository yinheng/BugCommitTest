import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.read.biff.BiffException;

public class FirefoxMainTest {
	public static void main(String[] args) throws InterruptedException, IOException, BiffException {
		String url = "http://bug.raisecom.com";
		FireFoxInit fireFoxInit = new FireFoxInit();
		fireFoxInit.openFireFox(url);
		fireFoxInit.createBug();
		
		
	}

}
