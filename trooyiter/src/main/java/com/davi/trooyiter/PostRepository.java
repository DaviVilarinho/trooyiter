package com.davi.trooyiter;

import org.springframework.data.repository.CrudRepository;
import com.davi.trooyiter.Post;

// spring sabe o que fazer...
public interface UserRepository extends CrudRepository<User, Integer> {

}