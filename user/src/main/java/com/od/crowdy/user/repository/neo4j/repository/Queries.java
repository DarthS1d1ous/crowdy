package com.od.crowdy.user.repository.neo4j.repository;

public interface Queries {
    String GET_AUTHOR_BY_PROJECT_ID_CYPHER = """
            MATCH (u:User)-[:OWNS]->(p:Project {id: $projectId}) 
            RETURN u
            """;
}
