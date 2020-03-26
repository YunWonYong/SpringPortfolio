Editor : STS 4.2.1, 
ORM : mybatis,
DBMS : Oracle11g,
Server : Aphache,
WAS : Tomcat v7.0,
Language : Java(JDK 1.8)

trigger :
portfolio_certification{
CREATE OR REPLACE TRIGGER modify_member_email
AFTER update on portfolio_certification FOR EACH ROW
BEGIN
   if :new.c_inspection_check = '1' and :old.c_inspection_check ='0' then
      update portfolio_member set m_email = :new.c_email
      where c_index = :new.c_index; 
   end if;
END;
/		
},
portfolio_member{
CREATE OR REPLACE TRIGGER set_certification_id
AFTER insert on portfolio_member FOR EACH ROW
BEGIN
	update portfolio_certification set c_id = :new.m_id
	where c_index = :new.c_index and c_email = :new.m_email; 
END;
/
}
