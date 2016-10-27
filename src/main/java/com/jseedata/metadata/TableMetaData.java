package com.jseedata.metadata;

import java.util.ArrayList;
import java.util.List;

public class TableMetaData {
	
	String name;
	private List<ColumnMetaData> columnList;

	public TableMetaData(String name) {
		super();
		this.name = name;
	}



	public List<ColumnMetaData> getColumnList() {
		if (columnList == null) {
			columnList = new ArrayList<ColumnMetaData>();
		}
		return columnList;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "TableMetaData [name=" + name + ", columnList=" + columnList + "]";
	}
	
}
