%
% CSCI 4155 Machine Learning
% A4 Q1 Learn regression using gradent decent
% 

clear all; close all; clc
x = load('X.dat'); y = load('Y.dat');
m = length(y); 

figure; 
scatter(x, y, 'o');

% Gradient descent
x = [ones(m, 1) x]; 
theta = zeros(size(x(1,:)))';
MAX_ITR = 300;
alpha = 0.05;

for num_iterations = 1:MAX_ITR
    grad = (1/m).* x' * ((x * theta) - y);
    theta = theta - alpha .* grad;
end
% found theta
theta

% Plot the linear fit	
hold on; 
plot(x(:,2), x*theta, '-')
legend('Data', 'Regression')
hold off 

% value for X = 20
predict = [1, 20] *theta

theta0_vals = linspace(-10, 20, 100);
theta1_vals = linspace(0, 6, 100);

J_vals = zeros(length(theta0_vals), length(theta1_vals));

for i = 1:length(theta0_vals)
	  for j = 1:length(theta1_vals)
	  t = [theta0_vals(i); theta1_vals(j)];    
	  J_vals(i,j) = (0.5/m) .* (x * t - y)' * (x * t - y);
    end
end

J_vals = J_vals';
figure;
surf(theta0_vals, theta1_vals, J_vals)
xlabel('\theta_0'); ylabel('\theta_1');

figure;
contour(theta0_vals, theta1_vals, J_vals , linspace(0, 50,50))
xlabel('\theta_0'); ylabel('\theta_1');