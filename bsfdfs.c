#include <stdio.h>

int a[20][20], visited[20], n;

/* BFS Traversal */
void bfs(int start) {
    int queue[20], front = 0, rear = -1, i;
    
    for (i = 0; i < n; i++)
        visited[i] = 0;

    queue[++rear] = start;
    visited[start] = 1;

    printf("BFS Traversal: ");

    while (front <= rear) {
        start = queue[front++];
        printf("%d ", start);

        for (i = 0; i < n; i++) {
            if (a[start][i] == 1 && visited[i] == 0) {
                queue[++rear] = i;
                visited[i] = 1;
            }
        }
    }
    printf("\n");
}

/* DFS Traversal */
void dfs(int start) {
    int i;
    printf("%d ", start);
    visited[start] = 1;

    for (i = 0; i < n; i++) {
        if (a[start][i] == 1 && visited[i] == 0)
            dfs(i);
    }
}

/* Main Function */
int main() {
    int i, j, start, ch;

    printf("Enter number of cities (nodes): ");
    scanf("%d", &n);

    printf("Enter adjacency matrix:\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    while (1) {
        printf("\n--- GRAPH MENU ---\n");
        printf("1.BFS\n2.DFS\n3.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);

        switch (ch) {
        case 1:
            printf("Enter starting city: ");
            scanf("%d", &start);
            bfs(start);
            break;

        case 2:
            for (i = 0; i < n; i++)
                visited[i] = 0;
            printf("Enter starting city: ");
            scanf("%d", &start);
            printf("DFS Traversal: ");
            dfs(start);
            printf("\n");
            break;

        case 3:
            return 0;

        default:
            printf("Invalid choice\n");
        }
    }
}
