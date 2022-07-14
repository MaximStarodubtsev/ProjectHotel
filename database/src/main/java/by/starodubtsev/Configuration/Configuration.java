package by.starodubtsev.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("by.starodubtsev")
@org.springframework.context.annotation.Configuration
@EnableWebMvc
public class Configuration{

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Session session(){
        return sessionFactory().openSession();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure()
                .buildSessionFactory();
    }
}
