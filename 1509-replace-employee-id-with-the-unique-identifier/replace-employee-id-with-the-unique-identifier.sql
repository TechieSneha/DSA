# Write your MySQL query statement below
SELECT emu.unique_id AS unique_id, emp.name AS name
FROM Employees emp
LEFT JOIN  EmployeeUNI emu
ON emp.id = emu.id