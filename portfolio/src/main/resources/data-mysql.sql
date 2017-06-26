-- ALTER TABLE leadingindex DROP COLUMN wkn;
--ALTER TABLE stockdata DROP COLUMN wkn;

insert into leadingindex(id,name,isin,searchkey) values(1,'DAX','846900','GDAXI');
insert into leadingindex(id,name,isin,searchkey) values(2,'DOW JONES','969420','^DJI');
insert into leadingindex(id,name,isin,searchkey) values(3,'Nasdaq','US6311011026','^IXIC');
insert into leadingindex(id,name,isin,searchkey) values(4,'S&P 500','A0AET0','^GSPC');

-- DAX
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Adidas AG','DE000A1EWWW0','ADS.DE','USD',1, 'AKTIE', 'CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Allianz','DE0008404005','ALV.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('BASF','DE000BASF111','BAS.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Bayer','DE000BAY0017','BAYN.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Beiersdorf','DE0005200000','BEI.DE','USD',1, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('BMW','DE0005190003','BMW.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Commerzbank','DE000CBK1001','CBK.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Continental','DE0005439004','CON.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Daimler','DE0007100000','DAI.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Bank','DE0005140008','DBK.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Boerse','DE0005810055','DB1.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Post','DE0005552004','DPW.DE','USD',1, 'AKTIE','TRANSPORTATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Deutsche Telekom','DE0005557508','DTE.DE','USD',1, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('E.ON','DE000ENAG999','EOAN.DE','USD',1, 'AKTIE','SUPPLIER');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Fresenius','DE0005785604','FME.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Fresenius Medical Care','DE0005785802','FRE.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('HeidelbergCement','DE0006047004','HEI.DE','USD',1, 'AKTIE','CONSTRUCTION_INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Henkel vz','DE0006048432','HEN3.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Infineon','DE0006231004','IFX.DE','USD',1, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Linde','DE0006483001','LIN.DE','USD',1, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Lufthansa','DE0008232125','LHA.DE','USD',1, 'AKTIE','TRANSPORTATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Merck','DE0006599905','MRK.DE','USD',1, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Muenchener Rueck','DE0008430026','MUV2.DE','USD',1, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('ProSiebenSat1 Media','DE000PSM7770','PSM.DE','USD',1, 'AKTIE','ENTERTAINMENT');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('RWE','DE0007037129','RWE.DE','USD',1, 'AKTIE','SUPPLIER');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('SAP','DE0007164600','SAP.DE','USD',1, 'AKTIE','SOFTWARE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Siemens','DE0007236101','SIE.DE','USD',1, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('thyssenkrupp','DE0007500001','TKA.DE','USD',1, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Volkswagen vz','DE0007664039','VNA.DE','USD',1, 'AKTIE','AUTOMOBILE_INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Vonovia','DE000A1ML7J1','VOW3.DE','USD',1, 'AKTIE','DIVERSE');

-- DOW-Jones
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('3M','US88579Y1010','MMM','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('American Express','US0258161092','AXP','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Apple','US0378331005','AAPL','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Boeing','US0970231058','BA','USD',2, 'AKTIE','TRANSPORTATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Caterpillar','US1491231015','CAT','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Chevron','US1667641005','CVX','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Cisco Systems','US17275R1023','CSCO','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Coca-Cola','US1912161007','KO','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('DuPont','US2635341090','DFT','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Exxon Mobil','US30231G1022','XOM','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('General Electric','US3696041033','GE','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Goldman Sachs','US38141G1040','GS','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Home Depot','US4370761029','HD','USD',2, 'AKTIE','COMMERCE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('IBM','US4592001014','IBM','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Intel','US4581401001','INTC','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('JohnsonJohnson','US4781601046','JNJ','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('JPMorgan','US46625H1005','JPM','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('McDonalds','US5801351017','MCD','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('MerckCo','US58933Y1055','MRK','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Microsoft','US5949181045','MSFT','USD',2, 'AKTIE','SOFTWARE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Nike','US6541061031','NKE','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Pfizer','US7170811035','PFE','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('ProcterGamble','US7427181091','PG','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Travelers Companies','US89417E1091','TRV','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('United Technologies','US9130171096','UNH','NKE',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('UnitedHealth Group','US91324P1021','UTX','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Verizon','US92343V1044','VZ','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Visa','US92826C8394','V','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Walmart','US9311421039','WMT','USD',2, 'AKTIE','COMMERCE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Walt Disney','US2546871060','DIS','USD',2, 'AKTIE','ENTERTAINMENT');

-- TODO MDax, S&P, NASDAQ

-- TODO MDax, S&P, NASDAQ


-- Andere
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('HSBC Holdings plc','GB0005405286','HBC1.DE','USD',2, 'AKTIE','FINANCIAL_SECTOR');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('iShares STOXX Global Select Dividend 100','DE000A0F5UH1','ISPA.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Lyxor UCITS ETF MSCI Emerging Markets','FR0010429068','LYM7.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Alstria Office Reit-AG','DE000A0LD2U1','AOX.DE','USD',2, 'AKTIE', 'DIVERSE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('K+S Aktiengesellschaft','DE000KSAG888','SDF.DE','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Telefónica Deutschland Holding AG','DE000A1J5RX9','O2D.DE','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('SPDR® Barclays Euro High Yield Bond ETF','IE00B6YX5M31','SYBJ.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('iShares Euro High Yield Corporate Bond','IE00B66F4759','EUNW.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Royal Dutch Shell plc','GB00B03MLX29','R6C.DE','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('China Mobile Limited','HK0941009539','CTM.DE','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('DB X-TRACKERS FTSE EPRA','LU0489337690','D5BK.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('BP p.l.c.','GB0007980591','BPE5.DE','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('freenet AG','DE000A0Z2ZZ5','FNTN.DE','USD',2, 'AKTIE','INFORMATIONTECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('DEUTSCHE AST MGMT BARCLAYS GLOB','LU0942970103','XBAG.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('SPDR S&P Euro Dividend Aristocrats','IE00B5M1WJ87','SPYW.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('BLACKROCK AM (DE) ISHARES','DE000A0H0785','EXHF.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('ComStage STOXX Europe 600 Food & Bev. NR UCITS ETF','LU0378435803','C067.DE','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('LYXOR-UCITS-ETF-FTSE-ATHEX-LARGE-CAP-EUR-DIS-ETF','FR0010405431','FR0010405431.PA','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('XETRA-GOLD','DE000A0S9GB0','A0S9GBDE.DE','USD',2, 'ETF','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('DB-X-TRACKERS-EURO-STOXX-50-UCITS-ETF-1C-EUR-ACC-ETF','LU0380865021','DXET.F','USD',2, 'ETF','UNDEFINED');

insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Covestro AG','DE0006062144','1COV.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Mobotix AG','DE0005218309','MBQ.F','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('SKF AB','SE0000108227','SKFB.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Rhön-Klinikum','DE0007042301','RHK.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Salzgitter','DE0006202005','SZG.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Heidelberger-Druckmaschinen','DE0007314007','HDD.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('RIB-Software','DE000A0Z2XN6','RIB.F','USD',2, 'AKTIE','SOFTWARE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('M4E AG','DE000A0MSEQ3','MU4.F','USD',2, 'AKTIE','ENTERTAINMENT');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Aixtron','DE000A0WMPJ6','AIXA.F','USD',2, 'AKTIE','ENTERTAINMENT');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('SABINA-GOLD-SILVER','CA7852461093','RXC.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('HARMONY-GOLD','ZAE000015228','HAM1.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('NESTE-CORPORATION','FI0009013296','NEF.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('BIOTEST-AG','DE0005227201','BIO.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('IAMGOLD','CA4509131088','IAL.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('GoPro','US38268T1034','5G5.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Nordex','DE000A0D6554','NDX1.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('ATLANTIC-GOLD-CORP','CA04854Q1019','Q9I.BE','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('BEADELL-RESOURCES','AU000000BDR9','3B7.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('UNDER-ARMOUR-INC','US9043111072','U9R.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('SYGNIS-AG','DE000A1RFM03','LIO1.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('GOLD-FIELDS-LTD','ZAE000018123','EDGA.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('K92-MINING-INC','CA4991131083','92K.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('ITN-NANOVATION-AG','DE000A0JL461','I7N.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('DIAGEO-PLC','GB0002374006','GUI.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('AT & T','US00206R1023','SOBA.F','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('ENDEAVOUR-SILVER-CORP','CA29258Y1034','EJD.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('HOCHSCHILD-MINING-PLC','GB00B1FW5029','H3M.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Gazprom','US3682872078','GAZ.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('GOLDEN-STAR','CA38119T1049','GS5.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('INTERNATIONAL-LITHIUM-CORP','CA4598201065','IAH.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('GLENCORE','JE00B4T3BW64','8GC.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('LION-E-MOBILITY-AG','CH0132594711','LMI.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('DEUTSCHE-TECHNOLOGIE-BETEILIGUNGEN-AG','DE000A1X3WX6','DTKK.F','USD',2, 'AKTIE','DIVERSE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Unilever','NL0000009355','UNI3.F','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('NOS-SGPS-SA','PTZON0AM0006','PMV.F','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('CAMECO','CA13321L1085','CJ6.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('BYD-CO','CNE100000296','BY6.DE','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('OMEGA-HEALTHCARE','US6819361006','OHI','USD',2, 'AKTIE','DIVERSE');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('KAPSCH-TRAFFICCOM-AG','AT000KAPSCH9','BZ6.F','USD',2, 'AKTIE','INFORMATIONTECHNOLOGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Novo-Nordisk','DK0060534915','NOVC.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Solarworld','DE000A1YCMM','SWVK.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Suedzucker','DE0007297004','SZU.F','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('Baywa','DE0005194062','BYW6.DE','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('ZINC-ONE-RESOURCES','CA98959W1041','RH33.F','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('KINROSS-GOLD-CORP','CA4969024047','KIN2.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('GLAXOSMITHKLINE-PLC','GB0009252882','GS7.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,searchkey,currency,leadingindex_id,stocktype,industry) values('DANAKALI-LTD','AU000000DNK9','SO3.F','USD',2, 'AKTIE','UNDEFINED');



-- Benutzer
insert into benutzer(id, email, passwort) values(1, 'system@freenet.de', '12345');
insert into benutzer(id, email, passwort) values(2, 'goldi23@freenet.de', '12345');

-- Depots
insert into depots(id, name, humanuser_id, seedcapital, stockspercentage, cashpercentage, cashamount) values(1, 'Aktuell', 2, 6000.0, 10, 6, 100.0);
insert into depots(id, name, humanuser_id, seedcapital, stockspercentage, cashpercentage, cashamount) values(2, 'Aristokraten', 2, 6000.0, 10, 6, 100.0);



-- ############################################# MonitorEvents #############################################
-- MonitorEvents an 52 Wochentief orientieren, prüfen ob dies über Yahoo-Schnittstelle zu ermitteln ist
-- VERIZON
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'US92343V1044','Kaufen',40.00,'UNDERCUTTED','2016-09-14', 2);

-- SPDR Dividend Aristocrats
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'IE00B5M1WJ87','Kaufen',20.10,'UNDERCUTTED','2016-09-14', 2);

-- Global Select Dividend
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A0F5UH1','Kaufen',24.2,'UNDERCUTTED','2016-10-04', 2);

-- McDonalds
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

-- TELEFONICA
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A1J5RX9','Verkaufen',5.0,'EXCEEDED','2016-10-10', 2);
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A1J5RX9','Kaufen',3.1,'UNDERCUTTED','2016-10-10', 2);

-- HSBC
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'GB0005405286','Kaufen',5.5,'UNDERCUTTED','2016-10-10', 2);

-- FREENET
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A0Z2ZZ5','Kaufen',23,'UNDERCUTTED','2016-10-10', 2);

-- Deutsche Post
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE0005552004','Kaufen',25.0,'UNDERCUTTED','2016-10-10', 2);
