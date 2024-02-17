package com.hogwartscompany.phonebook;

import com.hogwartscompany.phonebook.utils.mapper.*;
import org.apache.catalina.mapper.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhonebookApplication {
	MapperEmployeeWithEmployeeDTO mapperEmployee = new MapperEmployeeWithEmployeeDTO();
	MapperAddressWithAddressDTO mapperAddress = new MapperAddressWithAddressDTO();
	MapperWorksiteWithWorksiteDTO mapperWorksite = new MapperWorksiteWithWorksiteDTO();
	MapperServiceWithServiceSiteDTO mapperServiceSite = new MapperServiceWithServiceSiteDTO();

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
	@Bean
	public MapperAlwaysWithAlwaysDTO mapperAlwaysWithAlwaysDTO() {
		return new MapperAlwaysWithAlwaysDTO(
				mapperEmployee, mapperAddress, mapperWorksite, mapperServiceSite
		);
	}

}
