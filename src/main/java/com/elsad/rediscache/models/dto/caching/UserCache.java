package com.elsad.rediscache.models.dto.caching;

import com.elsad.rediscache.models.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@AllArgsConstructor
@Getter
@Accessors(chain = true)
@RedisHash(value = "userCache")
public class UserCache {
    @Id
    private String key;

    @Indexed
    private User value;
}