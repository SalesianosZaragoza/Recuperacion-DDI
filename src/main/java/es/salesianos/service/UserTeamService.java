package es.salesianos.service;

import java.util.List;

import es.salesianos.model.UserTeam;
import es.salesianos.repository.UserTeamRepository;

public class UserTeamService {

	UserTeamRepository repository = new UserTeamRepository();

	private List<UserTeam> listUserTeam() {
		return repository.listAll();
	}

}
