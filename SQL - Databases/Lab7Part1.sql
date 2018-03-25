UPDATE cs130_2017_lab7_property 
SET 
	listingdate='2017-10-15'
WHERE ((listingdate='2017-10-13') OR (listingdate='2017-10-14'));

UPDATE cs130_2017_lab7_property 
SET 
	askingprice='100000'
WHERE ((askingprice<'100000') AND (askingprice>'95000'));

DELETE FROM cs130_2017_lab7_property WHERE (((agent='Property Kings') AND (housetype='Semi-detached')) AND ((energyrating='C') OR (energyrating='D')));

DELETE FROM cs130_2017_lab7_property WHERE agent is NULL OR numbeds is NULL;

UPDATE cs130_2017_lab7_property 
SET
	askingprice=(askingprice-(askingprice*.08))
WHERE agent='CS130 Estates';

DELETE FROM cs130_2017_lab7_property WHERE ((char_length(address)>20) AND (address ~'^\d{4,}.*$') AND (address LIKE '%Road'));

