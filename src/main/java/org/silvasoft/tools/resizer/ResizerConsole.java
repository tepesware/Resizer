package org.silvasoft.tools.resizer;

import javax.naming.NameNotFoundException;

/**
 * Hello world!
 * 
 */
public class ResizerConsole {

	public static void main(String[] args) throws InterruptedException {

		String lpWindowName = "Kalkulator";
		int x = 50;
		int y = 100;
		int width = 1024;
		int height = 728;

		try {
			WindowUtils.resizeWindow(lpWindowName, x, y, width * 2, height, true);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResizeException e) {
			e.printStackTrace();
		}

	}
}
