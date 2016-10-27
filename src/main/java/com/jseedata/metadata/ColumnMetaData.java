package com.jseedata.metadata;

public class ColumnMetaData {
	
	String datatype;
	
	Integer dataLength;
	
	String columnName;
	
	String valueSet;

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getValueSet() {
		return valueSet;
	}

	public void setValueSet(String valueSet) {
		this.valueSet = valueSet;
	}

	public Integer getDataLength() {
		return dataLength;
	}

	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}

	@Override
	public String toString() {
		return "ColumnMetaData [datatype=" + datatype + ", dataLength=" + dataLength + ", columnName=" + columnName
				+ ", valueSet=" + valueSet + "]";
	}
	

}
