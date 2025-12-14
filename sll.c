#include <stdio.h>
#include <stdlib.h>

// Node structure
struct node {
    int data;
    struct node *next;
};

struct node *top = NULL;

/* Push operation */
void push() {
    struct node *newnode;
    int item;

    newnode = (struct node*)malloc(sizeof(struct node));
    if (newnode == NULL) {
        printf("Stack Overflow\n");
        return;
    }

    printf("Enter element: ");
    scanf("%d", &item);

    newnode->data = item;
    newnode->next = top;
    top = newnode;

    printf("Element pushed\n");
}

/* Pop operation */
void pop() {
    struct node *temp;

    if (top == NULL) {
        printf("Stack Underflow\n");
        return;
    }

    temp = top;
    printf("Popped element: %d\n", temp->data);
    top = top->next;
    free(temp);
}

/* Display stack */
void display() {
    struct node *temp;

    if (top == NULL) {
        printf("Stack is empty\n");
        return;
    }

    printf("Stack elements:\n");
    temp = top;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

/* Main function */
int main() {
    int ch;

    while (1) {
        printf("\n--- STACK MENU ---\n");
        printf("1.Push\n2.Pop\n3.Display\n4.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);

        switch (ch) {
        case 1: push(); break;
        case 2: pop(); break;
        case 3: display(); break;
        case 4: exit(0);
        default: printf("Invalid choice\n");
        }
    }
}
