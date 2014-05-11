package org.silvasoft.tools.resizer;

import javax.naming.NameNotFoundException;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;

public class ResizeUtils {

	private static final int SWP_SHOWWINDOW = 0x0040;

	public synchronized static void resizeWindow(String lpWindowName, int x, int y, int width, int height, boolean show)
			throws NameNotFoundException {
		final User32 user32 = User32.INSTANCE;
		HWND hWnd = user32.FindWindow(null, lpWindowName);
		if (hWnd == null) {
			throw new NameNotFoundException();
		}

		user32.SetWindowPos(hWnd, null, x, y, width, height, SWP_SHOWWINDOW);
		if (show) {
			user32.ShowWindow(hWnd, WinUser.SW_SHOW);
			user32.SetForegroundWindow(hWnd);
		}
	}

}
