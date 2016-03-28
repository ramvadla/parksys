package com.iiit.parksys.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;
/**
 * It handles the configuration proerties
 * @author ramakrishna
 *
 */
public class ConfigProperties {

	private static Properties prop = new Properties();
	static {
		InputStream inputStream = null;
		try {
			final URL url = Resources.getResource("config.properties");
			final ByteSource byteSource = Resources.asByteSource(url);
			final Properties properties = new Properties();

			inputStream = byteSource.openBufferedStream();

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException(
						"property file not found in the classpath");
			}
		} catch (Exception e) {
			// TODO: Replace it with logger
			e.printStackTrace();
		}
	}

	static public String getValue(String key) {
		return prop.getProperty(key);

	}

}
