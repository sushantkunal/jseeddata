package com.jseedata.metadata;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ColumnRowMapper implements RowMapper<ColumnMetaData>{

	public ColumnMetaData mapRow(ResultSet rs, int rowNum) throws SQLException {
		ColumnMetaData columnMetaData = new ColumnMetaData();
		columnMetaData.setColumnName(rs.getString("COLUMN_NAME"));
		columnMetaData.setDatatype(rs.getString("DATA_TYPE"));
		columnMetaData.setDataLength(rs.getInt("DATA_LENGTH"));
		return columnMetaData;
	}

}
