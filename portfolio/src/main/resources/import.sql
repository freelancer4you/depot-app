insert into leadingindex(id,name,isin,wkn,searchkey) values(1,'DAX','DE0008469008','846900','GDAXI');
insert into leadingindex(id,name,isin,wkn,searchkey) values(2,'DOW JONES',null,'969420','^DJI');

-- DAX
--insert into stockdata(id,name,isin,wkn,searchkey,currency) values(1,'DAX','DE0008469008','846900','^GDAXI','USD');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Adidas AG','DE000A1EWWW0',null,'ADS.DE','USD',1, 'AKTIE', 'CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Allianz','DE0008404005',null,'ALV.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('BASF','DE000BASF111',null,'BAS.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Bayer','DE000BAY0017',null,'BAYN.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Beiersdorf','DE0005200000',null,'BEI.DE','USD',1, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('BMW','DE0005190003',null,'BMW.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Commerzbank','DE000CBK1001',null,'CBK.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Continental','DE0005439004',null,'CON.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Daimler','DE0007100000',null,'DAI.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Bank','DE0005140008',null,'DBK.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Boerse','DE0005810055',null,'DB1.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Post','DE0005552004',null,'DPW.DE','USD',1, 'AKTIE','TRANSPORTATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Telekom','DE0005557508',null,'DTE.DE','USD',1, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('E.ON','DE000ENAG999',null,'EOAN.DE','USD',1, 'AKTIE','SUPPLIER');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Fresenius','DE0005785604',null,'FME.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Fresenius Medical Care','DE0005785802',null,'FRE.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('HeidelbergCement','DE0006047004',null,'HEI.DE','USD',1, 'AKTIE','CONSTRUCTION_INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Henkel vz','DE0006048432',null,'HEN3.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Infineon','DE0006231004',null,'IFX.DE','USD',1, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Linde','DE0006483001',null,'LIN.DE','USD',1, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Lufthansa','DE0008232125',null,'LHA.DE','USD',1, 'AKTIE','TRANSPORTATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Merck','DE0006599905',null,'MRK.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Muenchener Rueck','DE0008430026',null,'MUV2.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('ProSiebenSat1 Media','DE000PSM7770',null,'PSM.DE','USD',1, 'AKTIE','ENTERTAINMENT');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('RWE','DE0007037129',null,'RWE.DE','USD',1, 'AKTIE','SUPPLIER');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('SAP','DE0007164600',null,'SAP.DE','USD',1, 'AKTIE','SOFTWARE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Siemens','DE0007236101',null,'SIE.DE','USD',1, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('thyssenkrupp','DE0007500001',null,'TKA.DE','USD',1, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Volkswagen vz','DE0007664039',null,'VNA.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Vonovia','DE000A1ML7J1',null,'VOW3.DE','USD',1, 'AKTIE','DIVERSE');

-- DOW-Jones
--insert into stockdata(name,isin,wkn,searchkey,currency,leadingIndex) values(32,'DOW JONES',null,'969420','^DJI','USD');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('3M','US88579Y1010',null,'MMM','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('American Express','US0258161092',null,'AXP','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Apple','US0378331005',null,'AAPL','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Boeing','US0970231058',null,'BA','USD',2, 'AKTIE','TRANSPORTATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Caterpillar','US1491231015',null,'CAT','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Chevron','US1667641005',null,'CVX','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Cisco Systems','US17275R1023',null,'CSCO','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Coca-Cola','US1912161007',null,'KO','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('DuPont','US2635341090',null,'DFT','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Exxon Mobil','US30231G1022',null,'XOM','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('General Electric','US3696041033',null,'GE','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Goldman Sachs','US38141G1040',null,'GS','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Home Depot','US4370761029',null,'HD','USD',2, 'AKTIE','COMMERCE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('IBM','US4592001014',null,'IBM','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Intel','US4581401001',null,'INTC','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('JohnsonJohnson','US4781601046',null,'JNJ','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('JPMorgan','US46625H1005',null,'JPM','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('McDonalds','US5801351017',null,'MCD','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('MerckCo','US58933Y1055',null,'MRK','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Microsoft','US5949181045',null,'MSFT','USD',2, 'AKTIE','SOFTWARE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Nike','US6541061031',null,'NKE','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Pfizer','US7170811035',null,'PFE','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('ProcterGamble','US7427181091',null,'PG','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Travelers Companies','US89417E1091',null,'TRV','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('United Technologies','US9130171096',null,'UNH','NKE',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('UnitedHealth Group','US91324P1021',null,'UTX','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Verizon','US92343V1044',null,'VZ','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Visa','US92826C8394',null,'V','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Walmart','US9311421039',null,'WMT','USD',2, 'AKTIE','COMMERCE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Walt Disney','US2546871060',null,'DIS','USD',2, 'AKTIE','ENTERTAINMENT');

-- TODO MDax, S&P, NASDAQ

-- TODO MDax, S&P, NASDAQ


-- Andere
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('HSBC Holdings plc','GB0005405286',null,'HBC1.DE','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('iShares STOXX Global Select Dividend 100','DE000A0F5UH1',null,'ISPA.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Lyxor UCITS ETF MSCI Emerging Markets','FR0010429068',null,'LYM7.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Alstria Office Reit-AG','DE000A0LD2U1',null,'AOX.DE','USD',2, 'AKTIE', 'DIVERSE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('K+S Aktiengesellschaft','DE000KSAG888',null,'SDF.DE','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Telefónica Deutschland Holding AG','DE000A1J5RX9',null,'O2D.DE','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('SPDR® Barclays Euro High Yield Bond ETF','IE00B6YX5M31',null,'SYBJ.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('iShares Euro High Yield Corporate Bond','IE00B66F4759',null,'EUNW.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Royal Dutch Shell plc','GB00B03MLX29',null,'R6C.DE','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('China Mobile Limited','HK0941009539',null,'CTM.DE','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('DB X-TRACKERS FTSE EPRA','LU0489337690',null,'D5BK.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('BP p.l.c.','GB0007980591',null,'BPE5.DE','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('freenet AG','DE000A0Z2ZZ5',null,'FNTN.DE','USD',2, 'AKTIE','INFORMATIONTECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('DEUTSCHE AST MGMT BARCLAYS GLOB','LU0942970103',null,'XBAG.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('SPDR S&P Euro Dividend Aristocrats','IE00B5M1WJ87',null,'SPYW.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('BLACKROCK AM (DE) ISHARES','DE000A0H0785',null,'EXHF.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('ComStage STOXX Europe 600 Food & Bev. NR UCITS ETF','LU0378435803',null,'C067.DE','USD',2, 'ETF','UNDEFINED');

--Benutzer
insert into benutzer(id, email, passwort) values(1, 'system@freenet.de', '12345')
insert into benutzer(id, email, passwort) values(2, 'goldi23@freenet.de', '12345')

-- Depots
insert into depots(id, name, humanuser_id, seedcapital, stockspercentage, cashpercentage, cashamount) values(1, 'Aktuell', 2, 6000.0, 10, 6, 100.0);
insert into depots(id, name, humanuser_id, seedcapital, stockspercentage, cashpercentage, cashamount) values(2, 'Aristokraten', 2, 6000.0, 10, 6, 100.0);

---Aktien
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (1, 5,  'DE0005552004', true, 1);--'AKTIE' Deutsche Post
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (2, 0, 'DE0005557508', false, 1);--'AKTIE' Telekom
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (3, 0,  'DE0007100000', true, 1);--'AKTIE' Daimler
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (4, 0, 'DE000KSAG888', false, 1);--'AKTIE'K+2
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (5, 0,  'DE0008404005', true, 1);--'AKTIE' Allianz
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (6, 10, 'DE000A0LD2U1', false, 1);--'AKTIE' Alstria 
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (7, 10, 'GB00B03MLX29', true, 1);--'AKTIE' Royal Dutch
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (8, 2,  'US5801351017', true, 1);--'AKTIE'  MCDONALD
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (9, 0,  'DE000A0Z2ZZ5', true, 1);--'AKTIE' FREENET
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (10, 20, 'DE000A1J5RX9', false, 1);--'AKTIE' TELEFONICA
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (11, 5,  'US92343V1044', true, 1);--'AKTIE' VERIZON 
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (12, 1, 'GB0005405286', false, 1);--'AKTIE' HSBC
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (13, 0, 'GB0007980591', false, 1);--'AKTIE' BP
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (14, 0,  'US1912161007', true, 1);--'AKTIE' Coca Cola
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id) values (15, 19, 'HK0941009539', false, 1);--'AKTIE' China Mobile

--ETFs
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (16, 3, 'DE000A0H0785', false, 1, 32);--'ETF' iShare Euro Gov
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (17, 40, 'FR0010429068', false, 1, 8);--'ETF' LYXOR
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (18, 10, 'LU0489337690', false, 1, 2);--'ETF' DB X-T.FTSE
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (19, 3, 'IE00B66F4759', false, 1, 32);--'ETF' iShare Euro High Yield
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (20, 14, 'IE00B5M1WJ87', false, 1, 17);--'ETF' SPDR Dividend Aristocrats
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (21, 6, 'IE00B6YX5M31', false, 1, 32);-- 'ETF' SPDR Barclays  
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (22, 24, 'LU0942970103', false, 1, 32);--'ETF' Barclay Global Aggregate Bond
insert into stock (id,anzahl, stockdata_isin, aristocrat, depot_id, percentage) values (23, 0,'DE000A0F5UH1', false, 1, 22);--'ETF' IShare Global Select Dividend


-- -############################################# Depot  -#############################################
--Deutsche Post
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0005552004',24.50,10,'BUY','2016-07-06');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0005552004',28.10,3,'SELL','2016-09-22');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0005552004',32.095,2,'SELL','2017-02-27');

--Telekom
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0005557508',17.00,10,'BUY','2015-11-17');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0005557508',14.40,10,'SELL','2016-11-17');

--Daimler
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0007100000',53.97,4,'BUY','2017-06-08');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0007100000',70.00,2,'SELL','2017-01-16');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE0007100000',53.97,2,'SELL','2016-06-29');

--K+S
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000KSAG888',17.60,12,'BUY','2016-09-20');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000KSAG888',18.11,12,'SELL','2016-10-20');

-- Allianz
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null, 'DE0008404005', 126.75, 2 ,'BUY', '2016-07-04');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null, 'DE0008404005', 159.10, 1 ,'SELL', '2017-01-16');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null, 'DE0008404005', 172.10, 1 ,'SELL', '2017-06-06');

--Alstria
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',11.73,10,'BUY','2015-09-02');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',12.90,4,'SELL','2015-10-26');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',12.90,6,'SELL','2015-10-26');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',11.80,20,'BUY','2016-07-06');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',12.50,4,'SELL','2016-09-22');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',11.50,10,'BUY','2016-11-02');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',11.515,11,'SELL','2017-02-15');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0LD2U1',11.63,5,'SELL','2016-04-11');	

--Royal Dutch
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB00B03MLX29',22.465,14,'BUY','2015-09-02');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB00B03MLX29',24.595,14,'SELL','2015-10-26');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB00B03MLX29',23.71,12,'BUY','2015-10-28');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB00B03MLX29',23.08,10,'BUY','2015-11-12');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB00B03MLX29',20.90,10,'BUY','2015-12-08');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB00B03MLX29',24.145,10,'SELL','2016-06-29');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB00B03MLX29',26.00,12,'SELL','2017-01-16');

