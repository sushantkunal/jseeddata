package com.jseedata.metadata;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jseedata.configreader.IConfigReader;
import com.jseedata.configreader.RunConfig;
import com.jseedata.configreader.Table;

@EnableAutoConfiguration
public class OracleMetaDataCollector implements IMetaDataCollector {
	
	@Autowired
	private IConfigReader configReader;
	
	@Autowired
	private DataSource dataSource;
	
	private final static String SQL_GET_COLUMNS = "select COLUMN_NAME, DATA_TYPE, DATA_LENGTH from ALL_TAB_COLUMNS where TABLE_NAME=? ORDER BY COLUMN_ID";

	public DataBaseMetaData initializeMetaData() {
		// TODO Auto-generated method stub
		DataBaseMetaData dbMetaData = new DataBaseMetaData();
		try {
			RunConfig runConfig = configReader.readConfigurationFile();
			List<Table> tables = runConfig.getTables();
			for(Table table: tables){
				TableMetaData tableMetaData = new TableMetaData(table.getName());
				tableMetaData.getColumnList().addAll(getColumnsForTable(table.getName()));
				dbMetaData.getTableList().add(tableMetaData);
			}
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		return dbMetaData;
	}
	
	public List<ColumnMetaData> getColumnsForTable(String tableName){
		JdbcTemplate template = new JdbcTemplate(dataSource);
		List<ColumnMetaData> columns = template.query(SQL_GET_COLUMNS, new ColumnRowMapper(), tableName);
		return columns;
	}

}
