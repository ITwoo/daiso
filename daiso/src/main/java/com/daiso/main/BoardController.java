package com.daiso.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daiso.service.BoardService;
import com.daiso.service.ProductService;
import com.daiso.service.ReviewService;
import com.daiso.vo.BoardVO;
import com.daiso.vo.ProductVO;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;
	@Autowired
	private ProductService productService;
	@Autowired
	ReviewService reviewService;

//	@GetMapping("/update")
//	public String update(Model model) {
//		
//		model.addAttribute();
//		
//		return "boardupdate";
//	}

	@GetMapping("/write")
	public String write() {
		return "boardwrite";
	}

	@PostMapping("/write")
	public String writeprocess(HttpServletRequest http) {
		BoardVO vo = new BoardVO();
		logger.info("디버그 = " + http.getUserPrincipal().getName());
		vo.setM_userid(http.getUserPrincipal().getName());
		vo.setB_title((String) http.getParameter("title"));
		vo.setB_writing((String) http.getParameter("content"));
		logger.info((String) http.getParameter("image"));
		vo.setP_productid(productService.selectProductId((String) http.getParameter("image")));
		boardService.insertBoard(vo);
		return "redirect:/board";
	}
//	@RequestMapping(value = "/board", method = RequestMethod.GET)
//	public String board() {
//		return "board";
//	}	
	
	@GetMapping("/data/{b_num}")
	@ResponseBody
	public Map<String, Object> boarddetail(@PathVariable int b_num) {
		logger.info("b_num"+b_num);
		Map<String, Object> map = new HashMap<String, Object>();
		this.boardService.selectBoard(b_num);
		List<BoardVO> list = this.boardService.selectBoard(b_num);
		BoardVO board = list.get(0);
		ProductVO product = productService.selectProduct(list.get(0).getP_productid());
		map.put("code", "success");
		map.put("board", board);
		map.put("product", product);
		return map;	
	}
	@GetMapping("/detail") //글 하나 보기
	public String boardSelectOne() {
		return "boarddetail";
	}

	@GetMapping("/board") // 글 전체보기(게시판)
	public String boardSelectAll(Model model) {
		List<BoardVO> list = boardService.selectAllBoards();
		logger.info("한국"+list.get(0).getM_userid());
		Map<Integer,ProductVO> map= new HashMap<Integer, ProductVO>();
		
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getP_productid(), productService.selectProduct(list.get(i).getP_productid()));
		}
		
		model.addAttribute("map",map);
		model.addAttribute("list", list);
		return "board";
	}

//	@GetMapping("/delete/{b_num}") // 글 삭제
//	public String boardDelete(@PathVariable("b_num") int b_num) {
//		this.boardService.deleteBoard(b_num);
//		return "redirect:/board";
//	}

	@GetMapping("/update/{b_num}")
	public String boardupdate(@PathVariable int b_num,Model model) {
		List<BoardVO> list = this.boardService.selectBoard(b_num);
		BoardVO board = list.get(0);
		ProductVO product = productService.selectProduct(list.get(0).getP_productid());
		model.addAttribute("board",board);
		model.addAttribute("product",product);
		return "boardupdate";
	}
	@PutMapping("/data")
	public String update(HttpServletRequest http) {
		BoardVO vo = new BoardVO();
		logger.info("디버그 = " + (String)http.getParameter("image"));
		logger.info(http.getParameter("id"));
		logger.info(http.getParameter("title"));
		logger.info(http.getParameter("content"));
		logger.info(http.getParameter("num"));
		vo.setM_userid(http.getParameter("id"));
		vo.setB_title((String) http.getParameter("title"));
		vo.setB_writing((String) http.getParameter("content"));
		vo.setP_productid(productService.selectProductId((String) http.getParameter("image")));
		int num = Integer.parseInt((String)http.getParameter("num"));
		vo.setB_num(num);
		boardService.updateBoard(vo);
		return "redirect:/detail?b_num="+ num;
	}
	@GetMapping("/delete/{b_num}")
	public String delete(@PathVariable("b_num") int num) {
		logger.info("dao" + num);
		reviewService.deleteReviewAll(num);
		boardService.deleteBoard(num);
		return "redirect:/board";
	}
//	@PutMapping("/board/{b_num}") //글 업데이트
//	public Map boardUpdate(@PathVariable int b_num, Model model) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("b_num", b_num);
//		this.boardService.selectBoard(map);
//		List<BoardVO> list = (List<BoardVO>)map.get("boardResult");
//		BoardVO board = list.get(0);
//		map.put("boardResult", board);
//		return map;
//	}

}
