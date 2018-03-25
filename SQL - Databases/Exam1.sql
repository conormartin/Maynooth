SELECT * from jupiter where (char_length(custname)>=10 AND (char_length(custname)<=14));
SELECT * from jupiter where (items>=9 AND items<=13) AND (useddebit='no');
SELECT * from jupiter where (custname LIKE 'Peter%')
SELECT * from jupiter where (entrytime >= '2017-01-27 00:00:00')AND(entrytime<='2017-01-27 23:59:59'); ...wrong
SELECT * from jupiter where custname ~*'^.*c.*.*s.*$';
SELECT * from jupiter where (loyaltycard ~'^.*(\d{4}\s{1}).*$'); ...wrong
SELECT * from jupiter where ((tillid ~*'^d{2}.*(0|2|4|6|8)$')AND (tillid ~*'d{2}(1|3|5|7|9).*$')); ...wrong
SELECT * from jupiter where loyaltycard ~*'^.*(a|e|i|o|u){2,}.*$';
SELECT * from jupiter where ((custname ~*'^(a|e|i|o|u).*$')AND(custname ~*'^.*\s{1}(a|e|i|o|u).*$'));
SELECT * from jupiter where (((EXTRACT(DOW FROM entrytime)=6) OR (EXTRACT(DOW FROM entrytime)=0)) AND (useddebit='yes'));
SELECT * from jupiter where (exittime - entrytime >='1:00:00');