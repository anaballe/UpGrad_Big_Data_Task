create database UpGrad;
use UpGrad;
create table entertain(show string,channel string,cts int) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';
load data local inpath '/root/Downloads/final_compiled.txt' into table entertain;
select 'Sum of Viewers on ABC',SUM(cts) from entertain where channel == 'ABC';
select 'Sum of Viewers on BAT',SUM(cts) from entertain where channel == 'BAT';
select show,SUM(cts) Sum1 from entertain group by show,channel having channel ='ABC' order by Sum1 DESC limit 1;
select distinct show from entertain where channel = 'ZOO' or channel = 'NOX' or channel = 'ABC';
