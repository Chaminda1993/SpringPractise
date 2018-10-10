package forum.repository;

import forum.models.user;
import org.springframework.data.repository.CrudRepository;

public interface  userRepo extends CrudRepository<user,Integer>{

}