
package com.MyBlog.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.Category;
import com.MyBlog.Service.BoardService;
import com.MyBlog.Service.HeaderService;
import com.MyBlog.Service.LeftService;

/*사용하지 않음*/
/*@Controller*/
public class LeftController {

	@Autowired
	BoardService boardService;

	@Autowired
	public LeftService leftService;
	
	@Autowired
	HeaderService headerService;

	@GetMapping("/category")
	public String saveCategoryName(@RequestParam(name = "c", required = false, defaultValue = "") String categoryName,
			@RequestParam(name = "p", required = false, defaultValue = "1") int page,
			@RequestParam(name = "f", required = false, defaultValue = "title") String field,
			@RequestParam(name = "q", required = false, defaultValue = "") String query,
			@RequestParam(name = "r", required = false, defaultValue = "15") int size,
			@RequestParam(name = "desc", required = false, defaultValue = "DESC") String desc,
			@RequestParam(name = "order", required = false, defaultValue = "date") String order,
			@RequestParam(name = "n", required = false, defaultValue = "") String nickName,
			@AuthenticationPrincipal PrincipalDetail principal, Model model,
			Board board
			) {

		
			List<Category> getCategoryList = leftService.getCategoryList(principal.getNickName());
			model.addAttribute("getCategoryList",getCategoryList);
		
			/* header */
			String getChannelName = headerService.getChannelName(principal.getUsername());
			if(getChannelName !=null)
			{
				model.addAttribute("getChannelName",getChannelName);
			}
		
		
		boolean pub = true;
		List<Board> getWritingList = boardService.getWritingList(page, field, query, pub, size, order, desc, categoryName, principal.getNickName());
		System.out.println("/category_getWritingList:"
				+"\n page:"+page+
				"\n field:"+field+
				"\n query:"+query+
				"\n rowNum:"+size+
				"\n order:"+order+
				"\n categoryName:"+categoryName+
				"\n nickName:"+principal.getNickName());
		
		
		
		int getWritingCount = boardService.getWritingCount(field, query);
		model.addAttribute("getWritingList", getWritingList);
		model.addAttribute("getWritingCount", getWritingCount);
		return "root.mid_contentList";
	}
	
	@GetMapping("/category/{categoryName}")
	public String getCategoryPage(@PathVariable String categoryName,
			@RequestParam(name = "p", required = false, defaultValue = "1") Integer page,
			@RequestParam(name = "f", required = false, defaultValue = "title") String field,
			@RequestParam(name = "q", required = false, defaultValue = "") String query,
			@RequestParam(name = "r", required = false, defaultValue = "15") Integer rowNum,
			@RequestParam(name = "desc", required = false, defaultValue = "DESC") String desc,
			@RequestParam(name = "order", required = false, defaultValue = "date") String order,
			@RequestParam(name = "n", required = false, defaultValue = "") String nickName,
			@AuthenticationPrincipal PrincipalDetail principal,
			Model model) {
		
		boolean pub = true;
		List<Board> getWritingList = boardService.getWritingList(page, field, query, pub, rowNum, order, desc, categoryName, principal.getNickName());
		System.out.println("/category/{categoryName}_getWritingList:"
				+"\n page:"+page+
				"\n field:"+field+
				"\n query:"+query+
				"\n rowNum:"+rowNum+
				"\n order:"+order+
				"\n categoryName:"+categoryName+
				"\n nickName:"+principal.getNickName());
		
		
		int getWritingCount = boardService.getWritingCount(field, query);
		model.addAttribute("getWritingList", getWritingList);
		model.addAttribute("getWritingCount", getWritingCount);
		
		
		return "root.mid_contentList";
	}
}
