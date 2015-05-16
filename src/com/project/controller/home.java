package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.dao.mosquedao;
import com.hibernate.util.mosques;
import com.hibernate.util.prayer_time;
import com.hibernate.util.users;
 
@Controller
public class home {
    @Autowired
    private mosquedao msqdao;
	@ModelAttribute("users")
	public users getuser(){
		return new users();
	}
	@RequestMapping(value="/home.jsp")
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	@RequestMapping("/mosque_data.json")
	public @ResponseBody String handle_data(HttpServletRequest req){
		String data = (String) req.getParameter("data");
        mosques msq = msqdao.getmsq(data);
		if (msq==null)
			return "{\"status\" : \"404\"}";
		else {
			prayer_time time = msq.getTimes();
			return "{\"jumma_time\" :\"" + msq.getJumma_time() + "\", \"capacity\" :\""+ msq.getCapacity() + "\", \"eid_time\" : \"" + msq.getEid_time() + "\", \"sect\" : \"" + msq.getSect() + "\"" +",\"status\":\"200\",\"fajar\": \""+time.getFajar()+ "\"" + ",\"zuhr\": \""+time.getZuhr()+ "\"" +",\"asar\": \""+time.getAsar()+ "\"" +",\"maghrib\": \""+time.getMaghrib()+ "\"" +",\"esha\": \""+time.getEsha()+ "\"" +",\"pic\": \""+msq.getPic()+ "\"" + "}";
		}
	}
	@RequestMapping("/modal.load")
	public ModelAndView handle_modal(@RequestBody String data){
		ModelAndView model = new ModelAndView("modal");
		data=data.replace("data=", "");
        mosques msq = msqdao.getmsq(data);
		if (msq==null){model.addObject("msqname", "Mosque not Found.");}
		else {
			prayer_time time = msq.getTimes();
			users admin = msq.getAdmin();
			model.addObject("msqname", msq.getPlace_name());model.addObject("msqsect", msq.getSect());
			model.addObject("msqaddress", "To be Added");model.addObject("msqnumber", admin.getPhone_number());model.addObject("msqadmin", admin.getName());
			model.addObject("Fajar", time.getFajar());model.addObject("Zuhr", time.getZuhr());model.addObject("Asar", time.getAsar());model.addObject("Maghrib", time.getMaghrib());model.addObject("Isha", time.getEsha());model.addObject("Juma", msq.getJumma_time());model.addObject("Eid", msq.getEid_time());
		}
		return model;
	}
}