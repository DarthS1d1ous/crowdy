package com.od.crowdy.common.domain.neo4j.model.mapper;

import org.neo4j.driver.Record;

public interface Neo4jMapper<T> {
    T map(Record record);
}