--MCDONALD
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'US5801351017',116.25,2,'BUY','2016-08-19');

--FREENET
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0Z2ZZ5',22.84,5,'BUY','2016-06-28');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0Z2ZZ5',31.60,5,'SELL','2017-06-01');

--TELEFONICA
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A1J5RX9',3.80,20,'BUY','2016-06-13');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A1J5RX9',3.60,35,'BUY','2016-07-01');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A1J5RX9',4.15,20,'SELL','2017-01-09');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A1J5RX9',4.649,15,'SELL','2017-04-07');

--VERIZON
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'US92343V1044',45.95,5,'BUY','2016-02-08');

--HSBC
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0005405286',6.80,15,'BUY','2015-09-02');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0005405286',5.45,24,'BUY','2016-07-07');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0005405286',6.64,9,'SELL','2016-09-28');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0005405286',7.258,29,'SELL','2016-11-16');

--BP
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0007980591',4.779,26,'BUY','2015-09-02');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0007980591',5.23,26,'SELL','2015-10-22');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0007980591',5.241,30,'BUY','2015-10-27');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0007980591',4.69,12,'BUY','2015-12-08');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0007980591',5.942,22,'SELL','2017-01-09');	
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'GB0007980591',5.25,20,'SELL','2017-06-08');	

--Coca Cola
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'US1912161007',41.83,6,'BUY','2016-10-04');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'US1912161007',41.16,6,'BUY','2016-10-11');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'US1912161007',41.45,6,'SELL','2016-12-15');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'US1912161007',45.10,6,'SELL','2017-06-08');

