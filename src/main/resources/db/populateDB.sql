DELETE FROM themes;
DELETE FROM languages;
DELETE FROM questions;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO languages (name, id) VALUES
  ('Java', 1),
  ('Python', 2),
  ('C++', 3);

INSERT INTO themes (name, id) VALUES
  ('OOP', 1),
  ('OOD', 2),
  ('RunTime...', 3);

INSERT INTO questions (question, answer, language_id, theme_id) VALUES
  ('What is your Favorite language?', 'Java', 1, 3),
  ('What is your unFavorite language?', 'C++', 1, 3),
  ('What is your name?', 'Yehor', 2, 1),
  ('Class1 extends Class2 what is that mechanims name?', 'Inheritance', 1, 1);
