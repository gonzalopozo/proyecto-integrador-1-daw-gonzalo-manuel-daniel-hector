-- SQLBook: Code
DROP TABLE IF EXISTS juega;
DROP TABLE IF EXISTS partidas;
DROP TABLE IF EXISTS personajes;
DROP TABLE IF EXISTS miembros;

CREATE TABLE miembros(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    apellidos TEXT NOT NULL,
    num_expediente INTEGER NOT NULL,
    estudios TEXT NOT NULL
);

CREATE TABLE personajes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    raza TEXT NOT NULL,
    clase TEXT NOT NULL,
    miembro_id INTEGER,
    FOREIGN KEY (miembro_id) REFERENCES miembros(id)
);

CREATE TABLE partidas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    game_master_id INTEGER,
    ambientacion TEXT NOT NULL,
    esta_en_curso BOOLEAN NOT NULL,
    num_sesion INTEGER NOT NULL,
    duración INTEGER NOT NULL,
    fecha TEXT NOT NULL,
    FOREIGN KEY (game_master_id) REFERENCES miembros(id)
);


CREATE TABLE juega (
    nivel INTEGER NOT NULL,
    personaje_id INTEGER NOT NULL,
    partida_id INTEGER NOT NULL,
    salud INTEGER NOT NULL,
    fuerza INTEGER NOT NULL,
    destreza INTEGER NOT NULL,
    sabiduria INTEGER NOT NULL,
    carisma INTEGER NOT NULL,
    inteligencia INTEGER NOT NULL,
    constitucion INTEGER NOT NULL,
    PRIMARY KEY (nivel, personaje_id, partida_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(id),
    FOREIGN KEY (partida_id) REFERENCES partidas(id)
);