INSERT INTO OL_PAIS
  (PAIS_ID, PAIS_NOMB
  ) VALUES
  (1, 'Perú'
  );
  
INSERT INTO OL_PAIS
  (PAIS_ID, PAIS_NOMB
  ) VALUES
  (2, 'Chile'
);

INSERT INTO OL_PAIS
  (PAIS_ID, PAIS_NOMB
  ) VALUES
  (3, 'Ecuador'
  );
INSERT INTO OL_PAIS
  (PAIS_ID, PAIS_NOMB
  ) VALUES
  (4, 'África'
  );
  
commit;

INSERT
INTO OL_ZOOLOGICO
  (
    ZOOL_ID,
    ZOOL_CIUD,
    ZOOL_ANIO,
    PAIS_ID,
    ZOOL_NOMB
  )
  VALUES
  (
    1,
    'Santiago de Chile',
    2000,
    2,
    'Zoológico de Santiago'
  );
  
  INSERT
INTO OL_ZOOLOGICO
  (
    ZOOL_ID,
    ZOOL_CIUD,
    ZOOL_ANIO,
    PAIS_ID,
    ZOOL_NOMB
  )
  VALUES
  (
    2,
    'Lima',
    2010,
    1,
    'Zoológico de Lima'
  );
  
  commit;
  
  
  
  INSERT
INTO OL_PERSONA
  (
    PERS_ID,
    PERS_APEL,
    PERS_NOMB,
    PAIS_ID,
    PERS_DIRE,
    pers_esta
  )
  VALUES
  (
    1,
    'Apellido 1',
    'Nombre 1',
    1,
    'Dirección 1',
    'A'
  );
  
  INSERT
INTO OL_PERSONA
  (
    PERS_ID,
    PERS_APEL,
    PERS_NOMB,
    PAIS_ID,
    PERS_DIRE,
    pers_esta
  )
  VALUES
  (
    2,
    'Apellido 2',
    'Nombre 2',
    2,
    'Dirección 2',
    'A'
  );
  
  INSERT
INTO OL_PERSONA
  (
    PERS_ID,
    PERS_APEL,
    PERS_NOMB,
    PAIS_ID,
    PERS_DIRE,
    pers_esta
  )
  VALUES
  (
    3,
    'Apellido 3',
    'Nombre 3',
    3,
    'Dirección 3',
    'A'
  );
  
  commit;
  
  INSERT
INTO OL_CUIDADOR
  (
    CUID_ID,
    CUID_ESTA,
    CUID_FREG,
    PERS_ID
  )
  VALUES
  (
    1,
    'A',
    sysdate,
    1
  );
  
    INSERT
INTO OL_CUIDADOR
  (
    CUID_ID,
    CUID_ESTA,
    CUID_FREG,
    PERS_ID
  )
  VALUES
  (
    2,
    'A',
    sysdate,
    2
  );
  
    INSERT
INTO OL_CUIDADOR
  (
    CUID_ID,
    CUID_ESTA,
    CUID_FREG,
    PERS_ID
  )
  VALUES
  (
    3,
    'A',
    sysdate,
    3
  );
  
  commit;
  
  
  INSERT INTO OL_FAMILIA
  (FAMI_ID, FAMI_NOMB
  ) VALUES
  (1, 'Hominidae'
  );
  
    INSERT INTO OL_FAMILIA
  (FAMI_ID, FAMI_NOMB
  ) VALUES
  (2, 'Felidae'
  );
  
      INSERT INTO OL_FAMILIA
  (FAMI_ID, FAMI_NOMB
  ) VALUES
  (3, 'Elephantidae'
  );
  commit;
  
  INSERT INTO OL_GENERO
  (GENE_ID, GENE_NOMB, FAMI_ID
  ) VALUES
  (1, 'Pongo', 1
  );
  
    INSERT INTO OL_GENERO
  (GENE_ID, GENE_NOMB, FAMI_ID
  ) VALUES
  (2, 'Panthera', 2
  );
  
    INSERT INTO OL_GENERO
  (GENE_ID, GENE_NOMB, FAMI_ID
  ) VALUES
  (3, 'Loxodonta', 3
  );
  
  commit;
  
  INSERT
INTO OL_ESPECIE
  (
    ESPE_ID,
    ESPE_NOMV,
    ESPE_NOMC,
    GENE_ID
  )
  VALUES
  (
    1,
    'orangután',
    'pygmaeus',
    1
  );
  
   
  INSERT
INTO OL_ESPECIE
  (
    ESPE_ID,
    ESPE_NOMV,
    ESPE_NOMC,
    GENE_ID
  )
  VALUES
  (
    2,
    'tigre',
    'tigris',
    2
  );
  
   
  INSERT
INTO OL_ESPECIE
  (
    ESPE_ID,
    ESPE_NOMV,
    ESPE_NOMC,
    GENE_ID
  )
  VALUES
  (
    3,
    'león',
    'leo',
    2
  );
  
    INSERT
INTO OL_ESPECIE
  (
    ESPE_ID,
    ESPE_NOMV,
    ESPE_NOMC,
    GENE_ID
  )
  VALUES
  (
  4,
    'elefante',
    'cyclotis',
    3
  );
  
  commit;
  
  
  INSERT
INTO OL_ANIMAL
  (
    ANIM_ID,
    ANIM_FNAC,
    ANIM_NOMB,
    ANIM_SEXO,
    PAIS_ID,
    CUID_ID,
    ESPE_ID,
    ZOOL_ID,
    ANIM_PESO
  )
  VALUES
  (
    1,
    sysdate,
    'Roberto',
    'M',
    3,--pais
    1, --cuid
    1, --espe
    1,--zool
    50
  );
  
  
    INSERT
INTO OL_ANIMAL
  (
    ANIM_ID,
    ANIM_FNAC,
    ANIM_NOMB,
    ANIM_SEXO,
    PAIS_ID,
    CUID_ID,
    ESPE_ID,
    ZOOL_ID,
    ANIM_PESO
  )
  VALUES
  (
    2,
    sysdate,
    'María',
    'H',
    4,--pais
    2, --cuid
    4, --espe
    2,--zool
    40
  );
  
  commit;
  
  
  INSERT
INTO OL_USUARIO
  (
    USER_ID,
    USER_CARG,
    USER_USER,
    PERS_ID,
    USER_ESTA,
    USER_PASS
  )
  VALUES
  (
    1,
    'A',
    'admin',
    1,
    'A',
    'admin'
  );
  
   INSERT
INTO OL_USUARIO
  (
    USER_ID,
    USER_CARG,
    USER_USER,
    PERS_ID,
    USER_ESTA,
    USER_PASS
  )
  VALUES
  (
    2,
    'A',
    'empl1',
    2,
    'A',
    '11111'
  );
  
  commit;