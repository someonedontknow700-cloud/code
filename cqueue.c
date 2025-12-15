#include <stdio.h>
#define MAX 5

int cq[MAX];
int front = -1, rear = -1;

/* Enqueue operation */
void enqueue() {
    int value;

    if ((rear + 1) % MAX == front) {
        printf("Circular Queue Overflow\n");
        return;
    }

    printf("Enter value to enqueue: ");
    scanf("%d", &value);

    if (front == -1) {   // first element
        front = rear = 0;
    } else {
        rear = (rear + 1) % MAX;
    }

    cq[rear] = value;
    printf("%d inserted\n", value);
}

/* Dequeue operation */
void dequeue() {
    if (front == -1) {
        printf("Circular Queue Underflow\n");
        return;
    }

    printf("%d removed\n", cq[front]);

    if (front == rear) {   // last element removed
        front = rear = -1;
    } else {
        front = (front + 1) % MAX;
    }
}

/* Display operation */
void display() {
    if (front == -1) {
        printf("Circular Queue is empty\n");
        return;
    }

    printf("Circular Queue elements: ");
    int i = front;
    while (1) {
        printf("%d ", cq[i]);
        if (i == rear)
            break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}

int main() {
    int choice;

    while (1) {
        printf("\n--- Circular Queue Menu ---\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1: enqueue(); break;
            case 2: dequeue(); break;
            case 3: display(); break;
            case 4: return 0;
            default: printf("Invalid choice\n");
        }
    }
}
