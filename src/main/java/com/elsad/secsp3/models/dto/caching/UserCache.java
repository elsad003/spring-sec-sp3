package com.elsad.secsp3.models.dto.caching;

import com.elsad.secsp3.models.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@AllArgsConstructor
@Getter
@Accessors(chain = true)
@RedisHash("cacheData")
public class UserCache {
    @Id
    private String key;

    @Indexed
    private User value;
}