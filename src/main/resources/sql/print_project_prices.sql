with project_mouth as (select id,
                              date_part('year', AGE(finish_date, start_date)) * 12 +
                              date_part('month', AGE(finish_date, start_date)) as mouth_duration
                       from project),
     project_worker_salary as (select project_id, sum(w.salary) as mouth_salary
                               from project_worker pw
                                        join worker w on w.id = pw.worker_id
                               group by project_id)

select id as project_id, (pm.mouth_duration * ps.mouth_salary) as price
from project_mouth pm
         join project_worker_salary ps on pm.id = ps.project_id;

