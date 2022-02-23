update prestamo
set  tipo = :tipo,
     nombre = :nombre,
     valor_prestamo = :valorPrestamo,
     fecha_prestamo = :fechaPrestamo,
     idUsuario = :idUsuario
where id = :id