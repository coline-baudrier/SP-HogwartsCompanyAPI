package com.hogwartscompany.phonebook;

import com.hogwartscompany.phonebook.utils.mapper.MapperAddressWithAddressDTO;
import com.hogwartscompany.phonebook.utils.mapper.MapperEmployeeWithEmployeeDTO;
import com.hogwartscompany.phonebook.utils.mapper.MapperServiceWithServiceSiteDTO;
import com.hogwartscompany.phonebook.utils.mapper.MapperWorksiteWithWorksiteDTO;
import org.apache.catalina.mapper.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhonebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}

	@Bean
	public MapperAddressWithAddressDTO mapperAddressWithAddressDTO(){
		return new MapperAddressWithAddressDTO();
	}
	@Bean
	public MapperWorksiteWithWorksiteDTO mapperWorksiteWithWorksiteDTO(){
		return new MapperWorksiteWithWorksiteDTO();
	}
	@Bean
	public MapperServiceWithServiceSiteDTO mapperServiceWithServiceDTO() {
		return new MapperServiceWithServiceSiteDTO();
	}
	@Bean
	public MapperEmployeeWithEmployeeDTO mapperEmployeeWithEmployeeDTO() {
		return new MapperEmployeeWithEmployeeDTO();
	}
}
