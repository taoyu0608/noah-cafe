package noah.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import noah.core.model.User;
import noah.core.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String showAllUsersPage(Model model) {

		List<User> allUsers = userService.findAllUsers();
		model.addAttribute("users", allUsers);
		
		return "users";
	}
	
	@ResponseBody
	@RequestMapping("/users/list")
	public List<User> showAllUsers() {

		List<User> allUsers = userService.findAllUsers();
		return allUsers;
	}
}
