package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;

//JpaRepository 상속받기
//엔티티와 pk타입 지정

// INSERT, UPDATE, DELETE 기능을 사용할 때 추가
// COMMIT 처리
@Transactional
public interface BoardRepository extends JpaRepository<Board, Integer> { 
	
	// 특정 회원이 작성한 모든 게시물을 삭제하는 메소드
	@Modifying
	@Query("delete from Board where writer = :mem")
	public void deleteWriter(@Param("mem") Member member);
}
