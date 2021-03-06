CREATE TABLE IF NOT EXISTS tb_amp_backend_base_daily (
CREATE_DATE DATE NOT NULL ,
MIC VARCHAR(24) NOT NULL,
VISITS INTEGER DEFAULT 0,
VISITOR INTEGER DEFAULT 0,
PV INTEGER DEFAULT 0,
CLICK INTEGER DEFAULT 0,
BOUNCE_VISIT INTEGER DEFAULT 0,
VIEW_TIME NUMERIC(8,2) DEFAULT 0,
PRIMARY KEY(CREATE_DATE,MIC));


CREATE TABLE IF NOT EXISTS tb_amp_backend_trans_daily (
CREATE_DATE DATE NOT NULL ,
MIC VARCHAR(24) NOT NULL,
BEGAVIOR_VV INTEGER DEFAULT 0,
TRANSACTION_VV INTEGER DEFAULT 0,
PHONEBUY_VV INTEGER DEFAULT 0,
SETMEAL_VV INTEGER DEFAULT 0,
PARTS_VV INTEGER DEFAULT 0,
PRIMARY KEY(CREATE_DATE,MIC));


CREATE TABLE IF NOT EXISTS tb_amp_flow_marketing_daily (
CREATE_DATE DATE NOT NULL ,
MIC VARCHAR(24) NOT NULL,
URL TEXT NOT NULL,
VISITS INTEGER DEFAULT 0,
PV INTEGER DEFAULT 0,
PRIMARY KEY(CREATE_DATE,MIC,URL));


CREATE TABLE IF NOT EXISTS tb_amp_flow_nature_daily (
CREATE_DATE DATE NOT NULL ,
CLASSFY VARCHAR(20) NOT NULL,
REFERER TEXT NOT NULL,
ENTRYPAGE TEXT NOT NULL,
VISITS INTEGER DEFAULT 0,
PV INTEGER DEFAULT 0,
PRIMARY KEY(CREATE_DATE,CLASSFY,REFERER,ENTRYPAGE));


CREATE TABLE IF NOT EXISTS tb_amp_flow_total_daily (
CREATE_DATE DATE NOT NULL ,
CLASSFY VARCHAR(20) NOT NULL,
URL TEXT NOT NULL,
VISITS INTEGER DEFAULT 0,
PV INTEGER DEFAULT 0,
VIEW_TIME NUMERIC(8,2) DEFAULT 0,
PRIMARY KEY(CREATE_DATE,CLASSFY,URL));