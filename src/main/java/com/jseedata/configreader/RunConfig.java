package com.jseedata.configreader;

import java.util.List;

/**
 * General configuration for run depicted by the JSON config file
 * @author SushantKunal
 *
 */
public class RunConfig {
	
	private List<Table> tables;
	private String databaseType;

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	@Override
	public String toString() {
		return "RunConfig [tables=" + tables + ", databaseType=" + databaseType + "]";
	}

}
