from pylab import *
# Parameters
N, P, gamma = 10, 0.8, .9 

# Reward function
r = zeros(N) - 0.1; r[0] = -1;  r[N-1] = 1

# Initiality random start policy and value function
policy = floor(2*rand(N)); policy[0] = 2; policy[N-1] = 2
Vpi = rand(N); Vpi[0]=r[0]; Vpi[N-1]=r[N-1]
Q = zeros([N,2])
#Loop until good enough, usually compare with e
for iter in range(50):
    # For state s in S
    for s in range(1,N-1):
    	# For action a in A - Can only go left or right
    	# left
    	
        snext  = s-1+2*policy[s]
        sother = s+1-2*policy[s]
        Q[s][0] = r[s]+gamma*(P*Vpi[snext]+(1-P)*Vpi[sother])
        Q[s][1] = r[s]+gamma*(P*Vpi[sother]+(1-P)*Vpi[snext])
        print Q[s][0]

        Vpi[s] = Q[s][argmax(Q[s][:])]
print policy
print Vpi
plot(Vpi); show()