--CHINA Mobile
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'HK0941009539',11.00,19,'BUY','2016-09-21');

-- TODO AT&T


--iShare Euro Gov
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0H0785',124.26,3,'BUY','2016-09-21');

--LYXOR
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'FR0010429068',8.34,40,'BUY','2016-11-26');

--DB X-T.FTSE
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'LU0489337690',23.85,10,'BUY','2015-10-08');

--iShare Euro High Yield
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'IE00B66F4759',105.31,5,'BUY','2015-11-02');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'IE00B66F4759',103.00,5,'SELL','2016-07-03');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'IE00B66F4759',104.55,3,'BUY','2016-09-20');

--SPDR Dividend Aristocrats
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'IE00B5M1WJ87',20.21,10,'BUY','2015-09-07');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'IE00B5M1WJ87',20.54,10,'SELL','2016-05-17');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'IE00B5M1WJ87',20.30,14,'BUY','2016-07-05');

--SPDR Barclays 
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'IE00B6YX5M31',56.79,6,'BUY','2016-09-21');

--Barclay Global Aggregate Bond
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'LU0942970103',42.50,24,'BUY','2016-07-04');

--IShare Global Select Dividend
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0F5UH1',24.18,14,'BUY','2015-09-24');
insert into orderhistory(id,stockdata_isin,price,quantity,orderaction,stamp) values(null,'DE000A0F5UH1',24.04,14,'SELL','2016-02-08');


