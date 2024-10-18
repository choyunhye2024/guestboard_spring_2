package com.peisia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dto.GuestDto;
import com.peisia.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*") // ;치지않음
// 프로젝트 루트 경로 이하 /guest상위폴더로 진입시 여기로 진입하게됨.
@AllArgsConstructor // 필드값을 매개변수로하는 생성자를 스프링이 알아서 만들어줌
// 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리 해줌 (@Auto.. 처럼)
@Controller
public class GuestController {

	// 위에 @AllArgsConstructor을 쓰면
	// 롬복 라이브러리가 아래 코드를 자동으로 삽입해줌

	// public GuestController(GuestService service){
	// this.service = service;
	// }

	public GuestService service;

	@GetMapping("/getList") // 프로젝트 경로 이하 /guest/getList URL진입 시 여기로 진입하게됨
	public void getList(Model model) { // 매개변수에 Model m식으로 작성하게되면
		// 스프링이 알아서 모델 객체를 만들어서 넘겨줌
		model.addAttribute("list", service.getList());
	} // 위 /getList와 동일한 jsp파일을 염. 상위경로 포함(/guest).
		// 즉 PJ부트/guest/getList.jsp 파일을 염.
		// 그리고 이 파일은 PJ/src/main/webapp/WEB-INP/view/guest/getList.jsp
		// 에 만들어놓으면 됨

	// 이런식으로 url 호출될 것을 가정하고
	// >>>홈페이지/spring/guest/read?bno=3
	// @GetMapping("/read")
	// public void read(@RequestParam("bno") Long bno, Model model){
	// log.info ("컨드롤러 == 글번호 == " + bno);
	// model.addAttribute("read", service.read(bno));
	// }

	@GetMapping({ "/read", "/modify" })
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ===== 글번호 ==========" + bno);
		model.addAttribute("read", service.read(bno));
	}

	// 이런식으로 url 호출될 것을 가정하고..
	// >>> 홈페이지/spring/guest/del?bno = 2
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ----- 글번호 ------------" + bno);
		service.del(bno);
		return "redirect:/guest/getList";
	}

	// >>>홈페이지/spring/guest/write (Post방식으로 오면 여기로 옴)
	@PostMapping("/write")
	// 폼태그의 텍스트 에어리어 태그에 btext 변수로 데이터가 넘어왔는데
	// 매개변수에 (GuestVO gvo) 이런 클래스를 선언해놓게 되면
	// 해당 객체의 멤버변수에 스프링이 알아서 채워줌
	public String write(GuestDto dto) {
		service.write(dto);
		return "redirect:/guest/getList"; // sendRedirect 로 이동하게됨

	}

	// >>>홈페이지 / spring / guest / write (get방식으로 오면 이리옴. 일반링크이동 = get방식임)
	@GetMapping("/write") // /write 중복이지만 이건 글쓰기 화면을 위한 url매핑
	public void write() {

	}

	@PostMapping("/modify")
	public String modify(GuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList";
	}
}
