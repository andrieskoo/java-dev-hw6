select name, salary from worker where SALARY = (select max(SALARY) from worker);
