package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import board.service.BoardServiceInter;

@Controller
public class BoardUpdateController {

	@Autowired
	private BoardServiceInter service;
	
	
}
