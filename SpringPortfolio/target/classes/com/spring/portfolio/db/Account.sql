create table portfolio_account(
	a_id varchar2(15) references portfolio_member(m_id) on delete cascade,
	a_jsession_id varchar2(100) not null,
	a_holding_time varchar2(50) not null,
	a_autologin_check varchar2(10) not null
);


insert into portfolio_account values('admin','TESTJSESSION','123128802','on')

 

delete from PORTFOLIO_ACCOUNT


select * from portfolio_account


drop table portfolio_account


commit

update portfolio_account set a_holding_time =a_holding_time -(60*60*24)



