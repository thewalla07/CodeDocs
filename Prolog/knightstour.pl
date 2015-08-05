/* This project, and all code, text          */
/* documents and any other files submitted   */
/* are completely my own work, and have not  */
/* been plagiarised from any sources unless  */
/* otherwise stated. I fully understand the  */
/* seriousness of plagiarism, and am aware   */
/* of and accept the Universities rules and  */
/* reguations regarding plagiarism.  */

/* Name: Michael Wall                */
/* Student Number: 13522003          */


/* Facts to create all squares on the board. */
square(1/1).
square(1/2).
square(1/3).
square(1/4).
square(1/5).
square(1/6).
square(1/7).
square(1/8).

square(2/1).
square(2/2).
square(2/3).
square(2/4).
square(2/5).
square(2/6).
square(2/7).
square(2/8).

square(3/1).
square(3/2).
square(3/3).
square(3/4).
square(3/5).
square(3/6).
square(3/7).
square(3/8).

square(4/1).
square(4/2).
square(4/3).
square(4/4).
square(4/5).
square(4/6).
square(4/7).
square(4/8).

square(5/1).
square(5/2).
square(5/3).
square(5/4).
square(5/5).
square(5/6).
square(5/7).
square(5/8).

square(6/1).
square(6/2).
square(6/3).
square(6/4).
square(6/5).
square(6/6).
square(6/7).
square(6/8).

square(7/1).
square(7/2).
square(7/3).
square(7/4).
square(7/5).
square(7/6).
square(7/7).
square(7/8).

square(8/1).
square(8/2).
square(8/3).
square(8/4).
square(8/5).
square(8/6).
square(8/7).
square(8/8).

/* List methods */

/* append(A,B,C) will result in C being  B appended to A.        */
/* This is the built in append method in Prolog, however I coded */
/* this version so I could understand how to use it correctly.   */
append([], Ys, Ys).
append([X|Xs], Ys, [X|Zs]) :-
      append(Xs, Ys, Zs).

/* isHead(X, Y) will return true if X is the Head of the List Y  */
/* it does this by matching X to the first element in the list.  */
isHead(X, [X|_]).

/* isEnd works by checking if X is the only element in the list, */
/* and therefor the end of the list. This is the base case.      */
/* If this is not only element, then the list is broken down by  */
/* chopping the head off the list, and then checking to see if   */
/* X is the only element left in the list.                       */
isEnd(X, [X]):- !.
isEnd(X, [_|Tail]):-
      isEnd(X,Tail).

/* len base case is the empty ist, in which case the length is 0 */
/* If the list is not empty, the List is split: len is called on */
/* the tail of the list, and 1 is added to N to count the Head.  */
len([], 0).
len([_|T], N):-
      len(T, X),
      N is X+1.

/* isPos base case is that the value X is the first (or 0th)     */
/* positioned element in the list. This occurs if X is the head  */
/* of the list. If it is not the 0th element, the list is split  */
/* and then checked to see if X is the head of the new tail, and */
/* 1 is added to N to represent the current position in the list */
/* This uses a combination of the theory in isEnd (recursively   */
/* searching down a list) and len (adding while recursing).      */
isPos(X, [X|_], 0).
isPos(X, [_|T], N):-
      isPos(X, T, I),
      N is I+1.

/* Move verification */
/* validMove first checks to see if the squares are on the board */
/* and then splits the squares into X and Y coordinates. Then it */
/* checks to see that the moves are actually valid jumps within  */
/* the knight's range. Parentheses are used to control order.    */
validMove(S1, S2):-
      square(S1),
      square(S2),
      S1 = X/Y,
      S2 = A/B,
      (((A is X+2 ; A is X-2),(B is Y+1 ; B is Y-1));
      ((A is X+1 ; A is X-1),(B is Y+2 ; B is Y-2))). 

/* Find a Valid path */
/* knightpath base case is that Path is simply one move long. It */
/* defines Path as being a list just two elements long, and then */
/* checks that there is a valid move between the two squares.    */
/* The recursive checks that there is a valid move from some     */
/* square H to X, and then appends the latter X to T in list O   */
/* where it checks for valid moves again recursively.            */
knightpath(Path):-
      Path=[H,T],
      validMove(H,T).
knightpath(Path):-
      Path=[H,X | T],
      validMove(H,X),
      append([X],T,O),
      knightpath(O).

/* Find a journey of Length L, start S, finish E, along path P   */
/* Uses knightpath to generate a path with head S and end E, and */
/* also uses len to calculate the length of the Path.            */
/* Note: in knightjourney(..., ..., L, ...) the L represents the */
/* length of the list, not the number of moves. The number of    */
/* moves is the length minus 1, eg. L = 5, moves = 5-1 = 4.      */
knightjourney(S,E,L,P):-
      len(P, N),
      knightpath(P),
      isHead(S,P),
      isEnd(E,P), 
      N=L.

/* Find if a square Sq is Nth element of path P */
/* Uses knightpath to generate a valid path, and then checks the */
/* position of a square Sq is N.                                 */ 
knightpassthru(P,Sq,N):-
      knightpath(P),
      isPos(Sq, P, N).
      

/* Answers the question asked by giving a knightjourney with a   */
/* start at x=2 y=1 ends at the opposite side of the board, is 5 */
/* positions (or 4 moves) long. It also checks that the path     */
/* generated passes through x=5 y=4 after the 2nd move.          */

/* Reresents first interpretation of the question, as noted in   */
/* the text document.                                            */
questionanswerView1(Path):-
      knightjourney(2/1, 7/8, 5, Path),
      knightpassthru(Path,5/4,2).
      
/* Represents my other interpretaion of the question, as noted   */
/* in the text document. */
questionanswerView2(Path):-
      knightjourney(2/1, _/8, 5, Path),
      knightpassthru(Path,5/4,2).