package org.silvasoft.tools.resizer.config;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root (name="config")
public class Configuration {

	@ElementList(inline=true)
	List<ResizeData> resizeData;

	public Configuration() {
	}

	public List<ResizeData> getResizeData() {
		return resizeData;
	}

	public void setResizeData(List<ResizeData> resizeData) {
		this.resizeData = resizeData;
	}
	
}
