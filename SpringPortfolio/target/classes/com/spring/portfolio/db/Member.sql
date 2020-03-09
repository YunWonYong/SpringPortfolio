create table portfolio_member(
m_index number(7) unique not null,
m_id varchar2(15) primary key not null,
m_password varchar2(20) not null,
m_nickname varchar2(15) unique,
m_name varchar2(21) not null,
m_grant char(1) default 'z', 
m_birth date not null,
m_age number(3) default 1 check(m_age between 1 and 150) not null,
m_zipcode number(5) not null,
m_address1 varchar2(100) not null,
m_address2 varchar2(100) not null,
m_email varchar2(30) not null,
m_phone varchar2(13) not null,
m_gender char(1) check(m_gender in('1','0')) not null,
m_registdate date default sysdate
)
drop table portfolio_member

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
						     m_gender
						     )
values((select nvl(max(m_index),0)+1 from portfolio_member),
									'admin',
									'1234',
									'admin',
									'admin',
									'a',
									'1992-11-07',
									29,
									00000,
									'회사사무실',
									'우리회사18평',
									'google@gmail.com',
									'010-2222-2222',
									'0');
									
commit

update portfolio_member set m_age = 32 where m_index = 2


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


select * from portfolio_member

delete from portfolio_member where m_index >2


select count(m_index) from portfolio_member where m_gender = '1'

