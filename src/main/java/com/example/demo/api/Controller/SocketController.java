package com.example.demo.api.Controller;

import com.example.demo.Socket.CityRoom.CityRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class SocketController {

	private final CityRoomRepository cityRoomRepository;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("chat");
		return mv;
	}

	/**
	 * 새로운 세션 생성
	 * @param pid
	 * @return "redirect:/"
	 */
	@PostMapping("/room/new")
	public String makeRoom(@RequestParam String pid){
		cityRoomRepository.createChatRoom(pid);
		return "redirect:/";
	}

	/**
	 * 현재 세션 확인
	 * @param
	 * @return "rooms"
	 */
	@GetMapping("/room/find")
	public String rooms(Model model){
		model.addAttribute("rooms",cityRoomRepository.findAllRoom());
		return "rooms";
	}

	/**
	 * 선택한 세션 제거
	 * @param pid
	 * @return "redirect:/"
	 */
	@PostMapping("/room/delete")
	public String deleteRoom(@RequestParam String pid){
		cityRoomRepository.deleteChatRoom(pid);
		return "redirect:/";
	}


	
	

}