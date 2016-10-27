package com.jseedata.configreader;

import java.io.FileNotFoundException;

public interface IConfigReader {

	RunConfig readConfigurationFile() throws FileNotFoundException;
	
}