---############################################# MonitorEvents #############################################
---MonitorEvents an 52 Wochentief orientieren, prüfen ob dies über Yahoo-Schnittstelle zu ermitteln ist
--VERIZON
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'US92343V1044','Kaufen',40.00,'UNDERCUTTED','2016-09-14', 2);

--SPDR Dividend Aristocrats
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'IE00B5M1WJ87','Kaufen',20.10,'UNDERCUTTED','2016-09-14', 2);

-- Global Select Dividend
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A0F5UH1','Kaufen',24.2,'UNDERCUTTED','2016-10-04', 2);

--McDonalds
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'US5801351017','Kaufen',90.0,'UNDERCUTTED','2016-10-04', 2);

-- Coca
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'US1912161007','Kaufen',37.0,'UNDERCUTTED','2016-10-05', 2);

-- Comstage Stoxx Eur 600. Food & Bev.
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'LU0378435803','Kaufen',105.0,'UNDERCUTTED','2016-10-10', 2);

-- Royal
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'GB00B03MLX29','Kaufen',20.5,'UNDERCUTTED','2016-10-10', 2);

-- Telekom
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE0005557508','Verkaufen',17.0,'EXCEEDED','2016-10-10', 2);
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE0005557508','Kaufen',14.0,'UNDERCUTTED','2016-10-10', 2);

--TELEFONICA
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A1J5RX9','Verkaufen',5.0,'EXCEEDED','2016-10-10', 2);
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A1J5RX9','Kaufen',3.1,'UNDERCUTTED','2016-10-10', 2);

--HSBC
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'GB0005405286','Kaufen',5.5,'UNDERCUTTED','2016-10-10', 2);

--FREENET
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A0Z2ZZ5','Kaufen',5.5,'UNDERCUTTED','2016-10-10', 2);

--Deutsche Post
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE0005552004','Kaufen',22.0,'UNDERCUTTED','2016-10-10', 2);
