create table portfolio_account(
	m_id varchar2(15) references portfolio_member(m_id),
	a_jsession_id varchar2(100) not null,
	a_holding_time number(10) not null
);

select * from portfolio_account
delete from PORTFOLIO_ACCOUNT
