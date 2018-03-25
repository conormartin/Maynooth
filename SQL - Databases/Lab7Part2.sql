SELECT S.studentid, S.studentfirstname, S.studentlastname, S.studentgender, S.studentemail, S.studentcourse, M.moduleid
FROM lab7_students as S, lab7_modules as M, lab7_enrolledon as E
WHERE (S.studentid = E.studentid) AND (E.moduleid = M.moduleid) AND (M.moduleid='CS123');

SELECT S.studentid, S.studentgender, M.moduleid, M.modulesemester
FROM lab7_students as S, lab7_modules as M, lab7_enrolledon as E
WHERE (S.studentid = E.studentid) AND (E.moduleid = M.moduleid) AND (S.studentgender='Female') AND (M.modulesemester='Semester 1');

SELECT S.studentid, S.studentemail, M.moduleid
FROM lab7_students as S, lab7_modules as M, lab7_enrolledon as E
WHERE (S.studentid = E.studentid) AND (E.moduleid = M.moduleid) AND (studentemail LIKE '%2017%');

SELECT S.studentid, S.studentcourse, M.moduleid, M.modulecredits
FROM lab7_students as S, lab7_modules as M, lab7_enrolledon as E
WHERE (S.studentid = E.studentid) AND (E.moduleid = M.moduleid) AND (S.studentcourse) AND (M.modulecredits >='10') AND (M.modulecredits<='15');

SELECT S.studentid, S.studentcourse, M.moduleid, M.modulecredits
FROM lab7_students as S, lab7_modules as M, lab7_enrolledon as E
WHERE (S.studentid = E.studentid) AND (E.moduleid = M.moduleid) AND (S.studentcourse NOT LIKE '%BSc%') AND (S.studentcourse NOT LIKE '%BA%') AND (M.modulecredits >='10') AND (M.modulecredits<='15');

