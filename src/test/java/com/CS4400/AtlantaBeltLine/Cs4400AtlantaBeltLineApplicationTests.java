package com.CS4400.AtlantaBeltLine;

import com.mysql.jdbc.jdbc2.optional.MysqlPooledConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cs4400AtlantaBeltLineApplicationTests {

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void test1() throws SQLException {
//		Logger log = new Logger();
//		MysqlPooledConnection dataSource;
//		try (Connection connection = dataSource.getConnection()) {
//			log.info("catalog:" + connection.getCatalog());
//		}
//	}

}
