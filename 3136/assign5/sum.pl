sum([], 0).

sum([FirstNumber|Tail], Sum) :-
        sum(Tail, TailSum),
        Sum is FirstNumber + TailSum.
