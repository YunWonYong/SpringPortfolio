create table portfolio_account(
	a_id varchar2(15) not null primary key,
	m_id varchar2(15) references portfolio_member(m_id),
	a_jsession_id varchar2(100) not null,
	a_holding_time number(10) not null,
	a_autologin_check varchar2(10) not null
);



delete from PORTFOLIO_ACCOUNT


select * from portfolio_account


drop table portfolio_account

commit

update portfolio_account set a_holding_time =a_holding_time -(60*60*24)



