CREATE OR REPLACE FUNCTION create_bookcode RETURN VARCHAR2 IS

    v_code     book_info.book_code%TYPE;
    v_new_code book_info.book_code%TYPE;

BEGIN
    BEGIN
        SELECT MAX(book_code)
        INTO   v_code
        FROM   book_info
        WHERE  1 = 1
        AND    SUBSTR(book_code, 1, 8) = TO_CHAR(SYSDATE,'rrrrmmdd');
    EXCEPTION
        WHEN OTHERS THEN
        --v_new_code := TO_CHAR(SYSDATE, 'rrrrmmdd') || '-' || '001';
        v_code := TO_CHAR(SYSDATE, 'rrrrmmdd') || '-' || '000';
    
    END;

    IF v_code IS NULL THEN
        v_code := TO_CHAR(SYSDATE, 'rrrrmmdd') || '-' || '000';
    END IF;

    SELECT TO_CHAR(SYSDATE, 'rrrrmmdd') || '-' || LPAD(to_number(SUBSTR(v_code, 10, 12)) + 1, 3, '0')
    INTO   v_new_code
    FROM   dual;

    RETURN(v_new_code);
END create_bookcode;
/
