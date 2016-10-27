package com.jseedata.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.jseedata.configreader.IConfigReader;
import com.jseedata.configreader.JSONConfigReader;
import com.jseedata.metadata.ColumnMetaData;
import com.jseedata.metadata.DataBaseMetaData;
import com.jseedata.metadata.IMetaDataCollector;
import com.jseedata.metadata.OracleMetaDataCollector;
import com.jseedata.metadata.TableMetaData;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@PropertySource(value = { "classpath:db.properties" })
public class AppConfig {

	@Autowired
	private Environment env;

	@Value("${jseeddata.db.relationships}")
	private String relationships;

	@Value("${jseeddata.db.num_records}")
	private Integer numRecords;

	@Value("${jseeddata.db.database}")
	private String databaseType;

	@Autowired
	private DataSource dataSource;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public IConfigReader configReader() {
		return new JSONConfigReader();
	}
	
	@Bean
	public IMetaDataCollector metadataCollector() {
		return new OracleMetaDataCollector();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {		
		return new JdbcTemplate(dataSource);
	}

	

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(AppConfig.class, args);
		DataBaseMetaData dbMetadata = context.getBean(IMetaDataCollector.class).initializeMetaData();
		for(TableMetaData tableMeta : dbMetadata.getTableList()){
			System.out.println(generateInsertScript(tableMeta));
		}		
	}
	
	private static String generateInsertScript(TableMetaData tableMeta){
		StringBuilder strBuilder = new StringBuilder();
		StringBuilder strBuilderValues = new StringBuilder();
		strBuilder.append("INSERT INTO ").append(tableMeta.getName()).append(" (");
		strBuilderValues.append(" VALUES (");
		boolean firstColumn = true;
		for(ColumnMetaData column : tableMeta.getColumnList()){
			if(!firstColumn){
				strBuilder.append(", ");
				strBuilderValues.append(", ");
			}else{
				firstColumn = false;
			}
			strBuilderValues.append("?");
			strBuilder.append(column.getColumnName());
		}
		strBuilder.append(")");
		strBuilderValues.append(")");
		strBuilder.append(strBuilderValues);
		return strBuilder.toString();
	}

}
