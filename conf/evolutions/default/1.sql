# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table basket_item (
  id                        bigint not null,
  number_of_student_tickets integer,
  number_of_concession_tickets integer,
  number_of_under15tickets  integer,
  number_of_adult_tickets   integer,
  movie_title               varchar(255),
  movie_start_time          varchar(255),
  ticket_type               varchar(255),
  number_tickets            integer,
  constraint pk_basket_item primary key (id))
;

create sequence basket_item_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists basket_item;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists basket_item_seq;

