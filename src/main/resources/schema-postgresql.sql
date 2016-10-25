CREATE TABLE IF NOT EXISTS tb_amp_backend_base_daily_table(
createDate DATE NOT NULL ,
mcid VARCHAR(24) NOT NULL,
visits INTEGER DEFAULT 0,
visitor INTEGER DEFAULT 0,
pv INTEGER DEFAULT 0,
click INTEGER DEFAULT 0,
bounceVisit INTEGER DEFAULT 0,
viewtime NUMERIC(8,2) DEFAULT 0,
PRIMARY KEY(createDate,mcid));


CREATE TABLE IF NOT EXISTS tb_amp_backend_trans_daily_table(
createDate DATE NOT NULL ,
mcid VARCHAR(24) NOT NULL,
begavior INTEGER DEFAULT 0,
trans INTEGER DEFAULT 0,
phonebuy INTEGER DEFAULT 0,
setmeal INTEGER DEFAULT 0,
parts INTEGER DEFAULT 0,
PRIMARY KEY(createDate,mcid));


CREATE TABLE IF NOT EXISTS tb_amp_flow_marketing_daily_table(
createDate DATE NOT NULL ,
mcid VARCHAR(24) NOT NULL,
url TEXT NOT NULL,
visits INTEGER DEFAULT 0,
pv INTEGER DEFAULT 0,
PRIMARY KEY(createDate,mcid,url));


CREATE TABLE IF NOT EXISTS tb_amp_flow_nature_daily_table(
createDate DATE NOT NULL ,
classfy VARCHAR(20) NOT NULL,
referer TEXT NOT NULL,
entrypage TEXT NOT NULL,
visits INTEGER DEFAULT 0,
pv INTEGER DEFAULT 0,
PRIMARY KEY(createDate,classfy,referer,entrypage));


CREATE TABLE IF NOT EXISTS tb_amp_flow_total_daily_table(
createDate DATE NOT NULL ,
classfy VARCHAR(20) NOT NULL,
url TEXT NOT NULL,
visits INTEGER DEFAULT 0,
pv INTEGER DEFAULT 0,
viewtime NUMERIC(8,2) DEFAULT 0,
PRIMARY KEY(createDate,classfy,url));