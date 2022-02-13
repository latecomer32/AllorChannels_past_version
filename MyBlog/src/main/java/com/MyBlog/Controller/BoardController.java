package com.MyBlog.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.Channel;
import com.MyBlog.Service.BoardService;
import com.MyBlog.Service.ChannelService;
import com.MyBlog.Service.HeaderService;
import com.MyBlog.Service.LeftService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	HeaderService headerService;

	@Autowired
	LeftService leftService;

	@Autowired
	ChannelService channelService;

	@GetMapping("/board/saveTheWritingForm")
	public String saveTheWriting() {
		return "root.mid_saveTheWritingForm";
	}

	@RequestMapping({ "/", "/{channel}", "/{channel}" })
	public String index(@PathVariable(required = false) String channel,
			@RequestParam(name = "c", required = false, defaultValue = "") String categoryName,
			@RequestParam(name = "p", required = false, defaultValue = "1") int page,
			@RequestParam(name = "f", required = false, defaultValue = "title") String field,
			@RequestParam(name = "q", required = false, defaultValue = "") String query,
			@RequestParam(name = "r", required = false, defaultValue = "15") int size,
			@RequestParam(name = "desc", required = false, defaultValue = "DESC") String desc,
			@RequestParam(name = "order", required = false, defaultValue = "date") String order,
			@RequestParam(name = "n", required = false, defaultValue = "") String nickName, Model model, Board board,
			@AuthenticationPrincipal PrincipalDetail principal, HttpServletRequest request) {
		boolean pub = true;
	

		/* 로그인 전 */
		if (principal == null) {
			/* board */
			List<Board> getWritingList = boardService.getWritingList(page, field, query, pub, size, order, desc,
					categoryName, nickName);

			int getWritingCount = boardService.getWritingCount(field, query);
			model.addAttribute("getWritingList", getWritingList);
			model.addAttribute("getWritingCount", getWritingCount);
		}
		/* 로그인 후 */
		else if (request.getContextPath() == "/" && principal != null) {
			/* board */
			List<Board> getWritingList = boardService.getWritingList(page, field, query, pub, size, order, desc,
					categoryName, principal.getNickName());
			int getWritingCount = boardService.getWritingCount(field, query);
			model.addAttribute("getWritingList", getWritingList);
			model.addAttribute("getWritingCount", getWritingCount);

			/* header */
			String getChannelName = headerService.getChannelName(principal.getUsername());
			if (getChannelName != null) {
				model.addAttribute("getChannelName", getChannelName);
			}
			return "forward:/category";
		} else {

			/* board */
			List<Board> getWritingList = boardService.getWritingList(page, field, query, pub, size, order, desc,
					categoryName, principal.getNickName());
			int getWritingCount = boardService.getWritingCount(field, query);
			model.addAttribute("getWritingList", getWritingList);
			model.addAttribute("getWritingCount", getWritingCount);

			/* header */
			String getChannelName = headerService.getChannelName(principal.getUsername());
			if (getChannelName != null) {
				model.addAttribute("getChannelName", getChannelName);
			}

			/* left */
			List<Category> getCategoryList = leftService.getCategoryList(principal.getNickName());
			model.addAttribute("getCategoryList", getCategoryList);

		}

		/* Channel */
		List<Channel> getChannelList = channelService.getChannelList(page, size, query);
		int getChannelCount = channelService.getChannelCount(field, query);
		model.addAttribute("getChannelList", getChannelList);
		model.addAttribute("getChannelCount", getChannelCount);

		return "root.mid_contentList";
	}

	@GetMapping("/board/detail/{no}")
	public String findByNo(@PathVariable int no, Model model) {
		System.out.println("no" + boardService.getWritingDetail(no).getNo());
		model.addAttribute("board", boardService.getWritingDetail(no));
		return "root.mid_detail";

	}

}
