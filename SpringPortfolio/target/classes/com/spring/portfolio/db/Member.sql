create table portfolio_member(
m_index number(7) unique not null,
m_id varchar2(15) primary key not null,
m_password varchar2(20) not null,
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

delete from portfolio_member

insert into portfolio_member(m_index,
						     m_id,
						     m_password,
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
									'admin123',
									'admin',
									'a',
									'1992-11-07',
									29,
									00000,
									'회사사무실',
									'우리회사18평',
									'google@gmail.com',
									'010-2222-2222',
									'0')