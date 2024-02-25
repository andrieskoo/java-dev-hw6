select id, 'YOUNGEST' as type, name, birthday
from worker
where birthday = (select max(birthday) from worker)
union
select id, 'OLDEST' as type, name, birthday
from worker
where birthday = (select min(birthday) from worker);