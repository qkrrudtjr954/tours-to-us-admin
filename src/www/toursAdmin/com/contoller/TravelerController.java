package www.toursAdmin.com.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import www.toursAdmin.com.model.TravelerDto;
import www.toursAdmin.com.service.TravelerService;

@Controller
public class TravelerController {
	@Autowired
	TravelerService travelerService;
	
	Logger logger = LoggerFactory.getLogger(TravelerController.class);
	
	@RequestMapping(value="travelerManager.do", method=RequestMethod.GET)
	public String travelerManager(Model model) {
		List<TravelerDto> travelerList = travelerService.getAllTraveler();
		model.addAttribute("travelers", travelerList);
		return "travelerManager.tiles";
	}
	
	@RequestMapping(value="travelerDetail.do", method=RequestMethod.GET)
	public String travelerDetail(Model model, int seq) {
		TravelerDto traveler = travelerService.getTravelerBySeq(seq);
		model.addAttribute("traveler", traveler);
		return "travelerDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="deleteTraveler.do", method=RequestMethod.GET)
	public TravelerDto deleteTraveler(Model model, int seq) {
		TravelerDto traveler = travelerService.deleteTraveler(seq);
		return traveler;
	}
}
