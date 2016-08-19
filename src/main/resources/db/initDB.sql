DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS languages;
DROP TABLE IF EXISTS themes;
DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS global_seq_answers;

CREATE SEQUENCE global_seq START 100000;
CREATE SEQUENCE global_seq_answers START 100000;

CREATE TABLE languages
(
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR
);
CREATE UNIQUE INDEX languageName
  ON languages (name);


CREATE TABLE themes
(
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR
);
CREATE UNIQUE INDEX themeName
  ON themes (name);

CREATE TABLE questions
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  question    VARCHAR NOT NULL,
  language_id INTEGER,
  theme_id    INTEGER,
  FOREIGN KEY (theme_id) REFERENCES themes (id) ON DELETE CASCADE,
  FOREIGN KEY (language_id) REFERENCES languages (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX questionText
  ON questions (question);

CREATE TABLE answers
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq_answers'),
  name        VARCHAR,
  isRight     BOOLEAN DEFAULT FALSE,
  question_id INTEGER,
  theme_id    INTEGER,
  language_id INTEGER,
  FOREIGN KEY (theme_id) REFERENCES themes (id),
  FOREIGN KEY (question_id) REFERENCES questions (id),
  FOREIGN KEY (language_id) REFERENCES languages (id)
);
CREATE UNIQUE INDEX answersName
  ON answers (name);


