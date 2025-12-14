#include <stdio.h>
#include <string.h>

#define SIZE 15

// Structure for hash table slot
typedef struct {
    char name[21];
    int usn;
    int used;   // 0 = empty, 1 = occupied
} Slot;

Slot table[SIZE];

// Initialize hash table
void init() {
    for (int i = 0; i < SIZE; i++) {
        table[i].used = 0;
    }
}

// Insert record using Linear Probing
void insertRec(const char *name, int usn) {
    int idx = usn % SIZE;
    int start = idx;   // To detect full table

    // Find empty slot
    while (table[idx].used) {
        idx = (idx + 1) % SIZE;
        if (idx == start) {
            printf("Hash Table Full. Cannot insert %s %d\n", name, usn);
            return;
        }
    }

    strcpy(table[idx].name, name);
    table[idx].usn = usn;
    table[idx].used = 1;
}

int main() {
    int N;
    scanf("%d", &N);

    init();

    for (int i = 0; i < N; i++) {
        char name[21];
        int usn;
        scanf("%20s %d", name, &usn);

        // USN validation (optional but safe)
        if (usn >= 1000 && usn <= 9999) {
            insertRec(name, usn);
        }
    }

    // Display hash table
    for (int i = 0; i < SIZE; i++) {
        if (table[i].used) {
            printf("%s %d\n", table[i].name, table[i].usn);
        } else {
            printf("##\n");
        }
    }

    return 0;
}
