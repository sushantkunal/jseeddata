package com.jseedata.configreader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@EnableAutoConfiguration
public class JSONConfigReader implements IConfigReader{
	
	
	public RunConfig readConfigurationFile() throws FileNotFoundException{
		RunConfig runConfig = null;
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader("C:\\cfam\\config.json"));
		runConfig = gson.fromJson(reader, RunConfig.class);
		System.out.println(runConfig);
		return runConfig;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new JSONConfigReader().readConfigurationFile();
	}
}
