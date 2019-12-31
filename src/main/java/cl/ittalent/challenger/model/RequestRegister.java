package cl.ittalent.challenger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RequestRegister {
  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  @JsonProperty("phones")
  private List<Phone> phones;

  public RequestRegister(
          final String name,
          final String email,
          final String password,
          final List<Phone> phones) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phones = phones;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public List<Phone> getPhones() {
    return phones;
  }
}
