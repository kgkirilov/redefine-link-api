INSERT INTO user (`id_user`,`username`,
                  `password`,`email`,`firstname`,`lastname`,`created`,`updated`)
VALUES
(100,'username here','hashed password here','email here','firstname here','lastname here',
 CURRENT_TIMESTAMP(),
 CURRENT_TIMESTAMP()
);

INSERT INTO user (`id_user`,`username`,
                  `password`,`email`,`firstname`,`lastname`,`created`,`updated`)
VALUES
(101,'NEW USER','NEW USER','NEW USER','NEW USER','NEW USER',
 CURRENT_TIMESTAMP(),
 CURRENT_TIMESTAMP()
);



INSERT INTO url (`id_URL`,`url_original`,`url_rdfn`,`created`,`preview_mode`,`custom_domain`,`id_user`)
VALUES(100,'original domain','url short',CURRENT_TIMESTAMP(),0,1,100);

INSERT INTO url (`id_URL`,`url_original`,`url_rdfn`,`created`,`preview_mode`,`custom_domain`,`id_user`)
VALUES(101,'original domain2','url short2',CURRENT_TIMESTAMP(),1,0,100);

INSERT INTO url (`id_URL`,`url_original`,`url_rdfn`,`created`,`preview_mode`,`custom_domain`,`id_user`)
VALUES(102,'original domain3','url short3',CURRENT_TIMESTAMP(),1,0,101);

INSERT INTO country (`id_country`,`country`) VALUES (100, 'Bulgaria');
INSERT INTO country (`id_country`,`country`) VALUES (101, 'United Kingdom');


INSERT INTO visit (`id_visit`, `id_URL`,`id_country`,`created`)
VALUES (100, 100, 100, current_timestamp());

INSERT INTO visit (`id_visit`, `id_URL`,`id_country`,`created`)
VALUES (101, 100, 101, current_timestamp());

