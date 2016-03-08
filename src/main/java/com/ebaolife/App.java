package com.ebaolife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebaolife.model.DataSource;

@SpringBootApplication
@RestController
public class App extends SpringBootServletInitializer
{
	@Qualifier("primaryDataSource")
	@Autowired
	private DataSource primaryDataSource;
	
	@Qualifier("secondaryDataSource")
	@Autowired
	private DataSource secondaryDataSource;
 
	public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(App.class);  
    }
    
    @RequestMapping("/")
    public void hello(){
    	System.out.println(primaryDataSource);
    	System.out.println(secondaryDataSource);
    }
}
