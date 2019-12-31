package cl.ittalent.challenger.tools;

public class Constants {
    public static final String REGEX_EMAIL = "^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}\\b";
    public static final String REGEX_PASS = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{2,})[A-Za-z0-9]{1,}$";
    public static final String ERROR_EMAIL = "El Correo electrónico ya se encuentra registrado";
    public static final String ERROR_FORMAT_EMAIL = "Error en el formato del Email";
    public static final String ERROR_FORMAT_PASS = "Error en el formato de la Contraseña";
    public static final String ERROR_FIELDS_REQUIRED = "Error en la entrada : todos los campos son obligatorios";
    public static final String ACTIVE = "ACTIVE USER";
}
