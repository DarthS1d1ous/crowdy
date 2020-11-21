package com.od.crowdy.user.dao.neo4j.repository;

public interface Queries {
    String FIND_AUTHOR_BY_PROJECT_ID_CYPHER = """
            MATCH (u:User)-[:
            """ + RelationShips.OWNS + """
            ]->(p:Project {id: $projectId}) 
            RETURN u
            """;
}
