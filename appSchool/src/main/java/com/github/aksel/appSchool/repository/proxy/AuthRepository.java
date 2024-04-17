package com.github.aksel.appSchool.repository.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("AUTHORIZATION-SERVICE")
public interface AuthRepository {
}
