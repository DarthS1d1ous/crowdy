package com.od.crowdy.user.dao.neo4j.repository;

public interface Queries {
    String FIND_AUTHOR_BY_PROJECT_ID_CYPHER = """
            MATCH (u:User)-[:
            """ + RelationShips.OWNS + """
            ]->(p:Project {id: $projectId}) 
            RETURN u
            """;
    String FIND_USER_BY_USERNAME_CYPHER = """
            MATCH (u:User {username: $username})
            RETURN u
            """;
    String FIND_ROLES_BY_USER_ID_CYPHER = """
            MATCH (r:Role)<-[:
            """ + RelationShips.HAS + """
            ]-(u:User {id: $userId})
            RETURN r.name
            """;
}
