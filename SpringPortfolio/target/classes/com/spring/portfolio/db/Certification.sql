create table portfolio_certification(
	c_index number(7) primary key not null,
	c_inspection varchar2(100) null,
	c_email varchar2(30) not null,
	c_date date null, 
	c_id varchar2(15) null,
	c_inspection_check char default '0'
)

insert into portfolio_certification(c_index,c_email) values((select nvl(max(c_index),0)+1 from portfolio_certification),'ywyi1992@naver.com')

delete from portfolio_certification where c_index = 1;

drop table portfolio_certification cascade constraints

select * from portfolio_certification

alter table portfolio_certification rename column m_email to c_email

alter table portfolio_certification rename column m_id to c_id

select * from PORTFOLIO_MEMBER m, portfolio_certification c, portfolio_account
where m.c_index = c.c_index


delete from portfolio_certification
where c_index = (select c.c_index from PORTFOLIO_MEMBER m,portfolio_certification c
				 where m.c_index = c.c_index)