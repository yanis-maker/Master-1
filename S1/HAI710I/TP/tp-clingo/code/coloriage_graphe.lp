% instance
node(wa).
node(nt).
node(q).
node(nsw).
node(v).
node(sa).
node(t).

edge(wa,nt).
edge(wa,sa).
edge(nt,q).
edge(sa,q).
edge(sa,nt).
edge(sa,nsw).
edge(sa,v).
edge(nsw,q).
edge(nsw,v).

couleur(r).
couelur(g).
couleur(b).
%couleur(grey).


color(X,Z):- node(X)  , couleur(Z) , not isColored(X,Z)  . %,  affecterSommet(X,Z) .
isColored(X,Z) :- node(X) , color(X,Y) , couleur(Y) , Y!= Z , couleur(Z). 
%color(sa,grey):- .
%:- color(X,b), node(X).
estMemeCouleur(X,Z) :- color(X,Y) , color(Z,Y)  ,X!=Z . 

:- edge(X,Z) , estMemeCouleur(X,Z).

#show color/2.
