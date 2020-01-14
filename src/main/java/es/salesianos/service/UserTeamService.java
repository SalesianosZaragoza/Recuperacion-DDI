package es.salesianos.service;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.model.Character;
import es.salesianos.repository.Repository;

public class UserTeamService {

	@Autowired
	private Repository<Character> repository;

}
