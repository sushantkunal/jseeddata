package com.jseedata.metadata;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class DataTypeMapper {

	public static final Map<String, Class<?>> datatypeMap = new HashMap<String, Class<?>>();
	static {
		datatypeMap.put("NUMBER", BigDecimal.class);
		datatypeMap.put("VARCHAR2", String.class);
		datatypeMap.put("CHAR", Boolean.class);
		datatypeMap.put("SMALLINT", Integer.class);
		datatypeMap.put("INTEGER", Integer.class);
		datatypeMap.put("BIGINT", Long.class);
		datatypeMap.put("REAL", Float.class);
		datatypeMap.put("DOUBLE", Double.class);
		datatypeMap.put("FLOAT", Double.class);
		datatypeMap.put("DATE", Date.class);
		datatypeMap.put("TIME", Time.class);
		datatypeMap.put("TIMESTAMP",Timestamp.class);
		datatypeMap.put("BLOB", Blob.class);
		datatypeMap.put("BIT", Boolean.class);
		datatypeMap.put("SMALLINT", Boolean.class);
		datatypeMap.put("DECIMAL", BigDecimal.class);
	}
	
	public static Class<?> getClassForDataType(String datatype){
		return datatypeMap.get(datatype.toUpperCase());
	}
	
	

}
