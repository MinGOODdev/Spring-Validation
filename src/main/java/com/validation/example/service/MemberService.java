package com.validation.example.service;

import com.validation.example.domain.request.MemberRequestDto;
import com.validation.example.domain.response.MemberResponseDto;
import com.validation.example.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

  private MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Transactional
  public Long save(MemberRequestDto memberRequestDto) {
    return memberRepository.save(memberRequestDto.toEntity()).getId();
  }

  @Transactional(readOnly = true)
  public List<MemberResponseDto> findAll() {
    return memberRepository.findAll()
            .stream()
            .map(MemberResponseDto::new)
            .collect(Collectors.toList());
  }

}
