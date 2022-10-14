package br.uniamerica.password;

import br.uniamerica.password.validator.UserValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;

@SpringBootApplication
public class PasswordApplication implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(PasswordApplication.class, args);
    }

    @Override
    public void configureValidatingRepositoryEventListener(
            ValidatingRepositoryEventListener validatingListener) {
        addValidator(new UserValidator(), validatingListener);
    }

    private void addValidator(Validator validator,
                              ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
        validatingListener.addValidator("beforeLinkSave", validator);
    }
}
