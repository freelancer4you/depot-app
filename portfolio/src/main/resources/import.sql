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
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('LYXOR-UCITS-ETF-FTSE-ATHEX-LARGE-CAP-EUR-DIS-ETF','FR0010405431',null,'FR0010405431.PA','USD',2, 'ETF','UNDEFINED');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('XETRA-GOLD','DE000A0S9GB0',null,'A0S9GBDE.DE','USD',2, 'ETF','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('DB-X-TRACKERS-EURO-STOXX-50-UCITS-ETF-1C-EUR-ACC-ETF','LU0380865021',null,'DXET.F','USD',2, 'ETF','UNDEFINED');

insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Covestro AG','DE0006062144',null,'1COV.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Mobotix AG','DE0005218309',null,'MBQ.F','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('SKF AB','SE0000108227',null,'SKFB.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Rhön-Klinikum','DE0007042301',null,'RHK.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Salzgitter','DE0006202005',null,'SZG.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Heidelberger-Druckmaschinen','DE0007314007',null,'HDD.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('RIB-Software','DE000A0Z2XN6',null,'RIB.F','USD',2, 'AKTIE','SOFTWARE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('M4E AG','DE000A0MSEQ3',null,'MU4.F','USD',2, 'AKTIE','ENTERTAINMENT');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Aixtron','DE000A0WMPJ6',null,'AIXA.F','USD',2, 'AKTIE','ENTERTAINMENT');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('SABINA-GOLD-SILVER','CA7852461093',null,'RXC.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('HARMONY-GOLD','ZAE000015228',null,'HAM1.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('NESTE-CORPORATION','FI0009013296',null,'NEF.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('BIOTEST-AG','DE0005227201',null,'BIO.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('IAMGOLD','CA4509131088',null,'IAL.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('GoPro','US38268T1034',null,'5G5.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Nordex','DE000A0D6554',null,'NDX1.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('ATLANTIC-GOLD-CORP','CA04854Q1019',null,'Q9I.BE','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('BEADELL-RESOURCES','AU000000BDR9',null,'3B7.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('UNDER-ARMOUR-INC','US9043111072',null,'U9R.F','USD',2, 'AKTIE','INDUSTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('SYGNIS-AG','DE000A1RFM03',null,'LIO1.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('GOLD-FIELDS-LTD','ZAE000018123',null,'EDGA.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('K92-MINING-INC','CA4991131083',null,'92K.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('ITN-NANOVATION-AG','DE000A0JL461',null,'I7N.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('DIAGEO-PLC','GB0002374006',null,'GUI.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('AT & T','US00206R1023',null,'SOBA.F','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('ENDEAVOUR-SILVER-CORP','CA29258Y1034',null,'EJD.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('HOCHSCHILD-MINING-PLC','GB00B1FW5029',null,'H3M.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Gazprom','US3682872078',null,'GAZ.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('GOLDEN-STAR','CA38119T1049',null,'GS5.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('INTERNATIONAL-LITHIUM-CORP','CA4598201065',null,'IAH.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('GLENCORE','JE00B4T3BW64',null,'8GC.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('LION-E-MOBILITY-AG','CH0132594711',null,'LMI.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('DEUTSCHE-TECHNOLOGIE-BETEILIGUNGEN-AG','DE000A1X3WX6',null,'DTKK.F','USD',2, 'AKTIE','DIVERSE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Unilever','NL0000009355',null,'UNI3.F','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('NOS-SGPS-SA','PTZON0AM0006',null,'PMV.F','USD',2, 'AKTIE','TELECOMMUNICATION');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('CAMECO','CA13321L1085',null,'CJ6.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('BYD-CO','CNE100000296',null,'BY6.DE','USD',2, 'AKTIE','TECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('OMEGA-HEALTHCARE','US6819361006',null,'OHI','USD',2, 'AKTIE','DIVERSE');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('KAPSCH-TRAFFICCOM-AG','AT000KAPSCH9',null,'BZ6.F','USD',2, 'AKTIE','INFORMATIONTECHNOLOGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Novo-Nordisk','DK0060534915',null,'NOVC.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Solarworld','DE000A1YCMM',null,'SWVK.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Suedzucker','DE0007297004',null,'SZU.F','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('Baywa','DE0005194062',null,'BYW6.DE','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('ZINC-ONE-RESOURCES','CA98959W1041',null,'RH33.F','USD',2, 'AKTIE','CONSUMER_GOODS');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('KINROSS-GOLD-CORP','CA4969024047',null,'KIN2.F','USD',2, 'AKTIE','ENERGY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('GLAXOSMITHKLINE-PLC','GB0009252882',null,'GS7.F','USD',2, 'AKTIE','CHEMESTRY');
insert into stockdata(name,isin,wkn,searchkey,currency,leadingindex_id,stocktype,industry) values('DANAKALI-LTD','AU000000DNK9',null,'SO3.F','USD',2, 'AKTIE','UNDEFINED');



--Benutzer
insert into benutzer(id, email, passwort) values(1, 'system@freenet.de', '12345')
insert into benutzer(id, email, passwort) values(2, 'goldi23@freenet.de', '12345')

-- Depots
insert into depots(id, name, humanuser_id, seedcapital, stockspercentage, cashpercentage, cashamount) values(1, 'Aktuell', 2, 6000.0, 10, 6, 100.0);
insert into depots(id, name, humanuser_id, seedcapital, stockspercentage, cashpercentage, cashamount) values(2, 'Aristokraten', 2, 6000.0, 10, 6, 100.0);



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
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE000A0Z2ZZ5','Kaufen',23,'UNDERCUTTED','2016-10-10', 2);

--Deutsche Post
insert into monitorevent(id,stockdata_isin,comment,pricelimit,pricelimitDirection,greated, humanuser_id) values(null,'DE0005552004','Kaufen',25.0,'UNDERCUTTED','2016-10-10', 2);
