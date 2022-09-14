package co.tuneup.prj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "co.tuneup.prj.**.mapper")
public class TuneUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuneUpApplication.class, args);
	}

}
