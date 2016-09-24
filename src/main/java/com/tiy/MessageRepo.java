package com.tiy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by DTG2 on 09/24/16.
 */
public interface MessageRepo extends CrudRepository<Message, Integer>{
    List<Message> findByText(String text);

    List<Message> findByUser(User user);

    @Query("SELECT t FROM Message t WHERE t.text LIKE ?1%")
    List<Message> findByNameStartsWith(String text);

}
