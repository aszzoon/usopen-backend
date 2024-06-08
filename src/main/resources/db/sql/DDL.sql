CREATE TABLE board
(
    board_number   INT         NOT NULL AUTO_INCREMENT COMMENT '게시물 번호',
    title          TEXT        NOT NULL COMMENT '게시물 제목',
    content        TEXT        NOT NULL COMMENT '게시물 내용',
    write_datetime DATETIME    NOT NULL COMMENT '게시물 작성 날짜',
    favorite_count INT         NOT NULL DEFAULT 0 COMMENT '게시물 좋아요 개수',
    comment_count  INT         NOT NULL DEFAULT 0 COMMENT '게시물 댓글 수',
    view_count     INT         NOT NULL DEFAULT 0 COMMENT '게시물 조회 수',
    write_email    VARCHAR(50) NOT NULL COMMENT '게시물 작성 이메일',
    PRIMARY KEY (board_number)
) COMMENT '게시물 테이블';

CREATE TABLE comment
(
    comment_number INT         NOT NULL COMMENT '댓글 번호',
    content        TEXT        NOT NULL COMMENT '댓글 내용',
    write_datetime DATETIME    NULL COMMENT '작성 날짜 및 시간',
    user_email     VARCHAR(50) NOT NULL COMMENT '사용자 이메일',
    board_number   INT         NOT NULL COMMENT '게시물 번호',
    PRIMARY KEY (comment_number)
) COMMENT '댓글 테이블';

CREATE TABLE favorite
(
    user_email   VARCHAR(50) NOT NULL COMMENT '사용자 이메일',
    board_number INT         NOT NULL COMMENT '게시물 번호'
) COMMENT '좋아요 테이블';

CREATE TABLE image
(
    board_number INT  NOT NULL COMMENT '게시물 번호',
    image        TEXT NOT NULL COMMENT '게시물 이미지 URL'
) COMMENT '게시물 이미지 테이블';

CREATE TABLE search_log
(
    sequence      INT     NOT NULL auto_increment COMMENT '시퀀스',
    search_world  TEXT    NOT NULL COMMENT '검색어',
    relation_word TEXT    NULL COMMENT '관련 검색어',
    relation      BOOLEAN NOT NULL COMMENT '관련 검색어 여부',
    PRIMARY KEY (sequence)
) COMMENT '검색 기록 테이블';

CREATE TABLE user
(
    email          VARCHAR(50)  NOT NULL COMMENT '사용자 이메일',
    password       VARCHAR(100) NOT NULL COMMENT '사용자 비밀번호',
    nickname       VARCHAR(20)  NOT NULL COMMENT '사용자 닉네임',
    tel_number     VARCHAR(15)  NOT NULL COMMENT '사용자 휴대폰번호',
    address        TEXT         NULL COMMENT '사용자 주소',
    address_detail TEXT         NULL COMMENT '사용자 상세 주소',
    profile_image  TEXT         NULL COMMENT '사용자 프로필 사진 URL',
    PRIMARY KEY (email)
) COMMENT '사용자 테이블';

ALTER TABLE image
    ADD CONSTRAINT FK_board_TO_image
        FOREIGN KEY (board_number)
            REFERENCES board (board_number);

ALTER TABLE board
    ADD CONSTRAINT FK_user_TO_board
        FOREIGN KEY (write_email)
            REFERENCES user (email);

ALTER TABLE favorite
    ADD CONSTRAINT FK_user_TO_favorite
        FOREIGN KEY (user_email)
            REFERENCES user (email);

ALTER TABLE favorite
    ADD CONSTRAINT FK_board_TO_favorite
        FOREIGN KEY (board_number)
            REFERENCES board (board_number);

ALTER TABLE comment
    ADD CONSTRAINT FK_user_TO_comment
        FOREIGN KEY (user_email)
            REFERENCES user (email);

ALTER TABLE comment
    ADD CONSTRAINT FK_board_TO_comment
        FOREIGN KEY (board_number)
            REFERENCES board (board_number);

CREATE VIEW board_list_view AS
select B.board_number   AS board_number,
       B.title          AS title,
       B.content        AS content,
       I.image          AS title_image,
       B.view_count     AS view_count,
       B.favorite_count AS favorite_count,
       B.comment_count  AS comment_count,
       B.write_datetime AS write_datetime,
       U.email          AS writer_email,
       U.nickname       AS writer_nickname,
       U.profile_image  AS write_profile_image
from board AS B
         inner Join user AS u
                    ON B.write_email = U.email
         LEFT JOIN(select board_number, MIN(image) as image from image group by board_number) AS I
                  ON B.board_number = I.board_number;

drop view board_list_view;