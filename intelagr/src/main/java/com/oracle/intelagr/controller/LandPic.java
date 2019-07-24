package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landPic")
public class LandPic {
	@RequestMapping("/list")
	public String list() {
		return "/landpic/landPicList";
	}
}
