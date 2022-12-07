

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

INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 1, 'Porgand', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 2, 'Veiseliha', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 11, 'Spagetid', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 5, 'Kanamuna M', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 5, 'Kanamuna L', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 5, 'Vutimuna', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Piim 2.5%', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Pett', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Keefir', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Maitsestamata jogurt', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 11, 'Lasanjeplaadid', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 2, 'Hakkliha', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 1, 'Sibul', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 1, 'Küüslauk', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Rosmariin', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 22, 'Valge vein', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 13, 'Purustatud tomatid', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Sool', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Pipar', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Pune', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Basiilik', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Riivjuust', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Mozzarella', DEFAULT);
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 11, 'Nisujahu', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 11, 'Pärm', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Meresool', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Suhkur', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 17, 'Vesi', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 6, 'Või', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 17, 'Äädikas', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 1, 'Õun', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Kaneel', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Kardemon', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 3, 'Tursafilee', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 3, 'Lõhefilee', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 1, 'Porrulauk', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 13, 'Tomatipüree', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Tüümian (kuivatatud)', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 22, 'Kuiv valge vein', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 16, 'Kalapuljongikuubik', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Rõõsk koor 10%', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 15, 'Safran', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 11, 'Riis', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 3, 'Kooritud krevetid', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 13, 'Teod soolvees', 'A');
INSERT INTO public.ingredient (id, ingredient_group_id, name, status) VALUES (DEFAULT, 4, 'Prantsuse koor', 'A');

INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 33, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 33, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 33, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 32, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 32, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 32, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 31, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 31, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 31, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 30, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 30, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 30, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 30, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 30, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 29, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 29, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 29, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 29, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 29, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 28, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 28, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 28, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 28, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 28, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 28, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 28, 9);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 27, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 27, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 27, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 27, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 27, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 27, 9);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 26, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 26, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 26, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 26, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 25, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 25, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 25, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 25, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 25, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 24, 2);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 24, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 24, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 24, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 24, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 24, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 24, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 34, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 34, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 35, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 35, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 36, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 36, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 37, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 37, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 37, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 38, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 38, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 39, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 39, 9);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 40, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 41, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 41, 4);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 42, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 42, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 42, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 43, 3);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 43, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 44, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 44, 10);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 45, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 45, 10);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 13, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 13, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 14, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 14, 12);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 14, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 18, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 18, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 18, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 18, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 21, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 11, 1);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 11, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 11, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 12, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 12, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 17, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 19, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 19, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 19, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 15, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 15, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 15, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 20, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 20, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 20, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 20, 11);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 22, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 22, 6);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 23, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 21, 5);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 21, 7);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 21, 8);
INSERT INTO public.allowed_measurement_unit (id, ingredient_id, measurement_unit_id) VALUES (DEFAULT, 21, 11);


INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 3, 24, 5, 500.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 3, 25, 5, 20.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 3, 18, 5, 10.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 3, 27, 5, 10.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 3, 28, 5, 400.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 3, 34, 5, 30.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 3, 15, 1, 3.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 24, 5, 300.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 27, 8, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 18, 7, 0.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 29, 5, 200.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 28, 8, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 30, 2, 10.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 31, 1, 5.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 27, 8, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 32, 7, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 24, 8, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 18, 7, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 33, 7, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 29, 8, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 9, 4, 1, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 34, 5, 400.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 35, 5, 300.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 36, 1, 0.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 13, 1, 0.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 29, 8, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 37, 8, 1.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 14, 12, 1.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 18, 7, 1.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 38, 7, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 21, 7, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 39, 3, 2.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 40, 1, 1.50, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 41, 3, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 42, 5, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 28, 3, 5.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 43, 3, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 44, 5, 150.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 45, 10, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 10, 46, 3, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 11, 1, 10.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 12, 6, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 13, 1, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 14, 12, 4.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 15, 11, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 16, 3, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 17, 5, 800.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 18, 11, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 19, 11, 1.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 20, 8, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 21, 7, 2.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 22, 5, 200.00, DEFAULT, null);
INSERT INTO public.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id, quantity, date_from, date_to) VALUES (DEFAULT, 7, 23, 5, 200.00, DEFAULT, null);



