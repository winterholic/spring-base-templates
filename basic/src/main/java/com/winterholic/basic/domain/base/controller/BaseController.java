package com.winterholic.basic.domain.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BaseController {
    @GetMapping("/")
    public String index() {
        return LocalDateTime.now().toString();
    }

    /// 주석들 규칙
    // TODO: [작성자] 구현해야 할 기능이나 개선사항
    // FIXME: [작성자] 버그나 문제가 있어서 수정 필요
    // NOTE: [작성자] 중요한 설명이나 참고사항
    /// 주석들 규칙
}
