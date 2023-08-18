package com.springboot.crudP1.controller;

import com.springboot.crudP1.dto.BoardDto;
import com.springboot.crudP1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // -------------------------------- 게시글 리스트 --------------------------------
//    @GetMapping("/")
//    public String List(Model model) {
//        List<BoardDto> boardDtoList = boardService.getBoardList();
//        model.addAttribute("boardList", boardDtoList);
//        return "board/list.html";
//    }

    // -------------------------------- 게시글 리스트, 페이징 구현 --------------------------------
    @GetMapping("/")
    public String List(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardDtoList = boardService.getBoardList(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("pageList", pageList);

        return "board/list.html";
    }

    // -------------------------------- 게시글 작성 --------------------------------
    @GetMapping("/post")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    // -------------------------------- 게시글 상세 보기 --------------------------------
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    // -------------------------------- 게시글 수정 --------------------------------
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    // -------------------------------- 게시글 수정 완료 --------------------------------
    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    // -------------------------------- 게시글 삭제 --------------------------------
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long id) {
        boardService.deletePost(id);

        return "redirect:/";
    }

    // -------------------------------- 게시글 검색 --------------------------------
    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }


}
