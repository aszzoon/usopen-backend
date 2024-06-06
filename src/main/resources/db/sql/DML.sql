use busan;

-- 회원가입
INSERT INTO USER
VALUES ('email@email.com', 'password', 'nickname', '01011111111', '서울특별시 종로구 안국동', '안국역 1번출구', null);

-- 로그인
select * from user where email = 'email@email.com';

-- 게시물 작성
insert into
    board (title, content, write_datetime, favorite_count, comment_count, view_count, write_email)
    values ('제목입니다', '내용입니다.', '2024-05-18', 0, 0, 0, 'email@email.com');

    insert into
    image values (1, 'url');

-- 댓글 작성

-- 테이블 수정
alter table comment
    change comment_number comment_number int not null  auto_increment comment '댓글 번호';
--

insert into
comment (content, write_datetime, user_email, board_number)
values ('반갑습니다.', '2024-05-18 19:40', 'email@email.com', 1);

update board set comment_count = comment_count + 1 where  board_number = 1;

-- 좋아요
insert into
    favorite values ('email@email.com', 1);

update board set favorite_count = favorite_count + 1 where  board_number = 1;

delete from favorite where user_email = 'email@email.com' and board_number = 1;

update board set favorite_count = favorite_count - 1 where  board_number = 1;

-- 게시물 수정
update board set title = '수정 제목 입니다.',  content = '수정 내용입니다.' where board_number =1;

delete  from image where board_number = 1;

insert into image values(1, 'url');

-- 게시물 삭제
delete from comment where board_number = 1;

delete from favorite where board_number =1;

delete from board where board_number = 1;

-- 상세 게시물 불러오기

SELECT *
FROM board AS A
INNER JOIN user AS U
ON 
