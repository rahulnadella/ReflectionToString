/*
 The MIT License (MIT)

 Copyright (c) 2015 Rahul Nadella https://github.com/rahulnadella 

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */
package com.util.mutableObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * The {@class PropertiesCache} represents a persistent set of properties. The
 * Properties can be saved to a stream or loaded from a stream. Each key and its
 * corresponding value in the property list is a string.
 * 
 * @version 1.0
 */
public class PropertiesCache {

	private final Properties configProp = new Properties();

	private PropertiesCache() {
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream("mutable.properties");

		try {
			configProp.load(in);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * The Initialization-on-demand holder idiom patter called LazyHolder for
	 * instantiate the PropertiesCache
	 */
	private static class LazyHolder {
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	/**
	 * Retrieves a single loaded instance
	 */
	public static PropertiesCache getInstance() {
		return LazyHolder.INSTANCE;
	}

	/* Get/Set Property methods */

	public String getProperty(String key) {
		return configProp.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}

	public void setProperty(String key, String value) {
		configProp.setProperty(key, value);
	}
}
