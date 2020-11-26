package com.od.crowdy.project.dao.neo4j.repository;

public interface Queries {
    String FIND_PROJECTS_BY_CATEGORY_NAME_CYPHER = """
            MATCH (p:Project)-[:
            """ + RelationShips.RELATED_TO + """
            ]->(c:Category {name: $categoryName}) 
            RETURN p.id as id, 
            p.name as name, 
            p.description as description, 
            p.createdAt as createdAt, 
            p.deadline as deadline, 
            p.imageUrls as imageUrls, 
            p.overallBack as overallBack, 
            p.currentBack as currentBack 
            """;
}
