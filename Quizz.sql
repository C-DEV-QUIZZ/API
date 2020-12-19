--
-- Fichier généré par SQLiteStudio v3.2.1 sur sam. déc. 19 02:03:28 2020
--
-- Encodage texte utilisé : UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table : Administrateurs
CREATE TABLE Administrateurs (IdAdministrateurs INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NomAdministrateurs VARCHAR NOT NULL, PrenomAdministrateurs VARCHAR NOT NULL, EmailAdministrateurs VARCHAR NOT NULL, PseudoAdministrateurs VARCHAR, PasswordAdministrateurs VARCHAR NOT NULL, TokenAdministrateurs VARCHAR NOT NULL, InscriptionConfirmAdministrateurs BOOLEAN);
INSERT INTO Administrateurs (IdAdministrateurs, NomAdministrateurs, PrenomAdministrateurs, EmailAdministrateurs, PseudoAdministrateurs, PasswordAdministrateurs, TokenAdministrateurs, InscriptionConfirmAdministrateurs) VALUES (2, 'ferrere', 'fabrice', 'bafdu69@hotmail.fr', NULL, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', 'OOBWRFEN2V6B1608334797545RIZXGFAT389U', 1);

-- Table : Parametres
CREATE TABLE Parametres (IdParametres INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NomSystemeParametres VARCHAR UNIQUE NOT NULL, ModeInscriptionParametres BOOLEAN NOT NULL);
INSERT INTO Parametres (IdParametres, NomSystemeParametres, ModeInscriptionParametres) VALUES (1, 'Site Admin', 1);

-- Table : Utilisateurs
CREATE TABLE Utilisateurs (IdUtilisateurs INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NomUtilisateurs VARCHAR NOT NULL, PrenomUtilisateurs VARCHAR NOT NULL, EmailUtilisateurs VARCHAR NOT NULL, PseudoUtilisateurs VARCHAR, PasswordUtilisateurs VARCHAR NOT NULL, TokenUtilisateurs VARCHAR, InscriptionConfirmUtilisateurs BOOLEAN);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (1, 'Doe', 'John', 'doe@john.fr', 'johnou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 1);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (2, 'Gates', 'Bill', 'gates@bill.fr', 'billou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 0);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (3, 'Musk', 'Ellon', 'musk@ellon.fr', 'ellonou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 0);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (4, 'Jobs', 'Steve', 'jobs@steve.fr', 'stevou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;


.save Quizz.db