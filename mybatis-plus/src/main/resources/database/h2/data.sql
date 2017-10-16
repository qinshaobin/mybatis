INSERT INTO T_STUDENT (NAME, AGE, BIRTHDAY, CREATE_TIME, CLASS_ID, VERSION) VALUES
  ('stu1', 23, curdate(), sysdate(), 1, 0),
  ('stu2', 24, curdate(), sysdate(), 1, 0),
  ('stu3', 25, curdate(), sysdate(), 1, 0),
  ('stu4', 23, curdate(), sysdate(), 1, 0),
  ('stu5', 24, curdate(), sysdate(), 2, 0),
  ('stu6', 25, curdate(), sysdate(), 2, 0),
  ('stu7', 23, curdate(), sysdate(), 2, 0),
  ('stu8', 24, curdate(), sysdate(), 2, 0);

INSERT INTO T_CLASS (NAME, SCHOOL_ID, VERSION) VALUES
  ('cla1', 1, 0),
  ('cla2', 1, 0),
  ('cla3', 1, 0),
  ('cla4', 2, 0),
  ('cla5', 2, 0),
  ('cla6', 2, 0);

INSERT INTO T_SCHOOL (NAME, VERSION) VALUES
  ('sch1', 0),
  ('sch2', 0);