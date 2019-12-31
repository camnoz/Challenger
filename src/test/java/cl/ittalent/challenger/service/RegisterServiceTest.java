package cl.ittalent.challenger.service;

import cl.ittalent.challenger.entity.Users;
import cl.ittalent.challenger.exception.ChallengerException;
import cl.ittalent.challenger.model.Phone;
import cl.ittalent.challenger.model.RequestRegister;
import cl.ittalent.challenger.model.ResponseRegister;
import cl.ittalent.challenger.repository.RegisterRepository;
import cl.ittalent.challenger.tools.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RegisterServiceTest {

  @Autowired private RegisterService registerService;

  @Mock private RegisterRepository repository;

  @DisplayName("Test Error Mandatory Fields")
  @Test
  void testErrorMandatory() {
    List<Phone> listPhone = new ArrayList<>();
    Phone phone = new Phone("123", "123", "123");
    listPhone.add(phone);
    RequestRegister requestRegister =
        new RequestRegister("", "mail@mail.com", "Hunter23", listPhone);
    try {
      registerService.createRegister(requestRegister);
    } catch (ChallengerException e) {
      assertEquals(Constants.ERROR_FIELDS_REQUIRED, e.getMessage());
    }
  }

  @DisplayName("Test Error Email Format")
  @Test
  void testErrorEmailFormat() {
    List<Phone> listPhone = new ArrayList<>();
    Phone phone = new Phone("123", "123", "123");
    listPhone.add(phone);
    RequestRegister requestRegister =
        new RequestRegister("John", "mailmail.com", "Hunter23", listPhone);
    try {
      registerService.createRegister(requestRegister);
    } catch (ChallengerException e) {
      assertEquals(Constants.ERROR_FORMAT_EMAIL, e.getMessage());
    }
  }

  @DisplayName("Test Error Format Password")
  @Test
  void testErrorPassFormat() {
    List<Phone> listPhone = new ArrayList<>();
    Phone phone = new Phone("123", "123", "123");
    listPhone.add(phone);
    RequestRegister requestRegister =
        new RequestRegister("John", "mail@mail.com", "Hunters2", listPhone);
    try {
      registerService.createRegister(requestRegister);
    } catch (ChallengerException e) {
      assertEquals(Constants.ERROR_FORMAT_PASS, e.getMessage());
    }
  }

  @DisplayName("Test Error Email Registered")
  @Test
  void testErrorEmailRegistered() {
    List<Phone> listPhone = new ArrayList<>();
    Phone phone = new Phone("123", "123", "123");
    listPhone.add(phone);
    RequestRegister requestRegister =
        new RequestRegister("John", "mail@mail.com", "Hunter23", listPhone);
    try {
      registerService.createRegister(requestRegister);
    } catch (ChallengerException e) {
      assertEquals(Constants.ERROR_EMAIL, e.getMessage());
    }
  }

  @DisplayName("Test Create User")
  @Test
  void testCreateUser() {
    List<Phone> listPhone = new ArrayList<>();
    Phone phone = new Phone("123", "123", "123");
    listPhone.add(phone);
    RequestRegister requestRegister =
        new RequestRegister("John", "mail@mail.com", "Hunter23", listPhone);
    String id = UUID.randomUUID().toString();
    String token = UUID.randomUUID().toString();
    Users user = new Users();
    user.setId(id);
    user.setEmail(requestRegister.getEmail());
    user.setName(requestRegister.getName());
    user.setPassword(requestRegister.getPassword());
    user.setNumber(requestRegister.getPhones().get(0).getNumber());
    user.setCitycode(requestRegister.getPhones().get(0).getCitycode());
    user.setCountrycode(requestRegister.getPhones().get(0).getCountrycode());
    user.setToken(token);
    user.setIsactive(Constants.ACTIVE);
    ResponseRegister expected =
        new ResponseRegister(id, new Date(), new Date(), new Date(), token, "ACTIVE USER");
    when(repository.findUser(requestRegister.getEmail())).thenReturn(user);
    when(repository.save(user)).thenReturn(user);
    ResponseRegister responseRegister = registerService.createRegister(requestRegister);
    assertEquals(expected.getIsactive(), responseRegister.getIsactive());
  }
}
