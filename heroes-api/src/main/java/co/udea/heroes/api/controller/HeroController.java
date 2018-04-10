package co.udea.heroes.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.heroes.api.domain.Hero;
import co.udea.heroes.api.exception.DataNotFoundException;
import co.udea.heroes.api.service.HeroService;
import co.udea.heroes.api.util.Messages;

@RestController
@RequestMapping("/tourofheroes")
public class HeroController {
	
	private static Logger log = LoggerFactory.getLogger(HeroController.class);
	
	@Autowired
    private Messages messages;	

	@Autowired
	@Qualifier("HeroServiceImpl")
	private HeroService heroService;

	
	@RequestMapping("listar")
	public List<Hero> getHeros(){
		return heroService.getHeroes();
	}
	
	@RequestMapping("consultar")
	public Hero getHero(int id) throws DataNotFoundException{
		log.debug("Entro a consultar");
		Optional<Hero> hero = heroService.getHero(id);
		if(!hero.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.hero"));
		}
		
		@Override
	    public void updateHero(Hero hero) {
	        // TODO Auto-generated method stub
	        heroRepository.save(hero);
	    }

	    @Override
	    public void addHero(Hero hero) {
	        // TODO Auto-generated method stub
	        heroRepository.save(hero);
	    }

	    @Override
	    public void deleteHero(Hero hero) {
	        // TODO Auto-generated method stub
	        heroRepository.delete(hero);
	        
	    }
		return hero.get();
	}
	
	
}
