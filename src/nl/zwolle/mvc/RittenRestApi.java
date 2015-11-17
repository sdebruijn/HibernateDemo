package nl.zwolle.mvc;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.zwolle.model.Rit;
import nl.zwolle.model.RitDao;

@RestController
@RequestMapping("/api/")
public class RittenRestApi {

	@RequestMapping(method = RequestMethod.GET)
	public List<Rit> ritten() {
		
		return RitDao.all();
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public Rit create(Rit rit) {
		Rit newrit = RitDao.create(rit.getOmschrijving(), rit.getStart(),
				rit.getEnd(), rit.getBusiness());
		return newrit;
	}
	
	@RequestMapping(value="rit/{id}", method=RequestMethod.POST)
	public Rit rit(@PathVariable String id){
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
		} 
		return rit;
	}
	
	@RequestMapping(value="rit/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String id){
		Long key;
		try{
			key = Long.valueOf(id);
		}
		catch(NumberFormatException e){
			// id is geen getal? error 404
			return;
		}
		RitDao.remove(key);
	}
	
}
