package com.tiy;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by DTG2 on 09/24/16.
 */
public interface UserRepo extends CrudRepository<User, Integer>{
    User findFirstByName(String name);


}
