﻿SELECT * from cs130_2017_lab3 WHERE custname SIMILAR TO '% M______';
SELECT booktitle,bookpages from CS130_2017_lab3 WHERE (bookpages%2=0)and(bookpages>=100)and(bookpages<=200);
SELECT bookisbn from CS130_2017_lab3 WHERE (bookisbn LIKE '0%' or bookisbn LIKE '7%') and (bookisbn LIKE '%0' or bookisbn LIKE '%7');
SELECT booktitle from CS130_2017_lab3 WHERE booktitle ~ '^.*\d{1}.*$';
SELECT booktitle from CS130_2017_lab3 WHERE booktitle ~*'operative' and booktitle ~*'web-enabled';
SELECT custiban from CS130_2017_lab3 WHERE custiban ~*'^(IE|CH|ES).*$';
SELECT custiban from CS130_2017_lab3 WHERE custiban ~'.*\s\d{3}$';
SELECT custiban from CS130_2017_lab3 WHERE custiban ~'\d{4}\s\d{4}\s\d{4}';
SELECT custiban from CS130_2017_lab3 WHERE custiban ~'\d{4}\s\d{4}\s\d{4}\s\d{4}\s\d{4}\s\d{4}';
SELECT booktitle,bookprice,bookpages,custregion from CS130_2017_lab3 WHERE ((bookprice*1.12)>=60.00) and bookpages>=100 and (custregion LIKE '%UK%' or custregion LIKE '%IE%');
SELECT booktitle,booktext from CS130_2017_lab3 WHERE booktext ~* '^.*(CS130).*$';
SELECT booktitle,bookpages from CS130_2017_lab3 WHERE (log(bookpages)>=2.2227) and (log(bookpages)<=2.285555);