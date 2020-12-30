package boot.shop.data;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.Alias;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import lombok.Data;
//ShopDto.java
@Data
@Alias("shop")
public class ShopDto {
	private String num;
	private String sangpum;
	private int price;
	private String photoname;
	private Timestamp ipgoday;
}

/*

//DatabaseConfig.java
@Bean(name = "mysqlSqlSessionFactory")
@Primary
public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource,
		ApplicationContext applicationContext) throws Exception {
	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	sqlSessionFactoryBean.setDataSource(mysqlDataSource);
	sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
	sqlSessionFactoryBean.setTypeAliasesPackage("boot.shop.*");
	return sqlSessionFactoryBean.getObject();
}


//ShopSql.xml
<select id="getAllDatas" resultType="shop">
	select * from shop order by sangpum asc
</select>


*/