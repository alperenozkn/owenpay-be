package com.pentavex.owenpay.repository;

import com.pentavex.owenpay.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
