package com.elsad.rediscache.repository.redis;

import com.elsad.rediscache.models.dto.caching.UserCache;
import org.springframework.data.repository.CrudRepository;

public interface CachedUserRepository extends CrudRepository<UserCache, String> {
}
