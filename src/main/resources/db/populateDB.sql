DELETE FROM themes;
DELETE FROM languages;
DELETE FROM questions;
DELETE FROM answers;
ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER SEQUENCE global_seq_answers RESTART WITH 100000;

INSERT INTO languages (name, id) VALUES
  ('Java', 1),
  ('Python', 2),
  ('C++', 3);

INSERT INTO themes (name, id) VALUES
  ('OOP', 1),
  ('OOD', 2),
  ('No theme', 4),
  ('RunTime...', 3);

INSERT INTO answers (name, language_id, theme_id) VALUES
  ('OOP', 1, 4),
  ('OOD', 1, 4),
  ('Java', 1, 4),
  ('php', 1, 4),
  ('RunTime...', 1, 4);


INSERT INTO questions (question, answer_id, language_id, theme_id) VALUES
  ('What is your Favorite language?', 100002, 1, 3),
  ('What is your unFavorite language?', 100003, 1, 3),
  ('What is your name?', 100000, 2, 1),
  ('Class1 extends Class2 what is that mechanims name?', 100001, 1, 1);
