package br.uniamerica.password.repostiroy;

import br.uniamerica.password.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "passwords", path = "passwords")
@CrossOrigin
public interface PasswordRepository extends SoftDeleteRepository<Password, Long> {
}
