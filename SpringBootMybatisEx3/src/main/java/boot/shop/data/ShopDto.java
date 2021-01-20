package boot.shop.data;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

//ShopDto.java
@Data
@Alias("shop")
public class ShopDto {
	private String num;
	private String sangpum;
	private int price;
	private String photoname;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp ipgoday;
}

/*
 * 
 * //DatabaseConfig.java
 * 
 * @Bean(name = "mysqlSqlSessionFactory")
 * 
 * @Primary public SqlSessionFactory
 * mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource
 * mysqlDataSource, ApplicationContext applicationContext) throws Exception {
 * SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
 * sqlSessionFactoryBean.setDataSource(mysqlDataSource);
 * sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(
 * "classpath:mapper/*.xml"));
 * sqlSessionFactoryBean.setTypeAliasesPackage("boot.shop.*"); return
 * sqlSessionFactoryBean.getObject(); }
 * 
 * 
 * //ShopSql.xml <select id="getAllDatas" resultType="shop"> select * from shop
 * order by sangpum asc </select>
 * 
 * 
 */