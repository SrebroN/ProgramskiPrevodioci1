# MikroJava Compiler

English

This project implements a compiler for the MikroJava programming language. The compiler translates syntactically and semantically correct MikroJava programs into MikroJava bytecode, which is executed on the MikroJava Virtual Machine (MJVM).

The compiler provides the following core functionalities:

### 1. Lexical Analysis

- Implemented using Lex.

- Identifies language lexemes and produces a sequence of tokens from the source code.

- Reports lexical errors with descriptive messages.

Syntax Analysis (Parsing)

Implemented using CUP.

Utilizes a bottom-up LALR(1) parser to check whether tokens form grammatically correct sentences according to the MikroJava grammar specification.

Provides feedback on successful parsing or detailed error reports in case of syntax errors.

Supports error recovery to continue parsing after encountering syntax issues.

Semantic Analysis

Performed on the Abstract Syntax Tree (AST) built during parsing.

Uses a visitor-based approach to check declarations, type rules, scope resolution, and other semantic constraints.

Reports semantic errors with clear explanations.

Code Generation

Translates syntactically and semantically correct programs into MikroJava bytecode for execution on the MJVM.

Uses AST traversal and visitor methods to generate instructions.


Srpski

Ovaj projekat predstavlja kompajler za programski jezik Mikrojava. Kompajler prevodi sintaksno i semantički ispravne Mikrojava programe u Mikrojava bajtkod, koji se izvršava na Mikrojava virtuelnoj mašini (MJVM).

Kompajler obuhvata sledeće osnovne funkcionalnosti:

Leksička analiza

Implementirana pomoću Lex alata.

Prepoznaje jezičke lekseme i formira skup tokena iz izvornog koda.

U slučaju greške, ispisuje odgovarajuću poruku.

Sintaksna analiza (parsiranje)

Implementirana pomoću CUP alata.

Koristi se bottom-up LALR(1) parser koji proverava da li tokeni čine gramatički ispravne rečenice u skladu sa gramatikom Mikrojave.

Obaveštava korisnika o uspešnosti parsiranja ili ispisuje detaljnu poruku u slučaju greške.

Implementiran je i oporavak od grešaka radi nastavka parsiranja.

Semantička analiza

Zasniva se na apstraktnom sintaksnom stablu (AST) koje se formira tokom parsiranja.

Implementirana kroz metode za posećivanje čvorova AST-a radi provere deklaracija, tipova, opsega i drugih semantičkih pravila.

U slučaju greške, ispisuje jasne i precizne poruke.

Generisanje koda

Prevodi ispravne programe u Mikrojava bajtkod za izvršavanje na MJVM-u.

Koristi metode za obilazak AST-a i generisanje instrukcija.
Prevodi ispravne programe u Mikrojava bajtkod za izvršavanje na MJVM-u.

Koristi metode za obilazak AST-a i generisanje instrukcija.
