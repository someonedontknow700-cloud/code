#include <stdio.h>
#include <stdlib.h>

// BST Node
struct node {
    int data;
    struct node *left, *right;
};

// Create new node
struct node* createNode(int item) {
    struct node *temp = (struct node*)malloc(sizeof(struct node));
    temp->data = item;
    temp->left = temp->right = NULL;
    return temp;
}

// Insert into BST
struct node* insert(struct node* root, int item) {
    if (root == NULL)
        return createNode(item);

    if (item < root->data)
        root->left = insert(root->left, item);
    else if (item > root->data)
        root->right = insert(root->right, item);

    return root;
}

// Inorder Traversal
void inorder(struct node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

// Preorder Traversal
void preorder(struct node* root) {
    if (root != NULL) {
        printf("%d ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

// Postorder Traversal
void postorder(struct node* root) {
    if (root != NULL) {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->data);
    }
}

// Search in BST
void search(struct node* root, int key) {
    if (root == NULL) {
        printf("Key not found\n");
        return;
    }
    if (key == root->data) {
        printf("Key found\n");
        return;
    }
    if (key < root->data)
        search(root->left, key);
    else
        search(root->right, key);
}

// Main function
int main() {
    struct node* root = NULL;
    int ch, n, i, item, key;

    while (1) {
        printf("\n--- BST MENU ---\n");
        printf("1.Create BST\n2.Inorder\n3.Preorder\n4.Postorder\n5.Search\n6.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);

        switch (ch) {
        case 1:
            printf("Enter number of nodes: ");
            scanf("%d", &n);
            root = NULL;
            printf("Enter elements:\n");
            for (i = 0; i < n; i++) {
                scanf("%d", &item);
                root = insert(root, item);
            }
            break;

        case 2:
            printf("Inorder Traversal: ");
            inorder(root);
            printf("\n");
            break;

        case 3:
            printf("Preorder Traversal: ");
            preorder(root);
            printf("\n");
            break;

        case 4:
            printf("Postorder Traversal: ");
            postorder(root);
            printf("\n");
            break;

        case 5:
            printf("Enter key to search: ");
            scanf("%d", &key);
            search(root, key);
            break;

        case 6:
            exit(0);

        default:
            printf("Invalid Choice\n");
        }
    }
}
