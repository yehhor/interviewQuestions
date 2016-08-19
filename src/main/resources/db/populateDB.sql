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

INSERT INTO questions (question, language_id, theme_id) VALUES
  ('What is your Favorite language?',  1, 3),
  ('What is your unFavorite language?', 1, 3),
  ('Basic programming principle?', 2, 1),
  ('Class1 extends Class2 what is that mechanims name?', 1, 1);

INSERT INTO answers (name, question_id, language_id, theme_id) VALUES
  ('OOP', 100002, 1, 4),
  ('Inheritance', 100003, 1, 4),
  ('Java', 100000, 1, 4),
  ('php', 100001, 1, 4),
  ('RunTime...', 100002, 1, 4);


UPDATE answers SET isright=true where id=100001;
