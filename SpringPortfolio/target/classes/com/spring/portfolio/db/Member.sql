create table portfolio_member(
m_index number(7) unique not null,
m_id varchar2(15) primary key not null,
m_password varchar2(20) not null,
m_nickname varchar2(15) unique,
m_name varchar2(21) not null,
m_grant char(1) default 'z' check(REGEXP_LIKE(m_grant,'[a-z]')),  
m_birth date not null,
m_age number(3) default 1 check(m_age between 1 and 150) not null,
m_zipcode number(5) not null,
m_address1 varchar2(100) not null,
m_address2 varchar2(100) not null,
m_email varchar2(30) not null unique,
m_phone varchar2(13) not null,
m_gender char(1) check(m_gender in('1','0')) not null,
m_registdate date default sysdate,
c_index number(7) references portfolio_certification(c_index) on delete cascade not null
)

select * from PORTFOLIO_MEMBER where regexp_like(m_grant,'[c]')

drop table portfolio_member cascade constraints

alter table portfolio_member add 
constraint grant_value_check check(REGEXP_LIKE(m_grant,'[a-z]'))


delete from portfolio_member 

insert into portfolio_member(m_index,
						     m_id,
						     m_password,
						     m_nickname,
						     m_name,
						     m_grant,
						     m_birth,
						     m_age,
						     m_zipcode,
						     m_address1,
						     m_address2,
						     m_email,
						     m_phone,
						     m_gender,
						     c_index
						     )
values((select nvl(max(m_index),0)+1 from portfolio_member),
									'admin',
									'1234',
									'admin',
									'운영자',
									'a',
									'1992-11-07',
									29,
									00000,
									'회사사무실',
									'우리회사18평',
									'ywyi1992@naver.com',
									'010-2222-2222',
									'0', 
									(select c_index  from portfolio_certification where c_email = 'ywyi1992@naver.com')
									);
									
commit
delete from PORTFOLIO_MEMBER

select * from PORTFOLIO_MEMBER
 

update portfolio_member set m_grant = 'a'



select m_index,
	   m_id,
	   m_nickname,
	   m_name,
	   m_grant,
	   m_age,
	   m_gender,
	   m_registdate from portfolio_member
where m_index = 1 order by m_index desc 

select *
from(
	select * from(
	   					select m_index,
	   						   m_id,
	                           m_nickname,
	                           m_name,
	                           m_grant,
	                           m_age,
	                           m_gender,
	                           m_registdate,
	                           rownum as r
	                           from portfolio_member
	                    where m_grant ='z' order by m_index desc 
						)where r<=20
)where r between 10 and 20

create table portfolio_member_backup as select * from PORTFOLIO_MEMBER

select * from portfolio_member_backup


select * from portfolio_member

delete from portfolio_member cascade


select count(m_index) from portfolio_member where m_gender = '1'

drop table portfolio_member

create table portfolio_member_backup as select * from portfolio_member

select * from portfolio_member_backup


drop trigger set_certification_id
 
select * from all_triggers 
where table_name='PORTFOLIO_MEMBER'

select * from user_errors where type='TRIGGER'

select sysdate from PORTFOLIO_ACCOUNT


select * from portfolio_member 

select c_index from PORTFOLIO_member



CREATE OR REPLACE TRIGGER set_certification_id
AFTER insert on portfolio_member FOR EACH ROW
BEGIN
	update portfolio_certification set c_id = :new.m_id
	where c_index = :new.c_index and c_email = :new.m_email; 
END;
/
