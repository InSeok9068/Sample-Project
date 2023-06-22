package kr.co.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/temp", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TempController {
}
