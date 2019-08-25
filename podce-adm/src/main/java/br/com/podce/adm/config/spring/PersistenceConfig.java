package br.com.podce.adm.config.spring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Victor Alexsander
 */
@Configuration
@EnableJpaRepositories(basePackages = "br.com.podce.adm.repository")
@EnableTransactionManagement
@Profile("dev")
public class PersistenceConfig {

    @Value("${data.source.db}")
    private String DATASOURCE_CLASS;

    @Value("${dialect.db}")
    private String DIALECT;

    @Value("${hbm2dll}")
    private String HBM2DLL;

    @Value("${user.db}")
    private String USER;

    @Value("${password.db}")
    private String PW;

    @Value("${url.db}"+"?verifyServerCertificate=false&useSSL=false&requireSSL=false")
    private String URL;

    @Value("${max.pool.db}")
    private Integer MAX_POOL;

    @Value("${min.pool.db}")
    private Integer MIN_POOL;

    @Value("${timeout.db}")
    private Integer TIMEOUT;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setPackagesToScan("br.com.podce");
        lcemfb.setPersistenceProvider(new HibernatePersistenceProvider());
        lcemfb.setPersistenceUnitName("podce-adm");
        lcemfb.setDataSource(dataSource());
        lcemfb.setJpaProperties(additionalProperties());
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(vendorAdapter);
        return lcemfb;
    }

    @Bean
    public DataSource dataSource(){
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", DATASOURCE_CLASS);
        props.setProperty("dataSource.url", URL);
        props.setProperty("dataSource.user", USER);
        props.setProperty("dataSource.password", PW);
        HikariConfig hikariConfig = new HikariConfig(props);
        hikariConfig.setIdleTimeout(TIMEOUT);
        hikariConfig.setMinimumIdle(MIN_POOL);
        hikariConfig.setMaximumPoolSize(MAX_POOL);
        hikariConfig.setPoolName("springHikariPodceCP");
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory().getObject());
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", DIALECT);
        properties.setProperty("hibernate.hbm2ddl.auto", HBM2DLL);
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.setProperty("hibernate.default_schema", "podce");
        return properties;
    }

}
