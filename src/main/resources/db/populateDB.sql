DELETE FROM questions;
DELETE FROM answers;
DELETE FROM themes;
DELETE FROM languages;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO languages (name, id) VALUES
  ('Java', 1),
  ('Python', 2),
  ('C++', 3);

INSERT INTO themes (name, id) VALUES
  ('OOP', 1),
  ('OOD', 2),
  ('RunTime...', 3);

INSERT INTO questions (name, language_id, theme_id) VALUES
  ('What is your Favorite language?',  1, 3),
  ('What is your unFavorite language?', 3, 3),
  ('Basic programming principle?', 1, 1),
  ('Class1 extends Class2 what is that mechanims name?', 1, 1);

INSERT INTO answers (name, question_id, isright) VALUES
  ('OOP', 100002, true),
  ('FalseAnswer', 100002, false),
  ('Inheritance', 100003, true),
  ('FalseAnswer', 100003, false),
  ('Java', 100000, TRUE ),
  ('FalseAnswer', 100000, false ),
  ('php', 100001, true),
  ('FalseAnswer', 100001, false),
  ('RunTime...', 100003, false);
