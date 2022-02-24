update prestamo
set  tipo = :tipo,
     nombre = :nombre,
     valor_prestamo = :valorPrestamo,
     fecha_prestamo = :fechaPrestamo,
     fecha_ultimo_pago = :fechaUltimoPago,
     idUsuario = :idUsuario
where id = :id