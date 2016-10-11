CREATE TABLE IF NOT EXIST
 TbAmpBackendBaseDailyTable(createDate TIMESTAMP,mcid VARCHAR(24),visits INT,visitor INT,pv INT,click INT,bounceVisit INT,viewtime NUMERIC(8,2));

CREATE TABLE IF NOT EXIST
 TbAmpBackendTransDailyTable(createDate TIMESTAMP,mcid VARCHAR(24),begavior INT,trans INT,phonebuy INT,setmeal INT,parts INT);

CREATE TABLE IF NOT EXIST
 TbAmpFlowMarketingDailyTable(createDate TIMESTAMP,mcid VARCHAR(24),url VARCHAR(200),visits INT,pv INT);

CREATE TABLE IF NOT EXIST
 TbAmpFlowNatureDailyTable(createDate TIMESTAMP,classfy VARCHAR(20),referer VARCHAR(200),entrypage VARCHAR(200),visits INT,pv INT);

CREATE TABLE IF NOT EXIST
 TbAmpFlowTotalDailyTable(createDate TIMESTAMP,classfy VARCHAR(20),url VARCHAR(200),visits INT,pv INT,viewtime NUMERIC(8,2));