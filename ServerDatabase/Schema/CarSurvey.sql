/*
Created: 4/21/2013
Modified: 4/21/2013
Model: CarSurvey
Database: PostgreSQL 9.1
*/

-- Create tables section -------------------------------------------------

-- Table Questions

CREATE TABLE "Questions"(
 "QuestionID" Bigint NOT NULL,
 "QuestionDesc" Text NOT NULL,
 "QuestionWeight" Numeric(6,2) DEFAULT 0.0 NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table Questions

ALTER TABLE "Questions" ADD CONSTRAINT "QuestionID_PK" PRIMARY KEY ("QuestionID")
;

-- Table UserResponse

CREATE TABLE "UserResponse"(
 "UserID" Bigint NOT NULL,
 "QuestionID" Bigint NOT NULL,
 "AnswerID" Bigint
)
WITH (OIDS=FALSE)
;

-- Add keys for table UserResponse

ALTER TABLE "UserResponse" ADD CONSTRAINT "Key3" PRIMARY KEY ("UserID","QuestionID")
;

-- Table User

CREATE TABLE "User"(
 "UserID" Bigint NOT NULL,
 "UserName" Varchar NOT NULL,
 "Password" Varchar NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table User

ALTER TABLE "User" ADD CONSTRAINT "UserID_PK" PRIMARY KEY ("UserID")
;

-- Table Answers

CREATE TABLE "Answers"(
 "AnswerID" Bigint NOT NULL,
 "QuestionID" Bigint NOT NULL,
 "AnswerDesc" Text NOT NULL,
 "AnswerWeight" Numeric(6,2) DEFAULT 0.0 NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table Answers

ALTER TABLE "Answers" ADD CONSTRAINT "AnswerID_PK" PRIMARY KEY ("AnswerID")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "Answers" ADD CONSTRAINT "Relationship2" FOREIGN KEY ("QuestionID") REFERENCES "Questions" ("QuestionID") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "UserResponse" ADD CONSTRAINT "Relationship3" FOREIGN KEY ("UserID") REFERENCES "User" ("UserID") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "UserResponse" ADD CONSTRAINT "Relationship4" FOREIGN KEY ("QuestionID") REFERENCES "Questions" ("QuestionID") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "UserResponse" ADD CONSTRAINT "Relationship5" FOREIGN KEY ("AnswerID") REFERENCES "Answers" ("AnswerID") ON DELETE NO ACTION ON UPDATE NO ACTION
;





