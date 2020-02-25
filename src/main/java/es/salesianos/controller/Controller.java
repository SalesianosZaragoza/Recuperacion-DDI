package es.salesianos.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.repository.CharacterRepository;
import es.salesianos.repository.Repository;
import es.salesianos.service.CharacterService;
import es.salesianos.service.RaceService;
import es.salesianos.service.Service;
import es.salesianos.sql.DbSqlQuery;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService;

	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/listCharacters")
	public String getListCharacterPage() {
		return "listCharacters";
	}

	@GetMapping("/listRaces")
	public String getListRacePage() {
		return "listRaces";
	}

	@PostMapping("/listcharacters")
	protected ModelAndView listAllCharacters() {
		List<Character> characters = characterService.listAll();
		ModelAndView model = new ModelAndView("listCharacters");
		model.addObject("listOfCharacters", characters);
		return model;
	}

	@PostMapping("/listraces")
	protected ModelAndView listAllRaces() {
		List<Race> races = raceService.listAll();
		ModelAndView model = new ModelAndView("listRaces");
		model.addObject("listOfRaces", races);
		return model;
	}

	@PostMapping("/insertCharacter")
	public String insertCharacter(Character character) {
		updateHolders();
		characterService.insert(character);

		return "welcomeCharacter";
	}

	@PostMapping("/insertRace")
	public String insertRace(Race race) {
		raceService.insert(race);
		return "welcomeRace";
	}

	@GetMapping("/updateCharacter")
	protected ModelAndView editCharacterById(@RequestParam("id") Integer id) {
		ModelAndView model = new ModelAndView("updateCharacter");
		Character character = characterService.findById(id);
		model.addObject("character", character);
		return model;
	}

	@PostMapping("/updateCharacter")
	protected ModelAndView updateCharacter(@ModelAttribute Character character) {
		characterService.update(character);
		return listAllCharacters();
	}

	@GetMapping("deleteCharacter")
	protected ModelAndView deleteCharacter(@RequestParam("id") Integer id) {
		characterService.delete(id);
		return listAllCharacters();
	}

	@GetMapping("deleteRace")
	protected ModelAndView deleteRace(@RequestParam("id") Integer id) {
		raceService.delete(id);
		return listAllRaces();
	}

	//Pone todos los portadores a 'false'
	public void updateHolders() {
		AbstractConnection manager = new H2Connection();
		Connection conn = manager.open(Repository.jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(DbSqlQuery.UPDATE_CARRIER);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
}
