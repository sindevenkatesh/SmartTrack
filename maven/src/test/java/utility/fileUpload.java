package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

public class fileUpload {

	public void ROBOT(String docPath) throws AWTException, InterruptedException {

		StringSelection ss = new StringSelection(docPath);
		try {

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
		} catch (NoSuchElementException ex) {

		}

	}

}
