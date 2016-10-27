package com.jseedata.metadata;

import java.util.ArrayList;
import java.util.List;

public class DataBaseMetaData {
	private List<TableMetaData> tableList;

	public List<TableMetaData> getTableList() {
		if (tableList == null) {
			tableList = new ArrayList<TableMetaData>();
		}
		return tableList;
	}

	@Override
	public String toString() {
		return "DataBaseMetaData [tableList=" + tableList + "]";
	}

}
