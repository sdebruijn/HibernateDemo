package nl.zwolle.mvc;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.zwolle.model.Rit;
import nl.zwolle.model.RitDao;

@Controller
public class RittenRegistratie {

	/**
	 * Toon een overzicht van alle ritten
	 */
	@RequestMapping("/")
	public String overzicht(Model model) {
		model.addAttribute("ritten", RitDao.all());
		return "overzicht";
	}

	
	/**
	 * Toon een detail-view van een enkele rit
	 */
	@RequestMapping(value="/rit/{id}")
	public String detailView(@PathVariable String id, Model model){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
			// id is geen getal? error 404
			return null;
		}
		Rit rit = RitDao.find(key);
		if(rit == null){
			// geen rit met gegeven id? error 404
			return null;
		} else {
			model.addAttribute("rit", rit);
			return "detail";
		}
	}
	
	
	/**
	 * Verwijdert gegeven rit -- zonder om bevestiging te vragen ;)
	 */
	@RequestMapping(value="/delete/{id}")
	public String deleteView(@PathVariable String id){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
			// id is geen getal? error 404
			return null;
		}

		RitDao.remove(key);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String nieuw(String omschrijving, BigDecimal start, BigDecimal end, Boolean business){
		RitDao.create(omschrijving, start, end, business);
		return "redirect:/";
	}
}
