

INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Puu- ja köögiviljad');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Lihatooted');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'kalatooted');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Piimatooted');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Munad');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Võid');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Juustud');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Leivad, saiad');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Kondiitritooted');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Valmistoidud');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Kuivained');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Hommikusöögid');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Hoidised');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Maailma köök');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Maitseained');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Puljongid');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Kastmed, õlid');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Maiustused');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Küpsised');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Näksid');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Külmutatud toidukaubad');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Joogid');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Lastekaubad');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Lemmikloomakaubad');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Enesehooldustarbed');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Majapidamistarbed');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Vabaajakaubad');
INSERT INTO public.ingredient_group (id, name) VALUES (DEFAULT, 'Hooajakaubad');

INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Grillretseptid');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Hommikusöögid');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Joogid');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Kala ja mereannid');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Kana');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Kastmed, määrded');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Magustoidud');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Magusad küpsetised');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Eelroad');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Leib, Sai');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Liha');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Linnuliha');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Pastad ja risotod');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Salatid');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Soolased küpsetised');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Supid');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Suupisted');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Vormiroad');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Võileivad');
INSERT INTO public.recipe_category (id, name) VALUES (DEFAULT, 'Taimetoidud');

INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'tk', 'tükk');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'ml', 'milliliiter');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'dl', 'detsiliiter');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'l', 'liiter');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'g', 'gramm');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'kg', 'kilogramm');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'tl', 'teelusikas');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'spl', 'supilusikas');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'pdl', 'valmis toote pudel');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'purk', 'valmis toote purk');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'maitse järgi', 'vastavalt koka maitsele');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'küünt', 'üks osa tervikust');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'pk', 'pakk');

INSERT INTO public.preparation_time (id, prep_time) VALUES (DEFAULT, '0-15 min');
INSERT INTO public.preparation_time (id, prep_time) VALUES (DEFAULT, '16-30 min');
INSERT INTO public.preparation_time (id, prep_time) VALUES (DEFAULT, '31-45 min');
INSERT INTO public.preparation_time (id, prep_time) VALUES (DEFAULT, '46-60 min');
INSERT INTO public.preparation_time (id, prep_time) VALUES (DEFAULT, '1-2 h ');
INSERT INTO public.preparation_time (id, prep_time) VALUES (DEFAULT, '2+ h');

INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 16, 2, 'Frikadellisupp', 4, 'Siia tulevad frikadellisupi valmistamise juhised', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 14, 2, 'Värviline salat kurgi, tomati, avokaado ja kinoaga', 4, 'Keeda esmalt kinoa. Selleks arvesta 1 osa kinoad ja 2 osa vett. Kalla kinoa keevasse, vähese soolaga maitsestatud vette ja keeda vaiksel tulel kaane all ca 10-15 minutit. Töötle kinoa kahvli abil kohevaks.
Salati jaoks tõsta kaussi tükeldatud kurk, tomat, avokaado ja sibul. Lisa ka kinoa ja hakitud ürdid. Salatikastme jaoks sega kõik salatikastme komponendid ja kalla salatile. Sega salat läbi, kontrolli maitseid ja tõsta taldrikule või serveerimiskaussi. Soovi korral lisa veel kas fetajuustu, oliive või muid lisandeid. Võid salatile veel täiendavalt oliiviõli niristada.', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 15, 6, 'Evar Tšetšini suurepärane focaccia', 8, 'Sega kõik taina ained omavahel kokku (sõtku nii, et naeratus ja higi tulevad näole:). Lase tainal soojas kohas 1 tund kerkida, seejärel aseta see suurele ahjuplaadile ning lükka tainas õliste kätega ahjuplaadil laiali. Pane peale oliivõli, rosmariini ja soolahelbed (oma tunde järgi). Lase veel  1 tund plaadil kerkida ja küpseta seejärel 200 kraadi juures 30 minutit.', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 2, 3, 'Õhukesed pannkoogid ehk krepid ehk ülepannikoogid', 4,
'Klopi munad suhkruga lahti, sega juurde jahu, piim ja näpuotsaga soola ning sega ühtlaseks. Viimasena lisa juurde sulavõi, sega läbi. Kuumuta suur pann, lisa sobiv kogus tainast* ja küpseta paar minutit keskmisel kuumusel, kuni pannkook on altpoolt kaunilt kuldne. Keera ringi ja küpseta ka teiselt poolt.
Nipid ja soovitused:
Eriti mugav on kasutada spetsiaalset pannkoogipanni.Meie tõstame suure kulbitäie tainast ühte panni serva, siis keerame-kallutame panni, nii et tainas valguks ühtlase õhukese kihina laiali. Tulemuseks on hästi ilusad ümmargused pannkoogid.', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 13, 3, 'Risoto kanalihaga', 5,
'Keeda riis.Tükelda seened viiludeks,paprika kuubikuteks,haki sibul ning kuumuta neid mõni minut õlis.Lisa külmutatud köögivili ja puljong.Lõika kuumtöödeldud kanaliha väikesteks kuubikuteks ja lisa. Lõpuks pane juurde keedetud riis ja kuumuta veel mõni minut. Maitsesta.', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 16, 3, 'Tõeliselt sametine kõrvitsapüreesupp', 6,
'Pane kõrvitsatükid potti, kalla peale nii palju puljongit (või vesi + puljongipulber), et kõrvitsatükid oleksid kaetud. Lisa puljongipulber. Kuumuta keemiseni.
Haki sibul, prae õlis kuldseks. Lisa koos praadimisõliga kõrvitsatükkidele. Keeda kõrvitsatükke koos praetud sibulaga, kuni kõrvitsatükid on pehmed (aeg oleneb kõrvitsatüübist).
Kui kõrvits on pehme, siis püreesta kannmikseris või köögikombainis või saumiksriga ühtlaseks. Lisa sulatatud juust ning püreesta uuesti. Maitsesta vajadusel soola ja pipraga.
Lase supil 10-15 minutit taheneda, siis jaota kaussidesse ja serveeri. Peale nirista paksemat kõrvitsaseemneõli.
NIPP: Kui soovid, võid kaunistada supi ka röstitud kõrvitsaseemnetega', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 18, 4, 'Anni Arro lasanje', 10,
'Eelkuumuta ahi 200 kraadini. Haki sibul, küüslauk ja rosmariin ning prae kergelt läbi. Lisa hakkliha ja pruunista korralikult. Kui vedelik hakkab juba vaikselt aurustuma, lisa suts valget veini ja prae veel minutike. Lisa purustatud tomatid ja hauta umbes 10–15 minutit. Maitsesta soola, pipra ja punega.
Lao oliiviõliga piserdatud ahjuvormi kiht lasanjelehti, siis kiht hakklihasegu, õhuke kiht riivjuustu, värskeid basiilikulehti ja tükeldatud mozzarella’t. Tee samamoodi ka järgmised kihid. Kõige pealmiseks kihiks jääb hakklihasegu, basiilik, riivitud juust ja mozzarella. Pista vorm ahju ja küpseta 200° juures umbes 30 minutit.
Enne serveerimist lase lasanjel natuke aega jahtuda ja hanguda.', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 13, 2, 'Pasta carbonara', 4,
'Keeda makaronid rohkes soolases vees al dente.
Samal ajal lõika guanciale, pancetta või peekon väikesteks kuubikuteks või ribadeks. Prae mõõdukalt kuumal pannil väheses oliiviõlis kuldseks ja krõbedaks.
Pane muna(kollase)d suurde toasooja kaussi, milles plaanid pastarooga serveerida. Klopi munad vispliga lahti. Sega juurde riivitud juust, maitsesta julgelt musta pipraga. Nüüd vispelda juurde üks korralik kulbitäis kuuma pastakeeduvedelikku!*
Siis kurna spagetid ja lisa kohe muna-juustusegu hulka. Sega kiiresti läbi, sega juurde (vajadusel nõrutatud) lihakuubikud. Puista peale veel riivitud juustu ja musta pipart ning serveeri kohe.
Lisainfo:
* Pasta võiks ideaalis olla mõni "paksem spagett", nt bucatini või perciatelli, aga muidugi sobib ka tavaline spaghetti.
* Peekon võiks olla guanciale või pancetta.
* Juust peaks olema Pecorino Romano lambapiimajuust.
* Mingeid ürte ei lisata!
* Küüslauku ja sibulat selles roas ei ole, nagu ka šampinjone, sparglit, kanafileetükikesi jms.
* Pipar peaks olema kindlasti värskelt jahvatatud, otse pipraveskist!', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 8, 4, 'Eriti maitsev ja kodune õunapirukas', 6,
'Sega kuivained omavahel. Lisa külmad või-tükid ning näpi sõrmedega purutaoliseks massiks. Sega omavahel vesi ja äädikas ning lisa tainale. Sõtku tainas ühtlaseks pehmeks tainapalliks. Tõsta tainas külmkappi täidise valmistamise ajaks.
Koori ja viiluta õunad. ja lõika need neljaks. Eemalda südamik. Lõika õunesektorist õhukesed viilud. Sega täidise jaoks omavahel kuivained ning sega seejärel segu kokku õunaviiludega. Jaga külmkapis seisnud tainas kaheks, jättes ühe tainaosa pisut suuremaks. Rulli suurem tainapall jahusel pinnal õhukeseks. Otsi välja koogivorm (Ø21-22cm) ning määri see võiga kokku. Tõsta tainas koogivormi.
Lõika üle koogivormi ulatuvad tainaääred ühtlaseks. Vajadusel vormi ja silu tainas ühtlaseks. Lisa tainapõhjale õunad ning selle peale tõsta või-tükid. Võta teine tainapall ning rulli see samuti õhukeseks. Tõsta pirukale katteks ning eemalda üle ääre ulatuvad tainaääred. Suru ülemise pirukaketta ääred alumisega omavahel korralikult kokku. Tee noaga tainale peale 2 sisselõiget ja määri pirukas pealt lahtiklopitud munaga. Küpseta pirukat pöördõhurežiimil 180 kraadi juures 30-40minutit.', DEFAULT, null);
INSERT INTO public.recipe (id, recipe_category_id, preparation_time_id, name, serving_size, instructions, date_from, date_to) VALUES (DEFAULT, 16, 3, 'Kuldne kalasupp', 5, 'Pese ja viilusta porrulauk. Koori ja haki sibul. Sulata või potipõhjas ja hauta sibul selles läbipaistvaks. Lisa tomatipüree, purustatud küüslauk ja maitseained. Keeda pisut kaaneta potis. Lisa vein ja puljongikuubikud ning lase korraks keema tõusta. Sega juurde rõõsk koor, prantuses koor, vesi, safran ja riis. Keeda puljongit nõrgal tulel 15 minutit kaane all. Lõika kala ribadeks, lisa puljongile ja keeda nõrgal tulel 7 minutit. Lisa krevetid ja teod ning lase supil uuesti keema tõusta. Kaunista supp õhukeste porrurõngastega ja paku kuumalt. Soovi korral paku supi juurde kausiga prantsuse koort, mida on maitsestatud tilga sidrunimahlaga, purustatud küüslaugu ja terakese cayanne-i pipraga. Retsept on pärit Kodukiri 1/98.', DEFAULT, null);

INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'Mairold', '123');
INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'Kristiina', '123');
INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'Helen', '123');

INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (1, 1, 'Porgand', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (2, 2, 'Veiseliha', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (3, 11, 'Spagetid', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (4, 5, 'Kanamuna M', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (5, 5, 'Kanamuna L', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (6, 5, 'Vutimuna', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (7, 4, 'Piim 2.5%', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (8, 4, 'Pett', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (9, 4, 'Keefir', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (10, 4, 'Maitsestamata jogurt', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (11, 11, 'Lasanjeplaadid', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (12, 2, 'Hakkliha', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (13, 1, 'Sibul', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (14, 1, 'Küüslauk', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (15, 15, 'Rosmariin', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (16, 22, 'Valge vein', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (17, 13, 'Purustatud tomatid', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (18, 15, 'Sool', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (19, 15, 'Pipar', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (20, 15, 'Pune', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (21, 15, 'Basiilik', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (22, 4, 'Riivjuust', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (23, 4, 'Mozzarella', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (24, 11, 'Nisujahu', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (25, 11, 'Pärm', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (26, 15, 'Meresool', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (27, 15, 'Suhkur', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (28, 17, 'Vesi', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (29, 6, 'Või', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (30, 17, 'Äädikas', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (31, 1, 'Õun', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (32, 15, 'Kaneel', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (33, 15, 'Kardemon', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (34, 3, 'Tursafilee', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (35, 3, 'Lõhefilee', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (36, 1, 'Porrulauk', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (37, 13, 'Tomatipüree', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (38, 15, 'Tüümian (kuivatatud)', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (39, 22, 'Kuiv valge vein', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (40, 16, 'Kalapuljongikuubik', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (41, 4, 'Rõõsk koor 10%', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (42, 15, 'Safran', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (43, 11, 'Riis', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (44, 3, 'Kooritud krevetid', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (45, 13, 'Teod soolvees', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (46, 4, 'Prantsuse koor', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (47, 1, 'Rooma salat', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (48, 1, 'Kirsstomatid', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (49, 1, 'Avokaado', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (50, 1, 'Beebispinat', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (51, 1, 'Rukola', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (52, 1, 'Seened', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (53, 1, 'Paprika', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (54, 16, 'Puljong', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (55, 2, 'Kanaliha', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (56, 11, 'Kinoa', 'A');


INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (85, 11, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (87, 11, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (86, 11, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (89, 12, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (88, 12, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (76, 13, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (75, 13, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (79, 14, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (77, 14, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (78, 14, 12);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (95, 15, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (94, 15, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (96, 15, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (90, 17, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (80, 18, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (83, 18, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (82, 18, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (81, 18, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (91, 19, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (92, 19, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (93, 19, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (99, 20, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (97, 20, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (100, 20, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (98, 20, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (107, 21, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (84, 21, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (104, 21, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (106, 21, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (105, 21, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (101, 22, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (102, 22, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (103, 23, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (49, 24, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (48, 24, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (45, 24, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (46, 24, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (47, 24, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (44, 24, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (43, 24, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (41, 25, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (38, 25, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (39, 25, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (40, 25, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (42, 25, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (37, 26, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (36, 26, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (35, 26, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (34, 26, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (33, 27, 9);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (32, 27, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (31, 27, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (30, 27, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (29, 27, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (28, 27, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (27, 28, 9);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (26, 28, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (25, 28, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (24, 28, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (23, 28, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (22, 28, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (21, 28, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (16, 29, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (17, 29, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (18, 29, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (19, 29, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (20, 29, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (13, 30, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (14, 30, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (15, 30, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (11, 30, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (12, 30, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (10, 31, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (9, 31, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (8, 31, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (7, 32, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (5, 32, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (6, 32, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (3, 33, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (1, 33, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (2, 33, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (4, 33, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (50, 34, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (51, 34, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (52, 35, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (53, 35, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (54, 36, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (55, 36, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (57, 37, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (56, 37, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (58, 37, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (60, 38, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (59, 38, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (62, 39, 9);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (61, 39, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (63, 40, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (65, 41, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (64, 41, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (67, 42, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (68, 42, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (66, 42, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (70, 43, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (69, 43, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (72, 44, 10);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (71, 44, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (74, 45, 10);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (73, 45, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (108, 46, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (109, 46, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (110, 46, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (111, 47, 13);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (112, 47, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (113, 48, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (114, 49, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (115, 49, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (116, 50, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (117, 51, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (118, 52, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (119, 53, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (120, 53, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (121, 54, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (122, 54, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (123, 54, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (124, 55, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (125, 55, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (126, 56, 5);



INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (1, 3, 24, 5, 500.00, '2022-12-08 21:39:25.232164', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (2, 3, 25, 5, 20.00, '2022-12-08 21:39:25.244072', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (3, 3, 18, 5, 10.00, '2022-12-08 21:39:25.264151', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (4, 3, 27, 5, 10.00, '2022-12-08 21:39:25.276350', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (5, 3, 28, 5, 400.00, '2022-12-08 21:39:25.293961', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (6, 3, 34, 5, 30.00, '2022-12-08 21:39:25.315512', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (7, 3, 15, 1, 3.00, '2022-12-08 21:39:25.327680', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (8, 9, 24, 5, 300.00, '2022-12-08 21:39:25.346549', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (9, 9, 27, 8, 1.00, '2022-12-08 21:39:25.366705', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (10, 9, 18, 7, 0.50, '2022-12-08 21:39:25.387195', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (11, 9, 29, 5, 200.00, '2022-12-08 21:39:25.401320', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (12, 9, 28, 8, 2.00, '2022-12-08 21:39:25.419876', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (13, 9, 30, 2, 10.00, '2022-12-08 21:39:25.441379', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (14, 9, 31, 1, 5.00, '2022-12-08 21:39:25.459303', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (15, 9, 27, 8, 2.00, '2022-12-08 21:39:25.470233', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (16, 9, 32, 7, 1.00, '2022-12-08 21:39:25.492595', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (17, 9, 24, 8, 2.00, '2022-12-08 21:39:25.510895', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (18, 9, 18, 7, 1.00, '2022-12-08 21:39:25.534805', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (19, 9, 33, 7, 1.00, '2022-12-08 21:39:25.548237', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (20, 9, 29, 8, 2.00, '2022-12-08 21:39:25.569943', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (21, 9, 4, 1, 1.00, '2022-12-08 21:39:25.598092', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (22, 10, 34, 5, 400.00, '2022-12-08 21:39:25.625718', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (23, 10, 35, 5, 300.00, '2022-12-08 21:39:25.645889', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (24, 10, 36, 1, 0.50, '2022-12-08 21:39:25.670372', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (25, 10, 13, 1, 0.50, '2022-12-08 21:39:25.693500', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (26, 10, 29, 8, 1.00, '2022-12-08 21:39:25.710529', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (27, 10, 37, 8, 1.50, '2022-12-08 21:39:25.733049', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (28, 10, 14, 12, 1.50, '2022-12-08 21:39:25.753463', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (29, 10, 18, 7, 1.50, '2022-12-08 21:39:25.763954', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (30, 10, 38, 7, 1.00, '2022-12-08 21:39:25.785941', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (31, 10, 21, 7, 1.00, '2022-12-08 21:39:25.799558', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (32, 10, 39, 3, 2.50, '2022-12-08 21:39:25.815049', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (33, 10, 40, 1, 1.50, '2022-12-08 21:39:25.826495', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (34, 10, 41, 3, 2.00, '2022-12-08 21:39:25.845176', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (35, 10, 42, 5, 1.00, '2022-12-08 21:39:25.866405', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (36, 10, 28, 3, 5.00, '2022-12-08 21:39:25.887548', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (37, 10, 43, 3, 1.00, '2022-12-08 21:39:25.910812', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (38, 10, 44, 5, 150.00, '2022-12-08 21:39:25.925853', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (39, 10, 45, 10, 1.00, '2022-12-08 21:39:25.942756', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (40, 10, 46, 3, 1.00, '2022-12-08 21:39:25.960288', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (41, 7, 11, 1, 10.00, '2022-12-08 21:39:25.969760', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (42, 7, 12, 6, 1.00, '2022-12-08 21:39:25.982895', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (43, 7, 13, 1, 2.00, '2022-12-08 21:39:26.002055', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (44, 7, 14, 12, 4.00, '2022-12-08 21:39:26.024816', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (45, 7, 15, 11, 1.00, '2022-12-08 21:39:26.041708', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (46, 7, 16, 3, 1.00, '2022-12-08 21:39:26.056149', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (47, 7, 17, 5, 800.00, '2022-12-08 21:39:26.076995', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (48, 7, 18, 11, 1.00, '2022-12-08 21:39:26.099339', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (49, 7, 19, 11, 1.00, '2022-12-08 21:39:26.121207', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (50, 7, 20, 8, 2.00, '2022-12-08 21:39:26.133494', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (51, 7, 21, 7, 2.00, '2022-12-08 21:39:26.154456', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (52, 7, 22, 5, 200.00, '2022-12-08 21:39:26.177300', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (53, 7, 23, 5, 200.00, '2022-12-08 21:39:26.196099', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (54, 1, 1, 1, 1.00, '2022-12-08 21:54:33.636271', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (59, 1, 2, 5, 300.00, '2022-12-08 22:36:52.215175', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (60, 1, 13, 1, 1.00, '2022-12-08 22:36:52.215175', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (61, 1, 26, 11, 1.00, '2022-12-08 22:36:52.215175', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (62, 2, 49, 5, 200.00, '2022-12-08 22:36:52.215175', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (63, 2, 47, 5, 200.00, '2022-12-08 22:36:52.215175', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (64, 2, 48, 5, 200.00, '2022-12-08 22:36:52.215175', null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (65, 2, 56, 5, 150.00, '2022-12-08 22:36:52.215175', null);



