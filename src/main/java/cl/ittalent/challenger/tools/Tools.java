package cl.ittalent.challenger.tools;

import cl.ittalent.challenger.exception.ChallengerException;
import cl.ittalent.challenger.model.RequestRegister;
import cl.ittalent.challenger.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class Tools {

  public ResponseError createError(ChallengerException ex) {
    return new ResponseError(ex.getMessage());
  }

  public void validateInputRegister(RequestRegister requestRegister) throws ChallengerException {
    if (!validateObligatory(requestRegister)) {
      throw new ChallengerException(Constants.ERROR_FIELDS_REQUIRED, HttpStatus.BAD_REQUEST);
    } else {
      if (!validateEmail(requestRegister.getEmail())) {
        throw new ChallengerException(Constants.ERROR_FORMAT_EMAIL, HttpStatus.BAD_REQUEST);
      } else {
        if (!validatePassword(requestRegister.getPassword())) {
          throw new ChallengerException(Constants.ERROR_FORMAT_PASS, HttpStatus.BAD_REQUEST);
        }
      }
    }
  }

  private boolean validateObligatory(RequestRegister requestRegister) {
    return requestRegister.getEmail() != null
        && !requestRegister.getEmail().isEmpty()
        && requestRegister.getName() != null
        && !requestRegister.getName().isEmpty()
        && requestRegister.getPassword() != null
        && !requestRegister.getPassword().isEmpty()
        && requestRegister.getPhones() != null
        && !requestRegister.getPhones().isEmpty();
  }

  private boolean validateEmail(String email) {
    return Pattern.matches(Constants.REGEX_EMAIL, email);
  }

  private boolean validatePassword(String pass) {
    return Pattern.matches(Constants.REGEX_PASS, pass);
  }
}
