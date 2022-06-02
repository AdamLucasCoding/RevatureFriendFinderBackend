package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ActivityParticipant;
import com.revature.models.ClientMessage;
import com.revature.services.ActivityParticipantService;
import com.revature.util.ClientMessageUtil;

@RestController
@RequestMapping("/api")
public class ActivityParticipantController {
	
	@Autowired
	private ActivityParticipantService apService;
	
	@PostMapping(path="/ap/create")
	public @ResponseBody ClientMessage creatAp(@RequestBody ActivityParticipant ap) {
		if (apService.createAp(ap) != null) {
			return ClientMessageUtil.CREATION_SUCCESSFUL;
		} else {
			return ClientMessageUtil.CREATION_FAILED;
		}
	}
	
	@GetMapping(path="/ap/all")
	public @ResponseBody List<ActivityParticipant> apGetAll() {
		List<ActivityParticipant> allAps = apService.getAllAp();
		return apService.getAllAp();
	}
	
	@GetMapping(path="/ap/id")
	public @ResponseBody ActivityParticipant apById(@RequestBody int id) {
		return apService.getApById(id);
	}
	
	@GetMapping(path="/ap/byactivity")
	public @ResponseBody List<ActivityParticipant> apByActivity(@RequestBody int activity_id) {
		return apService.getApByActivity(activity_id);
	}
	
	@GetMapping(path="/ap/byuser")
	public @ResponseBody List<ActivityParticipant> apByUser(@RequestBody int user_id) {
		return apService.getApByUser(user_id);
	}
	
	@PutMapping(path="/ap/update")
	public @ResponseBody ActivityParticipant  updateAp(@RequestBody ActivityParticipant ap) {
		return apService.updateAp(ap);
	}
	
	@DeleteMapping(path="/ap/delete")
	public @ResponseBody boolean deleteAp(@RequestBody ActivityParticipant ap) {
		return apService.deleteAp(ap);
	}
	
}
