/*******************************
 * Alex Moriarty, B00317947
 * Login: moriarty
 * CSci2132: Assignment 3
 *******************************/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct node
{
	double x, y;
	struct node *next;
};

void plotTour(struct node *tour)
{
	 /*
         *      print postscript code depicting a given tour
         */

        struct node *curr;

        if (tour == NULL)
                return;

        printf("%%!\n50 50 translate\n0 0 512 512 rectstroke\n");

        /* plot the tour's edges */
        printf("%5.1f %5.1f moveto\n", 512.0*tour->x, 512.0*tour->y);
        printf("1.0 0.0 0.0 setrgbcolor\n");
        for (curr=tour->next; curr != NULL; curr=curr->next)
                printf("%5.1f %5.1f lineto\n",
                        512.0*curr->x, 512.0*curr->y);
        printf("closepath stroke\n");

        /* plot dots marking the locations of the nodes */
        printf("0.0 0.0 0.0 setrgbcolor\n");
        for (curr=tour; curr!=NULL; curr = curr->next)
 	{
                printf("newpath\n");
                printf("%5.1f %5.1f 2 0 360 arc\n",
                        512.0*curr->x, 512.0*curr->y);
                printf("closepath\nfill\n");
        }

        printf("showpage\n");
}



struct node *add_node(struct node *list, double x, double y)
{
/*
*	creates and returns a node containing the x and y values given.
*	this node is called new_node, which can the be added to a list.
*/
	struct node *new_node;
	new_node = malloc(sizeof(struct node));
	if (new_node == NULL)
	{
		printf("Error: not enough memory, malloc failed in 
add_node");
		exit(EXIT_FAILURE);
	}
	new_node->x = x;
	new_node->y = y;
	new_node->next = list;
	return new_node;
}


struct node *delete(struct node *list, double x, double y)
{
/*
*	finds node in list containing values x and y, then links previous
*	node to the node after the current node and deletes current node.
*/
	struct node *cur, *prev;

	for (cur = list, prev = NULL;
		 cur != NULL && ( cur->x != x && cur->y != x);
		 prev = cur, cur = cur->next)
		;
	if (cur == NULL)
		return list;
	if (prev == NULL)
		list = list->next;
	else
		prev->next = cur->next;
	free(cur);
	return list;
}

void move(struct node **from_list, struct node **to_list, double x, double 
y)
{
/*
*	"moves" a node from one list to another. really just creates a new 
*	node in the list its moving it to (to_list) and finds the node in 
*	(from_list) with the matching values and deletes it. there must be 
*	a better way, but this will due for now.
*/
	*to_list = add_node(*to_list, x, y);
	*from_list = delete(*from_list, x, y);
}

struct node *get_data(struct node *to_list)
{
/*
*	while two doubles are givin as input, it creates a node with those 
* 	two doubles and adds it "to_list".
*/
	double x = 0;
	double y = 0;
	int input;

	do{
		input = scanf("%lf%lf", &x, &y);
		to_list = add_node(to_list, x, y);
	}while (input == 2);

	return to_list;
}

double dist_nodes(struct node *point_a, struct node *point_b)
{
/*
*	this finds the distance between two nodes. which could have been 
*	updated to make use of the dist_linear and dist_points functions
*	writen later because I didnt always want to find the distance 	
*	between	nodes to avoid confusion.
*/
	double dx, dy, distance;
	dx = point_b->x - point_a->x;
	dy = point_b->y - point_a->y;

	distance = sqrt(dx*dx + dy*dy);
	return distance;
}

double dist_linear(double point_a, double point_b)
{
/*
*	this preforms very basic subtraction to find the distance from	 
*	point_a to point_b
*/
	double distance;
	distance = point_b - point_a;
	return distance;
}

double dist_points(double point_ax, double point_ay, double point_bx, 
double point_by)
{
/*
*	this one is a little trickier it uses subtraction and trig.
*	finds the distance between two points, calling on linear_dist 
*	to find the change in x and y.
*/
	double distance, dx, dy;
	dx = dist_linear(point_ax, point_bx);
	dy = dist_linear(point_ay, point_by);
	distance = sqrt(dx*dx + dy*dy);
	return distance;	
}

struct node *find_closest(struct node *nodes, struct node *tour)
{
/*
*	returns a new node with the closest with the same values as the *	
closest node in nodes from the most recent node in tour.
*	it loops for as long as there is a node in nodes, comparing the  *	
distance between the node in nodes and the last visited node in *	
tour with dist_nodes. 
*	the closets node can the be "moved" into the tour.
*/

	double dist_min = 0, x_min = 0, y_min = 0, dist = 0;
	struct node *closest;

	for (; nodes != NULL; nodes = nodes->next)
	{
		dist = dist_nodes(tour, nodes);

		if (dist_min == 0)
		{
			x_min = nodes->x;
			y_min = nodes->y;
			dist = dist_nodes(nodes, tour);
		}else if (dist_min != 0 && dist < dist_min && dist != 0)
		{
			x_min = nodes->x;
			y_min = nodes->y;
			dist_min = dist;
		}
	}

	closest = add_node(closest, x_min, y_min);

	return closest;
}

int main(void){
/* 	
*	The two required linked lists tour and nodes, aswell as closest *	
which will just hold the values of the closest point from nodes to *	
the last point in tour before its "moved"
*/
	struct node *tour = NULL;
	struct node *nodes = NULL;
	struct node *closest = NULL;

// gets the data and adds the list to nodes.
	nodes = get_data(nodes);
// why it read the last input twice was never determined. but this fixed 
//it
	nodes = delete(nodes, nodes->x, nodes->y);
// gets values of the last node in nodes
	double x = nodes->x;
	double y = nodes->y;
// and "moves" it into the tour list
	move(&nodes, &tour, x, y);
// these are for calculating the total distance
	double distance = 0;
	double x_initial = tour->x;
	double y_initial = tour->y;
	double x_temp = 0;
	double y_temp = 0;

	while (nodes != NULL )
	{
// finds closest node, calculates and increments distance, and "moves" 
//node to tour.
		closest = find_closest(nodes, tour);
		x = closest->x;
		y = closest->y;
		x_temp = tour->x;
		y_temp = tour->y;
		distance = distance + dist_points(x_temp, y_temp, x, y);
		move(&nodes, &tour, x, y);
	}
	
// and because it only calculated the tour lenght one way, it adds	
//the distance back to the beginning.
	distance = distance + dist_points(x, y, x_initial, y_initial);

//prints the distance to standard error
	printf(stderr, "length: %lf", distance);
//plots the tour	
	plotTour(tour);
	return 0;
	
	
}


