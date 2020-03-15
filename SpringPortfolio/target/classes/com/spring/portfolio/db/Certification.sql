create table portfolio_certification(
	c_index number(7) primary key not null,
	c_inspection varchar2(100) null,
	c_email varchar2(30) not null,
	c_date date default sysdate, 
	m_id varchar2(15) null,
	c_inspection_check char default '0'
)

insert into portfolio_certification(c_index,c_email) values((select nvl(max(c_index),0)+1 from portfolio_certification),'test@gmail.com')

delete from portfolio_certification where c_index = 1;

drop table portfolio_certification

select * from portfolio_certification

alter table portfolio_certification rename column m_email to c_email
