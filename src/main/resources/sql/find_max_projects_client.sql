with projects_count as (select c.id as id, c.name as name, count(p.id) as project_quantity
                        from client c
                                 join project p on p.client_id = c.id
                        group by c.id, c.name)
select name, project_quantity
from projects_count
where project_quantity = (select max(project_quantity) from projects_count);