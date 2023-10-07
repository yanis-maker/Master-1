parent(a,c).
parent(a,d).
parent(a,e).
parent(b,c).
parent(b,d).
parent(b,e).

frereOuSoeur(X,Y) :- parent(Z,X), parent(Z,Y), Y!=X, not frereOuSoeur(Y,X). % règle R
:-frereOuSoeur(X,X).

#show frereOuSoeur/2. % restriction affichage pour lisibilité