package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Payment;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;

public interface PaymentRepository extends ReactiveNeo4jRepository<Payment, String> {
}
