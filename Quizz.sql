--
-- Fichier g�n�r� par SQLiteStudio v3.2.1 sur jeu. d�c. 24 13:43:39 2020
--
-- Encodage texte utilis� : System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table : Administrateurs
CREATE TABLE Administrateurs (IdAdministrateurs INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NomAdministrateurs VARCHAR NOT NULL, PrenomAdministrateurs VARCHAR NOT NULL, EmailAdministrateurs VARCHAR NOT NULL, PseudoAdministrateurs VARCHAR, PasswordAdministrateurs VARCHAR NOT NULL, TokenAdministrateurs VARCHAR NOT NULL, InscriptionConfirmAdministrateurs BOOLEAN);
INSERT INTO Administrateurs (IdAdministrateurs, NomAdministrateurs, PrenomAdministrateurs, EmailAdministrateurs, PseudoAdministrateurs, PasswordAdministrateurs, TokenAdministrateurs, InscriptionConfirmAdministrateurs) VALUES (2, 'ferrere', 'fabrice', 'bafdu69@hotmail.fr', NULL, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', 'OOBWRFEN2V6B1608334797545RIZXGFAT389U', 1);

-- Table : Difficultes
CREATE TABLE Difficultes (IdDifficultes INTEGER PRIMARY KEY AUTOINCREMENT, NomDifficultes VARCHAR NOT NULL);
INSERT INTO Difficultes (IdDifficultes, NomDifficultes) VALUES (1, 'Facile');
INSERT INTO Difficultes (IdDifficultes, NomDifficultes) VALUES (2, 'Moyenne');
INSERT INTO Difficultes (IdDifficultes, NomDifficultes) VALUES (3, 'Expert');

-- Table : Parametres
CREATE TABLE Parametres (IdParametres INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NomSystemeParametres VARCHAR UNIQUE NOT NULL, ModeInscriptionParametres BOOLEAN NOT NULL);
INSERT INTO Parametres (IdParametres, NomSystemeParametres, ModeInscriptionParametres) VALUES (1, 'Site Admin', 1);

-- Table : Questions
CREATE TABLE Questions (IdQuestions INTEGER PRIMARY KEY AUTOINCREMENT, TexteQuestions VARCHAR UNIQUE NOT NULL, Fk_IdDifficultes INTEGER NOT NULL REFERENCES Difficultes (IdDifficultes), PointsQuestions INTEGER NOT NULL, Fk_IdBonneReponses INTEGER REFERENCES Reponses (IdReponses) ON DELETE CASCADE NOT NULL);
INSERT INTO Questions (IdQuestions, TexteQuestions, Fk_IdDifficultes, PointsQuestions, Fk_IdBonneReponses) VALUES (1, 'Dans quel pays peut-on trouver la Catalogne, l�Andalousie et la Castille ', 2, 8, 2);
INSERT INTO Questions (IdQuestions, TexteQuestions, Fk_IdDifficultes, PointsQuestions, Fk_IdBonneReponses) VALUES (2, 'Qui a dit : � Le sort en est jet� � (Alea jacta est)', 2, 7, 6);
INSERT INTO Questions (IdQuestions, TexteQuestions, Fk_IdDifficultes, PointsQuestions, Fk_IdBonneReponses) VALUES (3, 'Quel c�l�bre dictateur dirigea l�URSS du milieu des ann�es 1920 � 1953', 2, 9, 12);
INSERT INTO Questions (IdQuestions, TexteQuestions, Fk_IdDifficultes, PointsQuestions, Fk_IdBonneReponses) VALUES (4, 'Quelle ville a construit le premier m�tro', 3, 12, 15);
INSERT INTO Questions (IdQuestions, TexteQuestions, Fk_IdDifficultes, PointsQuestions, Fk_IdBonneReponses) VALUES (5, 'De quoi se nourrit le manchot', 1, 2, 17);

-- Table : Reponses
CREATE TABLE Reponses (IdReponses INTEGER PRIMARY KEY AUTOINCREMENT, TexteReponses VARCHAR NOT NULL, Fk_IdQuestions INTEGER REFERENCES Questions (IdQuestions));
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (1, 'L''Italie ', 1);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (2, 'L''Espagne', 1);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (3, 'La France ', 1);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (4, 'Le Portugal', 1);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (5, 'La corse
', 1);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (6, 'C�sar', 2);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (7, 'Attila', 2);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (8, 'Auguste', 2);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (9, 'Vercing�torix', 2);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (10, 'Trotski', 3);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (11, 'Molotov', 3);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (12, 'Staline', 3);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (13, 'L�nine', 3);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (14, 'P�kin', 3);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (15, 'Londres', 4);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (16, 'De crevette', 5);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (17, 'De plancton', 5);
INSERT INTO Reponses (IdReponses, TexteReponses, Fk_IdQuestions) VALUES (18, 'De sardine', 5);

-- Table : Utilisateurs
CREATE TABLE Utilisateurs (IdUtilisateurs INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, NomUtilisateurs VARCHAR NOT NULL, PrenomUtilisateurs VARCHAR NOT NULL, EmailUtilisateurs VARCHAR NOT NULL, PseudoUtilisateurs VARCHAR, PasswordUtilisateurs VARCHAR NOT NULL, TokenUtilisateurs VARCHAR, InscriptionConfirmUtilisateurs BOOLEAN);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (1, 'Doe', 'John', 'doe@john.fr', 'johnou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 1);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (2, 'Gates', 'Bill', 'gates@bill.fr', 'billou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 0);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (3, 'Musk', 'Ellon', 'musk@ellon.fr', 'ellonou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, 0);
INSERT INTO Utilisateurs (IdUtilisateurs, NomUtilisateurs, PrenomUtilisateurs, EmailUtilisateurs, PseudoUtilisateurs, PasswordUtilisateurs, TokenUtilisateurs, InscriptionConfirmUtilisateurs) VALUES (4, 'Jobs', 'Steve', 'jobs@steve.fr', 'stevou', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', NULL, NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;

.save Quizz.db