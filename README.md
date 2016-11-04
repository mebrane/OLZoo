drop table ol_usuario; drop table ol_animal; drop table ol_especie; drop table ol_genero; drop table ol_familia; drop table ol_cuidador; drop table ol_persona; drop table ol_zoologico; drop table ol_pais; commit; create table ol_animal ( anim_id NUMBER not null , anim_nomb VARCHAR2 (30) not null , anim_sexo CHAR (1) not null , anim_peso NUMBER (6,2) , anim_fnac DATE , espe_id NUMBER not null , zool_id NUMBER not null , cuid_id NUMBER not null , pais_id NUMBER not null ) ; alter table ol_animal add constraint ol_animal_pk primary key ( anim_id ) ; create table ol_cuidador ( cuid_id NUMBER not null , cuid_freg DATE not null , cuid_esta CHAR (1) not null , pers_id NUMBER not null ) ; alter table ol_cuidador add constraint ol_cuidador_pk primary key ( cuid_id ) ; create table ol_especie ( espe_id NUMBER not null , espe_nomc VARCHAR2 (30) not null , espe_nomv VARCHAR2 (30) not null , gene_id NUMBER not null ) ; alter table ol_especie add constraint ol_especie_pk primary key ( espe_id ) ; create table ol_familia ( fami_id NUMBER not null , fami_nomb VARCHAR2 (30) not null ) ; alter table ol_familia add constraint ol_familia_pk primary key ( fami_id ) ; create table ol_genero ( gene_id NUMBER not null , gene_nomb VARCHAR2 (30) not null , fami_id NUMBER not null ) ; alter table ol_genero add constraint ol_genero_pk primary key ( gene_id ) ; create table ol_pais ( pais_id NUMBER not null , pais_nomb VARCHAR2 (30) not null ) ; alter table ol_pais add constraint ol_pais_pk primary key ( pais_id ) ; create table ol_persona ( pers_id NUMBER not null , pers_nomb VARCHAR2 (30) not null , pers_apel VARCHAR2 (30) not null , pers_dire VARCHAR2 (50) , pais_id NUMBER not null, pers_esta char(1) not null ) ; alter table ol_persona add constraint ol_persona_pk primary key ( pers_id ) ; create table ol_usuario ( user_id NUMBER not null , user_user VARCHAR2 (30) not null , user_pass VARCHAR2 (30) not null , user_carg CHAR (1) not null , user_esta CHAR (1) not null , pers_id NUMBER not null ) ; alter table ol_usuario add constraint ol_usuario_pk primary key ( user_id ) ; create table ol_zoologico ( zool_id NUMBER not null , zool_nomb VARCHAR2 (30) not null , zool_anio NUMBER , zool_ciud VARCHAR2 (30) , pais_id NUMBER not null ) ; alter table ol_zoologico add constraint ol_zoologico_pk primary key ( zool_id ) ; alter table ol_animal add constraint ol_animal_ol_cuidador_fk foreign key ( cuid_id ) references ol_cuidador ( cuid_id ) not deferrable ; alter table ol_animal add constraint ol_animal_ol_especie_fk foreign key ( espe_id ) references ol_especie ( espe_id ) not deferrable ; alter table ol_animal add constraint ol_animal_ol_pais_fk foreign key ( pais_id ) references ol_pais ( pais_id ) not deferrable ; alter table ol_animal add constraint ol_animal_ol_zoologico_fk foreign key ( zool_id ) references ol_zoologico ( zool_id ) not deferrable ; alter table ol_cuidador add constraint ol_cuidador_ol_persona_fk foreign key ( pers_id ) references ol_persona ( pers_id ) not deferrable ; alter table ol_especie add constraint ol_especie_ol_genero_fk foreign key ( gene_id ) references ol_genero ( gene_id ) not deferrable ; alter table ol_genero add constraint ol_genero_ol_familia_fk foreign key ( fami_id ) references ol_familia ( fami_id ) not deferrable ; alter table ol_persona add constraint ol_persona_ol_pais_fk foreign key ( pais_id ) references ol_pais ( pais_id ) not deferrable ; alter table ol_usuario add constraint ol_usuario_ol_persona_fk foreign key ( pers_id ) references ol_persona ( pers_id ) not deferrable ; alter table ol_zoologico add constraint ol_zoologico_ol_pais_fk foreign key ( pais_id ) references ol_pais ( pais_id ) not deferrable ; commit; insert into ol_pais (pais_id, pais_nomb ) values (1, 'Perú' ); insert into ol_pais (pais_id, pais_nomb ) values (2, 'Chile' ); insert into ol_pais (pais_id, pais_nomb ) values (3, 'Ecuador' ); insert into ol_pais (pais_id, pais_nomb ) values (4, 'África' ); commit; insert into ol_zoologico ( zool_id, zool_ciud, zool_anio, pais_id, zool_nomb ) values ( 1, 'Santiago de Chile', 2000, 2, 'Zoológico de Santiago' ); insert into ol_zoologico ( zool_id, zool_ciud, zool_anio, pais_id, zool_nomb ) values ( 2, 'Lima', 2010, 1, 'Zoológico de Lima' ); commit; insert into ol_persona ( pers_id, pers_apel, pers_nomb, pais_id, pers_dire, pers_esta ) values ( 1, 'Apellido 1', 'Nombre 1', 1, 'Dirección 1', 'A' ); insert into ol_persona ( pers_id, pers_apel, pers_nomb, pais_id, pers_dire, pers_esta ) values ( 2, 'Apellido 2', 'Nombre 2', 2, 'Dirección 2', 'A' ); insert into ol_persona ( pers_id, pers_apel, pers_nomb, pais_id, pers_dire, pers_esta ) values ( 3, 'Apellido 3', 'Nombre 3', 3, 'Dirección 3', 'A' ); commit; insert into ol_cuidador ( cuid_id, cuid_esta, cuid_freg, pers_id ) values ( 1, 'A', sysdate, 1 ); insert into ol_cuidador ( cuid_id, cuid_esta, cuid_freg, pers_id ) values ( 2, 'A', sysdate, 2 ); insert into ol_cuidador ( cuid_id, cuid_esta, cuid_freg, pers_id ) values ( 3, 'A', sysdate, 3 ); commit; insert into ol_familia (fami_id, fami_nomb ) values (1, 'Hominidae' ); insert into ol_familia (fami_id, fami_nomb ) values (2, 'Felidae' ); insert into ol_familia (fami_id, fami_nomb ) values (3, 'Elephantidae' ); commit; insert into ol_genero (gene_id, gene_nomb, fami_id ) values (1, 'Pongo', 1 ); insert into ol_genero (gene_id, gene_nomb, fami_id ) values (2, 'Panthera', 2 ); insert into ol_genero (gene_id, gene_nomb, fami_id ) values (3, 'Loxodonta', 3 ); commit; insert into ol_especie ( espe_id, espe_nomv, espe_nomc, gene_id ) values ( 1, 'orangután', 'pygmaeus', 1 ); insert into ol_especie ( espe_id, espe_nomv, espe_nomc, gene_id ) values ( 2, 'tigre', 'tigris', 2 ); insert into ol_especie ( espe_id, espe_nomv, espe_nomc, gene_id ) values ( 3, 'león', 'leo', 2 ); insert into ol_especie ( espe_id, espe_nomv, espe_nomc, gene_id ) values ( 4, 'elefante', 'cyclotis', 3 ); commit; insert into ol_animal ( anim_id, anim_fnac, anim_nomb, anim_sexo, pais_id, cuid_id, espe_id, zool_id, anim_peso ) values ( 1, sysdate, 'Roberto', 'M', 3, 1, 1, 1, 50 ); insert into ol_animal ( anim_id, anim_fnac, anim_nomb, anim_sexo, pais_id, cuid_id, espe_id, zool_id, anim_peso ) values ( 2, sysdate, 'María', 'H', 4, 2, 4, 2, 40 ); commit; insert into ol_usuario ( user_id, user_carg, user_user, pers_id, user_esta, user_pass ) values ( 1, 'A', 'admin', 1, 'A', 'admin' ); insert into ol_usuario ( user_id, user_carg, user_user, pers_id, user_esta, user_pass ) values ( 2, 'A', 'empl1', 2, 'A', '11111' ); commit; drop sequence ol_animal_seq; create sequence ol_animal_seq minvalue 3 maxvalue 999999999999999999999999999 start with 3 increment by 1 cache 20; commit; drop sequence ol_cuidador_seq; create sequence ol_cuidador_seq minvalue 4 maxvalue 999999999999999999999999999 start with 4 increment by 1 cache 20; commit; drop sequence ol_especie_seq; create sequence ol_especie_seq minvalue 5 maxvalue 999999999999999999999999999 start with 5 increment by 1 cache 20; commit; drop sequence ol_familia_seq; create sequence ol_familia_seq minvalue 4 maxvalue 999999999999999999999999999 start with 4 increment by 1 cache 20; commit; drop sequence ol_genero_seq; create sequence ol_genero_seq minvalue 4 maxvalue 999999999999999999999999999 start with 4 increment by 1 cache 20; commit; drop sequence ol_pais_seq; create sequence ol_pais_seq minvalue 5 maxvalue 999999999999999999999999999 start with 5 increment by 1 cache 20; commit; drop sequence ol_persona_seq; create sequence ol_persona_seq minvalue 4 maxvalue 999999999999999999999999999 start with 4 increment by 1 cache 20; commit; drop sequence ol_usuario_seq; create sequence ol_usuario_seq minvalue 3 maxvalue 999999999999999999999999999 start with 3 increment by 1 cache 20; commit; drop sequence ol_zoologico_seq; create sequence ol_zoologico_seq minvalue 3 maxvalue 999999999999999999999999999 start with 3 increment by 1 cache 20; commit; select * from ol_persona;