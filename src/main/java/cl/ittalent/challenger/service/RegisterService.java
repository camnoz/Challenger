package cl.ittalent.challenger.service;

import cl.ittalent.challenger.model.RequestRegister;
import cl.ittalent.challenger.model.ResponseRegister;
import cl.ittalent.challenger.exception.ChallengerException;

public interface RegisterService {

  ResponseRegister createRegister(RequestRegister requestRegister) throws ChallengerException;
}
