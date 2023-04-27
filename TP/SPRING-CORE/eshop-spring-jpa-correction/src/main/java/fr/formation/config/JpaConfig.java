package fr.formation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration // Dire que c'est une classe de Configuration SPRING
@EnableTransactionManagement // Activer les annotations @Transactional
public class JpaConfig {
	// 1- DataSource : La façon dont SPRING va se connecter à la base de données
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/eshop");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");
		dataSource.setMaxTotal(10); // Nombre de connexions vers PostgreSQL simultanées autorisées
		
		return dataSource;
	}
	
	// 2- EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		Properties properties = new Properties();

		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "false");
		
		emf.setDataSource(dataSource);
		emf.setJpaProperties(properties);
		emf.setPackagesToScan("fr.formation.model");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		return emf;
	}
	
	// 3- Gestionnaire de transaction JPA
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
