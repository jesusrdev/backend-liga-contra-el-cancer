package pe.org.ligacancer.user_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.ligacancer.user_service.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
