# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table camp (
  id                        integer not null,
  name                      varchar(255),
  latitude                  double not null,
  longitude                 double not null,
  country                   varchar(255),
  region                    varchar(255),
  state                     integer not null,
  size                      integer,
  constraint ck_camp_state check (state in (0,1)),
  constraint pk_camp primary key (id))
;

create table event (
  id                        integer not null,
  title                     varchar(255),
  type                      integer,
  latitude                  double,
  longitude                 double,
  description               TEXT,
  beginning                 timestamp,
  end                       timestamp,
  creator_login             varchar(255),
  constraint ck_event_type check (type in (0,1,2)),
  constraint pk_event primary key (id))
;

create table incident (
  id                        integer not null,
  type                      integer not null,
  latitude                  double,
  longitude                 double,
  date                      timestamp,
  constraint ck_incident_type check (type in (0,1,2,3,4)),
  constraint pk_incident primary key (id))
;

create table user (
  dtype                     varchar(10) not null,
  login                     varchar(255) not null,
  password                  varchar(255),
  email                     varchar(255),
  firstname                 varchar(255),
  lastname                  varchar(255),
  camp_id                   integer,
  role                      integer,
  birthday                  timestamp not null,
  birth_place               varchar(255) not null,
  health_state              integer not null,
  latitude                  double,
  longitude                 double,
  incident_id               integer,
  arrive_date               timestamp,
  leave_date                timestamp,
  constraint ck_user_role check (role in (0,1,2,3)),
  constraint ck_user_health_state check (health_state in (0,1,2,3,4)),
  constraint pk_user primary key (login))
;

create sequence camp_seq;

create sequence event_seq;

create sequence incident_seq;

create sequence user_seq;

alter table event add constraint fk_event_creator_1 foreign key (creator_login) references user (login) on delete restrict on update restrict;
create index ix_event_creator_1 on event (creator_login);
alter table user add constraint fk_user_camp_2 foreign key (camp_id) references camp (id) on delete restrict on update restrict;
create index ix_user_camp_2 on user (camp_id);
alter table user add constraint fk_user_incident_3 foreign key (incident_id) references incident (id) on delete restrict on update restrict;
create index ix_user_incident_3 on user (incident_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists camp;

drop table if exists event;

drop table if exists incident;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists camp_seq;

drop sequence if exists event_seq;

drop sequence if exists incident_seq;

drop sequence if exists user_seq;

