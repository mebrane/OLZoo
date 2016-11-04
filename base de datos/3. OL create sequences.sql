 drop sequence ol_animal_seq;
  CREATE SEQUENCE ol_animal_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;
  
   drop sequence ol_cuidador_seq;
  CREATE SEQUENCE ol_cuidador_seq
  MINVALUE 4
  MAXVALUE 999999999999999999999999999
  START WITH 4
  INCREMENT BY 1
  CACHE 20;
  commit;
  
   drop sequence ol_especie_seq;
  CREATE SEQUENCE ol_especie_seq
  MINVALUE 5
  MAXVALUE 999999999999999999999999999
  START WITH 5
  INCREMENT BY 1
  CACHE 20;
  commit;
  
   
   drop sequence ol_familia_seq;
  CREATE SEQUENCE ol_familia_seq
  MINVALUE 4
  MAXVALUE 999999999999999999999999999
  START WITH 4
  INCREMENT BY 1
  CACHE 20;
  commit;
  
 
   drop sequence ol_genero_seq;
  CREATE SEQUENCE ol_genero_seq
  MINVALUE 4
  MAXVALUE 999999999999999999999999999
  START WITH 4
  INCREMENT BY 1
  CACHE 20;
  commit;
  
 
   drop sequence ol_pais_seq;
  CREATE SEQUENCE ol_pais_seq
  MINVALUE 5
  MAXVALUE 999999999999999999999999999
  START WITH 5
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  
   drop sequence ol_persona_seq;
  CREATE SEQUENCE ol_persona_seq
  MINVALUE 4
  MAXVALUE 999999999999999999999999999
  START WITH 4
  INCREMENT BY 1
  CACHE 20;
  commit;
  
 
   drop sequence ol_usuario_seq;
  CREATE SEQUENCE ol_usuario_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  
   drop sequence ol_zoologico_seq;
  CREATE SEQUENCE ol_zoologico_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  
  select * from ol_persona;