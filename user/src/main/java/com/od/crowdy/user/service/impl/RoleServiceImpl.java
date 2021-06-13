package com.od.crowdy.user.service.impl;

import com.od.crowdy.user.domain.neo4j.model.Role;
import com.od.crowdy.user.domain.neo4j.repository.RoleRepository;
import com.od.crowdy.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Flux<Role> getRolesByUserId(String userId) {
        return this.roleRepository.getRolesByUserId(userId);
    }

    @Override
    public Mono<Role> save(String userId, String roleName) {
        return this.roleRepository.save(userId, roleName);
    }
}
