package com.guppy.config;

import java.time.Duration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "app.datasource.cp")
@Getter
@Setter
public class DataSourceConfig extends HikariConfig {
	private String url;
	private String username;
	private String password;
	private Duration maxConTime;
	private int maximumPoolSize;
	private String poolName;
	private String driverClassName;
	private int minPoolSize;
	private Duration idleConTimeout;
	private Duration dbConnTimeout;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setJdbcUrl(url);
		hikariDataSource.setUsername(username);
		hikariDataSource.setPassword(password);
		hikariDataSource.setMaximumPoolSize(maximumPoolSize);
		hikariDataSource.setMaxLifetime(maxConTime.toMillis());
		hikariDataSource.setPoolName(poolName);
		hikariDataSource.setIdleTimeout(idleConTimeout.toMillis());
		hikariDataSource.setMinimumIdle(minPoolSize);
		hikariDataSource.setDriverClassName(driverClassName);
		hikariDataSource.setAutoCommit(true);
		hikariDataSource.setConnectionTimeout(dbConnTimeout.toMillis());
		return hikariDataSource;
	}

}
