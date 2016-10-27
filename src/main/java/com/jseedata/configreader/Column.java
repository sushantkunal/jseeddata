package com.jseedata.configreader;

import java.util.Arrays;

/**
 * Depicts a table column
 * 
 * @author SushantKunal
 *
 */
public class Column {
	public String name;
	public String datatype;
	public String derivedCategory;
	public String[] valueSet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getDerivedCategory() {
		return derivedCategory;
	}

	public void setDerivedCategory(String derivedCategory) {
		this.derivedCategory = derivedCategory;
	}

	public String[] getValueSet() {
		return valueSet;
	}

	public void setValueSet(String[] valueSet) {
		this.valueSet = valueSet;
	}

	@Override
	public String toString() {
		return "Column [name=" + name + ", datatype=" + datatype + ", derivedCategory=" + derivedCategory
				+ ", valueSet=" + Arrays.toString(valueSet) + "]";
	}

}
