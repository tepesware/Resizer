package org.silvasoft.tools.resizer.config;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

@Element(name="resizeData")
public class ResizeData {

	@Attribute
	String windowName;

	@Attribute
	int x;
	@Attribute
	int y;
	@Attribute
	int h;
	@Attribute
	int w;

	int w2;

	int h2;

	@Attribute(required=false)
	boolean show;

	public int getW2() {
		return w2;
	}

	public void setW2(int w2) {
		this.w2 = w2;
	}

	public int getH2() {
		return h2;
	}

	public void setH2(int h2) {
		this.h2 = h2;
	}

	public ResizeData(String windowName, int x, int y, int h, int w, int h2, int w2, boolean show) {
		super();
		this.windowName = windowName;
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.w2 = w2;
		this.h2 = h2;
		this.show = show;
	}


	public ResizeData() {
	}



	public String getWindowName() {
		return windowName;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(windowName);
		stringBuilder.append(",\t x=");
		stringBuilder.append(x);
		stringBuilder.append(",\t y=");
		stringBuilder.append(y);
		stringBuilder.append(",\t w=");
		stringBuilder.append(w);
		stringBuilder.append(",\t h=");
		stringBuilder.append(h);
		if (show) {
			stringBuilder.append("\t show");
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + h;
		result = prime * result + (show ? 1231 : 1237);
		result = prime * result + w;
		result = prime * result + ((windowName == null) ? 0 : windowName.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResizeData other = (ResizeData) obj;
		if (h != other.h)
			return false;
		if (show != other.show)
			return false;
		if (w != other.w)
			return false;
		if (windowName == null) {
			if (other.windowName != null)
				return false;
		} else if (!windowName.equals(other.windowName))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}