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
  name VARCHAR NOT NULL    DEFAULT 'No Lang'
);
CREATE UNIQUE INDEX languageName
  ON languages (name);


CREATE TABLE themes
(
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL    DEFAULT 'No Theme'
);
CREATE UNIQUE INDEX themeName
  ON themes (name);


CREATE TABLE questions
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  question    VARCHAR NOT NULL,
  language_id INTEGER NOT NULL    DEFAULT 0,
  theme_id    INTEGER NOT NULL    DEFAULT 0,
  FOREIGN KEY (theme_id) REFERENCES themes (id),
  FOREIGN KEY (language_id) REFERENCES languages (id)
);
CREATE UNIQUE INDEX questionText
  ON questions (question, language_id);


CREATE TABLE answers
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq_answers'),
  name        VARCHAR NOT NULL    DEFAULT 'No answer',
  isRight     BOOLEAN             DEFAULT FALSE,
  question_id INTEGER NOT NULL,
  FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);


