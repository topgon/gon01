package org.gon.controller;

import org.gon.domain.BoardVO;
import org.gon.domain.Criteria;
import org.gon.domain.PageDTO;
import org.gon.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		
		log.info("list");
		model.addAttribute("list",service.getListWithPaging(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, 123));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("register")
	public String register(BoardVO board,  RedirectAttributes rttr) {
		
		service.register(board);

		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
	}

	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		model.addAttribute("board",service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		if(service.modify(board)) {
			
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		if(service.remove(bno)) {
			
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	
}









