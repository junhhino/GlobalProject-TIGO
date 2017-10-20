-- selectFacturasPendientes=SELECT b.MF4hA  CUENTA, COUNT(*) CANT_FCM 
-- FROM BCCS.OF287V a INNER JOIN BCCS.MF9e7V b 
-- ON a.WAQIA = b.WAQIA
-- AND a.WASSA = b.WASSA
-- AND a.REFDA = b.REFDA
-- INNER JOIN BCCS.MF48V c ON
-- b.OM2PA = c.OM2PA
-- AND b.MF4HA = c.MF4HA
-- AND a.MF3HA = c.MF3HA
-- AND a.MF3GA = c.MF3GA
-- WHERE
-- b.OM2PA = 'CET' --Tipo cuenta
-- AND a.WAQIA = 'FCM' --Tipo comprobante
-- AND a.REFLA = 'PC' --Estado comprobante
-- AND a.REfkA > 0
-- AND b.MF4hA IN ? -- IN (?) --('77000116', '77000117') -- Cuenta
-- GROUP BY b.MF4hA
-- ORDER BY b.MF4hA;
selectFacturasPendientes=SELECT b.MF4hA  CUENTA, COUNT(*) CANT_FCM
FROM BCCS.OF287V a
INNER JOIN BCCS.MF9e7V b
ON a.WAQIA = b.WAQIA
AND a.WASSA = b.WASSA
AND a.REFDA = b.REFDA
inner JOIN BCCS.MF48V c ON
b.OM2PA = c.OM2PA
AND b.MF4HA = c.MF4HA
AND a.MF3HA = c.MF3HA
AND a.MF3GA = c.MF3GA
WHERE b.OM2PA = 'CET' --Tipo cuenta
AND a.WAQIA = 'FCM' --Tipo comprobante
AND a.REFLA = 'PC' --Estado comprobante
AND a.REfkA > 0
AND b.MF4hA IN ? --('77000116', '77000111', '77000888') -- Cuenta
GROUP BY b.MF4hA
--ORDER BY b.MF4hA
union
select x.cuenta,0
from (
SELECT c.MF4hA  CUENTA
FROM BCCS.MF48V c
WHERE c.OM2PA = 'CET' --Tipo cuenta
AND c.MF4hA IN ? --('77000116', '77000111', '77000888')
except
SELECT b.MF4hA  CUENTA
FROM BCCS.MF9e7V b
inner JOIN BCCS.OF287V a
ON a.WAQIA = b.WAQIA
AND a.WASSA = b.WASSA
AND a.REFDA = b.REFDA
LEFT JOIN BCCS.MF48V c ON b.OM2PA = c.OM2PA
AND b.MF4HA = c.MF4HA
AND a.MF3HA = c.MF3HA
AND a.MF3GA = c.MF3GA
WHERE
    b.OM2PA = 'CET' --Tipo cuenta
AND a.WAQIA = 'FCM' --Tipo comprobante
AND a.REFLA = 'PC' --Estado comprobante
AND a.REfkA > 0
AND b.MF4hA IN ? --('77000116', '77000111', '77000888') -- Cuenta
GROUP BY b.MF4hA)x;