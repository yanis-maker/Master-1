% oedipe-family-factbase.lp

% les caractères accentués ne sont pas admis par clingo
% ou alors il faut les mettre entre guillemets

% BASE DE FAITS 

% personnage est un prédicat unaire
% on utilise une écriture raccourcie permise par Clingo: 
% p(a;b). est un raccourci pour p(a). p(b). 
% Ne pas confondre p(a;b) et p(a,b) : écriture raccourcie pour prédicat unaire, et prédicat binaire !
personnage(agenor;cadmos;harmonie;ino;agave;polydore;labdacos;nicteis;penthe;oclasos).
personnage(menecee;jocaste;creon;hemon;eurydice;laios;oedipe).
personnage(antigone;ismene;eteocle;polynice;thersandre;ladamos).

% sexe des personnages
homme(agenor). % agénor
homme(cadmos).
femme(harmonie).
femme(ino).
femme(agave).	  % agavé
homme(polydore).
homme(labdacos).
femme(nicteis).   % nictéis
homme(penthe). % penthé
homme(oclasos). 
homme(menecee). % ménécée
femme(jocaste).
homme(creon).   % créon
homme(hemon). % hémon
femme(eurydice).
homme(laios).
homme(oedipe).
femme(antigone).
femme(ismene).   % ismène
homme(eteocle). % étéocle
homme(polynice).
homme(thersandre).
homme(ladamos).

% relations parent-enfant
aEnfant(agenor,cadmos).
aEnfant(cadmos,ino).
aEnfant(cadmos,agave).
aEnfant(cadmos,polydore).
aEnfant(harmonie,ino).
aEnfant(harmonie,agave).
aEnfant(harmonie,polydore).
aEnfant(polydore,labdacos).
aEnfant(nicteis,labdacos).
aEnfant(agave,penthe).
aEnfant(labdacos,laios).
aEnfant(penthe,oclasos).
aEnfant(oclasos,menecee).
aEnfant(menecee,jocaste).
aEnfant(menecee,creon).
aEnfant(creon,hemon).
aEnfant(eurydice,hemon). 
aEnfant(laios,oedipe).
aEnfant(jocaste,oedipe).
aEnfant(jocaste,antigone).
aEnfant(jocaste,eteocle).
aEnfant(jocaste,ismene).
aEnfant(jocaste,polynice).
aEnfant(oedipe,antigone).
aEnfant(oedipe,eteocle).
aEnfant(oedipe,ismene).
aEnfant(oedipe,polynice).
aEnfant(polynice, thersandre). 
aEnfant(eteocle,ladamos). 

% les rois
roi(agenor,tyr).
roi(cadmos,thebes).	% thèbes
roi(penthe,thebes).
roi(creon, thebes).
roi(oedipe,thebes).
roi(eteocle,thebes).
roi(ladamos,thebes). 

% BASE DE REGLES (A ECRIRE)
%Question1
pere(X,Y) :- homme(X), aEnfant(X,Y).
mere(X,Y) :- femme(X), aEnfant(X,Y).

%Question2
parent(X,Y) :- pere(X,Y).
parent(X,Y) :- mere(X,Y).
roi_pere_roi(X) :- pere(Y,X), roi(Y,V), roi(X,V2).

%Question3 
roi_pere_roi_lieu(X) :- pere(Y,X), roi(Y,V), roi(X,V2), V==V2.

%Question4
grand_parent(X,Y) :- parent(X,Z), parent(Z,Y). 
grand_parent_oedipe(X) :- grand_parent(X,oedipe).

%Question5
%ancetre(X,Y) :- parent(X,Z), grand_parent(Z,Y).
%ancetre(X,Y) :- parent(X,Z), ancetre(Z,Y).
%ancetre_oedipe(X) :- ancetre(X,oedipe). 

%Question6
neutre(X) :- personnage(X), not femme(X), not homme(X).

%Question7
pere_connu(X) :- pere(Y,X).
pere_inconnu(X) :- not pere_connu(X), personnage(X).
mere_connu(X) :- mere(Y,X).
mere_inconnu(X) :- not mere_connu(X), personnage(X).
parent_inconnu(X) :- pere_inconnu(X), mere_inconnu(X).

%Question8
un_parent_connu(X) :- pere_inconnu(X), mere_connu(X).
un_parent_connu(X) :- mere_inconnu(X), pere_connu(X).

%Question9
siblings(X,Y) :- mere(M,X), mere(M,Y), pere(P,X), pere(P,Y), X != Y.
half_sibling(X,Y) :- mere(M,X), not mere(M,Y), pere(P,X), pere(P,Y), X != Y.
half_sibling(X,Y) :-  mere(M,X), mere(M,Y), pere(P,X), not pere(P,Y), X != Y.

%Question10
inceste(X,Y) :- aEnfant(X,Y), aEnfant(X,Z), aEnfant(Y,Z).

%Controle de TP

%A
aAuMoinsDeuxEnfants(X) :- aEnfant(X,Y), aEnfant(X,Z), Y!=Z. 
aEnfantUnique(X) :- aEnfant(X,Y), not aAuMoinsDeuxEnfants(X).
femmeAvecEnfanUnique(X) :- aEnfantUnique(X), femme(X).

%B
pasDeuxParentsConnus(X) :- parent_inconnu(X).
pasDeuxParentsConnus(X):- un_parent_connu(X).

%C
ancetre(X,Y) :- parent(X,Y).
ancetre(X,Y) :- grand_parent(X,Y).
ancetre(X,Y) :- parent(X,Z), grand_parent(Z,Y).
ancetre(X,Y) :- parent(X,Z), ancetre(Z,Y).

ancetreFemmeAntigone(X):- ancetre(X,antigone), femme(X).

%D
ancetreCommun(Z,X,Y) :- ancetre(Z,X), ancetre(Z,Y), X!=Y.
plusProcheAncetreCommun(Z,X,Y):- ancetreCommun(Z,X,Y), aEnfant(Z,M), not ancetreCommun(M,X,Y).

plusProcheAncetreCommunOclasosLaios(X):- plusProcheAncetreCommun(X,oclasos,laios).
plusProcheAncetreCommunOclasosOedipe(X):- plusProcheAncetreCommun(X,oclasos,oedipe).

#show plusProcheAncetreCommunOclasosOedipe/1.