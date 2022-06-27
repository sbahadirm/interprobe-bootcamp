CREATE TABLE customer
(
    id bigint NOT NULL,
    birth_date date,
    email character varying(50) ,
    name character varying(100) ,
    password character varying(400) ,
    phone_number character varying(15) ,
    status character varying(30) ,
    surname character varying(100) ,
    username character varying(15) ,
    cancel_date timestamp ,
    create_date timestamp ,
    created_by bigint,
    update_date timestamp ,
    updated_by bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
    );

create sequence customer_id_seq start with 1 increment by 50;
