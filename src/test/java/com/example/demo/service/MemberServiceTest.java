package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	MemberService service;
	
	@Test
	public void 회원목록조회() {
		
		// 첫번째 페이지 조회
		Page<MemberDTO> page = service.getList(1);
		
		// 회원 목록 꺼내기
		List<MemberDTO> list = page.getContent();
		
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
		
	}
	
	// 회원등록
	@Test
	public void 회원등록() {
		
		MemberDTO dto = MemberDTO.builder()
								 .id("admin")
								 .password("123")
								 .name("또치")
								 .build();
		
		boolean isSuccess = service.register(dto);
		
		System.out.println("처리결과: " + isSuccess);
										 
	}
	
	
	// 회원단건조회
	@Test
	public void 회원단건조회() {
		
		MemberDTO dto = service.read("admin");
		
		System.out.println(dto);
	}
}
