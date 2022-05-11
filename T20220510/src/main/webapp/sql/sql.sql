SELECT *
FROM   book_info;

-- Create table
CREATE TABLE book_info(book_code VARCHAR2(12) NOT NULL
                      ,book_title VARCHAR2(100) NOT NULL
                      ,book_author VARCHAR2(100) NOT NULL
                      ,book_press VARCHAR2(100) NOT NULL
                      ,book_price NUMBER) tablespace users pctfree 10 initrans 1 maxtrans 255 storage(initial 64k NEXT 1m
                                                                                                      minextents 1
                                                                                                      maxextents
                                                                                                      unlimited);
-- Create/Recreate primary, unique and foreign key constraints 
ALTER TABLE book_info add primary key(book_code)
    USING INDEX tablespace users pctfree 10 initrans 2 maxtrans 255 storage(initial 64k NEXT 1m
                                                                            minextents 1
                                                                            maxextents
                                                                            unlimited);

-- insert sample data
INSERT INTO book_info
    (book_code
    ,book_title
    ,book_author
    ,book_press
    ,book_price)
VALUES
    (create_bookcode
    ,'title' || SUBSTR(create_bookcode,10,12)
    ,'author' || SUBSTR(create_bookcode,10,12)
    ,'press' || SUBSTR(create_bookcode,10,12)
    ,SUBSTR(create_bookcode,10,12) * 1000);

SELECT *
FROM   book_info
ORDER  BY 1;
