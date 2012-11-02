from pylab import *
# Parameters
N, P, gamma = 10, 0.8, .9 
alpha = 0.8

# Reward function
r = zeros(N) - 0.1; r[0] = -1;  r[N-1] = 1

# Initiality random start policy and value function
policy = floor(2*rand(N)); policy[0] = 2; policy[N-1] = 2
Vpi = rand(N); Vpi[0]=r[0]; Vpi[N-1]=r[N-1]
Q = zeros([N,2])
#Loop until good enough
for iter in range(10):
    # For state s in S
    for s in range(1,N-1):
    	#if rand() < P:
        #    snext  = s-1+2*policy[s]
        #    sother = s+1-2*policy[s]
        #else:
        #    snext = s+1-2*policy[s]
        #    sother = s-1+2*policy[s]
        a = policy[s]
        snext  = s-1+2*a
        sother = s+1-2*a
        #Q[s][0] = r[s]+gamma*(P*Vpi[snext]+(1-P)*Vpi[sother])
        #Q[s][1] = r[s]+gamma*(P*Vpi[sother]+(1-P)*Vpi[snext])
        Q[s][0] = r[s]+gamma*(P*Vpi[snext]+(1-P)*Vpi[sother])
        Q[s][1] = r[s]+gamma*(P*Vpi[sother]+(1-P)*Vpi[snext])
        

        # Use either On Policy or Off Policy
        # Equation 6.14
        #Vpi[s] = Vpi[s] + alpha*(r[s]+gamma*Vpi[snext]-Vpi[s])
        # Equation 6.17 On Policy
        Q[s][0] = Q[s][0] + alpha*(r[s]+gamma*Q[s][0] - Q[s][0])
        Q[s][1] = Q[s][1] + alpha*(r[s]+gamma*Q[s][1] - Q[s][1])

        # Equation 6.18, Off Policy
        #Q[s][0] = Q[s][0] + alpha*(r[s]+gamma*argmax(Q[s][:]) - Q[s][0])
        #Q[s][1] = Q[s][1] + alpha*(r[s]+gamma*argmax(Q[s][:]) - Q[s][1])
        
        Vpi[s] = Q[s][argmax(Q[s][:])]
print policy
print Vpi
plot(Vpi); show()