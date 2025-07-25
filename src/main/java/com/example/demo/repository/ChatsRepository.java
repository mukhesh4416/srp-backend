package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.ChatsDto;
import com.example.demo.model.ChatsEntity;

public interface ChatsRepository extends JpaRepository<ChatsEntity, Long> {
	
	@Query("SELECT new com.example.demo.dto.ChatsDto(c.chatId, c.uId, c.refId, c.message, c.createdId, c.createdDate, u.profileName) FROM ChatsEntity c LEFT JOIN UserinfoEntity u ON c.uId=u.uId WHERE c.refId=:refId")
	List<ChatsDto> getAllChatByRefId(@Param("refId") int refId);
}
