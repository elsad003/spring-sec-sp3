package com.elsad.secsp3.repository.redis;

import com.elsad.secsp3.models.dto.caching.UserCache;
import org.springframework.data.repository.CrudRepository;

public interface CachedUserRepository extends CrudRepository<UserCache, String> {
}
