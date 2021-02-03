
insert into userdto (id,email,username,password,role )
values (1,"morogoyo@gmail.com","morogoyo",
        "$2a$10$2.OGjHZerOxD39/L.k0ef.xspCCZ.MbyqVZCxbxbojZOT0/hknC6C",1
       );

insert into user_info (job_title,address,city,state,zip,birth_day,company_name,demographic_info,lead_source,marital_status,number_of_children,id,email)
values ("Software Engineer","123 main st.","Orlando","Florida",12345,
        "10-11-1979","noble digital","hispanic","sales funnel","maried",4,1,"morogoyo@gmail.com"
       );

-- insert into user_info (job_title,address,city,state,zip,birth_day,company_name,demographic_info,lead_source,marital_status,number_of_children,id)
-- values ("Software Engineer","123 main st.","Orlando","Florida",12345,
--         "10-11-1979","noble digital","hispanic","sales funnel","maried",4,1
--        );


insert into adminurls (url,id,email)
values ("nobledigitalservices.com/admin",1,"morogoyo@gmail.com"
       );
