package helpers;

import models.Entity;
import repositories.Repository;

import java.util.Optional;

public class AccessValidator<T extends Entity>{

    private Repository<T> repository;

    public AccessValidator(Repository<T> repository){
        this.repository = repository;
    }

    public Boolean verifyAccess(String code) {;
        Optional<T> foundObject = this.repository.getByCode(code);
        return foundObject.isPresent();
    }
}
