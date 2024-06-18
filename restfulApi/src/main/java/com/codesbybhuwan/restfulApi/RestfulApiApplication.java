package com.codesbybhuwan.restfulApi;

import com.codesbybhuwan.restfulApi.config.AppConstants;
import com.codesbybhuwan.restfulApi.entities.Role;
import com.codesbybhuwan.restfulApi.repository.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLOutput;
import java.util.List;


@SpringBootApplication

public class RestfulApiApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}
//	Make sure this is applicable passEncoder
	@Override
	public void run(String... args) throws Exception{

		System.out.println(this.passwordEncoder.encode("xyz"));
//		For the first time if there are no any table for roles then it will obviously create else will user older one
		try {
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ADMIN_USER");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("NORMAL_USER");

			List<Role> roles = List.of(role, role1);
			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r->{
				System.out.println(r.getName());
			});
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
