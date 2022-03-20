--
-- PostgreSQL database dump
--

-- Dumped from database version 13.5 (Ubuntu 13.5-0ubuntu0.21.10.1)
-- Dumped by pg_dump version 13.5 (Ubuntu 13.5-0ubuntu0.21.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: animal; Type: TABLE; Schema: public; Owner: alan
--

CREATE TABLE public.animal (
                               id integer NOT NULL,
                               nombre text NOT NULL,
                               especie text NOT NULL,
                               familia text NOT NULL,
                               orden text NOT NULL,
                               clase text NOT NULL,
                               habitat text NOT NULL,
                               dieta text NOT NULL,
                               gestacion text NOT NULL,
                               crias text NOT NULL,
                               vida text NOT NULL
);


ALTER TABLE public.animal OWNER TO alan;

--
-- Name: animal_id_seq; Type: SEQUENCE; Schema: public; Owner: alan
--

ALTER TABLE public.animal ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: habitat; Type: TABLE; Schema: public; Owner: alan
--

CREATE TABLE public.habitat (
                                id integer NOT NULL,
                                habitat text NOT NULL,
                                description text NOT NULL
);


ALTER TABLE public.habitat OWNER TO alan;

--
-- Name: habitat_id_seq; Type: SEQUENCE; Schema: public; Owner: alan
--

ALTER TABLE public.habitat ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.habitat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: animal; Type: TABLE DATA; Schema: public; Owner: alan
--

COPY public.animal (id, nombre, especie, familia, orden, clase, habitat, dieta, gestacion, crias, vida) FROM stdin;
2       Antílope acuático       Kobus ellipsiprymnus    Bovidae\n Antilopinae  aMammalia        SABANA AFRICANA El kobo es una animal muy dependiente del agua, se alimenta de una gran variedad de herbáceas de diferentes medidas de longitud. Su dieta es muy rica en proteínas.     Alrededor de 270-285 días.      1      18 años.
42      Boa de Duméril  Acrantophis dumerili    Boidae  Squamata        ReptiliaBOSQUE ECUATORIAL       Se alimenta de vertebrados terrestres silvestres y aves domésticas.     6 – 8 meses.    De 6 a 13 crías.        No encontrado.
43      Bongo oriental  Tragelaphus eurycerus isaaci    Bovidae\n Bovinae      Artiodactyla     Mammalia        BOSQUE ECUATORIAL       Ramoneador estricto, el bongo se alimenta principalmente de hojas y brotes de arbustos y de plantas trepadoras, aunque también busca la madera, corteza y frutas podridas.      285 días.       1       18 años en cautividad.
44      Búfalo rojo     Syncerus caffer nanus   Bovidae\n Bovinae       Artiodactyla    Mammalia        BOSQUE ECUATORIAL       Hierba, ramitas y brotes tiernos.       300 días.       1       18-20 años en la naturaleza, hasta 28 en cautividad.
45      Camaleón pantera        Furcifer pardalis       Chamaeleonidae  SquamataReptilia        BOSQUE ECUATORIAL       Invertebrados terrestes, pocas veces materia vegetal.   3-6 semanas.    10-46 huevos    Cautividad 5-6 años, libertad 1-3 años.
46      Cercopiteco de Brazza   Cercopithecus neglectus Cercopithecidae PrimatesMammalia        BOSQUE ECUATORIAL       Aunque es omnívoro, el 50-75% de su dieta son frutos y semillas, compensa los déficits con hojas y flores y también puede alimentarse de hongos, escarabajos, termitas y gusanos.       168 días.      122 años en la naturaleza y hasta 30 años en cautividad.
47      Chimpancé       Pan troglodytes Hominidae       Primates        MammaliaBOSQUE ECUATORIAL       Es omnívoro, alimentándose principalmente de frutas (la mitad de su dieta), hojas, cortezas y tallos. También se nutre de termitas y otros insectos, aves, huevos y pollos, y ocasionalmente pequeños mamíferos (entre ellos otros primates).   240 días.       1       40-60 años.
48      Cocodrilo enano Osteolaemus tetraspis   Crocodylidae    Crocodylia     Reptilia BOSQUE ECUATORIAL       Se alimenta principalmente de peces, cangrejos y anfibios.      100 días.       11-20   70 años.
49      Cucaracha silbadora     Gromphadorhina portentosa       Blaberidae     Blattodea        Insecta BOSQUE ECUATORIAL       Son detritívoros, se alimentan generalmente de restos de materia vegetal, incluida la fruta caída debido a su fácil disponibilidad, también se alimentan de insectos más pequeños y de cuerpos y restos de otros animales.      60-70 días.     15-40   2-5 años.
50      Dril    Mandrillus leucophaeus  Cercopithecidae Primates        MammaliaBOSQUE ECUATORIAL       Omnívoro, raíces, tubérculos, frutas, brotes y otras materias vegetales son complementados con caracoles, gusanos, insectos, ranas, lagartijas, culebras, ratones y otros pequeños mamíferos.   179-182 días.   1      Se estima que supera los 28 años.
51      Duiker rojo de Natal    Cephalophus natalensis  Bovidae\n Antilopinae  Artiodactyla     Mammalia        BOSQUE ECUATORIAL       Hojas, frutos y flores de diferentes especies ribereñas de árboles, arbustos y hierbas. 210 días.      1Hasta 15 años en cautividad.
52      Escorpión emperador     Pandinus imperator      Scorpionidae    Scorpiones      Arachnida       BOSQUE ECUATORIAL       Insectos y otros artrópodos, y en ocasiones pequeños vertebrados. Generalmente se alimenta de termitas. Ovovivíparo.    10-12   5-8 años en cautividad, mucho menos en la naturaleza.
54      Gecko de Madagascar     Phelsuma madagascariensis       Gekkonidae     Squamata Reptilia        BOSQUE ECUATORIAL       Se alimenta principalmente de una amplia variedad de artrópodos, aunque ocasionalmente también se alimenta de frutos y néctar. Su principal fuente de agua es la se forma por condensación sobre las hojas.     47-82 días.     2       15 años.
55      Gorila occidental de costa      Gorilla gorilla gorilla Hominidae      Primates Mammalia        BOSQUE ECUATORIAL       Un porcentaje muy alto en su dieta es vegetariana, ingiriendo una gran cantidad de plantas herbáceas, fruta, matorrales, plantas trepadoras y savia. También se alimentan de termitas, pero en un porcentaje más bajo en comparación con los vegetales. 260 días.       1      Alrededor de 50 años.
57      Hipopótamo pigmeo       Choeropsis liberiensis  Hippopotamidae  Artiodactyla    Mammalia        BOSQUE ECUATORIAL       Hojas, plantas acuáticas, frutos caídos, raíces y tubérculos. Usa sus gruesos labios llevarse la comida a la boca.      196-201 días.   1       Hasta 55 años en cautividad.
58      Leopardo        Panthera pardus\nPanthera pardus kotiya Felidae\n Pantherinae   Carnivora       Mammalia        BOSQUE ECUATORIAL       Generalmente cazan ungulados de tamaño medio, como antílopes, gacelas, ciervos, cerdos o ganado y también primates. Como buenos carnívoros oportunistas que son, se alimentan además de aves, reptiles, roedores o artrópodos. Prefieren presas de entre 10-40 kg. Se ha observado también como sustraen comida a otros animales, como guepardos, hienas solitarias y otros pequeños carnívoros.        97 días.        2-3    10-12 años en la naturaleza, hasta 20-22 en cautividad.
59      Mangabey de coronilla blanca    Cercocebus atys lunulatus       Cercopithecidae Primates        Mammalia        BOSQUE ECUATORIAL       Los frutos, incluidos carne y cáscaras de frutos muy duros, son sus alimentos básicos. También se alimentan de semillas, hojas y pequeños animales invertebrados.       163-167 días.   1       18 años en la naturaleza y 27 años en cautividad.
60      Nutria de cuello moteado        Hydrictis maculicollis  Mustelidae\n Lutrinae   Carnivora       Mammalia        BOSQUE ECUATORIAL       Peces (Barbus, Clarias, Haplochromis, Micropterus salmoides, Salmo trutta y Tilapia), cangrejos (Potomonautes) y ranas (Xenopus laevis y Rana). En primavera, verano y otoño se alimenta principalmente de cangrejos mientras que en invierno predomina la ingesta de peces. Ocasionalmente también se alimenta de insectos y pájaros.  60 días.2-3     22 años.
62      Potamoquero rojo        Potamochoerus porcus pictus     Suidae  Artiodactyla    Mammalia        BOSQUE ECUATORIAL       Omnívoro generalista, con marcada preferencia por raíces y tubérculos, también incluye en su dieta frutos, hierbas, plantas acuáticas, bulbos, insectos, huevos de aves, carroña.       120-130 días.   1-4 (rara vez 6).       12-15 años.
63      Sitatunga occidental    Tragelaphus spekiigratus        Bovidae\n Bovinae       Artiodactyla    Mammalia        BOSQUE ECUATORIAL       Cañas, plantas acuáticas y hierbas, ocasionalmente ramonea.     247 días.       1       19 años.
64      Talapoín norteño        Miophitecus ogouensis   Cercopithecidae PrimatesMammalia        BOSQUE ECUATORIAL       Los frutos constituyen casi el 80% de su dienta, aunque también se alimenta de hojas, semillas e invertebrados. 158-166 días.   1       28 años.
65      Tortuga leopardo        Geochelone pardalis     Testudinidae    Testudines      Reptilia        BOSQUE ECUATORIAL       Estrictamente herbívora, se alimentan generalmente de plantas suculentas, cardos y hierba.      140-180 días.  5-30     100 años.
66      Cocodrilo del Nilo      Crocodylus niloticus    Crocodylidae    Crocodylia      Reptilia        HUMEDALES AFRICANOS: LA CUEVA DE KITUM  Cuando son pequeños se alimentan de pequeños invertebrados acuáticos e insectos. En la edad adulta, sus presas son principalmente grandes vertebrados, como antílopes, búfalos, cebras, ñus, etc. Los peces y los pequeños vertebrados también son parte importante de su dieta.        80-90 días.     40-60 huevos.   45 años.
68      Hipopótamo común        Hippopotamus amphibius  Hippopotamidae  Artiodactyla    Mammalia        HUMEDALES AFRICANOS: LA CUEVA DE KITUM  Florívoro, aunque principalmente pastan en las riberas de los ríos, han sido vistos alimentándose de vegetación acuática y ocasionalmente de carroña y pequeños animales en respuesta a sus restricciones nutricionales. Usa sus finos labios para llevarse la comida a la boca.        227-240 días.   1       40-50 años.
69      Mantela dorada  Mantella aurantiaca     Mantellidae     Anura   AnfibiosHUMEDALES AFRICANOS: LA CUEVA DE KITUM  Insectívora a base de termitas, hormigas, moscas de la fruta y también cualquier otro artrópodo que quepa en su boca.  No hay información disponible.   No hay información disponible.  No hay información disponible.
71      Rana veneno azul        Dendrobates azureus     Dendrobatidae   Anura  Anfibios HUMEDALES AFRICANOS: LA CUEVA DE KITUM  Principalmente a base de hormigas, termitas y otros pequeños insectos, así como pequeñas arañas.        No hay información disponible.  No hay información disponible.  No hay información disponible.
72      Rana veneno fantasma    Epipedobates tricolor   Dendrobatidae   Anura  Anfibios HUMEDALES AFRICANOS: LA CUEVA DE KITUM  Insectívora a base de pequeños insectos.        No hay información disponible.  No hay información disponible. No hay información disponible.
74      Fosa    Cryptoprocta ferox      Eupleridae\n Euplerinae Carnivora      Mammalia ISLA DE MADAGASCAR      Principal depredador de Madagascar, se alimenta de pequeños mamíferos, aves, reptiles, anfibios e insectos. Los lémures constituyen más de la mitad de su dieta.        90 días.        2-4     20 años.
75      Lémur de cola anillada  Lemur catta     Lemuridae       Primates       Mammalia ISLA DE MADAGASCAR      Frutas, hojas, flores, hierbas y, ocasionalmente, insectos.     120-135 días.   1 individuo o gemelos.  Alrededor de 27 años en la naturaleza y 30 en cautividad.
76      Lémur frentirrojo       Eulemur rufus   Lemuridae       Primates       Mammalia ISLA DE MADAGASCAR      Altamente frugívoros, las frutas constituyen más del 50% de su dieta. También se alimenta de hojas, flores, y ocasionalmente de insectos y otros artrópodos.    120 días.       1       En la naturaleza desconocida, en cautividad hasta 35 años.
77      Lémur mangosta  Eulemur mongoz  Lemuridae       Primates        MammaliaISLA DE MADAGASCAR      Se alimentan principalmente de frutos, hojas, flores y néctar.  128 días.       1       En la naturaleza desconocida, en cautividad hasta 30 años.
78      Lémur de vientre rojo   Eulemur rubriventer     Lemuridae       PrimatesMammalia        ISLA DE MADAGASCAR      Fruta, flores, néctar, hojas y ocasionalmente insectos. 127-130 días.   1       20-25 años.
80      Vari blanquinegro       Varecia variegata variegata     Lemuridae      Primates Mammalia        ISLA DE MADAGASCAR      Es el lémur más frugívoro que existe, siendo su dieta principalmente a base de frutas, aún así también se alimenta de hojas, néctar y semillas en función de la estación.       90-102 días.   2-6      19 años en la naturaleza, hasta 28-32 años en cautividad.
81      Vari rojo       Varecia rubra   Lemuridae       Primates        MammaliaISLA DE MADAGASCAR      Se alimentan principalmente de fruta, néctar y polen. Durante la estación seca, cuando la comida escasea, se alimentan también de hojas, flores y semillas.     90-102 días.    3       18-20 años en naturaleza, hasta 25 años en cautividad.
5       Blesbok Damaliscus pygargus phillipsi   Bovidae\n Antilopinae   a      Mammalia SABANA AFRICANA Herbívora a base principalmente de gramíneas del género Themeda (en varias fases de crecimiento) y también de los géneros Eragrostis y Chloromelas.     Alrededor de 240 días.  1       23 años.
6       Cebra de Grant  Equus burchelli boehmi  Equidae a       Mammalia       SABANA AFRICANA  Pasto de baja calidad, tallos duros y, en ocasiones, hojas o cortezas de árboles y arbustos, requieren de una gran cantidad de alimento por lo que no es raro que pasen en torno a 20 horas al día pastando.    360-370 días.  138-40 años.
9       Damán roquero   Procavia capensis       Procaviidae     a       MammaliaSABANA AFRICANA Incluye una gran variedad de hierbas y arbustos, prefieren los brotes, capullos, frutas y bayas, ocasionalmente también se alimentan de corteza de árbol.       De 212 a 240 días.      1-6     Alrededor de 12 años.
10      Dik-dik de Kirk Madoqua kirkii  Bovidae\n Antilopinae   a       MammaliaSABANA AFRICANA Herbívora, a base de materia vegetal fácilmente digerible y con poca cantidad de fibra. El 80% de su dieta consiste en hojas de árboles y arbustos, el 17% procede de pastos, y el resto de hierbas y juncos.   Alrededor de 170 días.  1       17 años.
11      Elefante africano de sabana     Loxodonta africana      Elephantidae   aMammalia        SABANA AFRICANA Herbívoros generalistas, se alimentan de una gran variedad de hierbas y material herbáceo que incluye raíces, hojas, frutos, ramas, cortezas y semillas.        640-660 días.   1       50-70 años.
15      Facoquero       Phacochoerus africanus  Suidae  a       Mammalia       SABANA AFRICANA  Dieta omnívora compuesta de hierbas, raíces, bayas, corteza y ocasionalmente de hongos, huevos y carroña, así como pequeños mamíferos, reptiles y aves. El alimento ingerido varía estacionalmente en función de la disponibilidad, este oportunismo y la versatilidad de la dieta constituyen una excelente estrategia que garantiza su supervivencia. 170-175 días.   1-7     7-11 años.
16      Gacela Mhorr    Nanger dama mhorr       Bovidae\n Antilopinae   a      Mammalia SABANA AFRICANA Animal pastador, se alimenta principalmente de hojas de acacias, de duros y ásperos pastos, de matorrales y de granos de mijo.  Entre 174-202 días.     1       12 años en la naturaleza y hasta 19 en cautividad.
17      Gacela de Thomson       Eudorcas thomsonii      Bovidae\n Antilopinae  aMammalia        SABANA AFRICANA Herbívora a base principalmente de pastos de pequeño tamaño, también se alimentan de ramitas, semillas y hojas de árboles, especialmente durante la estación seca.      Alrededor de 180 días.  1       10 años.
19      Hiena manchada  Crocuta crocuta Hyaenidae\n Hyaeninae   a       MammaliaSABANA AFRICANA Diferentes especies de antílopes, cebras, búfalos, ñus, zorros, leones jóvenes y en ocasiones carroña.  117 días.       1-4, siendo la media 2.12 años.
21      Impala  Aepyceros melampus      Bovidae\n Antilopinae   a       MammaliaSABANA AFRICANA Pasta casi exclusivamente durante la estación lluviosa, cuando llega la estación seca el porcentaje de gramíneas disminuye hasta un 30% de su dieta y ramonea arbustos, herbáceas, vainas y semillas.   Alrededor de 195-200 días.      1       13 años en la naturaleza y hasta 17 en cautividad.
23      Jirafa Baringo  Giraffa camelopardalis rothschildi\nGiraffa camelopardalis      Giraffidae      a       Mammalia        SABANA AFRICANA Hojas, ramas y flores principalmente de diferentes especies de acacia.  Alrededor de 450 días. 1De 10-15 años en la naturaleza y de 20-27 en cautividad.
24      León africano   Panthera leo bleyenberghi\nPanthera leo Felidae\n Pantherinae   a       Mammalia        SABANA AFRICANA Carnívoros generalistas, aunque los ungulados de mediano y gran tamaño ocupan la mayor parte de su dieta, pueden alimentarse de una gran variedad de vertebrados, desde pequeños ratones hasta jóvenes rinocerontes, hipopótamos y elefantes, pasando por pájaros, reptiles, peces e incluso insectos.  92-119 días.    1-4     12 años en la naturaleza, hasta 25 años en cautividad.
25      Mangosta enana  Helogale parvula undulata       Herpestidae\n Mungotinaea       Mammalia        SABANA AFRICANA Predominantemente insectívora, especialmente a base de termitas y escarabajos, pero también ciempiés, larvas de escarabajo y ocasionalmente pequeños vertebrados (pequeños mamíferos, geckos, serpientes y pájaros).    55 días.        1-6     13 años en la naturaleza y hasta 18 años en cautividad.
26      Mangosta rayada Mungos mungo    Herpestidae\n Mungotinae        a      Mammalia SABANA AFRICANA Predominantemente insectívora, especialmente a base de escarabajos y larvas de ciempiés, y ocasionalmente pequeños vertebrados (incluyendo huevos, ratones, ratas, ranas, lagartos y serpientes).       60 días.       1-4      17 años.
28      Oricteropo      Orycteropus afer        Orycteropodidae a       MammaliaSABANA AFRICANA Hormigas, termitas y ocasionalmente larvas de insectos (principalmente escarabajos).    243 días.       1 y rara vez 2. 18 años.
31      Pitón real      Python regius   Boidae  a       Reptilia        SABANA AFRICANA Se alimenta principalmente de roedores, también pequeños conejos y ocasionalmente de aves y reptiles.   44-54 días.     4-12    15-30 años en la naturaleza y por encima de 40 en cautividad.
32      Pitón de Seba   Python sebae    Boidae  a       Reptilia        SABANA AFRICANA Se alimentan principalmente de vertebrados terrestres. Los individuos jóvenes, se alimentan de pequeños mamíferos, especialmente ratas. Una vez son adultos, se alimentarán de presas de mayor tamaño, como primates, cocodrilos, lagartos grandes, y antílopes 65-80 días.     20-50   20-30 años.
33      Puercoespín sudafricano Hystrix africaeaustralis        Hystricidae    aMammalia        SABANA AFRICANA Raíces, bulbos, tubérculos y corteza de árboles. Ocasionalmente carroña o esqueletos viejos, que roen en busca de sales minerales.      Alrededor de 94 días.   1-4     Hasta 15 años en la naturaleza y hasta 23 en cautividad.
34      Rata gambiana   Cricetomys gambianus    Nesomyidae      a       MammaliaSABANA AFRICANA Son omnívoras, se alimentan de una gran variedad de frutas, vegetales, nueces, raíces, tubérculos, e incluso termitas o caracoles.      30-32 días.     1-5     5-7 años.
35      Rata topo desnuda       Heterocephalus glaber   Bathyergidae    a      Mammalia SABANA AFRICANA Se alimentan de raíces, bulbos y tubérculos, que son accesibles bajo tierra. En ocasiones viajan grandes distancias para encontrar sus alimentos preferidos, suelen dejar partes de la planta intactas para que continúen creciendo y puedan volver en futuras ocasiones. Una vez encontrada la comida vuelven al nido, donde la almacenan.     70 días.        7       25-30 años.
36      Ratón espinoso  Acomys cahirinus        Muridae a       Mammalia       SABANA AFRICANA  Omnívoros y oportunistas, se alimentan de semillas, frutas, plantas secas, arañas, pequeños insectos e incluso caracoles. En poblaciones que viven cerca de los humanos, se alimentan también de grano y comida almacenada.    35-42 días.      1-5     4 años.
37      Ratón pigmeo africano   Mus minutoides  Muridae a       Mammalia       SABANA AFRICANA  Omnívoros y oportunistas, se alimentan de semillas, frutas, plantas secas, arañas y pequeños insectos. En poblaciones que viven cerca de los humanos, se alimentan también de grano y comida almacenada.        20 días.       1-6      2 años.
40      Suricata        Suricata suricatta      Herpestidae\n Mungotinae       aMammalia        SABANA AFRICANA Insectívora, especialmente escarabajos, arácnidos y larvas de ciempiés, ocasionalmente también se alimentan de pequeños vertebrados (incluyendo lagartos y pequeñas serpientes), huevos y fruta.        70-80 días.     3       10 años.
\.


--
-- Data for Name: habitat; Type: TABLE DATA; Schema: public; Owner: alan
--

COPY public.habitat (id, habitat, description) FROM stdin;
1       SABANA AFRICANA La sabana reúne la mayor concentración de grandes herbívoros del planeta y sus extensas planicies son el escenario de largas migraciones en busca de agua y alimento vinculadas al transcurrir de las dos estaciones de este bioma: la estación seca y la estación húmeda.
2       BOSQUE ECUATORIAL       Los bosques lluviosos primarios de África ecuatorial albergan un gran número de ecosistemas y hábitats diferentes, pudiendo observar el contraste entre la vida en las bóvedas arbóreas y la bulliciosa actividad que tiene lugar en el suelo del bosque.
3       HUMEDALES AFRICANOS: LA CUEVA DE KITUM  La cueva de Kitum se adentra unos 200 metros en el interior del Monte Elgon, en el Parque Nacional del Monte Elgon, en Kenia. Ella y sus vecinas son las únicas cuevas conocidas formadas por rocas volcánicas piroclásticas, cuya modificación a lo largo del tiempo ha dado lugar a la formación de sales minerales.
4       ISLA DE MADAGASCAR      La fauna y flora de esta isla del océano Índico, separada del continente africano hace 160 millones de años, ha evolucionado aislada, de forma que el 80% de sus especies son endémicas, lo que implica que sólo se encuentran en este punto del planeta.
\.


--
-- Name: animal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alan
--

SELECT pg_catalog.setval('public.animal_id_seq', 81, true);


--
-- Name: habitat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alan
--

SELECT pg_catalog.setval('public.habitat_id_seq', 4, true);


--
-- Name: animal animal_id; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_id PRIMARY KEY (id);


--
-- Name: animal animal_name; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_name UNIQUE (nombre);


--
-- Name: habitat habitat_habitat; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.habitat
    ADD CONSTRAINT habitat_habitat UNIQUE (habitat);


--
-- Name: habitat habitat_id; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.habitat
    ADD CONSTRAINT habitat_id PRIMARY KEY (id);


--
-- Name: animal animal_habitat_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_habitat_fkey FOREIGN KEY (habitat) REFERENCES public.habitat(habitat);


--
-- PostgreSQL database dump complete
--

