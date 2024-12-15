-- Erstelle die Blog-Tabelle
CREATE TABLE blog (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      artist VARCHAR(255) NOT NULL,
                      location VARCHAR(255) NOT NULL,
                      timestamp TIMESTAMP NOT NULL
);

-- Erstelle die BlogList-Tabelle
CREATE TABLE blog_list (
                           id SERIAL PRIMARY KEY,
                           owner_id VARCHAR(255) NOT NULL,
                           name VARCHAR(255) NOT NULL,
                           is_private BOOLEAN NOT NULL
);

-- Erstelle die Beziehungstabelle zwischen Blogs und BlogLists
CREATE TABLE contains_blog (
                               blog_list_id INT NOT NULL,
                               blog_id INT NOT NULL,
                               PRIMARY KEY (blog_list_id, blog_id),
                               FOREIGN KEY (blog_list_id) REFERENCES blog_list(id) ON DELETE CASCADE,
                               FOREIGN KEY (blog_id) REFERENCES blog(id) ON DELETE CASCADE
);

-- Füge Beispiel-Blogs ein
INSERT INTO blog (title, artist, location, timestamp)
VALUES
    ('Exploring Java', 'John Doe', 'Berlin', '2024-12-13 10:00:00'),
    ('Spring Boot Essentials', 'Jane Smith', 'Munich', '2024-11-01 14:00:00'),
    ('PostgreSQL Basics', 'Max Mustermann', 'Hamburg', '2024-12-10 09:00:00');

-- Füge eine Beispiel-BlogList ein
INSERT INTO blog_list (owner_id, name, is_private)
VALUES
    ('owner123', 'Tech Blogs', false),
    ('owner456', 'Private Blogs', true);

-- Verknüpfe Blogs mit BlogLists
INSERT INTO contains_blog (blog_list_id, blog_id)
VALUES
    (1, 1), -- Blog ID 1 in BlogList ID 1
    (1, 2), -- Blog ID 2 in BlogList ID 1
    (2, 3); -- Blog ID 3 in BlogList ID 2

-- Abfrage: Alle Blogs
SELECT * FROM blog;

-- Abfrage: Alle BlogLists
SELECT * FROM blog_list;

-- Abfrage: BlogLists mit Blogs
SELECT
    bl.id AS blog_list_id,
    bl.name AS blog_list_name,
    bl.is_private,
    b.id AS blog_id,
    b.title AS blog_title,
    b.artist AS blog_artist,
    b.location AS blog_location,
    b.timestamp AS blog_timestamp
FROM
    blog_list bl
        LEFT JOIN
    contains_blog cb ON bl.id = cb.blog_list_id
        LEFT JOIN
    blog b ON cb.blog_id = b.id;
