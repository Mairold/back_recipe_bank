

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
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'pudel', 'valmis toote pudel');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'purk', 'valmis toote purk');
INSERT INTO public.measurement_unit (id, name, description) VALUES (DEFAULT, 'pakk', 'valmis toote pakk');

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
'https://toidutare.ohtuleht.ee/920118/anni-arro-lasanje', DEFAULT, null);
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


