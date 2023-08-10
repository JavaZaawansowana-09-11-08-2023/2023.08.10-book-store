package pl.comarch.szkolenia.book.store.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import pl.comarch.szkolenia.book.store.interceptors.Interceptor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("pl.comarch.szkolenia.book.store")
public class AppConfiguration {

    @Bean
    public Connection connection() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookstore3",
                    "root",
                    "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } /*catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
    }
}
