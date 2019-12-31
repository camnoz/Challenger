package cl.ittalent.challenger.controller;

import cl.ittalent.challenger.exception.ChallengerException;
import cl.ittalent.challenger.model.RequestRegister;
import cl.ittalent.challenger.model.ResponseError;
import cl.ittalent.challenger.model.ResponseRegister;
import cl.ittalent.challenger.service.RegisterService;
import cl.ittalent.challenger.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challenger")
public class Controller {

  @Autowired
  RegisterService registerService;

  @Autowired
  Tools responseError;

  @PutMapping(
      value = "/register",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseRegister> createRegister(@RequestBody RequestRegister requestRegister) {
    return new ResponseEntity<>(registerService.createRegister(requestRegister), HttpStatus.OK);
  }

  @ExceptionHandler(ChallengerException.class)
  public ResponseEntity<ResponseError> exceptionHandler(ChallengerException ex) {
    return new ResponseEntity<>(responseError.createError(ex), ex.getHttpStatus());
  }
}
