// Alex Moriarty	
// login: moriarty	
// CSci2132: Assignment #3

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct node
{
	double x, y;
	struct node *next;
};

struct node *add_to(struct node *list, double x, double y)
{
	struct node *new_node;

	new_node = malloc(sizeof(struct node));
	if (new_node == NULL)
	{
		printf("Error: not enough memory, malloc failed in add_to");
		exit(EXIT_FAILURE);
	}
	
	new_node->x = x;
	new_node->y = y;
	new_node->next = list;
	return new_node;
}

struct node *get_input(void)
{
	struct node *first = NULL;
	double x = 0;
	double y = 0;
	int input;

	do
	{
		input = 0;
		input = scanf("%lf%lf", &x, &y);
		first = add_to(first, x, y);
	}while (input == 2);
	
	return first;
}

void re_link(struct node **list_two, struct node **the_node, struct node **prev_node)
{
	(*prev_node)->next = (*the_node)->next;
	(*the_node)->next = (*list_two)->next;
	*list_two = *the_node;
}

double distance_between(struct node *point_a, struct node *point_b)
{
	double dx, dy, distance;
	dx = point_b->y - point_a->x;
	dy = point_b->y - point_a->y;

	distance = sqrt(dx*dx + dy*dy);
	return distance;
}	

int main(void)
{
	struct node *nodes = NULL;
	struct node *tour = NULL;
	double distance, total_distance, min_distance;
	distance = 0;
	min_distance = 0;
	total_distance = 0;

	nodes = get_input();
	
	struct node *curr;
	struct node *prev;
	struct node *closest;
	struct node *prev_closest; 
	curr = nodes;
	prev = NULL;
	closest = NULL;
	prev_closest = NULL;

	relink(&tour, &curr, &prev);
	
	while (nodes != NULL)
	{
		for (curr = nodes, prev = NULL; curr != NULL; prev = curr, curr = curr->next)
		{	
			distance = distance_between(tour, curr);
			if (min_distance == 0) 
			{
				min_distance = distance;
			}
			if (distance < min_distance)
			{
				min_distance = distance;
				closest = curr;
				prev_closest = prev;
			}
			
		}
		total_distance += min_distance;
		relink(&tour, &closest, &prev_closest);
	}
}
