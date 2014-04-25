# BiBlioteca Database Questions and Answers

## Who checked out the book ‘The Hobbit’?
### Answer:
    Anand Beck

### Query:
    SELECT name
    FROM member INNER JOIN checkout_item, book
    ON checkout_item.book_id = book.id AND checkout_item.member_id = member.id
    WHERE book.title LIKE "The Hobbit";

## How many people have not checked out anything?
### Answer:
    37

### Query:
    SELECT COUNT(*)
    FROM member
    WHERE member.id NOT IN
    (SELECT member_id
    FROM checkout_item);

## What books and movies aren’t checked out?
### Answer:
    1984
    Catcher in the Rye
    Crouching Tiger, Hidden Dragon
    Domain Driven Design
    Fellowship of the Ring
    Lawrence of Arabia
    Office Space
    Thin Red Line
    To Kill a Mockingbird
    Tom Sawyer

### Query:
SELECT title FROM book
    WHERE book.id NOT IN
    (SELECT book_id
    FROM checkout_item
    WHERE book_id IS NOT NULL)
    UNION
    SELECT title FROM movie
    WHERE movie.id NOT IN
    (SELECT movie_id
    FROM checkout_item
    WHERE movie_id IS NOT NULL);


## Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database.
### Query for add the book 'The Pragmatic Programmer':
      INSERT INTO book (title)
      VALUES ('Pragmatic Programmer');

### Query for add yourself as a member:
      INSERT INTO member(name)
      VALUES ('Gaby Zamudio');

### Query for checkout the book ' The Pragmatic Programmer':   
      INSERT INTO checkout_item (member_id, book_id)
      VALUES(
      (SELECT id from member where name  = 'Gaby Zamudio'),
      (SELECT id from book  where title = 'Pragmatic Programmer')  
      );
### Use your query from question 1 to verify that you have checked it out.
### Answer:
    Gaby Zamudio

### Query:
    SELECT name
    FROM member INNER JOIN checkout_item, book
    ON checkout_item.book_id = book.id AND checkout_item.member_id = member.id
    WHERE book.title LIKE "Pragmatic Programmer";

## Who has checked out more that 1 item? | Tip: Research the GROUP BY syntax.
### Answer:
      Anand Beck
      Frank Smith

### Query:

      SELECT name FROM member 
      WHERE id in
      (SELECT member_id 
      FROM  checkout_item 
      GROUP BY member_id
      HAVING COUNT(member_id) > 1);
