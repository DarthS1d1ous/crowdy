package com.od.crowdy.common.domain.neo4j.repository;

public interface Queries {
    String FIND_PROJECTS_BY_CATEGORY_NAME_CYPHER = """
            MATCH (p:Project)-[:
            """ + RelationShips.RELATED_TO + """
            ]->(:Category {name: $categoryName}) 
            RETURN p
            """;
    String FIND_AUTHOR_BY_PROJECT_ID_CYPHER = """
            MATCH (u:User)-[:
            """ + RelationShips.OWNS + """
            ]->(:Project {id: $projectId}) 
            RETURN u
            """;
    String FIND_USER_BY_USERNAME_CYPHER = """
            MATCH (u:User {username: $username})
            RETURN u
            """;
    String FIND_ROLES_BY_USER_ID_CYPHER = """
            MATCH (r:Role)<-[:
            """ + RelationShips.HAS + """
            ]-(:User {id: $userId})
            RETURN r.name
            """;
    String FIND_USER_LIKES_BY_PROJECT_ID_CYPHER = """
            MATCH (u:User)-[:
            """ + RelationShips.LIKES + """
            ]->(:Project {id: $projectId})
            RETURN u
            """;
    String IS_USER_EXISTS_CYPHER = """
            MATCH (u:User {username: $username}) 
            RETURN EXISTS(u.username) as isExists
            """;
}
