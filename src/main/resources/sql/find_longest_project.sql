with project_mouth as (select id, name,
                              DATEDIFF('MONTH', start_date, finish_date) AS mouth_duration
                       from project)
select id, name, mouth_duration
from project_mouth
where mouth_duration = (select max(mouth_duration) from project_mouth);
