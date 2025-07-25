package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.AttachmentsDto;
import com.example.demo.model.AttachmentsEntity;

public interface AttachmentsRepository extends JpaRepository<AttachmentsEntity, Long>{

	List<AttachmentsEntity> findAllByRefId(int refId);

	@Query("SELECT new com.example.demo.dto.AttachmentsDto(a.attachId, a.uId, a.refId, a.documentName, a.attachFile, a.createdId, a.createdDate, u.profileName) FROM AttachmentsEntity a LEFT JOIN UserinfoEntity u ON a.uId = u.uId WHERE a.refId = :refId")
	List<AttachmentsDto> getAllAttachmentsList(@Param("refId") Integer refId);
}
