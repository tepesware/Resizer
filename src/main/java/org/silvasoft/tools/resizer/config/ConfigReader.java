package org.silvasoft.tools.resizer.config;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ConfigReader {

	
	public Configuration readConfig(String pathname) throws Exception {
		
		Serializer serializer = new Persister();
		File source = new File(pathname);
		return serializer.read(Configuration.class, source);
		
	}
	
}

