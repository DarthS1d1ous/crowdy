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
    String FIND_FOLLOWERS_BY_USER_ID_CYPHER = """
        MATCH (u:User {id: $userId})-[:
        """ + RelationShips.FOLLOWS + """
        ]->(f:User) 
        RETURN f
        """;
    String FIND_FAQS_BY_PROJECT_ID_CYPHER = """
        MATCH (:Project {id: $projectId})-[:
        """ + RelationShips.HAS + """
        ]->(f:Faq)
        RETURN f
        """;
    String FIND_COMMENTS_BY_PROJECT_ID_CYPHER = """
        MATCH (:Project {id: $projectId})-[:
        """ + RelationShips.HAS + """
        ]->(c:Comment)
        RETURN c
        ORDER BY c.createdAt ASC
        """;
    String FIND_AUTHOR_BY_COMMENT_ID_CYPHER = """
        MATCH (u:User)-[:
        """ + RelationShips.CREATES + """
        ]->(:Comment {id: $commentId})
        RETURN u
        """;
    String SAVE_COMMENT_CYPHER = """
        MATCH (p:Project {id: $projectId}),(u:User {id: $authorId}),(c:Comment {id: $commentId})
        CREATE (p)-[:
        """ + RelationShips.HAS + """
        ]->(c)<-[:
        """ + RelationShips.CREATES + """
        ]-(u)
        RETURN c
        """;
    String FIND_BACKOPTIONS_BY_PROJECT_ID_CYPHER = """
        MATCH (:Project {id: $projectId})-[:
        """ + RelationShips.HAS + """
        ]->(b:BackOption)
        RETURN b
        """;
}
