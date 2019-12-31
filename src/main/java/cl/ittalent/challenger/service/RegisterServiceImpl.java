package cl.ittalent.challenger.service;

import cl.ittalent.challenger.exception.ChallengerException;
import cl.ittalent.challenger.entity.Users;
import cl.ittalent.challenger.model.RequestRegister;
import cl.ittalent.challenger.model.ResponseRegister;
import cl.ittalent.challenger.repository.RegisterRepository;
import cl.ittalent.challenger.tools.Constants;
import cl.ittalent.challenger.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterServiceImpl implements RegisterService {

  @Autowired Tools tools;
  @Autowired RegisterRepository repository;

  @Override
  public ResponseRegister createRegister(RequestRegister requestRegister) throws ChallengerException {
    ResponseRegister responseRegister;

    try {
      tools.validateInputRegister(requestRegister);
      Users userValid = repository.findUser(requestRegister.getEmail());
      if (userValid == null) {
        Users user = new Users();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(requestRegister.getEmail());
        user.setName(requestRegister.getName());
        user.setPassword(requestRegister.getPassword());
        user.setNumber(requestRegister.getPhones().get(0).getNumber());
        user.setCitycode(requestRegister.getPhones().get(0).getCitycode());
        user.setCountrycode(requestRegister.getPhones().get(0).getCountrycode());
        user.setToken(UUID.randomUUID().toString());
        user.setIsactive(Constants.ACTIVE);
        Users userSaved = repository.save(user);
        responseRegister =
            new ResponseRegister(
                userSaved.getId(),
                userSaved.getCreated(),
                userSaved.getModified(),
                userSaved.getLastLogin(),
                userSaved.getToken(),
                userSaved.getIsactive());
      } else {
        throw new ChallengerException(Constants.ERROR_EMAIL, HttpStatus.BAD_REQUEST);
      }
    } catch (ChallengerException e) {
      throw new ChallengerException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseRegister;
  }
}
