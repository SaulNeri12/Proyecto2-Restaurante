
/**
 * Author:  neri
 * Created: 29 oct 2024
 */

-- Se agregan los tipos de multa al sistema
INSERT INTO multa(descripcion, porcentaje) VALUES ('Multa del 25% por cancelacion en un lapso de entre 1 a 2 dias antes de la reservacion', 25.0);
INSERT INTO multa(descripcion, porcentaje) VALUES ('Multa del 50% por cancelacion en menos de 24 horas antes de la reservacion', 50.0);

-- Se agregan los tipos de mesa al sistema
INSERT INTO tipo_mesa(nombre, maximo_personas, minimo_personas, precio) VALUES('Pequenia', 2, 1, 300.0);
INSERT INTO tipo_mesa(nombre, maximo_personas, minimo_personas, precio) VALUES('Mediana', 4, 3, 500.0);
INSERT INTO tipo_mesa(nombre, maximo_personas, minimo_personas, precio) VALUES('Grande', 8, 5, 800.0);

-- Se agrega el unico restaurante hasta la fecha
INSERT INTO restaurante(nombre, telefono, direccion, hora_apertura, hora_cierre) VALUES(
    'Restaurante X',
    '1122334455',
    'Calle Yaqui #410. Col. Las haciendas. Ciudad Obregon, Sonora.',
    '08:00:00',
    '20:00:00'
);

-- Agrega los 20 clientes al sistema
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Alberto Perez Perez', '6444112233');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Jorge Perez Soto', '6444112252');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Arely Cruz Perez', '1234567890');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Nicole Perez Lopez', '6444012210');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Nomar Quintero Lopez', '6444412210');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Bryan Quintero Lopez', '6444412219');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Carlos Damian Perez Bernal', '6444412299');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Carlos Jorge Perez Rodriguez', '6444812299');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Hannia Campoa Lopez', '6404412299');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Hannia Castillo Lopez', '6044412299');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Luis Hernandez Garcia', '5551234567');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Ana Maria Lopez', '5552345678');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Sofia Ramirez Cruz', '5553456789');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Miguel Angel Torres', '5554567890');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Carlos Alberto Mendez', '5555678901');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Fernanda Diaz Ortiz', '5556789012');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Raul Martinez Rivera', '5557890123');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Rosa Elena Fernandez', '5558901234');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Juan Pablo Dominguez', '5559012345');
INSERT INTO Cliente (nombre_completo, telefono) VALUES ('Valeria Jimenez Soto', '5550123456');

