
CREATE TABLE IF NOT EXISTS Pais (
    idPais INT PRIMARY KEY AUTO_INCREMENT,
    nombrePais VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS Departamento (
    idDepartamento INT PRIMARY KEY AUTO_INCREMENT,
    nombreDepartamento VARCHAR(100) NOT NULL,
    paisDepartamento INT,
    FOREIGN KEY (paisDepartamento) REFERENCES Pais(idPais)
);


CREATE TABLE IF NOT EXISTS Municipio (
    idMunicipio INT PRIMARY KEY AUTO_INCREMENT,
    nombreMunicipio VARCHAR(100) NOT NULL,
    departamentoMunicipio INT,
    FOREIGN KEY (departamentoMunicipio) REFERENCES Departamento(idDepartamento)
);


CREATE TABLE IF NOT EXISTS Cargo (
    idCargo INT PRIMARY KEY AUTO_INCREMENT,
    nombreCargo VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS Direccion (
    idDireccion INT PRIMARY KEY AUTO_INCREMENT,
    municipioDireccion INT,
    departamentoDireccion INT,
    paisDireccion INT,
    calleDireccion VARCHAR(255) NOT NULL,
    carreraDireccion VARCHAR(255),
    coordenadaDireccion VARCHAR(100),
    descripcionDireccion TEXT,
    FOREIGN KEY (municipioDireccion) REFERENCES Municipio(idMunicipio),
    FOREIGN KEY (departamentoDireccion) REFERENCES Departamento(idDepartamento),
    FOREIGN KEY (paisDireccion) REFERENCES Pais(idPais)
);


CREATE TABLE IF NOT EXISTS Persona (
    idPersona INT PRIMARY KEY AUTO_INCREMENT,
    nombrePersona VARCHAR(100) NOT NULL,
    apellidosPersona VARCHAR(100) NOT NULL,
    direccionPersona INT,
    FOREIGN KEY (direccionPersona) REFERENCES Direccion(idDireccion)
);


CREATE TABLE IF NOT EXISTS Empleado (
    idEmpleado INT PRIMARY KEY,
    cargoEmpleado INT,
    salarioEmpleado DECIMAL(10, 2),
    FOREIGN KEY (idEmpleado) REFERENCES Persona(idPersona),
    FOREIGN KEY (cargoEmpleado) REFERENCES Cargo(idCargo)
);


CREATE TABLE IF NOT EXISTS Estudiante (
    idEstudiante INT PRIMARY KEY,
    codigoEstudiante VARCHAR(50) NOT NULL,
    programaEstudiante VARCHAR(100) NOT NULL,
    promedioEstudiante DECIMAL(5, 2),
    FOREIGN KEY (idEstudiante) REFERENCES Persona(idPersona)
);
