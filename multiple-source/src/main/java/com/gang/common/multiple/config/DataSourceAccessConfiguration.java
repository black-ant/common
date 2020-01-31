//package com.gang.common.multiple.config;
//
//import com.gang.common.multiple.properties.MutipleSourceProperties;
//import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
//import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.jdbc.SchemaManagement;
//import org.springframework.boot.jdbc.SchemaManagementProvider;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Classname DataSourceAccessConfiguration
// * @Description TODO
// * @Date 2020/1/29 20:51
// * @Created by zengzg
// */
//
//@Configuration
//public class DataSourceAccessConfiguration {
//
//    @Autowired
//    private MutipleSourceProperties mutipleSourceProperties;
//
//    @Autowired
//    private ObjectProvider<List<SchemaManagementProvider>> providers;
//    @Autowired
//    private ObjectProvider<PhysicalNamingStrategy> physicalNamingStrategy;
//    @Autowired
//    private ObjectProvider<ImplicitNamingStrategy> implicitNamingStrategy;
//
//    /**
//     * 主数据库连接配置
//     *
//     * @return
//     */
//    @Bean
//    @Qualifier("primaryDataSource")
//    @ConfigurationProperties("spring.datasource.primary")
//    @Primary
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * 备数据库连接配置
//     *
//     * @return
//     */
//    @Qualifier("backupDataSource")
//    @Bean
//    @ConfigurationProperties("spring.datasource.backup")
//    public DataSource backupDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * 主 EntityManagerFactory配置
//     *
//     * @param builder
//     * @return
//     */
//    @Bean
//    @Qualifier("primaryEntityManagerFactory")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(primaryDataSource())
//                .properties(getVendorProperties(primaryDataSource()))
//                .packages(OrderRepository.class) //扫描OrderRepository所在的包
//                .persistenceUnit("primary")
//                .build();
//
//    }
//
//    /**
//     * 主 TransactionManager配置 事务配置
//     *
//     * @param builder
//     * @return
//     */
//    @Bean
//    @Qualifier("primaryTransactionManager")
//    @Primary
//    public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManagerFactory")
//    LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager(primaryEntityManagerFactory.getObject());
//        return transactionManager;
//    }
//
//    /**
//     * 备 EntityManagerFactory配置
//     *
//     * @param builder
//     * @return
//     */
//    @Bean
//    @Qualifier("backupEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean backupEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(backupDataSource())
//                .properties(getVendorProperties(backupDataSource()))
//                .packages(VerifyOrderRepository.class)  //扫描VerifyOrderRepository所在的包
//                .persistenceUnit("backup")
//                .build();
//
//    }
//
//    /**
//     * 备 TransactionManager配置 事务配置
//     *
//     * @param builder
//     * @return
//     */
//    @Bean
//    @Qualifier("backupTransactionManager")
//    public PlatformTransactionManager backupTransactionManager(@Qualifier("backupEntityManagerFactory")
//    LocalContainerEntityManagerFactoryBean backupEntityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager(backupEntityManagerFactory.getObject());
//        return transactionManager;
//    }
//
//
//    /**
//     * 配置hibernate的配置信息
//     *
//     * @param dataSource
//     * @return
//     */
//    protected Map<String, Object> getVendorProperties(DataSource dataSource) {
//        Map<String, Object> vendorProperties = new LinkedHashMap<String, Object>();
//        String defaultDdlMode = new HibernateDefaultDdlAutoProvider(
//                providers.getIfAvailable(Collections::emptyList))
//                .getDefaultDdlAuto(dataSource);
//        vendorProperties.putAll(jpaProperties.getHibernateProperties(
//                new HibernateSettings().ddlAuto(defaultDdlMode).physicalNamingStrategy(physicalNamingStrategy
//                .getIfAvailable())
//                        .implicitNamingStrategy(implicitNamingStrategy.getIfAvailable())
//        ));
//        return vendorProperties;
//    }
//
//    class HibernateDefaultDdlAutoProvider implements SchemaManagementProvider {
//        private final List<SchemaManagementProvider> providers;
//
//        HibernateDefaultDdlAutoProvider(List<SchemaManagementProvider> providers) {
//            this.providers = providers;
//        }
//
//        public String getDefaultDdlAuto(DataSource dataSource) {
//            if (!EmbeddedDatabaseConnection.isEmbedded(dataSource)) {
//                return "none";
//            } else {
//                SchemaManagement schemaManagement = this.getSchemaManagement(dataSource);
//                return SchemaManagement.MANAGED.equals(schemaManagement) ? "none" : "create-drop";
//            }
//        }
//
//        public SchemaManagement getSchemaManagement(DataSource dataSource) {
//            Iterator var2 = this.providers.iterator();
//
//            SchemaManagement schemaManagement;
//            do {
//                if (!var2.hasNext()) {
//                    return SchemaManagement.UNMANAGED;
//                }
//
//                SchemaManagementProvider provider = (SchemaManagementProvider) var2.next();
//                schemaManagement = provider.getSchemaManagement(dataSource);
//            } while (!SchemaManagement.MANAGED.equals(schemaManagement));
//
//            return schemaManagement;
//        }
//    }
//
//}
