-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-22 13:46:27.417

-- tables
-- Table: allowed_measurement_unit
CREATE TABLE allowed_measurement_unit (
                                          id serial  NOT NULL,
                                          ingredient_id int  NOT NULL,
                                          measurement_unit_id int  NOT NULL,
                                          CONSTRAINT allowed_measurement_unit_pk PRIMARY KEY (id)
);

CREATE INDEX allowed_measurement_unit_idx_1 on allowed_measurement_unit (ingredient_id ASC);

CREATE INDEX allowed_measurement_unit_idx_2 on allowed_measurement_unit (measurement_unit_id ASC);

-- Table: ingredient
CREATE TABLE ingredient (
                            id serial  NOT NULL,
                            ingredient_group_id int  NOT NULL,
                            name varchar(20)  NOT NULL,
                            status char(1)  NOT NULL DEFAULT 'A',
                            CONSTRAINT ingredient_ak_1 UNIQUE (name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                            CONSTRAINT ingredient_pk PRIMARY KEY (id)
);

-- Table: ingredient_group
CREATE TABLE ingredient_group (
                                  id serial  NOT NULL,
                                  name varchar(255)  NOT NULL,
                                  CONSTRAINT ingredient_group_ak_1 UNIQUE (name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                                  CONSTRAINT ingredient_group_pk PRIMARY KEY (id)
);

-- Table: measurement_unit
CREATE TABLE measurement_unit (
                                  id serial  NOT NULL,
                                  name varchar(50)  NOT NULL,
                                  description varchar(255)  NULL,
                                  CONSTRAINT measurement_unit_pk PRIMARY KEY (id)
);

-- Table: menu
CREATE TABLE menu (
                      id int  NOT NULL,
                      user_id int  NOT NULL,
                      date_time_added timestamp  NOT NULL,
                      CONSTRAINT menu_pk PRIMARY KEY (id)
);

-- Table: preparation_time
CREATE TABLE preparation_time (
                                  id int  NOT NULL,
                                  prep_time varchar(50)  NOT NULL,
                                  CONSTRAINT preparation_time_ak_1 UNIQUE (prep_time) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                                  CONSTRAINT preparation_time_pk PRIMARY KEY (id)
);

-- Table: recipe
CREATE TABLE recipe (
                        id serial  NOT NULL,
                        preparation_time_id int  NOT NULL,
                        food_category_id int  NOT NULL,
                        name varchar(255)  NOT NULL,
                        serving_size int  NOT NULL,
                        instructions varchar(2000)  NOT NULL,
                        date_from timestamp  NOT NULL,
                        date_to date  NULL,
                        CONSTRAINT recipe_pk PRIMARY KEY (id)
);

-- Table: recipe_category
CREATE TABLE recipe_category (
                                 id int  NOT NULL,
                                 name varchar(50)  NOT NULL,
                                 CONSTRAINT food_category_ak_1 UNIQUE (name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                                 CONSTRAINT recipe_category_pk PRIMARY KEY (id)
);

-- Table: recipe_in_section
CREATE TABLE recipe_in_section (
                                   id serial  NOT NULL,
                                   section_in_menu_id int  NOT NULL,
                                   recipe_id int  NOT NULL,
                                   planned_serving_size int  NOT NULL,
                                   comment varchar(255)  NULL,
                                   date_time_added timestamp  NOT NULL,
                                   date_time_modified timestamp  NULL,
                                   CONSTRAINT recipe_in_section_pk PRIMARY KEY (id)
);

-- Table: recipe_ingredient
CREATE TABLE recipe_ingredient (
                                   id serial  NOT NULL,
                                   recipe_id int  NOT NULL,
                                   ingredient_id int  NOT NULL,
                                   measure_unit_id int  NOT NULL,
                                   quantity decimal(6,2)  NOT NULL,
                                   date_from timestamp  NOT NULL,
                                   date_to date  NULL,
                                   CONSTRAINT recipe_ingredient_pk PRIMARY KEY (id)
);

-- Table: section_in_menu
CREATE TABLE section_in_menu (
                                 id serial  NOT NULL,
                                 menu_id int  NOT NULL,
                                 name varchar(100)  NOT NULL,
                                 CONSTRAINT section_in_menu_pk PRIMARY KEY (id)
);

-- Table: shopping_list
CREATE TABLE shopping_list (
                               id serial  NOT NULL,
                               menu_id int  NOT NULL,
                               user_id int  NOT NULL,
                               date_time_added timestamp  NULL,
                               comment varchar(255)  NULL,
                               CONSTRAINT shopping_list_pk PRIMARY KEY (id)
);

-- Table: shopping_list_custom_ingredient
CREATE TABLE shopping_list_custom_ingredient (
                                                 id serial  NOT NULL,
                                                 ingredient_group_id int  NULL,
                                                 measurement_unit_id int  NULL,
                                                 shopping_list_id int  NOT NULL,
                                                 name varchar(255)  NOT NULL,
                                                 quantity decimal(6,2)  NULL,
                                                 date_time_added timestamp  NOT NULL,
                                                 date_time_modified timestamp  NULL,
                                                 CONSTRAINT shopping_list_custom_ingredient_pk PRIMARY KEY (id)
);

-- Table: shopping_list_ingredient
CREATE TABLE shopping_list_ingredient (
                                          id serial  NOT NULL,
                                          ingredient_id int  NOT NULL,
                                          measurement_unit_id int  NOT NULL,
                                          shopping_list_id int  NOT NULL,
                                          quantity decimal(6,2)  NOT NULL,
                                          date_time_added timestamp  NOT NULL,
                                          date_time_modified timestamp  NULL,
                                          CONSTRAINT shopping_list_ingredient_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        username varchar(100)  NOT NULL,
                        password varchar(50)  NOT NULL,
                        CONSTRAINT User_ak_1 UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: allowed_measurement_unit_ingredient (table: allowed_measurement_unit)
ALTER TABLE allowed_measurement_unit ADD CONSTRAINT allowed_measurement_unit_ingredient
    FOREIGN KEY (ingredient_id)
        REFERENCES ingredient (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: allowed_measurement_unit_measurement_unit (table: allowed_measurement_unit)
ALTER TABLE allowed_measurement_unit ADD CONSTRAINT allowed_measurement_unit_measurement_unit
    FOREIGN KEY (measurement_unit_id)
        REFERENCES measurement_unit (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ingredient_ingredient_group (table: ingredient)
ALTER TABLE ingredient ADD CONSTRAINT ingredient_ingredient_group
    FOREIGN KEY (ingredient_group_id)
        REFERENCES ingredient_group (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: menu_user (table: menu)
ALTER TABLE menu ADD CONSTRAINT menu_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: recipe_food_category (table: recipe)
ALTER TABLE recipe ADD CONSTRAINT recipe_food_category
    FOREIGN KEY (food_category_id)
        REFERENCES recipe_category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: recipe_in_section_recipe (table: recipe_in_section)
ALTER TABLE recipe_in_section ADD CONSTRAINT recipe_in_section_recipe
    FOREIGN KEY (recipe_id)
        REFERENCES recipe (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: recipe_in_section_section_in_menu (table: recipe_in_section)
ALTER TABLE recipe_in_section ADD CONSTRAINT recipe_in_section_section_in_menu
    FOREIGN KEY (section_in_menu_id)
        REFERENCES section_in_menu (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: recipe_ingredient_ingredient (table: recipe_ingredient)
ALTER TABLE recipe_ingredient ADD CONSTRAINT recipe_ingredient_ingredient
    FOREIGN KEY (ingredient_id)
        REFERENCES ingredient (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: recipe_ingredient_measure_unit (table: recipe_ingredient)
ALTER TABLE recipe_ingredient ADD CONSTRAINT recipe_ingredient_measure_unit
    FOREIGN KEY (measure_unit_id)
        REFERENCES measurement_unit (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: recipe_ingredient_recipe (table: recipe_ingredient)
ALTER TABLE recipe_ingredient ADD CONSTRAINT recipe_ingredient_recipe
    FOREIGN KEY (recipe_id)
        REFERENCES recipe (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: recipe_preparation_time (table: recipe)
ALTER TABLE recipe ADD CONSTRAINT recipe_preparation_time
    FOREIGN KEY (preparation_time_id)
        REFERENCES preparation_time (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: section_in_menu_menu (table: section_in_menu)
ALTER TABLE section_in_menu ADD CONSTRAINT section_in_menu_menu
    FOREIGN KEY (menu_id)
        REFERENCES menu (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_custom_ingredient_ingredient_group (table: shopping_list_custom_ingredient)
ALTER TABLE shopping_list_custom_ingredient ADD CONSTRAINT shopping_list_custom_ingredient_ingredient_group
    FOREIGN KEY (ingredient_group_id)
        REFERENCES ingredient_group (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_custom_ingredient_measurement_unit (table: shopping_list_custom_ingredient)
ALTER TABLE shopping_list_custom_ingredient ADD CONSTRAINT shopping_list_custom_ingredient_measurement_unit
    FOREIGN KEY (measurement_unit_id)
        REFERENCES measurement_unit (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_custom_ingredient_shopping_list (table: shopping_list_custom_ingredient)
ALTER TABLE shopping_list_custom_ingredient ADD CONSTRAINT shopping_list_custom_ingredient_shopping_list
    FOREIGN KEY (shopping_list_id)
        REFERENCES shopping_list (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_ingredient_ingredient (table: shopping_list_ingredient)
ALTER TABLE shopping_list_ingredient ADD CONSTRAINT shopping_list_ingredient_ingredient
    FOREIGN KEY (ingredient_id)
        REFERENCES ingredient (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_ingredient_measurement_unit (table: shopping_list_ingredient)
ALTER TABLE shopping_list_ingredient ADD CONSTRAINT shopping_list_ingredient_measurement_unit
    FOREIGN KEY (measurement_unit_id)
        REFERENCES measurement_unit (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_ingredient_shopping_list (table: shopping_list_ingredient)
ALTER TABLE shopping_list_ingredient ADD CONSTRAINT shopping_list_ingredient_shopping_list
    FOREIGN KEY (shopping_list_id)
        REFERENCES shopping_list (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_menu (table: shopping_list)
ALTER TABLE shopping_list ADD CONSTRAINT shopping_list_menu
    FOREIGN KEY (menu_id)
        REFERENCES menu (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: shopping_list_user (table: shopping_list)
ALTER TABLE shopping_list ADD CONSTRAINT shopping_list_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.
