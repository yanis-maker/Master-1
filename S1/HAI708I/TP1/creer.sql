CREATE TABLE Utilisateur(
    idUser INT,
    prenom VARCHAR2(30),
    Age INT,
    eMail VARCHAR2(30) ,
    mot_de_passe VARCHAR2(30),
    CONSTRAINT check_email CHECK (REGEXP_LIKE (eMail, '^\w+(\.\w+)*+@\w+(\.\w+)+$')),
    CONSTRAINT PK_User PRIMARY KEY (idUser)
);

CREATE TABLE Configuration(
    idConfig INT PRIMARY KEY,
    ouverture VARCHAR2(30),
    focale VARCHAR2(30),
    tmp_expo VARCHAR2(30),
    ISO INT,
    flash VARCHAR2(30),
    CONSTRAINT c_flash CHECK (flash IN ('ON','OFF','Auto'))
);


CREATE TABLE AppareilPhoto(
    idAppareil INT PRIMARY KEY,
    Nom VARCHAR2(30)
);

CREATE TABLE Photographie(
    idPicture INT PRIMARY KEY,
    date_prise DATE,
    date_publie DATE,
    lieu VARCHAR2(30),
    Nom VARCHAR2(30),
    NbVues INT,
    Licence_distribution VARCHAR2(30),
    idUser INT,
    idConfig INT,
    idAppareil INT,
    CONSTRAINT FK_USER FOREIGN KEY (idUser) REFERENCES Utilisateur(idUser),
    CONSTRAINT FK_CONFIG FOREIGN KEY (idConfig) REFERENCES Configuration(idConfig),
    CONSTRAINT FK_APP FOREIGN KEY (idAppareil) REFERENCES AppareilPhoto(idAppareil)
);
