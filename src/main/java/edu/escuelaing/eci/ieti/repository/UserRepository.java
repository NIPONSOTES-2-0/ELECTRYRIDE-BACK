package edu.escuelaing.eci.ieti.repository;


import edu.escuelaing.eci.ieti.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User,String> {
}