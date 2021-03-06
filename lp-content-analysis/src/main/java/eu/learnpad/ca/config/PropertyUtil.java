/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package eu.learnpad.ca.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

/**
*
* @author gulyx
*/
public class PropertyUtil {
  private static Logger log = Logger.getLogger(PropertyUtil.class);
	
  private static final String DEFAULT_CONFIG_FILE_LOCATION = "config.properties";
  						
//  private Properties properties;
  private PropertiesConfiguration properties;

  public PropertyUtil() {
    this(DEFAULT_CONFIG_FILE_LOCATION);
  }

//  public PropertyUtil(String configFileLocation) {
//	this.properties = new Properties();
//	try {
//		this.properties.load(new FileInputStream(configFileLocation));
//	} catch (IOException e) {
//      log.error("Cannot load application properties for CA component from : " + configFileLocation + "\n Loaded Default ConfFile Instead.", e);
//		try {
//			this.properties.load(new FileInputStream(DEFAULT_CONFIG_FILE_LOCATION));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
//  }

	public PropertyUtil(String configFileLocation) {
		try {
			this.properties = new PropertiesConfiguration(configFileLocation);
		} catch (ConfigurationException e) {
			log.error(
					"Cannot load application properties for dashboard component from : " + configFileLocation + "\n Loaded Default ConfFile Instead.", e);
			try {
				this.properties = new PropertiesConfiguration(
						DEFAULT_CONFIG_FILE_LOCATION);
			} catch (ConfigurationException e1) {
				e1.printStackTrace();
			}
		}
	}

  public String getProperty(String key){
	  return this.properties.getString(key);
  }

  public String getProperty(String key, String defalut){
	  return this.properties.getString(key,defalut);
  }

}