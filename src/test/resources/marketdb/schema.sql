drop table T_BRAND if exists;
drop table T_CATEGORY if exists;
drop table T_PRODUCT if exists;

create table T_BRAND (ID char(8) primary key, NAME varchar(50) not null, unique(NAME));
create table T_CATEGORY (ID char(8) primary key, LABEL varchar(50) not null, NAME varchar(50) not null, unique(LABEL));
create table T_PRODUCT (ID char(6) primary key, NAME varchar(120) not null, PRICE decimal(8, 2) not null, CATEGORY_ID char(8), BRAND_ID char(8));
create table T_PRODUCT_IMAGE (ID integer identity primary key, PRODUCT_ID char(6), LINK varchar(150) not null, unique(LINK));

alter table T_PRODUCT add constraint FK_CATEGORY foreign key (CATEGORY_ID) references T_CATEGORY(ID);
alter table T_PRODUCT add constraint FK_BRAND foreign key (BRAND_ID) references T_BRAND(ID);
alter table T_PRODUCT_IMAGE add constraint FK_PRODUCT foreign key (PRODUCT_ID) references T_PRODUCT(ID) on delete cascade;

CREATE SEQUENCE S_PRODUCT_NUMBER START WITH 1 INCREMENT BY 1;
create table DUAL_PRODUCT_NUMBER (ZERO integer);
insert into DUAL_PRODUCT_NUMBER values (0);