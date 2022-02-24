select id, tipo, nombre, valor_prestamo, fecha_prestamo, fecha_ultimo_pago, idUsuario
from prestamo
where id = :id