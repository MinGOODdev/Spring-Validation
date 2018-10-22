package com.validation.example.controller;

import com.validation.example.domain.request.MemberRequestDto;
import com.validation.example.domain.response.MemberResponseDto;
import com.validation.example.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

  private MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("members")
  public List<MemberResponseDto> findAll() {
    return memberService.findAll();
  }

  @PostMapping("member")
  public Long saveMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {
    return memberService.save(memberRequestDto);
  }

}
