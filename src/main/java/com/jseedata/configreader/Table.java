package com.jseedata.configreader;

import java.util.List;

/**
 * Depicts a table from DB
 * 
 * @author SushantKunal
 *
 */
public class Table {
	private String name;
	private List<Column> columns;
	private String parent;
	private int oneToManyCount;
	private String primaryKey;
	private boolean populateSelectedColumns = false;

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public boolean isPopulateSelectedColumns() {
		return populateSelectedColumns;
	}

	public void setPopulateSelectedColumns(boolean populateSelectedColumns) {
		this.populateSelectedColumns = populateSelectedColumns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public int getOneToManyCount() {
		return oneToManyCount;
	}

	public void setOneToManyCount(int oneToManyCount) {
		this.oneToManyCount = oneToManyCount;
	}

	@Override
	public String toString() {
		return "Table [name=" + name + ", columns=" + columns + ", parent=" + parent + ", oneToManyCount="
				+ oneToManyCount + ", populateSelectedColumns=" + populateSelectedColumns + "]";
	}

}
