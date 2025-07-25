package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.UserinfoDto;
import com.example.demo.model.UserinfoEntity;

public interface UserinfoRepository extends JpaRepository<UserinfoEntity, Long>{

	@Query("SELECT user FROM UserinfoEntity user WHERE user.userName = :userName AND user.password = :password")
	List<UserinfoEntity> getUserLogin(@Param("userName") String username, @Param("password") String password);
	
	@Query("SELECT new com.example.demo.dto.UserinfoDto(users.profileName, users.uId) From UserinfoEntity users WHERE users.role = 'Tester'")
	List<UserinfoDto> getTestList();
	
	@Query("SELECT new com.example.demo.dto.UserinfoDto(users.profileName, users.uId) From UserinfoEntity users WHERE users.role = 'Developer'")
	List<UserinfoDto> getDevelopersList();
}

